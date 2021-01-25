package com.topru.mononoke.common.registry.libs;

import com.topru.mononoke.client.Mononoke;
import com.topru.mononoke.common.item.BlockItemBase;
import com.topru.mononoke.common.item.MononokeItem;
import com.topru.mononoke.common.item.SoulItem;
import com.topru.mononoke.util.CreatureType;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Mononoke.MOD_ID)
public class LibItems extends Lib<Item> {

    private LibItems() {
        SOULURIUM_INGOT = new MononokeItem().setRegistryName("soulurium_ingot");
        SOULURIUM_ROD = new MononokeItem().setRegistryName("soulurium_rod");
        HITODAMA_ESSENCE = new MononokeItem().setRegistryName("soul_essence");
        HITODAMA_ESSENCE_FRAGMENT = new MononokeItem().setRegistryName("soul_essence_fragment");

        ORDINARY_SOUL_ITEM = new SoulItem(CreatureType.UNDEFINED).setRegistryName("soul_item_ordinary");
        ILLAGER_SOUL_ITEM = new SoulItem(CreatureType.ILLAGER).setRegistryName("soul_item_illager");
        ARTHROPOD_SOUL_ITEM = new SoulItem(CreatureType.ARTHROPOD).setRegistryName("soul_item_arthropod");
        WATER_SOUL_ITEM = new SoulItem(CreatureType.WATER).setRegistryName("soul_item_water");
        UNDEAD_SOUL_ITEM = new SoulItem(CreatureType.UNDEAD).setRegistryName("soul_item_undead");

        BASE_STATUE_BLOCK_ITEM = new BlockItemBase(LibBlocks.BASE_STATUE_BLOCK).setRegistryName("mononoke_base_block");
        GOTAI_STATUE_BLOCK_ITEM = new BlockItemBase(LibBlocks.GOTAI_STATUE_BLOCK).setRegistryName("gotai_statue_block");
        MONONOKE_PUMPKIN_BLOCK_ITEM = new BlockItemBase(LibBlocks.MONONOKE_PUMPKIN_BLOCK).setRegistryName("mononoke_pumpkin");
        SOUL_BLOCK_ITEM = new BlockItemBase(LibBlocks.SOUL_BLOCK).setRegistryName("soul_block");
        SOULURIUM_BLOCK_ITEM = new BlockItemBase(LibBlocks.SOULURIUM_BLOCK).setRegistryName("soulurium_block");
    }

    private static LibItems instance;

    public static LibItems Instance() {
        if (instance == null) instance = new LibItems();
        return instance;
    }

    private final Item SOULURIUM_INGOT;
    private final Item SOULURIUM_ROD;
    private final Item HITODAMA_ESSENCE;
    private final Item HITODAMA_ESSENCE_FRAGMENT;

    // Items
    private final Item UNDEAD_SOUL_ITEM;
    private final Item ORDINARY_SOUL_ITEM;
    private final Item ARTHROPOD_SOUL_ITEM;
    private final Item ILLAGER_SOUL_ITEM;
    private final Item WATER_SOUL_ITEM;

    // Block items
    private final Item BASE_STATUE_BLOCK_ITEM;
    private final Item GOTAI_STATUE_BLOCK_ITEM;
    private final Item MONONOKE_PUMPKIN_BLOCK_ITEM;
    private final Item SOUL_BLOCK_ITEM;

    private final Item SOULURIUM_BLOCK_ITEM;

    public Item getSOULURIUM_INGOT() {
        return SOULURIUM_INGOT;
    }

    public Item getSOULURIUM_ROD() {
        return SOULURIUM_ROD;
    }

    public Item getHITODAMA_ESSENCE() {
        return HITODAMA_ESSENCE;
    }

    public Item getHITODAMA_ESSENCE_FRAGMENT() {
        return HITODAMA_ESSENCE_FRAGMENT;
    }

    public Item getUNDEAD_SOUL_ITEM() {
        return UNDEAD_SOUL_ITEM;
    }

    public Item getORDINARY_SOUL_ITEM() {
        return ORDINARY_SOUL_ITEM;
    }

    public Item getARTHROPOD_SOUL_ITEM() {
        return ARTHROPOD_SOUL_ITEM;
    }

    public Item getILLAGER_SOUL_ITEM() {
        return ILLAGER_SOUL_ITEM;
    }

    public Item getWATER_SOUL_ITEM() {
        return WATER_SOUL_ITEM;
    }

    public Item getBASE_STATUE_BLOCK_ITEM() {
        return BASE_STATUE_BLOCK_ITEM;
    }

    public Item getGOTAI_STATUE_BLOCK_ITEM() {
        return GOTAI_STATUE_BLOCK_ITEM;
    }

    public Item getMONONOKE_PUMPKIN_BLOCK_ITEM() {
        return MONONOKE_PUMPKIN_BLOCK_ITEM;
    }

    public Item getSOUL_BLOCK_ITEM() {
        return SOUL_BLOCK_ITEM;
    }

    public Item getSOULURIUM_BLOCK_ITEM() {
        return SOULURIUM_BLOCK_ITEM;
    }


}
