package com.topru.mononoke.registry.libs;

import com.topru.mononoke.Mononoke;
import com.topru.mononoke.registry.ToolMaterialRegistry;
import net.minecraft.item.*;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Mononoke.MOD_ID)
public class LibTools extends Lib<Item> {

    private LibTools() {
        this.SOULURIUM_SWORD = new SwordItem(ToolMaterialRegistry.soulurium,3, -2.0f, new Item.Properties().group(Mononoke.TAB)).setRegistryName("soulurium_sword");
        this.SOULURIUM_PICKAXE = new PickaxeItem(ToolMaterialRegistry.soulurium,1, -2.8f, new Item.Properties().group(Mononoke.TAB)).setRegistryName("soulurium_pickaxe");
        this.SOULURIUM_AXE = new AxeItem(ToolMaterialRegistry.soulurium,6.0f, -3.0f, new Item.Properties().group(Mononoke.TAB)).setRegistryName("soulurium_axe");
        this.SOULURIUM_SHOVEL =  new ShovelItem(ToolMaterialRegistry.soulurium,1.5f, -3.0f, new Item.Properties().group(Mononoke.TAB)).setRegistryName("soulurium_shovel");
        this.SOULURIUM_HOE = new HoeItem(ToolMaterialRegistry.soulurium,-1.0f, new Item.Properties().group(Mononoke.TAB)).setRegistryName("soulurium_hoe");

        this.POWERED_SOULURIUM_SWORD = new SwordItem(ToolMaterialRegistry.powered_soulurium,3, -2.0f, new Item.Properties().group(Mononoke.TAB)).setRegistryName("powered_soulurium_sword");
        this.POWERED_SOULURIUM_PICKAXE = new PickaxeItem(ToolMaterialRegistry.powered_soulurium,1, -2.8f, new Item.Properties().group(Mononoke.TAB)).setRegistryName("powered_soulurium_pickaxe");
        this.POWERED_SOULURIUM_AXE = new AxeItem(ToolMaterialRegistry.powered_soulurium,7.0f, -3.0f, new Item.Properties().group(Mononoke.TAB)).setRegistryName("powered_soulurium_axe");
        this.POWERED_SOULURIUM_SHOVEL =  new ShovelItem(ToolMaterialRegistry.powered_soulurium,1.5f, -3.0f, new Item.Properties().group(Mononoke.TAB)).setRegistryName("powered_soulurium_shovel");
        this.POWERED_SOULURIUM_HOE = new HoeItem(ToolMaterialRegistry.powered_soulurium,-1.0f, new Item.Properties().group(Mononoke.TAB)).setRegistryName("powered_soulurium_hoe");
    }

    private static LibTools instance;

    public static LibTools Instance() {
        if (instance == null) instance = new LibTools();
        return instance;
    }

    private final Item SOULURIUM_SWORD;
    private final Item SOULURIUM_PICKAXE;
    private final Item SOULURIUM_AXE;
    private final Item SOULURIUM_SHOVEL;
    private final Item SOULURIUM_HOE;

    private final Item POWERED_SOULURIUM_SWORD;
    private final Item POWERED_SOULURIUM_PICKAXE;
    private final Item POWERED_SOULURIUM_AXE;
    private final Item POWERED_SOULURIUM_SHOVEL;
    private final Item POWERED_SOULURIUM_HOE;

    public Item getSOULURIUM_SWORD() {
        return SOULURIUM_SWORD;
    }

    public Item getSOULURIUM_PICKAXE() {
        return SOULURIUM_PICKAXE;
    }

    public Item getSOULURIUM_AXE() {
        return SOULURIUM_AXE;
    }

    public Item getSOULURIUM_SHOVEL() {
        return SOULURIUM_SHOVEL;
    }

    public Item getSOULURIUM_HOE() {
        return SOULURIUM_HOE;
    }

    public Item getPOWERED_SOULURIUM_SWORD() {
        return POWERED_SOULURIUM_SWORD;
    }

    public Item getPOWERED_SOULURIUM_PICKAXE() {
        return POWERED_SOULURIUM_PICKAXE;
    }

    public Item getPOWERED_SOULURIUM_AXE() {
        return POWERED_SOULURIUM_AXE;
    }

    public Item getPOWERED_SOULURIUM_SHOVEL() {
        return POWERED_SOULURIUM_SHOVEL;
    }

    public Item getPOWERED_SOULURIUM_HOE() {
        return POWERED_SOULURIUM_HOE;
    }

}
