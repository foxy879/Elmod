package net.foxy.elmod;

import com.mojang.logging.LogUtils;
import net.foxy.elmod.block.ModBlocks;
import net.foxy.elmod.item.ModCreativeModTabs;
import net.foxy.elmod.item.ModItems;
import net.foxy.elmod.loot.ModLootModifiers;
import net.foxy.elmod.villager.ModAldeanos;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static net.foxy.elmod.villager.ModAldeanos.VILLAGER_PROFESSIONS;

@Mod(Elmod.MOD_ID)
public class Elmod {

    public static final String MOD_ID = "elmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Elmod() {


        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModLootModifiers.register(modEventBus);


        ModAldeanos.register(modEventBus);


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.FLOR_DE_LOTO.getId(), ModBlocks.FLOR_DE_LOTO_MESETA);

        });

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event ) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)
            event.accept(ModItems.ZAFIRO);

        }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
