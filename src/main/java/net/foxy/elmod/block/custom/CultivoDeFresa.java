package net.foxy.elmod.block.custom;


import net.foxy.elmod.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;




public class CultivoDeFresa extends CropBlock {

    public static final int MAX_AGE = 5 ;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public CultivoDeFresa(Properties pProperties) {
        super(pProperties);
    }


    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.SEMILLA_DE_FRESA.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
       pBuilder.add(AGE);



    }

}