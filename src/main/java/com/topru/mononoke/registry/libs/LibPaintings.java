package com.topru.mononoke.registry.libs;

import com.topru.mononoke.Mononoke;
import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Mononoke.MOD_ID)
public class LibPaintings extends Lib<PaintingType> {

    private LibPaintings() {
        this.KITSUNE_PAINTING = new PaintingType(64,64).setRegistryName("kitsune");
        this.FOREST_MONONOKE_PAINTING = new PaintingType(64,48).setRegistryName("forest-mononoke");
    }

    private static LibPaintings instance;

    public static LibPaintings Instance() {
        if (instance == null) instance = new LibPaintings();
        return instance;
    }

    public final PaintingType KITSUNE_PAINTING;
    public final PaintingType FOREST_MONONOKE_PAINTING;

    public PaintingType getKITSUNE_PAINTING() {
        return KITSUNE_PAINTING;
    }

    public PaintingType getFOREST_MONONOKE_PAINTING() {
        return FOREST_MONONOKE_PAINTING;
    }
}
