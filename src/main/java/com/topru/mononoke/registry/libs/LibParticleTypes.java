package com.topru.mononoke.registry.libs;

import com.topru.mononoke.Mononoke;
import com.topru.mononoke.fx.particles.SoulFlameParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Mononoke.MOD_ID)
public class LibParticleTypes extends Lib<BasicParticleType>{

    private LibParticleTypes() {
        this.SOUL_FLAME = new BasicParticleType(true);
        this.SOUL_FLAME.setRegistryName("soul_flame_particle");
    }

    private static LibParticleTypes instance;

    public static LibParticleTypes Instance() {
        if (instance == null) instance = new LibParticleTypes();
        return instance;
    }

    private final BasicParticleType SOUL_FLAME;

    public BasicParticleType getSOUL_FLAME() {
        return SOUL_FLAME;
    }

    public void registerFactories() {
        Minecraft.getInstance().particles.registerFactory(this.SOUL_FLAME, sprite -> new SoulFlameParticle.Factory(sprite));
    }


}
