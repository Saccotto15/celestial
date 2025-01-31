package net.thevortex8196.celestial.item.custom;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.thevortex8196.celestial.Celestial;
import net.thevortex8196.celestial.effect.ModEffects;

import java.util.Random;
import java.util.random.RandomGenerator;

public class HarpoonItem extends BaseAttackItem {
    public HarpoonItem(Item.Settings settings) {
        super(settings.maxCount(1).maxDamage(1024).attributeModifiers(createAttributes(8, 1)));
    }

    private static boolean isAboutToBreak(ItemStack stack) {
        return stack.getDamage() >= stack.getMaxDamage() - 1;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            int i = this.getMaxUseTime(stack, user) - remainingUseTicks;
            if (i >= 10) {
                if (!world.isClient) {
                    Vec3d lookDirection = user.getRotationVec(1.0F);
                    double strength = 2.0; // Adjust force here

                    user.setVelocity(lookDirection.multiply(strength));
                    user.velocityModified = true;

                    ((PlayerEntity) user).getItemCooldownManager().set(this, 100);

                    if (!isAboutToBreak(stack) || stack.isDamageable()) {
                        stack.damage(1, user, LivingEntity.getSlotForHand(user.getActiveHand()));
                    }
                }
            }
        }

        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (isAboutToBreak(itemStack)) {
            return TypedActionResult.fail(itemStack);
        } else if (EnchantmentHelper.getTridentSpinAttackStrength(itemStack, user) > 0.0F && !user.isTouchingWaterOrRain()) {
            return TypedActionResult.fail(itemStack);
        } else {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(selected) {
            entity.fallDistance = 0;
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int randomNum = (int)(Math.random() * 11);
        if (randomNum==1) {
            target.addStatusEffect(new StatusEffectInstance(ModEffects.BLEEDING_OUT, 300, 0));
        }
        return super.postHit(stack, target, attacker);
    }
}
