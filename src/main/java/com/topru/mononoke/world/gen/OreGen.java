package com.topru.mononoke.world.gen;

import net.minecraft.world.gen.placement.CountRangeConfig;

public class OreGen {
    private static final CountRangeConfig SOULURIUM = new CountRangeConfig(5, 0, 20, 32);
    private static final int SOULURIUM_VEIN_SIZE = 8;  // max size of vein

    public static void setupOreGen() {
        /*
        for (Biome biome : ForgeRegistries.BIOMES) {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.SOULURIUM_ORE.getDefaultState(), SOULURIUM_VEIN_SIZE)
                    ).withPlacement(Placement.COUNT_RANGE.configure(SOULURIUM))
            );
        }
        */
    }
}
