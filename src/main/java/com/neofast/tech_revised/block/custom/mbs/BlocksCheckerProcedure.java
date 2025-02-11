package com.neofast.tech_revised.block.custom.mbs;

import com.neofast.tech_revised.block.ModBlocks;
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
        BlockState mouse = Blocks.AIR.defaultBlockState();
        BlockState psu = Blocks.AIR.defaultBlockState();
        BlockState desktop = Blocks.AIR.defaultBlockState();
        BlockState cableBundle = Blocks.AIR.defaultBlockState();
        cableBundle = Blocks.CHAIN.defaultBlockState();
        desktop = Blocks.CHEST.defaultBlockState();
        psu = Blocks.REDSTONE_LAMP.defaultBlockState();
        mouse = Blocks.DIAMOND_BLOCK.defaultBlockState();
        frame = Blocks.EMERALD_BLOCK.defaultBlockState();
        interfaceBlock = ModBlocks.COMP_CONTROLLER_BLOCK.get().defaultBlockState();
        middleLineBlock = Blocks.REDSTONE_BLOCK.defaultBlockState();
        crossBlockMiddleLayer = Blocks.NETHERITE_BLOCK.defaultBlockState();
        if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 1))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 1))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 1))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 1))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == middleLineBlock.getBlock()
                && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == middleLineBlock.getBlock()
                && (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == middleLineBlock.getBlock()
                && (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == middleLineBlock.getBlock()
                && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == frame.getBlock()
                && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == middleLineBlock.getBlock()
                && (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == middleLineBlock.getBlock()
                && (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == middleLineBlock.getBlock()
                && (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == middleLineBlock.getBlock()
                && (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == mouse.getBlock() //Right Down Corner
                && (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == psu.getBlock() //Left Up Corner
                && (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == cableBundle.getBlock() //Right Up Corner
                && (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == desktop.getBlock()) { //Left Down Corner
            if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == interfaceBlock.getBlock()
                    && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == crossBlockMiddleLayer.getBlock()
                    && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == crossBlockMiddleLayer.getBlock()
                    && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == crossBlockMiddleLayer.getBlock()) {
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
