package net.foxy.elmod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties PASTEL = new FoodProperties.Builder().nutrition(10).saturationMod(3.0f)
            .effect( () -> new MobEffectInstance(MobEffects.REGENERATION, 200),100).build();
    public static final FoodProperties MELON = new FoodProperties.Builder().nutrition(12840).saturationMod(73.0f)
            .effect( () -> new MobEffectInstance(MobEffects.REGENERATION, 200),100).build();


}
