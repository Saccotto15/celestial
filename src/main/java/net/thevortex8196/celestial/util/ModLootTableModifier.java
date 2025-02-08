package net.thevortex8196.celestial.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetContentsLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.thevortex8196.celestial.item.ModItems;

import java.util.List;

public class ModLootTableModifier {

    private static final RegistryKey<LootTable> VEX_KEY = EntityType.VEX.getLootTableId();
    private static final RegistryKey<LootTable> SHULKER_KEY = EntityType.SHULKER.getLootTableId();

    public static void register() {
        LootTableEvents.MODIFY.register((registryKey, builder, lootTableSource, wrapperLookup) -> {
            if (registryKey.equals(VEX_KEY)) {
                LootPool vex_tear = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.VEX_TEAR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())
                        .build();


                builder.pools(List.of(vex_tear));
            }
            if (registryKey.equals(SHULKER_KEY)) {
                LootPool vex_tear = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.SHULKER_DUST))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 2f)).build())
                        .build();


                builder.pools(List.of(vex_tear));
            }
        });
    }
}
