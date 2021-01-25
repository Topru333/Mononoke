package com.topru.mononoke.common.registry.libs;

import com.topru.mononoke.client.Mononoke;
import com.topru.mononoke.common.tile.TileEntitySoul;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class LibTileEntity extends Lib<TileEntityType<?>> {

    private LibTileEntity() {
        this.SOUL_ENTITY =  LibTileEntity.register("soul_entity", TileEntityType.Builder.create(TileEntitySoul::new, LibBlocks.SOUL_BLOCK));
    }

    private static LibTileEntity instance;

    public static LibTileEntity Instance() {
        if (instance == null) instance = new LibTileEntity();
        return instance;
    }

    private final TileEntityType<TileEntitySoul> SOUL_ENTITY;

    public TileEntityType<TileEntitySoul> getSOUL_ENTITY() {
        return SOUL_ENTITY;
    }

    public static <T extends TileEntity> TileEntityType<T> register(String id, TileEntityType.Builder<T> builder)
    {
        TileEntityType<T> type = builder.build(null);
        type.setRegistryName(Mononoke.MOD_ID, id);
        return type;
    }
}
