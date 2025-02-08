package net.thevortex8196.celestial.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thevortex8196.celestial.Celestial;
import net.thevortex8196.celestial.item.custom.BombItem;
import net.thevortex8196.celestial.item.custom.HarpoonItem;
import net.thevortex8196.celestial.item.custom.ModArmorItem;

public class ModItems {

    //Aaron
    public static final Item CELESTIUM = registerItem("celestium", new Item(new Item.Settings()));
    public static final Item HEAVEN_SCYTHE = registerItem("heaven_scythe", new Item(new Item.Settings()));

    //William
    public static final Item HARPOON = registerItem("harpoon", new HarpoonItem(new Item.Settings()));

    //Leo
    public static final Item VEX_TEAR = registerItem("vex_tear", new Item(new Item.Settings()));

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
    public static final Item DRILL = registerItem("drill", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Celestial.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Celestial.LOGGER.info("Registering Mod Items for Celestial!!!");
    }
}
