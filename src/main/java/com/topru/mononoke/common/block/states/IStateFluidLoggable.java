package com.topru.mononoke.common.block.states;

import net.minecraft.block.BlockState;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.util.Constants.BlockFlags;

import javax.annotation.Nonnull;

public interface  IStateFluidLoggable extends IBucketPickupHandler, ILiquidContainer {

    default boolean isValidFluid(@Nonnull Fluid fluid) {
        return fluid == getSupportedFluid();
    }

    default Fluid getSupportedFluid() {
        return Fluids.WATER;
    }

    @Nonnull
    default IFluidState getFluid(@Nonnull BlockState state) {
        if (state.get(BlockStateProperties.WATERLOGGED)) {
            Fluid fluid = getSupportedFluid();
            if (fluid instanceof FlowingFluid) {
                return ((FlowingFluid) fluid).getStillFluidState(false);
            }
            return fluid.getDefaultState();
        }
        return Fluids.EMPTY.getDefaultState();
    }

    default void updateFluids(@Nonnull BlockState state, @Nonnull IWorld world, @Nonnull BlockPos currentPos) {
        if (state.get(BlockStateProperties.WATERLOGGED)) {
            Fluid fluid = getSupportedFluid();
            world.getPendingFluidTicks().scheduleTick(currentPos, fluid, fluid.getTickRate(world));
        }
    }

    @Override
    default boolean canContainFluid(@Nonnull IBlockReader world, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull Fluid fluid) {
        return !state.get(BlockStateProperties.WATERLOGGED) && isValidFluid(fluid);
    }

    @Override
    default boolean receiveFluid(@Nonnull IWorld world, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull IFluidState fluidState) {
        Fluid fluid = fluidState.getFluid();
        if (canContainFluid(world, pos, state, fluid)) {
            if (!world.isRemote()) {
                world.setBlockState(pos, state.with(BlockStateProperties.WATERLOGGED, true), BlockFlags.DEFAULT);
                world.getPendingFluidTicks().scheduleTick(pos, fluid, fluid.getTickRate(world));
            }
            return true;
        }
        return false;
    }

    @Nonnull
    @Override
    default Fluid pickupFluid(@Nonnull IWorld world, @Nonnull BlockPos pos, @Nonnull BlockState state) {
        if (state.get(BlockStateProperties.WATERLOGGED)) {
            world.setBlockState(pos, state.with(BlockStateProperties.WATERLOGGED, false), BlockFlags.DEFAULT);
            return getSupportedFluid();
        }
        return Fluids.EMPTY;
    }

}
