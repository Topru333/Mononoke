package com.topru.mononoke.models.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class MononokeOreBlock extends OreBlock {
    private final int minXP;
    private final int maxXP;

    public MononokeOreBlock(Properties properties, int minXP, int maxXP) {
        super(properties);
        this.minXP = minXP;
        this.maxXP = maxXP;
    }

    @Override
    protected int getExperience(Random rand) {
        return MathHelper.nextInt(rand, minXP, maxXP);
    }
}
