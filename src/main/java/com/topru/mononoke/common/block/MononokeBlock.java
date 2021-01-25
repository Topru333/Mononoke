package com.topru.mononoke.common.block;

import com.topru.mononoke.common.block.states.IStateFluidLoggable;
import com.topru.mononoke.util.StateHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nonnull;

public abstract class MononokeBlock extends Block {


    protected MononokeBlock(Block.Properties properties) {
        super(properties);
        setDefaultState(StateHelper.getDefaultState(stateContainer.getBaseState()));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        StateHelper.fillBlockStateContainer(this, builder);
    }


    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return StateHelper.getStateForPlacement(this, super.getStateForPlacement(context), context);
    }

    @Override
    public IFluidState getFluidState(@Nonnull BlockState state) {
        if (state.getBlock() instanceof IStateFluidLoggable) {
            return ((IStateFluidLoggable) state.getBlock()).getFluid(state);
        }
        return super.getFluidState(state);
    }

    @Override
    public BlockState updatePostPlacement(@Nonnull BlockState state, @Nonnull Direction facing, @Nonnull BlockState facingState, @Nonnull IWorld world, @Nonnull BlockPos currentPos,
                                          @Nonnull BlockPos facingPos) {
        if (state.getBlock() instanceof IStateFluidLoggable) {
            ((IStateFluidLoggable) state.getBlock()).updateFluids(state, world, currentPos);
        }
        return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
    }

    public VoxelShape getCurrentShape() {
        return VoxelShapes.fullCube();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return getCurrentShape();
    }

}
