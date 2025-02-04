package net.thevortex8196.celestial.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.thevortex8196.celestial.entity.ModEntities;

public class BombEntity extends PersistentProjectileEntity {
    public BombEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public BombEntity(World world, PlayerEntity player) {
        super(ModEntities.BOMB, player, world, new ItemStack(Items.AIR), null);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        this.explode();
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return null;
    }

    private void explode() {
        if (!this.getWorld().isClient) {
            int explosionRadius = 3;
            this.getWorld().createExplosion(this.getOwner(), this.getX(), this.getY(), this.getZ(), (float) explosionRadius, World.ExplosionSourceType.MOB);
            this.remove(Entity.RemovalReason.KILLED);
            this.discard();
        }
    }
}
