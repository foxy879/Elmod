package net.foxy.elmod.datagen;

import net.foxy.elmod.Elmod;
import net.foxy.elmod.block.ModBlocks;
import net.foxy.elmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import java.util.concurrent.CompletableFuture;



//Este archivo define la

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Elmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.DETECTOR_DE_METALES_VARIABLE)
                .add(ModBlocks.MINERAL_MAGICO.get()).addTags(Tags.Blocks.ORES);


        //Estos son los bloques que pueden ser minados con un pico

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MINERAL_MAGICO.get())
                .add(ModBlocks.BLOQUE_DE_ZAFIRO.get())
                .add(ModBlocks.BLOQUE_MUSICAL.get())
                .add(ModBlocks.BOTON_COMOTANMUCHACHOS.get())
                .add(ModBlocks.PUERTA_COMOTANMUCHACHOS.get())
                .add(ModBlocks.PLACA_DE_PRESION_COMOTANMUCHACHOS.get())
                .add(ModBlocks.TRAMPILLA_COMOTANMUCHACHOS.get())
                .add(ModBlocks.LOSA_COMOTANMUCHACHOS.get())
                .add(ModBlocks.CERCA_COMOTANMUCHACHOS.get())
                .add(ModBlocks.PUERTA_DE_LA_CERCA_COMOTANMUCHACHOS.get())
                .add(ModBlocks.MURO_COMOTANMUCHACHOS.get())
                .add(ModBlocks.ESCALERAS_COMOTANMUCHACHOS.get())
                .add(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get());



        //Estos son los bloques que pueden ser minados con una hacha

        this.tag(BlockTags.MINEABLE_WITH_AXE);



        //Estos son los bloques que pueden ser minados con una pala


        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);



        //Estos son los bloques que pueden ser minados con una hoz



        this.tag(BlockTags.MINEABLE_WITH_HOE);






//Esto es el nivel de herramienta requerido para romper el bloque

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MINERAL_MAGICO.get())
                .add(ModBlocks.BLOQUE_DE_ZAFIRO.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);


        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get());



        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.ESCALERAS_COMOTANMUCHACHOS.get());


        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL);


        this.tag(ModTags.Blocks.NECESITA_HERRAMIENTA_MAGICA)
                .add(ModBlocks.BLOQUE_MUSICAL.get());





//Tarjetas (tags) de bloques que no son bloques enteros


        this.tag(BlockTags.FENCES)
                .add(ModBlocks.CERCA_COMOTANMUCHACHOS.get());



        this.tag(BlockTags.SLABS)
                .add(ModBlocks.LOSA_COMOTANMUCHACHOS.get());




        this.tag(BlockTags.DOORS)
                .add(ModBlocks.PUERTA_COMOTANMUCHACHOS.get());



        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.PUERTA_DE_LA_CERCA_COMOTANMUCHACHOS.get());



        this.tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.TRAMPILLA_COMOTANMUCHACHOS.get());



        this.tag(BlockTags.WALLS)
                .add(ModBlocks.MURO_COMOTANMUCHACHOS.get());



        this.tag(BlockTags.BUTTONS)
                .add(ModBlocks.BOTON_COMOTANMUCHACHOS.get());



        this.tag(BlockTags.STAIRS)
                .add(ModBlocks.ESCALERAS_COMOTANMUCHACHOS.get());



        this.tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.PLACA_DE_PRESION_COMOTANMUCHACHOS.get());





    }
}
