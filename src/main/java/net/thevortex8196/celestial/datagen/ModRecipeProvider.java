package net.thevortex8196.celestial.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.thevortex8196.celestial.block.ModBlocks;
import net.thevortex8196.celestial.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.CELESTIUM, RecipeCategory.DECORATIONS, ModBlocks.CELESTIUM_BLOCK);

        offerUpgradeRecipe(recipeExporter, Items.DIAMOND_HELMET, ModItems.VEX_TEAR, RecipeCategory.COMBAT, ModItems.VEX_TEAR_HELMET);
        offerUpgradeRecipe(recipeExporter, Items.DIAMOND_CHESTPLATE, ModItems.VEX_TEAR, RecipeCategory.COMBAT, ModItems.VEX_TEAR_CHESTPLATE);
        offerUpgradeRecipe(recipeExporter, Items.DIAMOND_LEGGINGS, ModItems.VEX_TEAR, RecipeCategory.COMBAT, ModItems.VEX_TEAR_LEGGINGS);
        offerUpgradeRecipe(recipeExporter, Items.DIAMOND_BOOTS, ModItems.VEX_TEAR, RecipeCategory.COMBAT, ModItems.VEX_TEAR_BOOTS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HARPOON)
                .pattern(" ,#")
                .pattern(" .,")
                .pattern(".  ")
                .input('#', Items.IRON_INGOT)
                .input('.', Items.STICK)
                .input(',', Items.STRING)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIUM)
                .pattern(" , ")
                .pattern(",#,")
                .pattern(" , ")
                .input('#', Items.IRON_INGOT)
                .input(',', Items.QUARTZ)
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .offerTo(recipeExporter, getItemPath(ModItems.CELESTIUM) + "_from_block");

        allAround(recipeExporter, Items.REDSTONE_BLOCK, Items.IRON_INGOT, RecipeCategory.MISC, ModItems.RADIOACTIVE_CORE);
        allAround(recipeExporter, ModItems.RADIOACTIVE_CORE, Items.TNT, RecipeCategory.COMBAT, ModItems.BOMB);

    }

    public static void offerUpgradeRecipe(RecipeExporter exporter, Item input1, Item input2, RecipeCategory category, Item result) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(input1), Ingredient.ofItems(input2), category, result
                )
                .criterion(hasItem(input2), conditionsFromItem(input2))
                .offerTo(exporter, getItemPath(result) + "_smithing");
    }

    public static void allAround(RecipeExporter exporter, Item center, Item around, RecipeCategory category, Item result) {
        ShapedRecipeJsonBuilder.create(category, result)
                .pattern(",,,")
                .pattern(",#,")
                .pattern(",,,")
                .input('#', center)
                .input(',', around)
                .criterion(hasItem(center), conditionsFromItem(center))
                .offerTo(exporter);
    }
}
