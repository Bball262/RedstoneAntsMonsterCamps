package net.bball_262.redsmonstercamps.common.Registries;

import net.bball_262.redsmonstercamps.RedsMonsterCamps;
import net.bball_262.redsmonstercamps.common.Screen.MonsterCampChestMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, RedsMonsterCamps.MOD_ID);

    public static final RegistryObject<MenuType<MonsterCampChestMenu>> MONSTER_CAMP_CHEST_MENU = registerMenuTypes("monster_chest_menu", MonsterCampChestMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuTypes(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
