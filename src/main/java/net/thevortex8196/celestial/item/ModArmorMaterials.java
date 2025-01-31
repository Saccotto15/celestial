package net.thevortex8196.celestial.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.thevortex8196.celestial.Celestial;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
     public static final RegistryEntry<ArmorMaterial> VEX_TEAR_ARMOR_MATERIAL = registerArmorMaterial("vex_tear",
             ()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                 map.put(ArmorItem.Type.HELMET, 3);
                 map.put(ArmorItem.Type.CHESTPLATE, 8);
                 map.put(ArmorItem.Type.LEGGINGS, 6);
                 map.put(ArmorItem.Type.BOOTS, 3);
                 map.put(ArmorItem.Type.BODY, 11 );
             }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.VEX_TEAR),
                     List.of(new ArmorMaterial.Layer(Identifier.of(Celestial.MOD_ID, "vex_tear"))), 3f, 0.1f ));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Celestial.MOD_ID, name), material.get());
    }
}
