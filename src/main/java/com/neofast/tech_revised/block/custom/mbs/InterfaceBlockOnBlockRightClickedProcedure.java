package com.neofast.tech_revised.block.custom.mbs;


import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;

public class InterfaceBlockOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        BlockState core = Blocks.AIR.defaultBlockState();
        core = Blocks.GOLD_BLOCK.defaultBlockState();
        if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == core.getBlock()) {
            BlocksCheckerProcedure.execute(world, x + 1, y, z);
        } else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == core.getBlock()) {
            BlocksCheckerProcedure.execute(world, x - 1, y, z);
        } else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == core.getBlock()) {
            BlocksCheckerProcedure.execute(world, x, y, z + 1);
        } else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == core.getBlock()) {
            BlocksCheckerProcedure.execute(world, x, y, z - 1);
        }
        if (new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getBoolean(tag);
                return false;
            }
        }.getValue(world, BlockPos.containing(x, y, z), "canOpenInventory")) {
            if (entity instanceof ServerPlayer _ent) {
                BlockPos _bpos = BlockPos.containing(x, y, z);
                NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return Component.literal("Inventory");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                        return new InventoryMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                    }
                }, _bpos);
            }
        }
    }
}