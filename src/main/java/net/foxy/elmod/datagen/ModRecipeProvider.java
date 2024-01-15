package net.foxy.elmod.datagen;

import net.foxy.elmod.Elmod;
import net.foxy.elmod.block.ModBlocks;
import net.foxy.elmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

        private static final List<ItemLike> MINERAL_FUNDIBLE = List.of(ModBlocks.MINERAL_MAGICO.get());

        public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);

    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        oreSmelting(pWriter,MINERAL_FUNDIBLE, RecipeCategory.MISC, ModItems.CRISTAL_DE_MANA.get(), 0.25f, 200, "bloque de minerales");
        oreBlasting(pWriter, MINERAL_FUNDIBLE, RecipeCategory.MISC, ModItems.CRISTAL_DE_MANA.get(), 0.25f, 100, "bloque de minerales");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOQUE_DE_ZAFIRO.get())
                .pattern("SSS")
                .pattern("SXS")
                .pattern("SSS")
                .define('S', ModItems.ZAFIRO.get())
                .define('X', ModItems.SONEDA.get())
                .unlockedBy(getHasName(ModItems.ZAFIRO.get()), has(ModItems.ZAFIRO.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BOTON_COMOTANMUCHACHOS.get())
                .pattern("   ")
                .pattern(" S ")
                .pattern("   ")
                .define('S', ModBlocks.BLOQUE_COMOTANMUCHACHOS.get())
                .unlockedBy(getHasName(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get()), has(ModBlocks.BLOQUE_COMOTANMUCHACHOS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ZAFIRO.get(), 9)
                .requires(ModBlocks.BLOQUE_DE_ZAFIRO.get())
                .unlockedBy(getHasName(ModBlocks.BLOQUE_DE_ZAFIRO.get()), has(ModBlocks.BLOQUE_DE_ZAFIRO.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "para_fundir");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "para_fundir_en_alto_horno");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  Elmod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
}
    }
