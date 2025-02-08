package net.thevortex8196.celestial.util;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thevortex8196.celestial.item.custom.DrillItem;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class DrillUsageEvent implements PlayerBlockBreakEvents.Before{

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos,
                                    BlockState state, @Nullable BlockEntity blockEntity) {
        ItemStack mainHandItem = player.getMainHandStack();

        if(mainHandItem.getItem() instanceof DrillItem hammer && player instanceof ServerPlayerEntity serverPlayer) {
            if(HARVESTED_BLOCKS.contains(pos)) {
                return true;
            }

            for(BlockPos position : DrillItem.getBlocksToBeDestroyed(1, pos, serverPlayer)) {
                if(pos == position || !hammer.isCorrectForDrops(mainHandItem, world.getBlockState(position))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(position);
                serverPlayer.interactionManager.tryBreakBlock(position);
                HARVESTED_BLOCKS.remove(position);
            }
        }

        return true;
    }
}
