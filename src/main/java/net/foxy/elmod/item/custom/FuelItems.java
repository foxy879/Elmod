package net.foxy.elmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

import javax.annotation.Nullable;

public class FuelItems extends Item {

    private int burnTime = 0;


    public FuelItems(Properties pProperties,int burnTime) {
        super(pProperties);
        this.burnTime = burnTime;
    }

    @Override

    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType){
        return this.burnTime;

    }
}
