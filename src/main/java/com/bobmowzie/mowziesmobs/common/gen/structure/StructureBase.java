package com.bobmowzie.mowziesmobs.common.gen.structure;

import net.minecraft.block.Block;
import net.minecraft.world.World;

/**
 * Created by jnad325 on 8/29/15.
 */
public class StructureBase {
    public static void replaceBlocks(Block toReplace, Block replacement, int x, int y, int z, int length, int width, int height, World world) {
        int i = 0;
        for (int x_ = x; x_ <= x + length; x_++) {
            for (int z_ = x; z_ <= z + width; z_++) {
                for (int y_ = y; y_ <= y + height; y_++) {
                    if (world.getBlock(x_, y_, z_) == toReplace)
                    {
//                        System.out.println("Block at " + x_ + ", " + y_ + ", " + z_ + " is " + world.getBlock(x_, y_, z_).getLocalizedName());
                        world.setBlock(x_, y_, z_, replacement);
                        i++;
                    }
                }
            }
        }
//        System.out.println("Replacing " + i + " blocks");
    }

    public static void replaceBlocks(Block toReplace, int toReplaceMetaData, Block replacement, int replacementMetaData, int x, int y, int z, int length, int width, int height, World world) {
        int i = 0;
        for (int x_ = x; x_ <= x + length; x_++) {
            for (int z_ = x; z_ <= z + width; z_++) {
                for (int y_ = y; y_ <= y + height; y_++) {
                    if (world.getBlock(x_, y_, z_) == toReplace && world.getBlockMetadata(x_, y_, z_) == toReplaceMetaData)
                    {
//                        System.out.println("Block at " + x_ + ", " + y_ + ", " + z_ + " is " + world.getBlock(x_, y_, z_).getLocalizedName());
                        world.setBlock(x_, y_, z_, replacement, replacementMetaData, 3);
                        i++;
                    }
                }
            }
        }
//        System.out.println("Replacing " + i + " blocks");
    }
}
