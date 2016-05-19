package com.bobmowzie.mowziesmobs.server.item;

import com.bobmowzie.mowziesmobs.MowziesMobs;
import com.bobmowzie.mowziesmobs.server.entity.wroughtnaut.EntityWroughtnaut;
import com.bobmowzie.mowziesmobs.server.world.structure.barakoa.StructureBarakoThrone;
import com.bobmowzie.mowziesmobs.server.world.structure.barakoa.StructureBarakoaHouse;
import coolalias.structuregenapi.util.Structure;
import net.ilexiconn.llibrary.server.structure.BlockState;
import net.ilexiconn.llibrary.server.structure.StructureBuilder;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class ItemTestStructure extends Item {
    int structure = 0;

    public ItemTestStructure() {
        super();
        setUnlocalizedName("testStructure");
    }

    @Override
    public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        Random rand = new Random();
        if (!world.isRemote) {
            StructureBuilder structure = new StructureBuilder().startComponent()
                    .cube(0, 0, 0, 19, 7, 19, Blocks.stone)
                    .cube(1, 1, 1, 17, 5, 17, Blocks.air)
                    .fillCube(8, 1, 0, 3, 5, 1, Blocks.air)
                    .cube(7, 0, 0, 5, 7, 1, Blocks.cobblestone)
                    .cube(7, 6, 0, 5, 1, 16, Blocks.cobblestone)
                    .cube(3, 6, 3, 13, 1, 5, Blocks.cobblestone)
                    .cube(3, 6, 7, 13, 1, 5, Blocks.cobblestone)
                    .cube(3, 6, 11, 13, 1, 5, Blocks.cobblestone)
                    .cube(7, 0, 0, 5, 1, 16, Blocks.cobblestone)
                    .cube(3, 0, 3, 13, 1, 5, Blocks.cobblestone)
                    .cube(3, 0, 7, 13, 1, 5, Blocks.cobblestone)
                    .cube(3, 0, 11, 13, 1, 5, Blocks.cobblestone)
                    .fillCube(1, 1, 1, 6, 5, 2, Blocks.stone)
                    .fillCube(12, 1, 1, 6, 5, 2, Blocks.stone)
                    .fillCube(7, 1, 3, 1, 5, 1, Blocks.cobblestone)
                    .fillCube(11, 1, 3, 1, 5, 1, Blocks.cobblestone)
                    .setBlock(8, 5, 0, BlockState.create(Blocks.stone_stairs, 5))
                    .setBlock(10, 5, 0, BlockState.create(Blocks.stone_stairs, 4))
                    .setBlock(7, 5, 2, BlockState.create(Blocks.stone_stairs, 6))
                    .setBlock(11, 5, 2, BlockState.create(Blocks.stone_stairs, 6))
                    .setBlock(7, 5, 1, BlockState.create(Blocks.stone_stairs, 7))
                    .setBlock(11, 5, 1, BlockState.create(Blocks.stone_stairs, 7))
                    .setBlock(8, 5, 3, BlockState.create(Blocks.stone_stairs, 5))
                    .setBlock(10, 5, 3, BlockState.create(Blocks.stone_stairs, 4))
                    .setBlock(7, 5, 4, BlockState.create(Blocks.stone_stairs, 7))
                    .setBlock(11, 5, 4, BlockState.create(Blocks.stone_stairs, 7))
                    .setBlock(6, 5, 3, BlockState.create(Blocks.stone_stairs, 4))
                    .setBlock(12, 5, 3, BlockState.create(Blocks.stone_stairs, 5))
                    .fillCube(3, 1, 3, 1, 5, 1, Blocks.cobblestone)
                    .fillCube(3, 1, 7, 1, 5, 1, Blocks.cobblestone)
                    .fillCube(3, 1, 11, 1, 5, 1, Blocks.cobblestone)
                    .fillCube(3, 1, 15, 1, 5, 1, Blocks.cobblestone)
                    .fillCube(7, 1, 15, 1, 5, 1, Blocks.cobblestone)
                    .fillCube(11, 1, 15, 1, 5, 1, Blocks.cobblestone)
                    .fillCube(15, 1, 15, 1, 5, 1, Blocks.cobblestone)
                    .fillCube(15, 1, 3, 1, 5, 1, Blocks.cobblestone)
                    .fillCube(15, 1, 7, 1, 5, 1, Blocks.cobblestone)
                    .fillCube(15, 1, 11, 1, 5, 1, Blocks.cobblestone)
                    .fillCube(1, 1, 3, 2, 5, 15, Blocks.stone)
                    .fillCube(16, 1, 3, 2, 5, 15, Blocks.stone)
                    .fillCube(3, 1, 16, 13, 5, 2, Blocks.stone)
                    .fillCube(8, 0, 1, 3, 1, 2, Blocks.double_stone_slab);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    structure.fillCube(4 + i * 4, 0, 4 + j * 4, 3, 1, 3, Blocks.double_stone_slab);
                }
            }
            structure.endComponent();

            structure.generate(world, x, y, z, rand);
            return true;
        }
        return false;
    }

    //    private void tryWroughtChamber(World world, Random random, int x, int z, int y)
