package com.topru.mononoke.models.blocks;

import com.topru.mononoke.models.blocks.states.IStateRotatable;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BaseStatueBlock extends MononokeBlock implements IStateRotatable {

    public BaseStatueBlock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(-1)
                .noDrops()
                .sound(SoundType.STONE)
                .harvestLevel(5)
                .harvestTool(ToolType.PICKAXE)
        );
    }

}
