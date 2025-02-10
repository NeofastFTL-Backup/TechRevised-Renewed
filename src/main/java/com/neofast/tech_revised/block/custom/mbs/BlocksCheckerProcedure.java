package com.neofast.tech_revised.block.custom.mbs;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class BlocksCheckerProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        BlockState frame = Blocks.AIR.defaultBlockState();
        BlockState interfaceBlock = Blocks.AIR.defaultBlockState();
        BlockState middleLineBlock = Blocks.AIR.defaultBlockState();
        BlockState crossBlockMiddleLayer = Blocks.AIR.defaultBlockState();
        frame = Blocks.DIAMOND_BLOCK.defaultBlockState();
        interfaceBlock = Blocks.PACKED_ICE.defaultBlockState();
        middleLineBlock = Blocks.REDSTONE_BLOCK.defaultBlockState();
        crossBlockMiddleLayer = Blocks.NETHERITE_BLOCK.defaultBlockState();
        if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 1))).getBlock() == frame.getBlock() && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 1))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 1))).getBlock() == frame.getBlock() && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 1))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == frame.getBlock() && (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == middleLineBlock.getBlock()
                && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == middleLineBlock.getBlock() && (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == middleLineBlock.getBlock()
                && (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == middleLineBlock.getBlock() && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock() == frame.getBlock() && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).getBlock() == frame.getBlock() && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == middleLineBlock.getBlock() && (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == middleLineBlock.getBlock()
                && (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == middleLineBlock.getBlock() && (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == middleLineBlock.getBlock()
                && (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == frame.getBlock() && (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == frame.getBlock() && (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == frame.getBlock()) {
            if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == interfaceBlock.getBlock() && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == crossBlockMiddleLayer.getBlock()
                    && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == crossBlockMiddleLayer.getBlock() && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == crossBlockMiddleLayer.getBlock()) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x + 1, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putBoolean("canOpenInventory", true);
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            } else if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == crossBlockMiddleLayer.getBlock() && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == interfaceBlock.getBlock()
                    && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == crossBlockMiddleLayer.getBlock() && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == crossBlockMiddleLayer.getBlock()) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x - 1, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putBoolean("canOpenInventory", true);
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            } else if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == crossBlockMiddleLayer.getBlock() && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == crossBlockMiddleLayer.getBlock()
                    && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == interfaceBlock.getBlock() && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == crossBlockMiddleLayer.getBlock()) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z + 1);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putBoolean("canOpenInventory", true);
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            } else if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == crossBlockMiddleLayer.getBlock() && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == crossBlockMiddleLayer.getBlock()
                    && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == crossBlockMiddleLayer.getBlock() && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == interfaceBlock.getBlock()) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z - 1);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putBoolean("canOpenInventory", true);
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            } else {
                if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == interfaceBlock.getBlock()) {
                    if (!world.isClientSide()) {
                        BlockPos _bp = BlockPos.containing(x + 1, y, z);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null)
                            _blockEntity.getPersistentData().putBoolean("canOpenInventory", false);
                        if (world instanceof Level _level)
                            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                } else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == interfaceBlock.getBlock()) {
                    if (!world.isClientSide()) {
                        BlockPos _bp = BlockPos.containing(x - 1, y, z);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null)
                            _blockEntity.getPersistentData().putBoolean("canOpenInventory", false);
                        if (world instanceof Level _level)
                            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                } else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == interfaceBlock.getBlock()) {
                    if (!world.isClientSide()) {
                        BlockPos _bp = BlockPos.containing(x, y, z + 1);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null)
                            _blockEntity.getPersistentData().putBoolean("canOpenInventory", false);
                        if (world instanceof Level _level)
                            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                } else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == interfaceBlock.getBlock()) {
                    if (!world.isClientSide()) {
                        BlockPos _bp = BlockPos.containing(x, y, z - 1);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null)
                            _blockEntity.getPersistentData().putBoolean("canOpenInventory", false);
                        if (world instanceof Level _level)
                            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                }
            }
        } else {
            if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == interfaceBlock.getBlock()) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x + 1, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putBoolean("canOpenInventory", false);
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            } else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == interfaceBlock.getBlock()) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x - 1, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putBoolean("canOpenInventory", false);
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            } else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == interfaceBlock.getBlock()) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z + 1);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putBoolean("canOpenInventory", false);
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            } else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == interfaceBlock.getBlock()) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z - 1);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putBoolean("canOpenInventory", false);
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            }
        }
    }
}
