package net.foxy.elmod.datagen;

import net.foxy.elmod.Elmod;
import net.foxy.elmod.block.ModBlocks;
import net.foxy.elmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;


public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Elmod.MOD_ID, existingFileHelper);


    }



    @Override
    protected void registerModels() {

        //items normales
        simpleItem(ModItems.GASOLINA);
        simpleItem(ModItems.SOBRE);
        simpleItem(ModItems.SORO);
        simpleItem(ModItems.SODIANTE);
        simpleItem(ModItems.SONEDA);
        simpleItem(ModItems.CRISTAL_DE_MANA);
        simpleItem(ModItems.ZAFIRO);
        simpleItem(ModItems.PASTEL);
        simpleItem(ModItems.DETECTOR_DE_METALES);
        simpleItem(ModItems.SOIRON);
        simpleItem(ModItems.SEMILLA_DE_FRESA);
        simpleItem(ModItems.MELON);
        simpleItem(ModItems.DURAZNO);
        simpleItem(ModItems.SEMILLA_DE_MAIZ);
        simpleItem(ModItems.MAIZ);





        //bloques que no son totalmente bloques



    simpleBlockItem(ModBlocks.PUERTA_COMOTANMUCHACHOS);

    fenceItem(ModBlocks.CERCA_COMOTANMUCHACHOS, ModBlocks.BLOQUE_COMOTANMUCHACHOS);
    buttonItem(ModBlocks.BOTON_COMOTANMUCHACHOS, ModBlocks.BLOQUE_COMOTANMUCHACHOS);
    wallItem(ModBlocks.MURO_COMOTANMUCHACHOS, ModBlocks.BLOQUE_COMOTANMUCHACHOS);

    evenSimplerBlockItem(ModBlocks.ESCALERAS_COMOTANMUCHACHOS);
    evenSimplerBlockItem(ModBlocks.LOSA_COMOTANMUCHACHOS);
    evenSimplerBlockItem(ModBlocks.PLACA_DE_PRESION_COMOTANMUCHACHOS);
    evenSimplerBlockItem(ModBlocks.PUERTA_DE_LA_CERCA_COMOTANMUCHACHOS);

    trapdoorItem(ModBlocks.TRAMPILLA_COMOTANMUCHACHOS);

    //Herramientas

    handheldItem(ModItems.HACHA_MAGICA);
    handheldItem(ModItems.PICO_MAGICO);
    handheldItem(ModItems.PALA_MAGICA);
    handheldItem(ModItems.HOZ_MAGICA);

    //Armadura

    trimmedArmorItem(ModItems.CASCO_DE_ZAFIRO);
    trimmedArmorItem(ModItems.PECHERA_DE_ZAFIRO);
    trimmedArmorItem(ModItems.PANTALON_DE_ZAFIRO);
    trimmedArmorItem(ModItems.BOTAS_DE_ZAFIRO);




    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = Elmod.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Elmod.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Elmod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Elmod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Elmod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Elmod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Elmod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Elmod.MOD_ID,"item/" + item.getId().getPath()));
    }
}