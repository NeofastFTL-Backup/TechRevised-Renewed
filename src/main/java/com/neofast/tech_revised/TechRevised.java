package com.neofast.tech_revised;

import com.neofast.tech_revised.block.ModBlocks;
import com.neofast.tech_revised.block.custom.mbs.InventoryScreen;
import com.neofast.tech_revised.block.custom.mbs.MultiBlockMachineModMenus;
import com.neofast.tech_revised.block.entity.ModBlockEntities;
import com.neofast.tech_revised.item.ModCreativeModTabs;
import com.neofast.tech_revised.item.ModItems;
import com.neofast.tech_revised.screen.HDD_27KB_Screen;
import com.neofast.tech_revised.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TechRevised.MOD_ID)
public class TechRevised
{
    public static final String MOD_ID = "tech_revised";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public TechRevised() {
        // Register the setup method for modloading
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        MultiBlockMachineModMenus.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        //Transistors Workbench (Faulty)

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HDD_27KB_BLOCK.get(), RenderType.translucent());

        MenuScreens.register(ModMenuTypes.HDD_27KB_MENU.get(), HDD_27KB_Screen::new);

        MenuScreens.register(MultiBlockMachineModMenus.INVENTORY.get(), InventoryScreen::new);


        //Transistors Workbench (Basic)

        }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.CHIPSET_1);
            event.accept(ModItems.CHIPSET_2);

            event.accept(ModItems.SILICON);

            event.accept(ModItems.PCB);
            event.accept(ModItems.COPPER_COIL);
            event.accept(ModItems.DI_ELECTRIC_SUBSTANCE);
            event.accept(ModItems.RAM_MODULE_1GB);
            event.accept(ModItems.TRANSISTOR_0);
            event.accept(ModItems.TRANSISTOR_1);
            event.accept(ModItems.TRANSISTOR_2);

            event.accept(ModBlocks.COMPRESSED_SILICON);
            event.accept(ModBlocks.HDD_27KB_BLOCK);

            event.accept(ModBlocks.IRON_BLOCK_SLAB);

            event.accept(ModBlocks.MACHINE_FRAME_0);
            event.accept(ModBlocks.COMP_CONTROLLER_BLOCK);
        }
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getName());
    }
}
