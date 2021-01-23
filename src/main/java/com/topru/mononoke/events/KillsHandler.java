package com.topru.mononoke.events;

import com.topru.mononoke.registry.libs.LibEnchantments;
import com.topru.mononoke.registry.libs.LibItems;
import com.topru.mononoke.util.CreatureType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class KillsHandler {
    public static final Random random = new Random();

    @SubscribeEvent
    public void onShinigamiKills(LivingDeathEvent event) {
        if (event.getEntity().getEntityWorld().isRemote || !(event.getSource().getTrueSource() instanceof PlayerEntity)) {
            return;
        }

        PlayerEntity killer = (PlayerEntity) event.getSource().getTrueSource();
        LivingEntity target = (LivingEntity) event.getEntity();

        if ( killer.inventory.getCurrentItem().equals(ItemStack.EMPTY) || !EnchantmentHelper.getEnchantments(killer.inventory.getCurrentItem()).containsKey(LibEnchantments.Instance().getSHINIGAMI_WILL())) {
            return;
        }

        int max_bound = 10 - EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING, killer.inventory.getCurrentItem());

        if (random.nextInt(max_bound) < 3) {
            ItemStack drop;
            switch (CreatureType.getType(target.getCreatureAttribute())) {
                case UNDEAD:
                    drop = new ItemStack(LibItems.Instance().getUNDEAD_SOUL_ITEM());
                    break;
                case ARTHROPOD:
                    drop = new ItemStack(LibItems.Instance().getARTHROPOD_SOUL_ITEM());
                    break;
                case ILLAGER:
                    drop = new ItemStack(LibItems.Instance().getILLAGER_SOUL_ITEM());
                    break;
                case WATER:
                    drop = new ItemStack(LibItems.Instance().getWATER_SOUL_ITEM());
                    break;
                default:
                    drop = new ItemStack(LibItems.Instance().getORDINARY_SOUL_ITEM());
                    break;
            }
            target.entityDropItem(drop, 1);
        }
    }
}
