package com.topru.mononoke.common.block;

import com.topru.mononoke.common.registry.libs.LibParticleTypes;
import com.topru.mononoke.common.block.states.IStateFluidLoggable;
import com.topru.mononoke.common.registry.libs.LibTileEntity;
import com.topru.mononoke.util.VoxelShapeHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.IParticleData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class SoulBlock extends MononokeBlock implements IStateFluidLoggable {

    private static final VoxelShape SHAPE = VoxelShapeHelper.combineAll(
            Block.makeCuboidShape(6.0D, 6.0D, 6.0D, 10.0D, 10.0D, 10.0D)
    );

    public SoulBlock() {
        super(Properties.create(Material.ORGANIC).hardnessAndResistance(-1).doesNotBlockMovement().lightValue(13).sound(SoundType.NETHER_WART));
    }

    @Override
    public VoxelShape getCurrentShape() {
        return SHAPE;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public boolean hasTileEntity() {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return LibTileEntity.Instance().getSOUL_ENTITY().create();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (worldIn.isRemote) {
            final double PERCENT_CHANCE_OF_FLAME_SPAWN = 20;  // only spawn flame particles occasionally (visually distracting if too
            if (rand.nextDouble() < PERCENT_CHANCE_OF_FLAME_SPAWN / 100.0) {
                soulPowerSparkle(pos, 60, 255,255,255, rand);
            }
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean addDestroyEffects(BlockState state, World world, BlockPos pos, ParticleManager manager) {
        //manager.
        return true;
    }

    @Override
    @Deprecated
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        return true;
    }

    public void soulPowerSparkle(BlockPos pos, int maxAge, float r, float g, float b, Random rand) {
        double xpos = pos.getX() + 0.5;
        double ypos = pos.getY() + 0.6;
        double zpos = pos.getZ() + 0.5;
        double velocityX = 0.0D; // increase in x position every tick
        double velocityY = 0.01D; // increase in y position every tick
        double velocityZ = 0.0D; // increase in z position every tick

        // add a small amount of wobble to stop particles rendering directly on top of each other (z-fighting) which makes them look weird
        final double POSITION_WOBBLE_AMOUNT = 0.3;
        xpos += POSITION_WOBBLE_AMOUNT * (rand.nextDouble() - 0.5);
        zpos += POSITION_WOBBLE_AMOUNT * (rand.nextDouble() - 0.5);

        Particle p = Minecraft.getInstance().particles.addParticle((IParticleData) LibParticleTypes.Instance().getSOUL_FLAME(),
                xpos, ypos, zpos, velocityX, velocityY, velocityZ);

        if (p != null) {
            p.setColor(r / 255.0F, g / 255.0F, b / 255.0F);
            p.setMaxAge(maxAge);
        }
    }

}
