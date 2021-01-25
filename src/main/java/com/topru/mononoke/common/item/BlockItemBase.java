package com.topru.mononoke.common.item;

import com.topru.mononoke.client.Mononoke;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block blockIn) {
        super(blockIn, new Item.Properties().group(Mononoke.TAB));
    }
}
