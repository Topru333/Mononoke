package com.topru.mononoke;

import com.topru.mononoke.events.KillsHandler;
import com.topru.mononoke.models.itemgroups.MononokeGroup;
import com.topru.mononoke.registry.libs.LibParticleTypes;
import com.topru.mononoke.registry.RenderRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mononoke")
public class Mononoke {
    public static final String MOD_ID = "mononoke";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final ItemGroup TAB = new MononokeGroup();
    public static CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public Mononoke() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientSetupEvent);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doParticleSetup);
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new KillsHandler());
    }

    public void doClientSetupEvent(FMLClientSetupEvent event) {
        RenderRegistry.registerRenders();
    }

    private void doParticleSetup(final ParticleFactoryRegisterEvent event) {
        LibParticleTypes.Instance().registerFactories();
    }
}
