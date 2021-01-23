package com.topru.mononoke.util;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.List;

public class DescriptionHelper {
    public static void addLocalizedString(List<ITextComponent> list, String key) {
        list.add(new TranslationTextComponent(key));
    }
}
