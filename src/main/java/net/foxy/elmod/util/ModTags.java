package net.foxy.elmod.util;

import net.foxy.elmod.Elmod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> DETECTOR_DE_METALES_VARIABLE = tag("detector_de_metales_variable");
        public static final TagKey<Block> NECESITA_HERRAMIENTA_MAGICA = tag("necesita_herramienta_magica");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(Elmod.MOD_ID, name ));
        }
    }


    public static class Items {
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(Elmod.MOD_ID, name ));


    }
  }
}
