package net.thevortex8196.celestial;

import net.fabricmc.api.ModInitializer;

import net.thevortex8196.celestial.block.ModBlocks;
import net.thevortex8196.celestial.datagen.ModLootTableProvider;
import net.thevortex8196.celestial.effect.ModEffects;
import net.thevortex8196.celestial.item.ModCreativeTab;
import net.thevortex8196.celestial.item.ModItems;
import net.thevortex8196.celestial.util.ModLootTableModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Celestial implements ModInitializer {
	public static final String MOD_ID = "celestial";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModLootTableModifier.register();

		ModCreativeTab.registerCreativeTab();

		ModEffects.registerModEffects();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}