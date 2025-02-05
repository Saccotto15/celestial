package net.thevortex8196.celestial.entity.custom;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.thevortex8196.celestial.effect.ModEffects;
import net.thevortex8196.celestial.entity.ModEntities;

import java.util.Collection;
import java.util.List;

public class BombEntity extends PersistentProjectileEntity {
    public BombEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public BombEntity(World world, PlayerEntity player) {
        super(ModEntities.BOMB, player, world, new ItemStack(Items.AIR), null);
    }

    private void spawnEffectsCloud() {
        Collection<StatusEffectInstance> collection = List.of(new StatusEffectInstance(ModEffects.RADIOACTIVE_POISONING, 140, 1, false, true, true));
        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(this.getWorld(), this.getX(), this.getY(), this.getZ());
        areaEffectCloudEntity.setRadius(2.5F);
        areaEffectCloudEntity.setRadiusOnUse(-0.5F);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(areaEffectCloudEntity.getDuration() / 2);
        areaEffectCloudEntity.setRadiusGrowth(-areaEffectCloudEntity.getRadius() / (float)areaEffectCloudEntity.getDuration());

        for (StatusEffectInstance statusEffectInstance : collection) {
            areaEffectCloudEntity.addEffect(new StatusEffectInstance(statusEffectInstance));
        }

        this.getWorld().spawnEntity(areaEffectCloudEntity);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        this.explode();
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        this.explode();
        super.onEntityHit(entityHitResult);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return null;
    }

    private void explode() {
        if (!this.getWorld().isClient) {
            int explosionRadius = 3;
            this.spawnEffectsCloud();
            this.getWorld().createExplosion(this.getOwner(), this.getX(), this.getY(), this.getZ(), (float) explosionRadius, World.ExplosionSourceType.MOB);
            this.remove(Entity.RemovalReason.KILLED);
            this.discard();
        }
    }
}