//    {
//        int xzCheckDistance = 20;
//
//                if (world.getBlock(x, y, z).isAir(world, x, y, z))
//                {
//                    System.out.println("Starting point is air");
//                    for (int y2 = 1; y2 <= 30; y2++)
//                    {
//                        if (world.getBlock(x, y - y2, z).isOpaqueCube())
//                        {
//                            System.out.println("Found floor at " + (y - y2));
//                            int y4 = 0;
//                            int y5 = 0;
//                            for (int x2 = 0; x2 <= xzCheckDistance; x2++)
//                            {
//                                if (world.getBlock(x - x2, y - y2 + y4 + 1, z).isOpaqueCube())
//                                {
//                                    System.out.println("Found obstacle decreasing x");
//                                    Boolean wall = true;
//                                    for (int y3 = 1; y3 <= 4; y3 ++)
//                                    {
//                                        if (!world.getBlock(x - x2, y - y2 + y4 + 1 + y3, z).isOpaqueCube())
//                                        {
//                                            wall = false;
//                                            y4 += y3;
//                                            System.out.println("Raising search by " + y4 + " block");
//                                            break;
//                                        }
//                                    }
//                                    if (wall)
//                                    {
//                                        generateWroughtChamber(world, random, x - x2 - 9, y - y2 + y4, z - 9, 0);
//                                        return;
//                                    }
//                                }
//                                if (world.getBlock(x + x2, y - y2 + y5 + 1, z).isOpaqueCube())
//                                {
//                                    System.out.println("Found obstacle increasing x");
//                                    Boolean wall = true;
//                                    for (int y3 = 1; y3 <= 4; y3++)
//                                    {
//                                        if (!world.getBlock(x + x2, y - y2 + y5 + 1 + y3, z).isOpaqueCube())
//                                        {
//                                            wall = false;
//                                            y5 += y3;
//                                            break;
//                                        }
//                                    }
//                                    if (wall)
//                                    {
//                                        generateWroughtChamber(world, random, x + x2 + 9, y - y2 + y5, z - 9, 2);
//                                        return;
//                                    }
//                                }
//                            }
//                            System.out.println("Checking other axes");
//                            y4 = 0;
//                            y5 = 0;
//                            for (int z2 = 0; z2 <= xzCheckDistance; z2++)
//                            {
//                                if (world.getBlock(x - 1, y - y2 + y4 + 1, z-z2).isOpaqueCube())
//                                {
//                                    System.out.println("Found obstacle decreasing z");
//                                    Boolean wall = true;
//                                    for (int y3 = 1; y3 <= 4; y3 ++)
//                                    {
//                                        if (!world.getBlock(x - 1, y - y2 + y4 + 1 + y3, z-z2).isOpaqueCube())
//                                        {
//                                            wall = false;
//                                            y4 += y3;
//                                            break;
//                                        }
//                                    }
//                                    if (wall)
//                                    {
//                                        generateWroughtChamber(world, random, x - 1, y - y2 + y4, z - z2 - 18, 1);
//                                        return;
//                                    }
//                                }
//                                if (world.getBlock(x - 1, y - y2 + y5 + 1, z+z2).isOpaqueCube())
//                                {
//                                    System.out.println("Found obstacle increasing z");
//                                    Boolean wall = true;
//                                    for (int y3 = 1; y3 <= 4; y3 ++)
//                                    {
//                                        if (!world.getBlock(x - 1, y - y2 + y5 + 1 + y3, z+z2).isOpaqueCube())
//                                        {
//                                            wall = false;
//                                            y5 += y3;
//                                            break;
//                                        }
//                                    }
//                                    if (wall)
//                                    {
//                                        generateWroughtChamber(world, random, x - 1, y - y2 + y5, z + z2, 3);
//                                        return;
//                                    }
//                                }
//                            }
//                            break;
//                        }
//                    }
//                }
//            }
//
    private void generateWroughtChamber(World world, Random random, int x, int y, int z, int direction) {
        Structure structure = MowziesMobs.GENERATOR.structures.get(0);
        EntityWroughtnaut wroughtnaut = new EntityWroughtnaut(world);
        wroughtnaut.setPositionAndRotation(x + 0.5, y + 1, z + 9.5, 0, 0);
        MowziesMobs.GENERATOR.setStructure(structure);
        MowziesMobs.GENERATOR.setStructureFacing(direction);
        MowziesMobs.GENERATOR.setDefaultOffset(structure.getOffsetX(), structure.getOffsetY(), structure.getOffsetZ());
        MowziesMobs.GENERATOR.generate(world, random, x, y - 1, z);
        System.out.println(x + ", " + y + ", " + z);
        world.spawnEntityInWorld(wroughtnaut);
    }

    private void generateBarakoaVillage(World world, Random random, int x, int y, int z) {
        StructureBarakoaHouse.generateFirepit(world, x, y, z);
        int currentX = x;
        int currentZ = z;
        int throneDirection = random.nextInt(4) + 1;
        if (throneDirection == 0) {
            currentX -= 10;
        } else if (throneDirection == 1) {
            currentZ -= 10;
        } else if (throneDirection == 2) {
            currentX += 10;
        } else if (throneDirection == 3) {
            currentZ += 10;
        }
        StructureBarakoThrone.generate(world, currentX, y, currentZ, throneDirection);
    }

    @Override
    public void registerIcons(IIconRegister registrar) {
    }
}