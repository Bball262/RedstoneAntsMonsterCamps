package net.bball_262.redsmonstercamps.common.Registries.blockEntities;

import net.bball_262.redsmonstercamps.RedsMonsterCamps;
import net.bball_262.redsmonstercamps.common.Blocks.blockEntity.MonsterCampChestBlockEntity;
import net.bball_262.redsmonstercamps.common.Registries.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RedsMonsterCamps.MOD_ID);

    public static final RegistryObject<BlockEntityType<MonsterCampChestBlockEntity>> MONSTER_CAMP_CHEST =
            BLOCK_ENTITIES.register("monster_camp_chest_be", () -> BlockEntityType.Builder.of(MonsterCampChestBlockEntity::new, Blocks.MONSTER_CAMP_CHEST.get()).build(null));
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}