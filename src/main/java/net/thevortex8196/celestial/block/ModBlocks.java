package net.thevortex8196.celestial.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thevortex8196.celestial.Celestial;

public class ModBlocks {

    public static final Block CELESTIUM_BLOCK = registerBlock("celestium_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool()));

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Celestial.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Celestial.MOD_ID, name), block);
    }

    public static void  registerModBlocks() {
        Celestial.LOGGER.info("Registring Mod Blocks for Celestial!!!");
    }
}
