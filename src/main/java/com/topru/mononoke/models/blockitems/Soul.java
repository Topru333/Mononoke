package com.topru.mononoke.models.blockitems;

import com.topru.mononoke.Mononoke;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class Soul extends BlockItem {
    public Soul(Block blockIn) {
        super(blockIn, new Item.Properties().group(Mononoke.TAB).maxStackSize(8));
    }
}
