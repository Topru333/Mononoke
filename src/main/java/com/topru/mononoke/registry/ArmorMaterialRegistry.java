package com.topru.mononoke.registry;

import com.topru.mononoke.Mononoke;
import com.topru.mononoke.registry.libs.LibItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum ArmorMaterialRegistry implements IArmorMaterial {
    soulurium("soulurium", 39, new int[] {4, 7, 9, 4}, 18, LibItems.Instance().getSOULURIUM_INGOT(), SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0f),
    powered_soulurium("powered_soulurium", 48, new int[] {5, 8, 10, 5}, 18, LibItems.Instance().getSOULURIUM_INGOT(), SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.5f);

    private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
    private String name;
    private SoundEvent equipSound;
    private int maxDamageFactor;
    private int  enchantability;
    private Item repairItem;
    private int[] damageReductionAmount;
    private float toughness;

    ArmorMaterialRegistry(String name,  int maxDamageFactorIn, int[] damageReductionAmount, int enchantability, Item repairItem, SoundEvent equipSoundIn, float toughness)
    {
        this.name = name;
        this.maxDamageFactor = maxDamageFactorIn;
        this.equipSound = equipSoundIn;
        this.enchantability = enchantability;
        this.repairItem = repairItem;
        this.damageReductionAmount = damageReductionAmount;
        this.toughness = toughness;
    }

    @Override
    public int getDurability(EquipmentSlotType slot) {
        return max_damage_array[slot.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slot) {
        return damageReductionAmount[slot.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairItem);
    }

    @Override
    public String getName() {
        return Mononoke.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}
