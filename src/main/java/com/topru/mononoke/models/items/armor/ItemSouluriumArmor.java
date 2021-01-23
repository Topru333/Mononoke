package com.topru.mononoke.models.items.armor;

import com.topru.mononoke.Mononoke;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class ItemSouluriumArmor extends ArmorItem {

    public ItemSouluriumArmor(String name, IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties builder) {
        super(materialIn, slot, builder);
        this.setRegistryName(Mononoke.MOD_ID, name);
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new SouluriumModelArmor(armorSlot);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        switch (slot) {
            case FEET:
                return Mononoke.MOD_ID + ":textures/models/armor/soulurium_boots.png";
            case LEGS:
                return Mononoke.MOD_ID + ":textures/models/armor/soulurium_legs.png";
            case CHEST:
                return Mononoke.MOD_ID + ":textures/models/armor/soulurium_chestplate.png";
            case HEAD:
                return Mononoke.MOD_ID + ":textures/models/armor/soulurium_helm.png";
        }
        return "";
    }
}
