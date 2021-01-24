package com.topru.mononoke.models.items;

import com.topru.mononoke.Mononoke;
import com.topru.mononoke.util.DescriptionHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class MononokeItem extends Item {

    private String loreTag = "";

    public MononokeItem(Item.Properties properties) {
        super(properties.group(Mononoke.TAB));
    }

    public MononokeItem() {
        super(new Item.Properties().group(Mononoke.TAB));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> list, ITooltipFlag flagIn) {
        if (loreTag.isEmpty()) {
            return;
        }

        if(Screen.hasShiftDown()){
            DescriptionHelper.addLocalizedString(list, loreTag);
        }
        else {
            DescriptionHelper.addLocalizedString(list, "tooltip.mononoke.holdShift");
        }
    }

    protected void setLoreTag(String tag) {
        this.loreTag = tag;
    }
}
