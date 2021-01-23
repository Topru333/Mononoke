package com.topru.mononoke.fx;

import com.topru.mononoke.registry.libs.LibItems;
import com.topru.mononoke.registry.libs.LibParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class FxDispatcher {

    private FxDispatcher() {}

    private static FxDispatcher instance;

    public static FxDispatcher Instance() {
        if (instance == null) instance = new FxDispatcher();
        return instance;
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
