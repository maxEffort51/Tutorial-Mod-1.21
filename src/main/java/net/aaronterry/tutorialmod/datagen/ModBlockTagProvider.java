package net.aaronterry.tutorialmod.datagen;

import net.aaronterry.tutorialmod.block.ModBlocks;
import net.aaronterry.tutorialmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public void addToTag(TagKey<Block> tag, Block[] blocks) {
        FabricTagBuilder builder = getOrCreateTagBuilder(tag);
        for (Block block : blocks) builder.add(block);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        addToTag(BlockTags.PICKAXE_MINEABLE, new Block[]{ModBlocks.ALIVITE_BLOCK, ModBlocks.ALIVITE_ORE});

        addToTag(BlockTags.NEEDS_STONE_TOOL, new Block[] { ModBlocks.ALIVITE_ORE });

        addToTag(BlockTags.NEEDS_IRON_TOOL, new Block[] { ModBlocks.ALIVITE_BLOCK });

        Block[] wand_to_ore = {
                Blocks.STONE, Blocks.DEEPSLATE, Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_GOLD_ORE,
                Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.COAL_ORE,
                Blocks.IRON_ORE, Blocks.GOLD_ORE, Blocks.REDSTONE_ORE, Blocks.LAPIS_ORE, Blocks.EMERALD_ORE, Blocks.DIAMOND_ORE, Blocks.NETHERRACK, Blocks.BLACKSTONE
        };
        addToTag(ModTags.Blocks.WAND_TO_ORE, wand_to_ore);
    }
}
