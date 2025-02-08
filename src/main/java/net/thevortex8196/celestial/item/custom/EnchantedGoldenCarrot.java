package net.thevortex8196.celestial.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.thevortex8196.celestial.item.ModFoodComponents;

public class EnchantedGoldenCarrot extends Item {
    public EnchantedGoldenCarrot(Settings settings) {
        super(settings.food(ModFoodComponents.ENCHANTED_GOLDEN_CARROT));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true; // This enables the glint effect
    }
}
