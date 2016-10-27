package com.bobmowzie.mowziesmobs;

import com.bobmowzie.mowziesmobs.server.ServerEventHandler;
import com.bobmowzie.mowziesmobs.server.ServerProxy;
import com.bobmowzie.mowziesmobs.server.biome.BiomeDictionaryHandler;
import com.bobmowzie.mowziesmobs.server.block.BlockHandler;
import com.bobmowzie.mowziesmobs.server.config.ConfigHandler;
import com.bobmowzie.mowziesmobs.server.creativetab.CreativeTabHandler;
import com.bobmowzie.mowziesmobs.server.entity.EntityHandler;
import com.bobmowzie.mowziesmobs.server.gui.GuiHandler;
import com.bobmowzie.mowziesmobs.server.item.ItemHandler;
import com.bobmowzie.mowziesmobs.server.message.MessagePlayerSolarBeam;
import com.bobmowzie.mowziesmobs.server.message.MessagePlayerSummonSunstrike;
import com.bobmowzie.mowziesmobs.server.message.MessageSwingWroughtAxe;
import com.bobmowzie.mowziesmobs.server.potion.PotionHandler;
import com.bobmowzie.mowziesmobs.server.property.MowziePlayerProperties;
import com.bobmowzie.mowziesmobs.server.sound.MMSounds;
import com.bobmowzie.mowziesmobs.server.world.MowzieWorldGenerator;

import net.ilexiconn.llibrary.server.config.Config;
import net.ilexiconn.llibrary.server.entity.EntityPropertiesHandler;
import net.ilexiconn.llibrary.server.network.NetworkWrapper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MowziesMobs.MODID, name = MowziesMobs.NAME, version = MowziesMobs.VERSION, dependencies = MowziesMobs.DEPENDENCIES)
public class MowziesMobs {
    public static final String MODID = "mowziesmobs";
    public static final String NAME = "Mowzie's Mobs";
    public static final String VERSION = "1.3.0";
    public static final String LLIBRARY_VERSION = "1.7.1";
    public static final String DEPENDENCIES = "required-after:llibrary@[" + MowziesMobs.LLIBRARY_VERSION + ",)";

    @Instance(MowziesMobs.MODID)
    public static MowziesMobs INSTANCE;
    @SidedProxy(clientSide = "com.bobmowzie.mowziesmobs.client.ClientProxy", serverSide = "com.bobmowzie.mowziesmobs.server.ServerProxy")
    public static ServerProxy PROXY;
    @NetworkWrapper({MessageSwingWroughtAxe.class, MessagePlayerSummonSunstrike.class, MessagePlayerSolarBeam.class})
    public static SimpleNetworkWrapper NETWORK_WRAPPER;
    @Config
    public static ConfigHandler CONFIG;
    private static ModContainer container;

    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(ServerEventHandler.INSTANCE);

        MMSounds.INSTANCE.onInit();
        CreativeTabHandler.INSTANCE.onInit();
        ItemHandler.INSTANCE.onInit();
        BlockHandler.INSTANCE.onInit();
        EntityHandler.INSTANCE.onInit();
        PotionHandler.INSTANCE.onInit();

        MowziesMobs.PROXY.onInit();

        EntityPropertiesHandler.INSTANCE.registerProperties(MowziePlayerProperties.class);
        GameRegistry.registerWorldGenerator(new MowzieWorldGenerator(), 0);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event) {
        MowziesMobs.PROXY.onLateInit();
    }

    @EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        BiomeDictionaryHandler.INSTANCE.onInit();
    }

    public static void openGui(EntityPlayer player, GuiHandler.Type type, int x) {
        openGui(player, type, x, 0);
    }

    public static void openGui(EntityPlayer player, GuiHandler.Type type, int x, int y) {
        openGui(player, type, x, y, 0);
    }

    public static void openGui(EntityPlayer player, GuiHandler.Type type, int x, int y, int z) {
        player.openGui(INSTANCE, type.ordinal(), player.worldObj, x, y, z);
    }
}
