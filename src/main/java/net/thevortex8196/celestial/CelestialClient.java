package net.thevortex8196.celestial;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.thevortex8196.celestial.entity.ModEntities;
import net.thevortex8196.celestial.entity.client.BombModel;
import net.thevortex8196.celestial.entity.client.BombRenderer;

public class CelestialClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(BombModel.BOMB, BombModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BOMB, BombRenderer::new);
    }
}
