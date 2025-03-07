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
                        entries.add(ModItems.HEAVEN_SCYTHE);
                        entries.add(ModItems.SHULKER_DUST);
                        entries.add(ModItems.EYE_OF_THE_END);
                        entries.add(ModItems.ENDER_LEATHER);
                    }).build());

    public static final ItemGroup WILLIAM = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Celestial.MOD_ID, "william"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.HARPOON))
                    .displayName(Text.translatable("creativetab.celestial.william"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.HARPOON);
                    }).build());

    public static final ItemGroup LEO = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Celestial.MOD_ID, "leo"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.VEX_TEAR))
                    .displayName(Text.translatable("creativetab.celestial.leo"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.VEX_TEAR);
                        entries.add(ModItems.VEX_TEAR_HELMET);
                        entries.add(ModItems.VEX_TEAR_CHESTPLATE);
                        entries.add(ModItems.VEX_TEAR_LEGGINGS);
                        entries.add(ModItems.VEX_TEAR_BOOTS);
                    }).build());

    public static final ItemGroup HANNI = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Celestial.MOD_ID, "hanni"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.RADIOACTIVE_CORE))
                    .displayName(Text.translatable("creativetab.celestial.hanni"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RADIOACTIVE_CORE);
                        entries.add(ModItems.BOMB);
                        entries.add(ModItems.OBSIDIAN_HELMET);
                        entries.add(ModItems.OBSIDIAN_CHESTPLATE);
                        entries.add(ModItems.OBSIDIAN_LEGGINGS);
                        entries.add(ModItems.OBSIDIAN_BOOTS);
                    }).build());

    public static final ItemGroup JONAS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Celestial.MOD_ID, "jonas"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.DRILL))
                    .displayName(Text.translatable("creativetab.celestial.jonas"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.DRILL);
                    }).build());

    public static void registerCreativeTab() {
        Celestial.LOGGER.info("Registering Creative Mode Tabs for Celestial!!!");
    }

}
