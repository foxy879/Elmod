package net.foxy.elmod.item;

import net.foxy.elmod.Elmod;
import net.foxy.elmod.block.ModBlocks;
import net.foxy.elmod.item.custom.Detector_de_Metales;
import net.foxy.elmod.item.custom.FuelItems;
import net.foxy.elmod.item.custom.ModArmorItem;
import net.minecraft.server.commands.DamageCommand;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Elmod.MOD_ID);

    //Objetos que tecnicamente no sirven pa un culo

    public static final RegistryObject<Item> ZAFIRO =
            ITEMS.register("zafiro", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SONEDA =
            ITEMS.register("soneda", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SODIANTE =
            ITEMS.register("sodiante", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SOIRON =
            ITEMS.register("soiron", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SORO =
            ITEMS.register("soro", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SOBRE =
            ITEMS.register("sobre", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRISTAL_DE_MANA =
            ITEMS.register("cristal_de_mana", () -> new Item(new Item.Properties()));



    //Objetos con funciones especiales

    public static final RegistryObject<Item> DETECTOR_DE_METALES =
            ITEMS.register("detector_de_metales",()-> new Detector_de_Metales(new Item.Properties().durability(100)));


    //Objetos que son comida

    public static final RegistryObject<Item> PASTEL =
            ITEMS.register("pastel",()-> new Item(new Item.Properties().food(ModFoods.PASTEL)));
    public static final RegistryObject<Item> MELON =
            ITEMS.register("melon",()-> new Item(new Item.Properties().food(ModFoods.MELON)));


    //Objetos que tienen funciones de combustibles

    public static final RegistryObject<Item> GASOLINA =
            ITEMS.register("gasolina",()-> new FuelItems(new Item.Properties(),400));

    //Objeto creado pq si

    public static final RegistryObject<Item> HONGO_FEO =
            ITEMS.register("hongo_feo",()-> new Item(new Item.Properties()));


    // Prueba de objeto 3d

    public static final RegistryObject<Item> SAPPHIRE_STAFF = ITEMS.register("sapphire_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));


    //Objetos que son armas

    public static final RegistryObject<Item> ESPADA_ANTIMAGIAA =
            ITEMS.register("espada_antimagiaa",()-> new SwordItem(ModToolTiers.MAGICA, 16, 1.6f, new Item.Properties()));


    //Objetos que son picos

    public static final RegistryObject<Item> PICO_MAGICO =
            ITEMS.register("pico_magico",()-> new PickaxeItem(ModToolTiers.MAGICA, 2, 1.6f, new Item.Properties()));


    //Objetos que son hachas

    public static final RegistryObject<Item> HACHA_MAGICA =
            ITEMS.register("hacha_magica",()-> new AxeItem(ModToolTiers.MAGICA, 11, 0.9f, new Item.Properties()));


    //Objetos que son palas

    public static final RegistryObject<Item> PALA_MAGICA =
            ITEMS.register("pala_magica",()-> new ShovelItem(ModToolTiers.MAGICA, 1.5f, 1.6f, new Item.Properties()));


    //Objetos que son hoz

    public static final RegistryObject<Item> HOZ_MAGICA =
            ITEMS.register("hoz_magica",()-> new HoeItem(ModToolTiers.MAGICA, 2, 1.6f, new Item.Properties()));

    //Objetos que son cascos

    public static final RegistryObject<Item> CASCO_DE_ZAFIRO =
            ITEMS.register("casco_de_zafiro",()-> new ModArmorItem(ModArmorMaterials.ZAFIRO, ArmorItem.Type.HELMET, new Item.Properties()));

    //Objetos que son pecheras

    public static final RegistryObject<Item> PECHERA_DE_ZAFIRO =
            ITEMS.register("pechera_de_zafiro",()-> new ModArmorItem(ModArmorMaterials.ZAFIRO, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    //Objetos que son pantalones

    public static final RegistryObject<Item> PANTALON_DE_ZAFIRO =
            ITEMS.register("pantalon_de_zafiro",()-> new ModArmorItem(ModArmorMaterials.ZAFIRO, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    //Objetos que son botas

    public static final RegistryObject<Item> BOTAS_DE_ZAFIRO =
            ITEMS.register("botas_de_zafiro",()-> new ModArmorItem(ModArmorMaterials.ZAFIRO, ArmorItem.Type.BOOTS, new Item.Properties()));

    //Objetos que son semillas de cultivos

    public static final RegistryObject<Item> SEMILLA_DE_FRESA =
            ITEMS.register("semilla_de_fresa",()-> new ItemNameBlockItem(ModBlocks.CULTIVO_DE_FRESA.get(),new Item.Properties()));










    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
