package com.topru.mononoke.fx.particles;

import net.minecraft.client.particle.*;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class SoulFlameParticle extends SpriteTexturedParticle {

    private final IAnimatedSprite sprites;

    public SoulFlameParticle(World world, double x, double y, double z,
                             double velocityX, double velocityY, double velocityZ,
                             double diameter,
                             IAnimatedSprite sprites) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        setColor(1, 1, 1);
        setSize((float)diameter, (float)diameter);
        
        this.particleScale =  0.5F * (float)diameter; // if the particleScale is 0.5, the texture will be rendered as 1 metre high, sets the rendering size of the particle for a TexturedParticle.
        this.maxAge = 40;  // lifetime in ticks: 100 ticks = 5 seconds
        this.particleAlpha = 1.0F;
        this.sprites = sprites;
        this.motionX = velocityX;
        this.motionY = velocityY;
        this.motionZ = velocityZ;

        this.canCollide = false;  // the move() method will check for collisions with scenery
    }

    // Choose the appropriate render type for your particles:
    // There are several useful predefined types:
    // PARTICLE_SHEET_TRANSLUCENT semi-transparent (translucent) particles
    // PARTICLE_SHEET_OPAQUE    opaque particles
    // TERRAIN_SHEET            particles drawn from block or item textures
    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick()
    {
        // if you want to change the texture as the particle gets older, you can use
        // selectSpriteWithAge(sprites);

    	this.prevPosX = posX;
    	this.prevPosY = posY;
    	this.prevPosZ = posZ;

        move(motionX, motionY, motionZ);  // simple linear motion.  You can change speed by changing motionX, motionY,
        // motionZ every tick.  For example - you can make the particle accelerate downwards due to gravity by
        // final double GRAVITY_ACCELERATION_PER_TICK = -0.02;
        // motionY += GRAVITY_ACCELERATION_PER_TICK;
        // calling move() also calculates collisions with other objects

        // collision with a block makes the ball disappear.  But does not collide with entities
        if (onGround) {  // onGround is only true if the particle collides while it is moving downwards...
            this.setExpired();
        }

        if (prevPosY == posY && motionY > 0) {  // detect a collision while moving upwards (can't move up at all)
            this.setExpired();
        }

        if (this.age++ >= this.maxAge) {
            this.setExpired();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {

        private final IAnimatedSprite sprites;

        public Factory(IAnimatedSprite sprites) {
            this.sprites = sprites;
        }

        @Nullable
        @Override
        public Particle makeParticle(BasicParticleType typeIn, World world, double xPos, double yPos, double zPos, double xVelocity, double yVelocity, double zVelocity) {
            SoulFlameParticle particle = new SoulFlameParticle(world, xPos, yPos, zPos, xVelocity, yVelocity, zVelocity,
                    0.03,
                    sprites);
            particle.selectSpriteRandomly(sprites);
            return particle;
        }

        /*
        private Factory() {
            // infinite loop
            throw new UnsupportedOperationException("Use the FlameParticleFactory(IAnimatedSprite sprite) constructor");
        }
         */
    }
}
