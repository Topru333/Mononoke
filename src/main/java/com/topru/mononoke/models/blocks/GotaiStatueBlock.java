package com.topru.mononoke.models.blocks;

import com.topru.mononoke.models.blocks.states.IStateRotatable;
import com.topru.mononoke.util.VoxelShapeHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraftforge.common.ToolType;


public class GotaiStatueBlock extends MononokeBlock implements IStateRotatable {

    private static final VoxelShape SHAPE = VoxelShapeHelper.combineAll(
            Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D)
    );

    public GotaiStatueBlock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(-1)
                .noDrops()
                .sound(SoundType.STONE)
                .harvestLevel(5)
                .harvestTool(ToolType.PICKAXE)
        );
    }

    @Override
    public VoxelShape getCurrentShape() {
        return SHAPE;
    }
}
