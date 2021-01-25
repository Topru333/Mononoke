package com.topru.mononoke.client;

import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Mononoke.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {
    public Object getArmorModel(int index) {
        return null;
    }
}
