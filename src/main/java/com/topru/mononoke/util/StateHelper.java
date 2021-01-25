package com.topru.mononoke.util;

import com.topru.mononoke.common.block.states.IStateFluidLoggable;
import com.topru.mononoke.common.block.states.IStateRotatable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class StateHelper {
    public static BlockState getDefaultState(@Nonnull BlockState state) {
        Block block = state.getBlock();
        if (block instanceof IStateFluidLoggable) {
            state = state.with(BlockStateProperties.WATERLOGGED, false);
        }
        if (block instanceof IStateRotatable) {
            state = state.with(HorizontalBlock.HORIZONTAL_FACING, Direction.NORTH);
        }
        return state;
    }

    public static void fillBlockStateContainer(Block block, StateContainer.Builder<Block, BlockState> builder) {
        List<IProperty<?>> properties = new ArrayList<>();
        if (block instanceof IStateFluidLoggable) {
            properties.add(BlockStateProperties.WATERLOGGED);
        }
        if (block instanceof IStateRotatable) {
            properties.add(HorizontalBlock.HORIZONTAL_FACING);
        }
        if (!properties.isEmpty()) {
            builder.add(properties.toArray(new IProperty[0]));
        }
    }

    public static BlockState getStateForPlacement(Block block, @Nullable BlockState state, BlockItemUseContext context) {
        return getStateForPlacement(block, state, context.getWorld(), context.getPos(), context.getPlayer(), context.getPlacementHorizontalFacing());
    }

    public static BlockState getStateForPlacement(Block block, @Nullable BlockState state, @Nonnull IWorld world, @Nonnull BlockPos pos, @Nullable PlayerEntity player, @Nonnull Direction face) {
        if (state == null) {
            return null;
        }
        if (block instanceof IStateFluidLoggable) {
            state = state.with(BlockStateProperties.WATERLOGGED,  world.getFluidState(pos).getFluid() == Fluids.WATER);
        }
        if (block instanceof IStateRotatable) {
            state = state.with(HorizontalBlock.HORIZONTAL_FACING, face.getOpposite());
        }
        return state;
    }
}
