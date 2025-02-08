package net.thevortex8196.celestial.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HeavenScytheItem extends BaseAttackItem {
    public HeavenScytheItem(Settings settings) {
        super(settings.maxCount(1).attributeModifiers(createAttributes(9, 1.6f)));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return super.use(world, user, hand);
    }
}
