package net.thevortex8196.celestial.item;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thevortex8196.celestial.Celestial;
import net.thevortex8196.celestial.item.custom.*;

public class ModItems {

    //Aaron
    public static final Item CELESTIUM = registerItem("celestium", new Item(new Item.Settings()));
    public static final Item ENDER_LEATHER = registerItem("ender_leather", new Item(new Item.Settings()));
    public static final Item EYE_OF_THE_END = registerItem("eye_of_the_end", new Item(new Item.Settings()));
    public static final Item SHULKER_DUST = registerItem("shulker_dust", new Item(new Item.Settings()));
    public static final Item HEAVEN_SCYTHE = registerItem("heaven_scythe", new HeavenScytheItem(new Item.Settings()));

    //William
    public static final Item HARPOON = registerItem("harpoon", new HarpoonItem(new Item.Settings()));

    //Leo
    public static final Item VEX_TEAR = registerItem("vex_tear", new Item(new Item.Settings()));

    public static final Item ENCHANTED_GOLDEN_CARROT = registerItem("enchanted_golden_carrot", new EnchantedGoldenCarrot(new Item.Settings()));

    public static final Item VEX_TEAR_HELMET = registerItem("vex_tear_helmet",
            new ModArmorItem(ModArmorMaterials.VEX_TEAR_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(35))));
    public static final Item VEX_TEAR_CHESTPLATE = registerItem("vex_tear_chestplate",
            new ArmorItem(ModArmorMaterials.VEX_TEAR_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(35))));
    public static final Item VEX_TEAR_LEGGINGS = registerItem("vex_tear_leggings",
            new ArmorItem(ModArmorMaterials.VEX_TEAR_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(35))));
    public static final Item VEX_TEAR_BOOTS = registerItem("vex_tear_boots",
            new ArmorItem(ModArmorMaterials.VEX_TEAR_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(35))));

    //Hanni
    public static final Item BOMB = registerItem("bomb", new BombItem(new Item.Settings()));
    public static final Item RADIOACTIVE_CORE = registerItem("radioactive_core", new Item(new Item.Settings()));

    public static final Item OBSIDIAN_HELMET = registerItem("obsidian_helmet",
            new ModArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(1))));
    public static final Item OBSIDIAN_CHESTPLATE = registerItem("obsidian_chestplate",
            new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(1))));
    public static final Item OBSIDIAN_LEGGINGS = registerItem("obsidian_leggings",
            new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(1))));
    public static final Item OBSIDIAN_BOOTS = registerItem("obsidian_boots",
            new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(1))));

    //Jonas
    public static final Item DRILL = registerItem("drill", new DrillItem(ToolMaterials.IRON, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.IRON, 3, -3.4f))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Celestial.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Celestial.LOGGER.info("Registering Mod Items for Celestial!!!");
    }
}
