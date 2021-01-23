package com.topru.mononoke.registry.libs;

import com.topru.mononoke.Mononoke;
import com.topru.mononoke.models.items.armor.ItemSouluriumArmor;
import com.topru.mononoke.registry.ArmorMaterialRegistry;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Mononoke.MOD_ID)
public class LibArmor extends Lib<Item> {

    private LibArmor() {
        this.SOULURIUM_HELMET = new ItemSouluriumArmor("soulurium_helmet", ArmorMaterialRegistry.soulurium, EquipmentSlotType.HEAD, new Item.Properties().group(Mononoke.TAB));
        this.SOULURIUM_CHESTPLATE = new ItemSouluriumArmor("soulurium_chestplate", ArmorMaterialRegistry.soulurium, EquipmentSlotType.CHEST, new Item.Properties().group(Mononoke.TAB));
        this.SOULURIUM_LEGGINGS = new ItemSouluriumArmor("soulurium_leggings", ArmorMaterialRegistry.soulurium, EquipmentSlotType.LEGS, new Item.Properties().group(Mononoke.TAB));
        this.SOULURIUM_BOOTS = new ItemSouluriumArmor("soulurium_boots", ArmorMaterialRegistry.soulurium, EquipmentSlotType.FEET, new Item.Properties().group(Mononoke.TAB));
    }

    private static LibArmor instance;

    public static LibArmor Instance() {
        if (instance == null) instance = new LibArmor();
        return instance;
    }

    public static Item SOULURIUM_HELMET;
    public static Item SOULURIUM_CHESTPLATE;
    public static Item SOULURIUM_LEGGINGS;
    public static Item SOULURIUM_BOOTS;

    public static Item getSouluriumHelmet() {
        return SOULURIUM_HELMET;
    }

    public static Item getSouluriumChestplate() {
        return SOULURIUM_CHESTPLATE;
    }

    public static Item getSouluriumLeggings() {
        return SOULURIUM_LEGGINGS;
    }

    public static Item getSouluriumBoots() {
        return SOULURIUM_BOOTS;
    }
}
