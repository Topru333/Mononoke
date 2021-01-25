package com.topru.mononoke.common.registry.libs;

import com.topru.mononoke.client.Mononoke;
import com.topru.mononoke.common.block.BaseStatueBlock;
import com.topru.mononoke.common.block.GotaiStatueBlock;
import com.topru.mononoke.common.block.PumpkinBlock;
import com.topru.mononoke.common.block.SoulBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Mononoke.MOD_ID)
public class LibBlocks extends Lib<Block>{

    private LibBlocks() {
        this.BASE_STATUE_BLOCK = new BaseStatueBlock().setRegistryName(location("mononoke_base_block"));
        this.GOTAI_STATUE_BLOCK = new GotaiStatueBlock().setRegistryName(location("gotai_statue_block"));
        this.MONONOKE_PUMPKIN_BLOCK = new PumpkinBlock().setRegistryName(location("mononoke_pumpkin"));
        this.SOUL_BLOCK = new SoulBlock().setRegistryName(location("soul_block"));
        this.SOULURIUM_BLOCK = new Block(Block.Properties.create(Material.IRON).harvestTool(ToolType.PICKAXE).harvestLevel(3).hardnessAndResistance(6,7).sound(SoundType.METAL)).setRegistryName(location("soulurium_block"));
    }

    private static LibBlocks instance;

    public static LibBlocks Instance() {
        if (instance == null) instance = new LibBlocks();
        return instance;
    }

    public static Block BASE_STATUE_BLOCK;
    public static Block GOTAI_STATUE_BLOCK;
    public static Block MONONOKE_PUMPKIN_BLOCK;
    public static Block SOUL_BLOCK;

    public static Block SOULURIUM_BLOCK;

    public static Block getBaseStatueBlock() {
        return BASE_STATUE_BLOCK;
    }

    public static Block getGotaiStatueBlock() {
        return GOTAI_STATUE_BLOCK;
    }

    public static Block getMononokePumpkinBlock() {
        return MONONOKE_PUMPKIN_BLOCK;
    }

    public static Block getSoulBlock() {
        return SOUL_BLOCK;
    }

    public static Block getSouluriumBlock() {
        return SOULURIUM_BLOCK;
    }


}
