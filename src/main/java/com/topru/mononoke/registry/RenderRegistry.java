package com.topru.mononoke.registry;

import com.topru.mononoke.registry.libs.LibBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class RenderRegistry {
    public static void registerRenders() {
        RenderTypeLookup.setRenderLayer(LibBlocks.SOUL_BLOCK, RenderType.getTranslucent());
    }
}
