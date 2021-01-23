package com.topru.mononoke.util;

import net.minecraft.entity.CreatureAttribute;

public enum CreatureType {
    UNDEAD("tooltip.mononoke.soul"),
    ARTHROPOD("tooltip.mononoke.soul"),
    ILLAGER("tooltip.mononoke.soul"),
    WATER("tooltip.mononoke.soul"),
    UNDEFINED("tooltip.mononoke.soul");

    final SoulData soulData;

    CreatureType(String soultag) {
        this.soulData = new SoulData(soultag);
    }

    public SoulData getSoulData() {
        return soulData;
    }

    public static CreatureType getType(CreatureAttribute attribute) {
        if (attribute.equals(CreatureAttribute.UNDEAD)) {
            return UNDEAD;
        } else if (attribute.equals(CreatureAttribute.ARTHROPOD)) {
            return ARTHROPOD;
        } else if (attribute.equals(CreatureAttribute.ILLAGER)) {
            return ILLAGER;
        } else if (attribute.equals(CreatureAttribute.WATER)) {
            return WATER;
        } else {
            return UNDEFINED;
        }
    }

    public class SoulData {
        private final String loretag;

        public SoulData(String tag) {
            this.loretag = tag;
        }

        public String getLoretag() {
            return loretag;
        }
    }
}
