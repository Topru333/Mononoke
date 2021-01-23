package com.topru.mononoke.models.enchantments;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;

public class ShinigamiEnchantment extends DamageEnchantment {
    public ShinigamiEnchantment() {
        super(Rarity.UNCOMMON,0, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND, EquipmentSlotType.OFFHAND});
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean canApplyTogether(Enchantment ench) {
        return true;
    }
}
