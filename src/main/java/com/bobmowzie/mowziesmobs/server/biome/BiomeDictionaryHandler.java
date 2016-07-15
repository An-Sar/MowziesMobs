package com.bobmowzie.mowziesmobs.server.biome;

import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.BiomeDictionary;

import com.bobmowzie.mowziesmobs.MowziesMobs;
import com.bobmowzie.mowziesmobs.server.entity.foliaath.EntityFoliaath;
import com.bobmowzie.mowziesmobs.server.entity.tribe.EntityTribeElite;

public enum BiomeDictionaryHandler {
    INSTANCE;

    public void onInit() {
        BiomeGenBase.SpawnListEntry foliaathSpawn = new BiomeGenBase.SpawnListEntry(EntityFoliaath.class, MowziesMobs.CONFIG.spawnrateFoliaath, 3, 1);
        BiomeGenBase.SpawnListEntry tribeEliteSpawn = new BiomeGenBase.SpawnListEntry(EntityTribeElite.class, MowziesMobs.CONFIG.spawnrateBarakoa, 0, 0);
        for (BiomeGenBase jungleBiome : BiomeDictionary.getBiomesForType(BiomeDictionary.Type.JUNGLE)) {
            jungleBiome.getSpawnableList(EnumCreatureType.monster).add(foliaathSpawn);
        }
        for (BiomeGenBase savannaBiome : BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SAVANNA)) {
            savannaBiome.getSpawnableList(EnumCreatureType.monster).add(tribeEliteSpawn);
        }
    }
}