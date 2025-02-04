package net.thevortex8196.celestial.entity.client;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.RotationAxis;
import net.thevortex8196.celestial.Celestial;
import net.thevortex8196.celestial.entity.custom.BombEntity;

public class BombRenderer extends EntityRenderer<BombEntity> {
protected BombModel model;

public BombRenderer(EntityRendererFactory.Context ctx) {
    super(ctx);
    this.model = new BombModel(ctx.getPart(BombModel.BOMB));
}

@Override
public void render(BombEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {

    matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
    
    matrices.push();

    VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers,
            this.model.getLayer(Identifier.of(Celestial.MOD_ID, "textures/entity/bomb.png")), false, false);
    this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);

    matrices.pop();
    super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
}

@Override
public Identifier getTexture(BombEntity entity) {
    return Identifier.of(Celestial.MOD_ID, "textures/entity/tomahawk/tomahawk.png");
}
}
