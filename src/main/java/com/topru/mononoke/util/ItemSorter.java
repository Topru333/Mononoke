package com.topru.mononoke.util;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

import java.util.Comparator;

public class ItemSorter implements Comparator<ItemStack> {
    @Override
    public int compare(ItemStack o1, ItemStack o2)
    {
        int weight1 = getWeight(o1);
        int weight2 = getWeight(o2);

        if (weight1 < weight2)
        {
            return -1;
        }

        if (weight2 < weight1)
        {
            return 1;
        }

        String displayName1 = o1.getDisplayName().getString();
        String displayName2 = o2.getDisplayName().getString();

        int result = displayName1.compareToIgnoreCase(displayName2);

        return result;
    }

    private int getWeight(ItemStack item) {
        if (item.getEquipmentSlot() != null) {
            return  2;
        }
        else if (item.getToolTypes().size() > 0) {
            return  3;
        }
        else if (item.getItem() instanceof ArmorItem) {
            return 4;
        }
        else if (item.getItem() instanceof BlockItem) {
            return 5;
        }
        return 1;
    }
}
