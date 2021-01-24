package com.topru.mononoke.models.items.armor;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class ModelArmor extends BipedModel<LivingEntity> {
    protected final EquipmentSlotType slot;

    public ModelArmor(EquipmentSlotType slot) {
        super(1);
        this.slot = slot;
    }

    // [VanillaCopy] ArmorStandArmorModel.setRotationAngles because armor stands are dumb
    // This fixes the armor "breathing" and helmets always facing south on armor stands
    @Override
    public void setRotationAngles(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!(entity instanceof ArmorStandEntity)) {
            super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            return;
        }

        ArmorStandEntity entityIn = (ArmorStandEntity) entity;
        setAngles(this.bipedHead, entityIn);
        setAngles(this.bipedBody, entityIn);
        setAngles(this.bipedLeftArm, entityIn);
        setAngles(this.bipedRightArm, entityIn);
        setAngles(this.bipedLeftLeg, entityIn);
        setAngles(this.bipedRightLeg, entityIn);
        this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
        this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
        this.bipedHeadwear.copyModelAngles(this.bipedHead);
    }

    private void setAngles(ModelRenderer model, ArmorStandEntity entity) {
        float devided = ((float) Math.PI / 180F);
        model.rotateAngleX = devided * entity.getHeadRotation().getX();
        model.rotateAngleY = devided * entity.getHeadRotation().getY();
        model.rotateAngleZ = devided * entity.getHeadRotation().getZ();
    }
}
