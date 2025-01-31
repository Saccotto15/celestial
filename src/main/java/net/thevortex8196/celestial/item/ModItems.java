package net.thevortex8196.celestial.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thevortex8196.celestial.Celestial;
import net.thevortex8196.celestial.item.custom.HarpoonItem;

public class ModItems {

    //Aaron
    public static final Item CELESTIUM = registerItem("celestium", new Item(new Item.Settings()));

    //William
    public static final Item HARPOON = registerItem("harpoon", new HarpoonItem(new Item.Settings()));
    public static final Item HARPOON_3D = registerItem("harpoon_3d", new HarpoonItem(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Celestial.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Celestial.LOGGER.info("Registering mod items for Celestial!");
    }
}
