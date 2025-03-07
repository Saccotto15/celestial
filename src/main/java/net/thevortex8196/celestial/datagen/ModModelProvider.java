package net.thevortex8196.celestial.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.thevortex8196.celestial.block.ModBlocks;
import net.thevortex8196.celestial.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CELESTIUM_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CELESTIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VEX_TEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.RADIOACTIVE_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDER_LEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHULKER_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.EYE_OF_THE_END, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VEX_TEAR_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VEX_TEAR_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VEX_TEAR_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VEX_TEAR_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OBSIDIAN_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OBSIDIAN_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OBSIDIAN_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OBSIDIAN_BOOTS));
    }
}
