package net.foxy.elmod.villager;
import com.google.common.collect.ImmutableSet;
import net.foxy.elmod.Elmod;
import net.foxy.elmod.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModAldeanos {
    public static final DeferredRegister<PoiType> POI_TYPE =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, Elmod. MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Elmod. MOD_ID);

    public static final RegistryObject <PoiType> SOUND_POI = POI_TYPE.register("sound_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.BLOQUE_MUSICAL.get().getStateDefinition().getPossibleStates())
                    ,1,1));

    public static final RegistryObject <VillagerProfession> DJ_ALDEANO = VILLAGER_PROFESSIONS.register("djaldeano",
            () -> new VillagerProfession( "djaldeano", holder -> holder.get()
                    ==SOUND_POI.get(),holder -> holder.get() == SOUND_POI.get(),ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static void register (IEventBus eventBus){
        POI_TYPE.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
