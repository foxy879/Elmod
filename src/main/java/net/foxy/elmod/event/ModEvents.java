package net.foxy.elmod.event;


import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.foxy.elmod.Elmod;
import net.foxy.elmod.block.ModBlocks;
import net.foxy.elmod.item.ModItems;
import net.foxy.elmod.villager.ModAldeanos;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Elmod.MOD_ID)
public class ModEvents {


    //este codigo se usa para modificar los tradeos de los aldeanos
    @SubscribeEvent
    public static void Agregartradeospersonalizados (VillagerTradesEvent event) {
        if (event.getType()== VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> Trades = event.getTrades();

//tradeo de aldeano modificado

            Trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.DIRT, 2),
                    new ItemStack(ModItems.MAIZ.get(), 1),
                    3,8,0.092f));
        }


    }
    @SubscribeEvent
    public static void Agregartradeoerrante (WandererTradesEvent event){
        List<VillagerTrades.ItemListing> Tradeogenerico = event.getGenericTrades();
        List<VillagerTrades.ItemListing> Tradeosraros = event.getRareTrades();

        Tradeogenerico.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.GOLD_INGOT, 10),
                new ItemStack(ModBlocks.FLOR_DE_LOTO.get(), 1),
                5,8,0.092f));

        Tradeosraros.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.GOLD_INGOT, 30),
                new ItemStack(ModItems.DETECTOR_DE_METALES.get(), 1),
                1,20,0.092f));
    }
    @SubscribeEvent
    public static void Tradeoparaelroscon (VillagerTradesEvent event){
        if (event.getType()== ModAldeanos.DJ_ALDEANO.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> Trades = event.getTrades();

            Trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND, 2),
                    new ItemStack(ModBlocks.ROYER_BLOCKE.get(), 1),
                    3,8,0.092f));
    }
  }
}
