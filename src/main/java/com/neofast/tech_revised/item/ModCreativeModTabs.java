package com.neofast.tech_revised.item;


import com.neofast.tech_revised.TechRevised;
import com.neofast.tech_revised.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TechRevised.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tech_revised_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SILICON.get()))
                    .title(Component.translatable("creativetab.tech_revised"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.CHIPSET_1.get());
                        pOutput.accept(ModItems.CHIPSET_2.get());

                        pOutput.accept(ModItems.SILICON.get());

                        pOutput.accept(ModItems.PCB.get());
                        pOutput.accept(ModItems.COPPER_COIL.get());
                        pOutput.accept(ModItems.DI_ELECTRIC_SUBSTANCE.get());
                        pOutput.accept(ModItems.RAM_MODULE_1GB.get());
                        pOutput.accept(ModItems.TRANSISTOR_0.get());
                        pOutput.accept(ModItems.TRANSISTOR_1.get());
                        pOutput.accept(ModItems.TRANSISTOR_2.get());

                        pOutput.accept(ModBlocks.COMPRESSED_SILICON.get());
                        pOutput.accept(ModBlocks.HDD_27KB_BLOCK.get());
                        pOutput.accept(ModBlocks.COMP_CONTROLLER_BLOCK.get());

                        pOutput.accept(ModBlocks.IRON_BLOCK_SLAB.get());

                        pOutput.accept(ModBlocks.MACHINE_FRAME_0.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}