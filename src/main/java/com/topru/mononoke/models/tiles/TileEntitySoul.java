package com.topru.mononoke.models.tiles;

import com.topru.mononoke.registry.libs.LibTileEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySoul extends TileEntity implements ITickableTileEntity {

    private int tick, lifetime;
    private boolean initialized = false;

    public TileEntitySoul() {
        super(LibTileEntity.Instance().getSOUL_ENTITY());
    }

    @Override
    public void tick() {
        if(!initialized) init();
        tick++;
        if(tick == lifetime) {
            getWorld().destroyBlock(getPos(), false);
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        CompoundNBT initvalues = new CompoundNBT();
        initvalues.putInt("lifetime", 700);
        compound.put("initvalues", initvalues);
        return super.write(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        CompoundNBT initValues = compound.getCompound("initvalues");
        if(initValues != null) {
            this.lifetime = initValues.getInt("lifetime");
            this.tick = 0;
            initialized = true;
            return;
        }
        init();
    }

    private void init() {
        this.initialized = true;
        this.tick = 0;
        this.lifetime = 100;
    }
}
