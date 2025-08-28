 package com.neofast.tech_revised.block;

 import com.neofast.tech_revised.TechRevised;
 import com.neofast.tech_revised.block.custom.HDD_27KB;
 import com.neofast.tech_revised.block.custom.WorkbenchT1;
 import com.neofast.tech_revised.item.ModItems;
 import net.minecraft.network.chat.Component;
 import net.minecraft.world.item.*;
 import net.minecraft.world.level.Level;
 import net.minecraft.world.level.block.*;
 import net.minecraft.world.level.block.state.BlockBehaviour;
 import net.minecraftforge.eventbus.api.IEventBus;
 import net.minecraftforge.registries.DeferredRegister;
 import net.minecraftforge.registries.ForgeRegistries;
 import net.minecraftforge.registries.RegistryObject;
 import org.jetbrains.annotations.Nullable;

 import java.util.List;
 import java.util.function.Supplier;


 public class ModBlocks {
     public static final DeferredRegister<Block> BLOCKS =
             DeferredRegister.create(ForgeRegistries.BLOCKS, TechRevised.MOD_ID);

     public static final RegistryObject<Block> COMPRESSED_SILICON = registerBlock("compressed_silicon",
             () -> new Block(BlockBehaviour.Properties.of()
                     .strength(9f).requiresCorrectToolForDrops()));

     public static final RegistryObject<Block> IRON_BLOCK_SLAB = registerBlock("iron_block_slab",
             () -> new SlabBlock(BlockBehaviour.Properties.of()
                     .strength(9f).requiresCorrectToolForDrops()));
     public static final RegistryObject<Block> MACHINE_FRAME_0 = registerBlock("machine_frame_0",
             () -> new SlabBlock(BlockBehaviour.Properties.of()
                     .strength(9f).requiresCorrectToolForDrops()));

     public static final RegistryObject<Block> HDD_27KB_BLOCK = registerBlock("hdd_27kb",
             () -> new HDD_27KB(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

     public static final RegistryObject<Block> WORKBENCH_T1 = registerBlock("workbench_t1",
             () -> new WorkbenchT1(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

     private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
         return BLOCKS.register(name, block);
     }

     private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                      CreativeModeTab tab, String tooltipKey) {
         RegistryObject<T> toReturn = BLOCKS.register(name, block);
         registerBlockItem(name, toReturn, tab, tooltipKey);
         return toReturn;
     }

     private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                             CreativeModeTab tab, String tooltipKey) {
         return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                 new Item.Properties()) {
             @Override
             public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                 pTooltip.add(Component.translatable(tooltipKey));
             }
         });
     }

     private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
         RegistryObject<T> toReturn = BLOCKS.register(name, block);
         registerBlockItem(name, toReturn);
         return toReturn;
     }

     private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
         return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                 new Item.Properties()));
     }

     public static void register(IEventBus eventBus) {
         BLOCKS.register(eventBus);
     }
 }