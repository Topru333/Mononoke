package com.topru.mononoke.registry;

import com.topru.mononoke.models.enchantments.ShinigamiEnchantment;
import com.topru.mononoke.registry.libs.*;
import com.topru.mononoke.world.gen.OreGen;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.item.*;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
        List<Item> items = new ArrayList<>();
        items.addAll(LibItems.Instance().allRegistries());
        items.addAll(LibTools.Instance().allRegistries());
        items.addAll(LibArmor.Instance().allRegistries());
        for(Item item : items) {
            itemRegistryEvent.getRegistry().register(item);
        }
    }

    @SubscribeEvent
    public static void onBlockRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        for(Block block : LibBlocks.Instance().allRegistries()) {
            blockRegistryEvent.getRegistry().register(block);
        }
    }


    @SubscribeEvent
    public static void onParticleRegistry(final RegistryEvent.Register<ParticleType<?>> ParticleRegistryEvent) {
        for(BasicParticleType pType : LibParticleTypes.Instance().allRegistries()) {
            ParticleRegistryEvent.getRegistry().register(pType);
        }
    }

    @SubscribeEvent
    public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> paintRegistryEvent) {
        for(TileEntityType entity : LibTileEntity.Instance().allRegistries()) {
            paintRegistryEvent.getRegistry().register(entity);
        }
    }

    @SubscribeEvent
    public static void onPaintingsRegistry(final RegistryEvent.Register<PaintingType> paintRegistryEvent) {
        for(PaintingType pType : LibPaintings.Instance().allRegistries()) {
            paintRegistryEvent.getRegistry().register(pType);
        }
    }

    @SubscribeEvent
    public static void onEnchantmentRegistry(final RegistryEvent.Register<Enchantment> enchantmentRegistryEvent) {
        for(Enchantment enchantment : LibEnchantments.Instance().allRegistries()) {
            enchantmentRegistryEvent.getRegistry().register(enchantment);
        }
    }

    @SubscribeEvent
    public static void onLoadComplete(final FMLLoadCompleteEvent event) {
        OreGen.setupOreGen();
    }

}
