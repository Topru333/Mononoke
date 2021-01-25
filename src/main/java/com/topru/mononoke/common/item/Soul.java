package com.topru.mononoke.common.item;

import com.topru.mononoke.client.Mononoke;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

@Deprecated
public class Soul extends BlockItem {
    public Soul(Block blockIn) {
        super(blockIn, new Item.Properties().group(Mononoke.TAB).maxStackSize(8));
    }
}
