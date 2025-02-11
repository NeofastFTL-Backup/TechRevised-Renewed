
package com.neofast.tech_revised.block.entity;

import com.neofast.tech_revised.TechRevised;
import com.neofast.tech_revised.block.ModBlocks;
import com.neofast.tech_revised.block.custom.mbs.CompControllerBlockEntity;
import com.neofast.tech_revised.block.entity.custom.HDD_27KB_BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TechRevised.MOD_ID);

    public static final RegistryObject<BlockEntityType<HDD_27KB_BlockEntity>> HDD_27KB_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("hdd_27kb", () ->
                    BlockEntityType.Builder.of(HDD_27KB_BlockEntity::new,
                            ModBlocks.HDD_27KB_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<CompControllerBlockEntity>> COMP_CONTROLLER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("comp_controller", () ->
                    BlockEntityType.Builder.of(CompControllerBlockEntity::new,
                            ModBlocks.COMP_CONTROLLER_BLOCK.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}