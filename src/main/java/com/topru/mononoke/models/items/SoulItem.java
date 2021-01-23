package com.topru.mononoke.models.items;

import com.topru.mononoke.util.CreatureType;
import net.minecraft.item.Item;

public class SoulItem extends MononokeItem {
    public SoulItem(CreatureType type) {
        super(new Item.Properties().maxStackSize(8));
        this.setLoreTag(type.getSoulData().getLoretag());
    }
}
