package net.thevortex8196.celestial.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.thevortex8196.celestial.Celestial;
import net.thevortex8196.celestial.block.ModBlocks;

public class ModCreativeTab {
    public static final ItemGroup AARON = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Celestial.MOD_ID, "aaron"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.CELESTIUM))
                    .displayName(Text.translatable("creativetab.celestial.aaron"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CELESTIUM);
                        entries.add(ModBlocks.CELESTIUM_BLOCK);
                    }).build());

    public static final ItemGroup WILLIAM = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Celestial.MOD_ID, "william"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.HARPOON))
                    .displayName(Text.translatable("creativetab.celestial.william"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.HARPOON);
                    }).build());

    public static void registerCreativeTab() {
        Celestial.LOGGER.info("Registering Creative Mode Tabs for Celestial!!!");
    }

}
