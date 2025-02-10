package com.neofast.tech_revised.block.custom.mbs;

import com.neofast.tech_revised.TechRevised;
import com.neofast.tech_revised.screen.HDD_27KB_Menu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class MultiBlockMachineModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, TechRevised.MOD_ID);

    public static final RegistryObject<MenuType<InventoryMenu>> INVENTORY = REGISTRY.register("inventory", () -> IForgeMenuType.create(InventoryMenu::new));

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                 String name) {
        return REGISTRY.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
