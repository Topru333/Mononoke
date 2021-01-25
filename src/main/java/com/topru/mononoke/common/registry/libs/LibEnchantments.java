package com.topru.mononoke.common.registry.libs;

import com.topru.mononoke.client.Mononoke;
import com.topru.mononoke.common.enchantment.ShinigamiEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Mononoke.MOD_ID)
public class LibEnchantments extends Lib<Enchantment>{

    private LibEnchantments() {
        this.SHINIGAMI_WILL = new ShinigamiEnchantment().setRegistryName("shinigami_enchantment");
    }

    private static LibEnchantments instance;

    public static LibEnchantments Instance() {
        if (instance == null) instance = new LibEnchantments();
        return instance;
    }

    private final Enchantment SHINIGAMI_WILL;

    public Enchantment getSHINIGAMI_WILL() {
        return SHINIGAMI_WILL;
    }
}
