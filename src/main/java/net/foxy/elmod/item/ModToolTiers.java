package net.foxy.elmod.item;

import net.foxy.elmod.Elmod;
import net.foxy.elmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {

    public static final Tier MAGICA = TierSortingRegistry.registerTier(
            new ForgeTier(5,1500, 5f, 4f, 25, ModTags.Blocks.NECESITA_HERRAMIENTA_MAGICA, () -> Ingredient.of(ModItems.CRISTAL_DE_MANA.get())),
            new ResourceLocation(Elmod.MOD_ID,"cristal_magico"), List.of(Tiers.NETHERITE), List.of());
}
