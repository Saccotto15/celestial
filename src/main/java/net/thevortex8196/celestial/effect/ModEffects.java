package net.thevortex8196.celestial.effect;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.thevortex8196.celestial.Celestial;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> BLEEDING_OUT = registerStatusEffect("bleeding_out",
            new BleedingOutEffect(StatusEffectCategory.HARMFUL, 0x8a0303));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Celestial.MOD_ID, name), statusEffect);
    }

    public static void registerModEffects() {
        Celestial.LOGGER.info("Registering Mod Effects for Celestial!");
    }
}
