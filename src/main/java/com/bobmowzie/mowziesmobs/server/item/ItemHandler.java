package com.bobmowzie.mowziesmobs.server.item;

import com.bobmowzie.mowziesmobs.server.entity.barakoa.MaskType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public enum ItemHandler {
    INSTANCE;

    public Item foliaathSeed;
    public Item testStructure;
    public Item mobRemover;
    public Item wroughtAxe;
    public Item wroughtHelmet;
    public ItemBarakoaMask[] barakoaMasks;
    public ItemBarakoMask barakoMask;
    public Item dart;
    public Item spear;
    public Item blowgun;
    public Item spawnEgg;
    public Item grantSunsBlessing;

    public void onInit() {
        foliaathSeed = new ItemFoliaathSeed();
        testStructure = new ItemTestStructure();
        mobRemover = new ItemMobRemover();
        wroughtAxe = new ItemWroughtAxe();
        wroughtHelmet = new ItemWroughtHelm();
        MaskType[] types = MaskType.values();
        barakoaMasks = new ItemBarakoaMask[types.length];
        for (int i = 0; i < types.length; i++) {
            barakoaMasks[i] = new ItemBarakoaMask(types[i]);
        }
        barakoMask = new ItemBarakoMask();
        dart = new ItemDart();
        spear = new ItemSpear();
        blowgun = new ItemBlowgun();
        spawnEgg = new ItemSpawnEgg();
        grantSunsBlessing = new ItemGrantSunsBlessing();

        GameRegistry.register(spawnEgg);

        GameRegistry.register(foliaathSeed);
        GameRegistry.register(wroughtAxe);
        GameRegistry.register(wroughtHelmet);
        for (ItemBarakoaMask itemBarakoaMask : barakoaMasks) {
            GameRegistry.register(itemBarakoaMask);
        }
        GameRegistry.register(barakoMask);
        GameRegistry.register(dart);
        GameRegistry.register(spear);
        GameRegistry.register(blowgun);

        GameRegistry.register(mobRemover);
        GameRegistry.register(grantSunsBlessing);

        GameRegistry.register(testStructure);
    }
}
