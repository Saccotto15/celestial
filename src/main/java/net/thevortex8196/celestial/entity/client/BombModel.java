package net.thevortex8196.celestial.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.thevortex8196.celestial.Celestial;
import net.thevortex8196.celestial.entity.custom.BombEntity;

import javax.swing.text.html.parser.Entity;

public class BombModel extends EntityModel<BombEntity> {
    public static final EntityModelLayer BOMB = new EntityModelLayer(Identifier.of(Celestial.MOD_ID, "bomb"), "main");
    private final ModelPart bone;
    public BombModel(ModelPart root) {
        this.bone = root.getChild("bone");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(0, 11).cuboid(-10.0F, -23.5F, 6.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-11.0F, -22.5F, 5.0F, 6.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(16, 11).cuboid(-8.0F, -26.25F, 6.5F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 24.0F, -8.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(BombEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        bone.render(matrices, vertexConsumer, light, overlay, color);
    }
}
