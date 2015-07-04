package com.bobmowzie.mowziesmobs;

import com.bobmowzie.mowziesmobs.common.ServerEventHandler;
import com.bobmowzie.mowziesmobs.common.ServerProxy;
import com.bobmowzie.mowziesmobs.common.biome.MMBiomeDictionarySpawns;
import com.bobmowzie.mowziesmobs.common.creativetab.MMTabs;
import com.bobmowzie.mowziesmobs.common.entity.MMEntityRegistry;
import com.bobmowzie.mowziesmobs.common.gen.MMStructureGenerator;
import com.bobmowzie.mowziesmobs.common.gen.MMWorldGenerator;
import com.bobmowzie.mowziesmobs.common.item.MMItems;
import com.bobmowzie.mowziesmobs.common.message.MessagePlaySound;
import com.bobmowzie.mowziesmobs.common.message.foliaath.MessageDecreaseTimer;
import com.bobmowzie.mowziesmobs.common.message.foliaath.MessageIncreaseTimer;
import com.bobmowzie.mowziesmobs.common.message.foliaath.MessageSetActiveFalse;
import com.bobmowzie.mowziesmobs.common.message.foliaath.MessageSetActiveTrue;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.ilexiconn.llibrary.common.content.ContentHelper;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "mowziesmobs", name = "Mowzie's Mobs", version = "${version}", dependencies = "required-after:llibrary@[0.3.1-1.7.10,)")
public class MowziesMobs
{
    public static final MMStructureGenerator gen = new MMStructureGenerator();
    public static SimpleNetworkWrapper networkWrapper;
    @Instance("mowziesmobs")
    public static MowziesMobs instance;
    @SidedProxy(clientSide = "com.bobmowzie.mowziesmobs.client.ClientProxy", serverSide = "com.bobmowzie.mowziesmobs.common.ServerProxy")
    public static ServerProxy proxy;

    public static String getModId()
    {
        return "mowziesmobs:";
    }

    public static void playSound(int entityId, String soundName)
    {
        playSound(entityId, soundName, 1, 1);
    }

    public static void playSound(int entityId, String soundName, float volume, float pitch)
    {
        if (FMLCommonHandler.instance().getEffectiveSide().isClient())
            networkWrapper.sendToServer(new MessagePlaySound(entityId, soundName, volume, pitch));
    }

    public static boolean isDebugging()
    {
        return "${version}".equals("${" + "version" + "}");
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ContentHelper.init(new MMTabs(), new MMItems(), new MMEntityRegistry());

        MinecraftForge.EVENT_BUS.register(new ServerEventHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();

        GameRegistry.registerWorldGenerator(new MMWorldGenerator(), 0);

        networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("mowziesMobs");
        networkWrapper.registerMessage(MessageIncreaseTimer.class, MessageIncreaseTimer.class, 0, Side.CLIENT);
        networkWrapper.registerMessage(MessageDecreaseTimer.class, MessageDecreaseTimer.class, 1, Side.CLIENT);
        networkWrapper.registerMessage(MessagePlaySound.class, MessagePlaySound.class, 2, Side.SERVER);
        networkWrapper.registerMessage(MessageSetActiveTrue.class, MessageSetActiveTrue.class, 3, Side.SERVER);
        networkWrapper.registerMessage(MessageSetActiveFalse.class, MessageSetActiveFalse.class, 4, Side.SERVER);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        MMBiomeDictionarySpawns.init();
    }
}
