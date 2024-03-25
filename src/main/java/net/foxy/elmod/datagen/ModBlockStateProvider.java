package net.foxy.elmod.datagen;

import net.foxy.elmod.Elmod;
import net.foxy.elmod.block.ModBlocks;
import net.foxy.elmod.block.custom.CultivoDeFresa;
import net.foxy.elmod.block.custom.CultivoDeMaiz;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;



public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Elmod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        //configuracion de las texturas de bloques


        blockWithItem(ModBlocks.BLOQUE_DE_ZAFIRO);

        blockWithItem(ModBlocks.BLOQUE_COMOTANMUCHACHOS);

        blockWithItem(ModBlocks.MINERAL_MAGICO);

        blockWithItem(ModBlocks.BLOQUE_MUSICAL);

        blockWithItem(ModBlocks.ROYER_BLOCKE);

        //configuracion de las texturas de escaleras


        stairsBlock(((StairBlock) ModBlocks.ESCALERAS_COMOTANMUCHACHOS.get()), blockTexture(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get()));


        //configuracion de las texturas de las losas


        slabBlock(((SlabBlock) ModBlocks.LOSA_COMOTANMUCHACHOS.get()), blockTexture(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get()), blockTexture(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get()));


        //configuracion de las texturas de las placas de presion


        pressurePlateBlock(((PressurePlateBlock) ModBlocks.PLACA_DE_PRESION_COMOTANMUCHACHOS.get()), blockTexture(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get()));


        //configuracion de las texturas de los botones


        buttonBlock(((ButtonBlock) ModBlocks.BOTON_COMOTANMUCHACHOS.get()), blockTexture(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get()));


        //configuración de las texturas de las cercas


        fenceBlock(((FenceBlock) ModBlocks.CERCA_COMOTANMUCHACHOS.get()), blockTexture(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get()));


        //configuracion de las texturas de las puertas de cerca


        fenceGateBlock(((FenceGateBlock) ModBlocks.PUERTA_DE_LA_CERCA_COMOTANMUCHACHOS.get()), blockTexture(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get()));


        //configuracion de las texturas de los muros


        wallBlock(((WallBlock) ModBlocks.MURO_COMOTANMUCHACHOS.get()), blockTexture(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get()));


        doorBlockWithRenderType(((DoorBlock) ModBlocks.PUERTA_COMOTANMUCHACHOS.get()),modLoc("block/abajo_puerta_comoestanmuchachos"),modLoc("block/arriba_puerta_comoestanmuchachos"),"cutout");


        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.TRAMPILLA_COMOTANMUCHACHOS.get()),modLoc("block/trampilla_comoestanmuchachos"),true,"cutout");

        //Configuracion de las texturas de cultivos



        makeStrawberryCrop((CropBlock) ModBlocks.CULTIVO_DE_FRESA.get(), "fresa_stage", "fresa_stage");
        makeCornCrop(((CropBlock) ModBlocks.CULTIVO_DE_MAIZ.get()), "maiz_stage_", "maiz_stage_");


        // configuracion de texturas de una flor y una meseta con la flor
        simpleBlockWithItem(ModBlocks.FLOR_DE_LOTO.get(), models().cross(blockTexture(ModBlocks.FLOR_DE_LOTO.get()).getPath(),
                blockTexture(ModBlocks.FLOR_DE_LOTO.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.FLOR_DE_LOTO_MESETA.get(), models().singleTexture("flor_de_loto_meseta", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.FLOR_DE_LOTO.get())).renderType("cutout"));
    }


    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> EstadoFresa (state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] EstadoFresa(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CultivoDeFresa) block).getAgeProperty()),
                new ResourceLocation(Elmod.MOD_ID, "block/" + textureName + state.getValue(((CultivoDeFresa) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    public void makeCornCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CultivoDeMaiz) block).getAgeProperty()),
                new ResourceLocation(Elmod.MOD_ID, "block/" + textureName + state.getValue(((CultivoDeMaiz) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
      }
}
