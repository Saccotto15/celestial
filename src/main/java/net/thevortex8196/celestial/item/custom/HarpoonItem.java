package net.thevortex8196.celestial.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.thevortex8196.celestial.effect.ModEffects;

public class HarpoonItem extends BaseAttackItem {
    public HarpoonItem(Item.Settings settings) {
        super(settings.maxCount(1).maxDamage(1024).attributeModifiers(createAttributes(0, 0)));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            itemStack.damage(1, user, (p) -> user.sendEquipmentBreakStatus(user., EquipmentSlot.MAINHAND));
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(ModEffects.BLEEDING_OUT, 100, 1)); // 5 sec
        return super.postHit(stack, target, attacker);
    }
}
