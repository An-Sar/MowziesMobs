package com.bobmowzie.mowziesmobs.client;

import com.bobmowzie.mowziesmobs.MowziesMobs;
import com.bobmowzie.mowziesmobs.client.debug.ModelGrapher;
import com.bobmowzie.mowziesmobs.client.model.entity.*;
import com.bobmowzie.mowziesmobs.client.model.item.ModelWroughtAxe;
import com.bobmowzie.mowziesmobs.client.model.item.ModelWroughtHelm;
import com.bobmowzie.mowziesmobs.client.render.entity.*;
import com.bobmowzie.mowziesmobs.common.ServerProxy;
import com.bobmowzie.mowziesmobs.common.entity.*;
import com.bobmowzie.mowziesmobs.common.item.MMItems;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.llibrary.client.render.RenderHelper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;

@SideOnly(Side.CLIENT)
public class ClientProxy extends ServerProxy
{
    private static final ModelWroughtHelm modelWroughtHelm = new ModelWroughtHelm();

    public void init()
    {
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        if (MowziesMobs.isDebugging()) {
            MinecraftForge.EVENT_BUS.register(ModelGrapher.INSTANCE);
            FMLCommonHandler.instance().bus().register(ModelGrapher.INSTANCE);
        }

        RenderingRegistry.registerEntityRenderingHandler(EntityBabyFoliaath.class, new RenderBabyFoliaath(new ModelBabyFoliaath(), 0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFoliaath.class, new RenderFoliaath(new ModelFoliaath(), 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityWroughtnaut.class, new RenderWroughtnaut(new ModelWroughtnaut(), 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityTribeLeader.class, new RenderTribeLeader(new ModelTribeLeader(), 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityTribesman.class, new RenderTribesman(new ModelTribesman(), 0.8F));
        RenderHelper.registerItem3dRenderer(MMItems.itemWroughtAxe, new ModelWroughtAxe(), new ResourceLocation(MowziesMobs.getModId() + "textures/items/modeled/textureWroughtAxe.png"));
        RenderHelper.registerItem3dRenderer(MMItems.itemWroughtHelm, new ModelWroughtHelm(), new ResourceLocation(MowziesMobs.getModId() + "textures/items/modeled/textureWroughtHelm.png"));
        RenderHelper.registerModelExtension(new ModelPlayerExtension());
    }

    public ModelBiped getArmorModel()
    {
        return modelWroughtHelm;
    }
}
