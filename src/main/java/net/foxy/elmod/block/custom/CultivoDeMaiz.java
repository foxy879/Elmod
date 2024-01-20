package net.foxy.elmod.block.custom;

import net.foxy.elmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;

public class CultivoDeMaiz extends CropBlock {
    public static final int EDAD_MAXIMA_PRIMERA_ETAPA = 7;
    public static final int EDAD_MAXIMA_SEGUNDA_ETAPA = 1;

    private static final VoxelShape[] FORMA_POR_EDAD = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};


    public static final IntegerProperty EDAD = IntegerProperty.create("age", 0, 8);


    public CultivoDeMaiz(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return FORMA_POR_EDAD[this.getAge(pState)];
    }
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pLevel.isAreaLoaded(pPos, 1)) return;
        if (pLevel.getRawBrightness(pPos, 0) >= 9) {
            int currentAge = this.getAge(pState);

            if (currentAge < this.getMaxAge()) {
                float growthSpeed = getGrowthSpeed(this, pLevel, pPos);

                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt((int)(25.0F / growthSpeed) + 1) == 0)) {
                    if(currentAge == EDAD_MAXIMA_PRIMERA_ETAPA) {
                        if(pLevel.getBlockState(pPos.above(1)).is(Blocks.AIR)) {
                            pLevel.setBlock(pPos.above(1), this.getStateForAge(currentAge + 1), 2);
                        }
                    } else {
                        pLevel.setBlock(pPos, this.getStateForAge(currentAge + 1), 2);
                    }

                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
                }
            }
        }
    }


    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return super.canSurvive(pState, pLevel, pPos) || pLevel.getBlockState(pPos.below(1)).is(this) &&
                pLevel.getBlockState(pPos.below(1)).getValue(EDAD)==7;
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return super.mayPlaceOn(state, world, pos);
    }

    @Override
    public void growCrops(Level pLevel, BlockPos pPos, BlockState pState) {
        int siguienteEdad = this.getAge(pState) + this.getBonemealAgeIncrease(pLevel);
        int maximaEdad = this.getMaxAge();
        if (siguienteEdad > maximaEdad) {
            siguienteEdad = maximaEdad;
        }
        if (this.getAge(pState) == EDAD_MAXIMA_PRIMERA_ETAPA && pLevel.getBlockState(pPos.above(1)).is(Blocks.AIR)){
            pLevel.setBlock(pPos.above(1), this.getStateForAge(siguienteEdad), 2);
        }else { pLevel.setBlock(pPos, this.getStateForAge(siguienteEdad-1), 2);


        }
    }

    @Override
    public int getMaxAge() {
        return EDAD_MAXIMA_PRIMERA_ETAPA + EDAD_MAXIMA_SEGUNDA_ETAPA ;
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return EDAD;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.SEMILLA_DE_MAIZ.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(EDAD);
    }
}
