package net.bball_262.redsmonstercamps.common.Registries;

import net.bball_262.redsmonstercamps.RedsMonsterCamps;
import net.bball_262.redsmonstercamps.common.Blocks.MonsterCampChest;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Blocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RedsMonsterCamps.MOD_ID);

    public static final Rarity MONSTER_RARITY = Rarity.create("monster_rarity", ChatFormatting.RED);

    public static final RegistryObject<Block> MONSTER_CAMP_CHEST = registerBlock("monster_camp_chest",
            () -> new MonsterCampChest(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CHEST)
                    .noOcclusion()
                    .strength((float) Double.POSITIVE_INFINITY)), MONSTER_RARITY);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Rarity pRarity) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, pRarity);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, Rarity pRarity) {
        return Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(pRarity)));
    }
}