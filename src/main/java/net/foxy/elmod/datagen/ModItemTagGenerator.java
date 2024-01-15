package net.foxy.elmod.datagen;

import net.foxy.elmod.Elmod;
import net.foxy.elmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;



public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags,  @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, Elmod.MOD_ID, existingFileHelper);



    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CASCO_DE_ZAFIRO.get(),
                        ModItems.PECHERA_DE_ZAFIRO.get(),
                        ModItems.PANTALON_DE_ZAFIRO.get(),
                        ModItems.BOTAS_DE_ZAFIRO.get());

    }
}
