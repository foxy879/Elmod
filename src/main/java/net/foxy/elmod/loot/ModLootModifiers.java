package net.foxy.elmod.loot;

import com.mojang.serialization.Codec;
import net.foxy.elmod.Elmod;
import net.minecraftforge.common.loot.IGlobalLootModifier;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Elmod.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> AGREGAR_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("tabla_de_loot",AddItemModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> AGREGAR_ITEM__SOSPECHOSO=
            LOOT_MODIFIER_SERIALIZERS.register("tabla_de_loot_sospechosa",AddSusSandItemModifier.CODEC);

    public static void register(IEventBus eventBus){

        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}
