package com.bobmowzie.mowziesmobs.common.item;

import com.bobmowzie.mowziesmobs.MowziesMobs;
import com.bobmowzie.mowziesmobs.common.creativetab.CreativeTabHandler;
import com.bobmowzie.mowziesmobs.common.entity.MowzieEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMobRemover extends Item {

    public ItemMobRemover() {
        setUnlocalizedName("mobRemover");
        setTextureName(MowziesMobs.MODID + ":mobRemover");
        setCreativeTab(CreativeTabHandler.INSTANCE.creativeTab);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (entity instanceof MowzieEntity) {
            entity.setDead();
        }
        return true;
    }
}