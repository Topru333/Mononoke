package com.topru.mononoke.common.itemgroup;

import com.topru.mononoke.common.registry.libs.LibItems;
import com.topru.mononoke.util.ItemSorter;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.Collections;

public class MononokeGroup extends ItemGroup {

    private ItemSorter itemSorter = new ItemSorter();

    public MononokeGroup() {
        super("MononokeTab");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(LibItems.Instance().getORDINARY_SOUL_ITEM());
    }

    @Override
    public void fill(NonNullList<ItemStack> items) {
        super.fill(items);
        Collections.sort(items, itemSorter);
    }

}
