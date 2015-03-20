package com.bobmowzie.mowziesmobs.item;

import com.bobmowzie.mowziesmobs.MMTabs;
import com.bobmowzie.mowziesmobs.MowziesMobs;
import com.bobmowzie.mowziesmobs.entity.EntityBabyFoliaath;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemFoliaathSeed extends Item
{
    public ItemFoliaathSeed()
    {
        setUnlocalizedName("foliaathSeed");
        setTextureName(MowziesMobs.getModID() + "foliaathSeed");
        setCreativeTab(MMTabs.generic);
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ)
    {
        if (world.isRemote) return true;
        else
        {
            Block block = world.getBlock(x, y, z);
            x += Facing.offsetsXForSide[meta];
            y += Facing.offsetsYForSide[meta];
            z += Facing.offsetsZForSide[meta];
            double d0 = 0d;

            if (meta == 1 && block.getRenderType() == 11) d0 = 0d;

            Entity entity = spawnCreature(world, new EntityBabyFoliaath(world), (double) x + 0d, (double) y + d0, (double) z + 0d);

            if (entity != null)
            {
                if (entity instanceof EntityLivingBase && stack.hasDisplayName()) ((EntityLiving) entity).setCustomNameTag(stack.getDisplayName());
                if (!player.capabilities.isCreativeMode) --stack.stackSize;
            }

            return true;
        }
    }

    public static Entity spawnCreature(World world, EntityLiving entity, double x, double y, double z)
    {
        if (entity != null)
        {
            entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360f), 0f);
            entity.rotationYawHead = entity.rotationYaw;
            entity.renderYawOffset = entity.rotationYaw;
            entity.onSpawnWithEgg(null);
            world.spawnEntityInWorld(entity);
            entity.playLivingSound();
        }

        return entity;
    }
}
