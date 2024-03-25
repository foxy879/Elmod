package net.foxy.elmod.datagen.loot;

import net.foxy.elmod.block.ModBlocks;
import net.foxy.elmod.block.custom.CultivoDeFresa;
import net.foxy.elmod.block.custom.CultivoDeMaiz;
import net.foxy.elmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }


    @Override
    protected void generate() {


        //Loot tables para bloques que boratan su mismo item


        this.dropSelf(ModBlocks.BLOQUE_DE_ZAFIRO.get());
        this.dropSelf(ModBlocks.BLOQUE_MUSICAL.get());
        this.dropSelf(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get());
        this.dropSelf(ModBlocks.ROYER_BLOCKE.get());


        this.dropSelf(ModBlocks.BOTON_COMOTANMUCHACHOS.get());
        this.dropSelf(ModBlocks.PUERTA_DE_LA_CERCA_COMOTANMUCHACHOS.get());
        this.dropSelf(ModBlocks.ESCALERAS_COMOTANMUCHACHOS.get());
        this.dropSelf(ModBlocks.PLACA_DE_PRESION_COMOTANMUCHACHOS.get());
        this.dropSelf(ModBlocks.MURO_COMOTANMUCHACHOS.get());
        this.dropSelf(ModBlocks.TRAMPILLA_COMOTANMUCHACHOS.get());
        this.dropSelf(ModBlocks.CERCA_COMOTANMUCHACHOS.get());

        //Loot tables para losas ya que no se cosidera un solo bloque


        this.add(ModBlocks.LOSA_COMOTANMUCHACHOS.get(), block -> createSlabItemTable(ModBlocks.LOSA_COMOTANMUCHACHOS.get()));


        //Loot tables para puertas ya que no se cosidera un solo bloque


        this.add(ModBlocks.PUERTA_COMOTANMUCHACHOS.get(), block -> createDoorTable(ModBlocks.PUERTA_COMOTANMUCHACHOS.get()));



        //Loot tables de bloques donde sueltan ciertas cantidades y otros items distintos

        this.add(ModBlocks.MINERAL_MAGICO.get(),
                block -> createRedstoneLikeOreDrops(ModBlocks.MINERAL_MAGICO.get(), ModItems.CRISTAL_DE_MANA.get()));

        //Loot tables de bloques que son flores y mesetas

        this.dropSelf(ModBlocks.FLOR_DE_LOTO.get());
        this.add(ModBlocks.FLOR_DE_LOTO_MESETA.get(), createPotFlowerItemTable(ModBlocks.FLOR_DE_LOTO.get()));



        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CULTIVO_DE_FRESA.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CultivoDeFresa.AGE, 5));





        this.add(ModBlocks.CULTIVO_DE_FRESA.get(), createCropDrops(ModBlocks.CULTIVO_DE_FRESA.get(), ModItems.PASTEL.get() ,
            ModItems.SEMILLA_DE_FRESA.get(), lootitemcondition$builder));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CULTIVO_DE_MAIZ.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CultivoDeMaiz.AGE, 7))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.CULTIVO_DE_MAIZ.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CultivoDeMaiz.AGE, 8)));


        this.add(ModBlocks.CULTIVO_DE_MAIZ.get(), createCropDrops(ModBlocks.CULTIVO_DE_MAIZ.get(), ModItems.MAIZ.get(),
                ModItems.SEMILLA_DE_MAIZ.get(), lootitemcondition$builder2));

    }

    protected LootTable.Builder createRedstoneLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.
                                between(1.0F, 20.0F))).apply(ApplyBonusCount.
                                addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;


    }
}
