package com.topru.mononoke.models.items.armor;

import net.minecraft.client.renderer.entity.model.BipedModel;
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
        float devided = ((float) Math.PI / 180F); 
        this.bipedHead.rotateAngleX = devided * entityIn.getHeadRotation().getX();
        this.bipedHead.rotateAngleY = devided * entityIn.getHeadRotation().getY();
        this.bipedHead.rotateAngleZ = devided * entityIn.getHeadRotation().getZ();
        this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.bipedBody.rotateAngleX = devided * entityIn.getBodyRotation().getX();
        this.bipedBody.rotateAngleY = devided * entityIn.getBodyRotation().getY();
        this.bipedBody.rotateAngleZ = devided * entityIn.getBodyRotation().getZ();
        this.bipedLeftArm.rotateAngleX = devided * entityIn.getLeftArmRotation().getX();
        this.bipedLeftArm.rotateAngleY = devided * entityIn.getLeftArmRotation().getY();
        this.bipedLeftArm.rotateAngleZ = devided * entityIn.getLeftArmRotation().getZ();
        this.bipedRightArm.rotateAngleX = devided * entityIn.getRightArmRotation().getX();
        this.bipedRightArm.rotateAngleY = devided * entityIn.getRightArmRotation().getY();
        this.bipedRightArm.rotateAngleZ = devided * entityIn.getRightArmRotation().getZ();
        this.bipedLeftLeg.rotateAngleX = devided * entityIn.getLeftLegRotation().getX();
        this.bipedLeftLeg.rotateAngleY = devided * entityIn.getLeftLegRotation().getY();
        this.bipedLeftLeg.rotateAngleZ = devided * entityIn.getLeftLegRotation().getZ();
        this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
        this.bipedRightLeg.rotateAngleX = devided * entityIn.getRightLegRotation().getX();
        this.bipedRightLeg.rotateAngleY = devided * entityIn.getRightLegRotation().getY();
        this.bipedRightLeg.rotateAngleZ = devided * entityIn.getRightLegRotation().getZ();
        this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
        this.bipedHeadwear.copyModelAngles(this.bipedHead);
    }
}
