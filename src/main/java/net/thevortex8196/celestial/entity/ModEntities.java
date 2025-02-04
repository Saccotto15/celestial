package net.thevortex8196.celestial.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thevortex8196.celestial.Celestial;
import net.thevortex8196.celestial.entity.custom.BombEntity;

public class ModEntities {
    public static final EntityType<BombEntity> BOMB = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Celestial.MOD_ID, "bomb"),
            EntityType.Builder.<BombEntity>create(BombEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f).build());


    public static void registerModEntities() {
        Celestial.LOGGER.info("Registering Mod Entities for Celestial");
    }
}
