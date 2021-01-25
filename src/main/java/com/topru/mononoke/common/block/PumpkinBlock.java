package com.topru.mononoke.common.block;

import com.topru.mononoke.common.block.states.IStateRotatable;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PumpkinBlock extends MononokeBlock implements IStateRotatable {
    public PumpkinBlock() {
        super(Block.Properties.create(Material.PLANTS)
                .hardnessAndResistance(1)
                .sound(SoundType.WOOD)
                .harvestTool(ToolType.AXE)
                .lightValue(15)
        );
    }
}
