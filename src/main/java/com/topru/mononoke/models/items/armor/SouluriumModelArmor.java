package com.topru.mononoke.models.items.armor;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;

public class SouluriumModelArmor extends ModelArmor {

    // helm
    private final ModelRenderer helm;
    private final ModelRenderer emblem;
    private final ModelRenderer headwear;

    private final ModelRenderer chestplate;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightarm;

    private final ModelRenderer corset;
    private final ModelRenderer leftleg;
    private final ModelRenderer rightleg;

    private final ModelRenderer rightfeet;
    private final ModelRenderer leftfeet;


    public SouluriumModelArmor(EquipmentSlotType slot) {
        super(slot);

        this.textureWidth = 64;
        this.textureHeight = 32;

        float s = 0.01F;

        // helm
        this.helm = new ModelRenderer(this);
        helm.setRotationPoint(0.0F, 0.0F, 0.0F);
        helm.setTextureOffset(30, 0).addBox(-4.0F, -8.01F, -4.99F, 8.0F, 8.0F, 9.0F, 0.0F, false);
        helm.setTextureOffset(0, 0).addBox(4.0F, -2.0F, -5.0F, 2.0F, 2.0F, 10.0F, 0.0F, true);
        helm.setTextureOffset(0, 0).addBox(-6.0F, -2.0F, -5.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
        helm.setTextureOffset(46, 17).addBox(-4.0F, -2.0F, 4.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);
        helm.setTextureOffset(35, 18).addBox(4.0F, -7.0F, -5.0F, 1.0F, 5.0F, 9.0F, 0.0F, false);
        helm.setTextureOffset(35, 18).addBox(-5.0F, -7.0F, -5.0F, 1.0F, 5.0F, 9.0F, 0.0F, true);
        helm.setTextureOffset(25, 0).addBox(-3.0F, -5.0F, -5.0F, 6.0F, 5.0F, 1.0F, 0.01F, false);

        this.emblem = new ModelRenderer(this);
        emblem.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.helm.addChild(this.emblem);
        emblem.setTextureOffset(56, 3).addBox(-1.0F, -9.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        emblem.setTextureOffset(56, 6).addBox(-3.0F, -10.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);
        emblem.setTextureOffset(56, 6).addBox(1.0F, -10.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        emblem.setTextureOffset(56, 6).addBox(-4.0F, -12.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        emblem.setTextureOffset(56, 6).addBox(2.0F, -12.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);
        emblem.setTextureOffset(56, 6).addBox(-3.0F, -14.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        emblem.setTextureOffset(56, 6).addBox(1.0F, -14.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);


        // headwear
        this.headwear = new ModelRenderer(this);
        headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        headwear.setTextureOffset(0, 15).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 8.0F, 9.0F, 0.5F, false);


        // chestplate
        this.chestplate = new ModelRenderer(this);
        chestplate.setRotationPoint(0.0F, 0.0F, 0.0F);
        chestplate.setTextureOffset(32, 13).addBox(-5.0F, -1.0F, -3.0F, 10.0F, 13.0F, 6.0F, 0.0F, false);
        chestplate.setTextureOffset(26, 0).addBox(-3.5F, 0.7F, -1.5F, 7.0F, 6.0F, 3.0F, 1.0F, false);

        // left arm
        this.leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
        leftarm.setTextureOffset(12, 15).addBox(-1.5F, -2.0F, -2.5F, 5.0F, 12.0F, 5.0F, 0.065F, false);
        leftarm.setTextureOffset(1, 4).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.05F, false);
        leftarm.setTextureOffset(48, 7).addBox(1.5F, -3.0F, -2.5F, 3.0F, 1.0F, 5.0F, 0.0F, false);

        // right arm
        this.rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        rightarm.setTextureOffset(48, 7).addBox(-4.5F, -3.0F, -2.5F, 3.0F, 1.0F, 5.0F, 0.0F, true);
        rightarm.setTextureOffset(12, 15).addBox(-3.5F, -2.0F, -2.5F, 5.0F, 12.0F, 5.0F, 0.065F, true);
        rightarm.setTextureOffset(1, 4).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.05F, true);

        // legs
        this.leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(1.9F, 12.0F, 0.0F);
        leftleg.setTextureOffset(0, 0).addBox(-2.15F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, 0.0F, false);
        leftleg.setTextureOffset(48, 0).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.2F, true);

        this.rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        rightleg.setTextureOffset(0, 0).addBox(-2.85F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, 0.01F, true);
        rightleg.setTextureOffset(48, 0).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.2F, true);

        this.corset = new ModelRenderer(this);
        corset.setRotationPoint(0.0F, 0.0F, 0.0F);
        corset.setTextureOffset(31, 18).addBox(-5.0F, 7.0F, -3.0F, 10.0F, 8.0F, 6.0F, -0.01F, false);

        this.rightfeet = new ModelRenderer(this);
        rightfeet.setRotationPoint(-1.9F, 12.0F, 0.0F);
        rightfeet.setTextureOffset(0, 0).addBox(-3.07F, 6.0F, -2.5F, 5.0F, 6.0F, 5.0F, -0.03F, true);

        this.leftfeet = new ModelRenderer(this);
        leftfeet.setRotationPoint(1.9F, 12.0F, 0.0F);
        leftfeet.setTextureOffset(0, 0).addBox(-1.93F, 6.0F, -2.5F, 5.0F, 6.0F, 5.0F, -0.03F, false);

        this.bipedHead = this.helm;
        this.bipedHeadwear = this.headwear;
        this.bipedBody = this.chestplate;
        this.bipedLeftArm = this.leftarm;
        this.bipedRightArm = this.rightarm;


        if (slot == EquipmentSlotType.LEGS) {
            this.bipedBody = this.corset;
            this.bipedRightLeg = this.rightleg;
            this.bipedLeftLeg = this.leftleg;
        } else {
            this.bipedRightLeg = this.rightfeet;
            this.bipedLeftLeg = this.leftfeet;
        }


    }

    @Override
    public void render(MatrixStack ms, IVertexBuilder buffer, int light, int overlay, float r, float g, float b, float a) {

        this.bipedHead.showModel = slot == EquipmentSlotType.HEAD;
        this.bipedHeadwear.showModel = slot == EquipmentSlotType.HEAD;

        this.bipedBody.showModel = (slot == EquipmentSlotType.CHEST || slot == EquipmentSlotType.LEGS) ;
        this.bipedLeftArm.showModel = slot == EquipmentSlotType.CHEST;
        this.bipedRightArm.showModel = slot == EquipmentSlotType.CHEST;

        this.bipedRightLeg.showModel = (slot == EquipmentSlotType.LEGS || slot == EquipmentSlotType.FEET);
        this.bipedLeftLeg.showModel = (slot == EquipmentSlotType.LEGS || slot == EquipmentSlotType.FEET);


        super.render(ms, buffer, light, overlay, r, g, b, a);
    }

}
