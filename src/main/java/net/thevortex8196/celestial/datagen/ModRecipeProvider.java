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
    }

    public static void offerUpgradeRecipe(RecipeExporter exporter, Item input1, Item input2, RecipeCategory category, Item result) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(input1), Ingredient.ofItems(input2), category, result
                )
                .criterion(hasItem(input2), conditionsFromItem(input2))
                .offerTo(exporter, getItemPath(result) + "_smithing");
    }
}
