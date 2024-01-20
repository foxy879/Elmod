package net.foxy.elmod.item;

import net.foxy.elmod.Elmod;
import net.foxy.elmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Elmod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> INSANA_TAB = CREATIVE_MODE_TABS.register("insana",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.ZAFIRO.get()))
                    .title(Component.translatable("creativetab.insana"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ZAFIRO.get());
                        pOutput.accept(ModItems.SONEDA.get());
                        pOutput.accept(ModItems.SODIANTE.get());
                        pOutput.accept(ModItems.SOBRE.get());
                        pOutput.accept(ModItems.SOIRON.get());
                        pOutput.accept(ModItems.SORO.get());
                        pOutput.accept(ModBlocks.BLOQUE_DE_ZAFIRO.get());
                        pOutput.accept(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get());
                        pOutput.accept(ModBlocks.MINERAL_MAGICO.get());
                        pOutput.accept(ModItems.CRISTAL_DE_MANA.get());
                        pOutput.accept(ModItems.DETECTOR_DE_METALES.get());
                        pOutput.accept(ModBlocks.BLOQUE_MUSICAL.get());
                        pOutput.accept(ModItems.PASTEL.get());
                        pOutput.accept(ModItems.GASOLINA.get());
                        pOutput.accept(ModBlocks.TRAMPILLA_COMOTANMUCHACHOS.get());
                        pOutput.accept(ModBlocks.PUERTA_COMOTANMUCHACHOS.get());
                        pOutput.accept(ModBlocks.MURO_COMOTANMUCHACHOS.get());
                        pOutput.accept(ModBlocks.PLACA_DE_PRESION_COMOTANMUCHACHOS.get());
                        pOutput.accept(ModBlocks.CERCA_COMOTANMUCHACHOS.get());
                        pOutput.accept(ModBlocks.PUERTA_DE_LA_CERCA_COMOTANMUCHACHOS.get());
                        pOutput.accept(ModBlocks.BOTON_COMOTANMUCHACHOS.get());
                        pOutput.accept(ModBlocks.LOSA_COMOTANMUCHACHOS.get());
                        pOutput.accept(ModBlocks.TRAMPILLA_COMOTANMUCHACHOS.get());
                        pOutput.accept(ModBlocks.ESCALERAS_COMOTANMUCHACHOS.get());
                        pOutput.accept(ModItems.HONGO_FEO.get());
                        pOutput.accept(ModItems.SAPPHIRE_STAFF.get());
                        pOutput.accept(ModItems.ESPADA_ANTIMAGIAA.get());
                        pOutput.accept(ModItems.PICO_MAGICO.get());
                        pOutput.accept(ModItems.HACHA_MAGICA.get());
                        pOutput.accept(ModItems.PALA_MAGICA.get());
                        pOutput.accept(ModItems.HOZ_MAGICA.get());
                        pOutput.accept(ModItems.CASCO_DE_ZAFIRO.get());
                        pOutput.accept(ModItems.PECHERA_DE_ZAFIRO.get());
                        pOutput.accept(ModItems.PANTALON_DE_ZAFIRO.get());
                        pOutput.accept(ModItems.BOTAS_DE_ZAFIRO.get());
                        pOutput.accept(ModItems.SEMILLA_DE_FRESA.get());
                        pOutput.accept(ModItems.MELON.get());
                        pOutput.accept(ModItems.DURAZNO.get());
                        pOutput.accept(ModBlocks.ROYER_BLOCKE.get());
                        pOutput.accept(ModItems.MAIZ.get());
                        pOutput.accept(ModItems.SEMILLA_DE_MAIZ.get());







                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
            }
}
