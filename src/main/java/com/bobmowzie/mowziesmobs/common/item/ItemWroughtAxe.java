package com.bobmowzie.mowziesmobs.common.item;

import com.bobmowzie.mowziesmobs.MowziesMobs;
import com.bobmowzie.mowziesmobs.common.creativetab.MMTabs;
import com.bobmowzie.mowziesmobs.common.message.MessageSwingWroughtAxe;
import com.bobmowzie.mowziesmobs.common.property.WroughtAxeSwingProperty;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ItemWroughtAxe extends ItemSword
{
    public ItemWroughtAxe()
    {
        super(Item.ToolMaterial.IRON);
        setCreativeTab(MMTabs.generic);
        setUnlocalizedName("wroughtAxe");
    }

    @Override
    public boolean getIsRepairable(ItemStack itemStack, ItemStack itemStackMaterial)
    {
        return false;
    }

    @Override
    public boolean hitEntity(ItemStack heldItemStack, EntityLivingBase player, EntityLivingBase entityHit)
    {
        if (!player.worldObj.isRemote)
        {
            player.playSound("minecraft:random.anvil_land", 0.3F, 0.5F);
        }
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack heldItemStack, World world, EntityPlayer player)
    {
        if (!world.isRemote)
        {
            WroughtAxeSwingProperty property = WroughtAxeSwingProperty.getProperty(player);
            if (property.getTime() <= 0)
            {
                world.playSoundAtEntity(player, "mowziesmobs:wroughtnautWhoosh", 0.5F, 1F);
                property.swing();
                MowziesMobs.networkWrapper.sendToDimension(new MessageSwingWroughtAxe(player), player.dimension);
            }
        }
        return heldItemStack;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase destroyer)
    {
        return true;
    }

    @Override
    public float func_150893_a(ItemStack itemStack, Block block)
    {
        return 1.0F;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.bow;
    }
}
