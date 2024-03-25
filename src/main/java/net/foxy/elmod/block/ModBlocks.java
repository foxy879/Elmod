package net.foxy.elmod.block;

import net.foxy.elmod.Elmod;
import net.foxy.elmod.block.custom.Bloque_musical;
import net.foxy.elmod.block.custom.CultivoDeFresa;
import net.foxy.elmod.block.custom.CultivoDeMaiz;
import net.foxy.elmod.item.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public final static DeferredRegister <Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Elmod.MOD_ID);

    public static final RegistryObject<Block> BLOQUE_DE_ZAFIRO = registerBlock("bloque_de_zafiro",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> BLOQUE_COMOTANMUCHACHOS = registerBlock("bloque_comoestanmuchachos",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> MINERAL_MAGICO = registerBlock("mineral_magico",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).destroyTime(3f).requiresCorrectToolForDrops(), UniformInt.of(1,10)));

    public static final RegistryObject<Block> BLOQUE_MUSICAL = registerBlock("bloque_musical",
            () -> new Bloque_musical(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.WOOD)));


    public static final RegistryObject<Block> ESCALERAS_COMOTANMUCHACHOS = registerBlock("escaleras_comoestanmuchachos",
            () -> new StairBlock(() -> ModBlocks.BLOQUE_COMOTANMUCHACHOS.get().defaultBlockState(),
            BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GLASS)));


    public static final RegistryObject<Block> LOSA_COMOTANMUCHACHOS = registerBlock("losa_comoestanmuchachos",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GLASS)));


    public static final RegistryObject<Block> BOTON_COMOTANMUCHACHOS = registerBlock("boton_comoestanmuchachos",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.GLASS),
                    BlockSetType.IRON,10,true));


    public static final RegistryObject<Block> PLACA_DE_PRESION_COMOTANMUCHACHOS = registerBlock("placa_de_presion_comoestanmuchachos",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GLASS),
                    BlockSetType.IRON));



    public static final RegistryObject<Block> CERCA_COMOTANMUCHACHOS = registerBlock("cerca_comoestanmuchachos",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GLASS)));



    public static final RegistryObject<Block> PUERTA_DE_LA_CERCA_COMOTANMUCHACHOS = registerBlock("puerta_de_la_cerca_comoestanmuchachos",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GLASS), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));



    public static final RegistryObject<Block> MURO_COMOTANMUCHACHOS = registerBlock("muro_comoestanmuchachos",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GLASS)));



    public static final RegistryObject<Block> PUERTA_COMOTANMUCHACHOS = registerBlock("puerta_comoestanmuchachos",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GLASS).noCollission(),BlockSetType.IRON));


    public static final RegistryObject<Block> TRAMPILLA_COMOTANMUCHACHOS = registerBlock("trampilla_comoestanmuchachos",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GLASS).noCollission(),BlockSetType.IRON));


    public static final RegistryObject<Block> CULTIVO_DE_FRESA = BLOCKS.register("cultivo_de_fresa",
            () -> new CultivoDeFresa(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> CULTIVO_DE_MAIZ = BLOCKS.register("cultivo_de_maiz",
            () -> new CultivoDeMaiz(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> ROYER_BLOCKE = registerBlock("royer_blocke",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.FIRE).sound(SoundType.NETHER_ORE)));

    public static final RegistryObject<Block> FLOR_DE_LOTO = registerBlock("flor_de_loto",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 20,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).sound(SoundType.FLOWERING_AZALEA).noCollission().noCollission()));

    public static final RegistryObject<Block> FLOR_DE_LOTO_MESETA = BLOCKS.register("flor_de_loto_meseta",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.FLOR_DE_LOTO,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_FLOWERING_AZALEA).sound(SoundType.FLOWERING_AZALEA).noCollission()));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block>RegistryObject <Item> registerBlockItem (String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

