package com.bobmowzie.mowziesmobs.common.item;

import com.bobmowzie.mowziesmobs.MowziesMobs;
import com.bobmowzie.mowziesmobs.common.creativetab.MMTabs;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by jnad325 on 11/1/15.
 */
public class ItemBarakoaMask extends ItemArmor {
    static final String ARMOR_TEXTURE_FORMAT = MowziesMobs.MODID + ":textures/entity/textureTribesman%s.png";

    private final BarakoaMask type;

    public ItemBarakoaMask(BarakoaMask type)
    {
        super(ArmorMaterial.CLOTH, 2, 0);
        this.type = type;
        setUnlocalizedName(type.getUnlocalizedName());
        setCreativeTab(MMTabs.generic);
    }

    public BarakoaMask getType()
    {
        return type;
    }

    public int getPotionEffectId()
    {
        return type.getPotionEffectId();
    }

    @Override
    public boolean getIsRepairable(ItemStack itemStack, ItemStack materialItemStack)
    {
        return false;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String variant)
    {
        return type.getArmorTexture();
    }

    @Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
    {
        ModelBiped armorModel = null;
        if (itemStack != null && itemStack.getItem() instanceof ItemBarakoaMask)
        {
            armorModel = MowziesMobs.proxy.getArmorModel(1);
        }
        return armorModel;
    }

    @Override
    public void registerIcons(IIconRegister registrar)
    {
    }

    @Override
    public int getColor(ItemStack itemStack)
    {
        return 0xFFFFFFFF;
    }

    @Override
    public ArmorMaterial getArmorMaterial() {
        return ArmorMaterial.CHAIN;
    }
}
