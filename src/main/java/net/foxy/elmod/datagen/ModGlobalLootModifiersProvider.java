package net.foxy.elmod.datagen;

import net.foxy.elmod.Elmod;
import net.foxy.elmod.item.ModItems;
import net.foxy.elmod.loot.AddItemModifier;
import net.foxy.elmod.loot.AddSusSandItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output ) {
        super(output, Elmod.MOD_ID);
    }

    @Override
    protected void start() {
        add("gasolina_from_cristal", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GLASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()},
                ModItems.GASOLINA.get()));

        add("gasolina_from_creeper", new AddItemModifier(new LootItemCondition[]{
              new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build()
        },ModItems.GASOLINA.get()));


        add("soneda_from_cofres", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/desert_pyramid")).build()
        },ModItems.SONEDA.get()));

        add("soneda_from_arena_sospechosa", new AddSusSandItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/desert_pyramid")).build()
        },ModItems.SONEDA.get()));


    }
}
