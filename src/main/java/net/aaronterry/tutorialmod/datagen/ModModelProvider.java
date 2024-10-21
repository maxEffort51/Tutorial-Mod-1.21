package net.aaronterry.tutorialmod.datagen;

import net.aaronterry.tutorialmod.block.ModBlocks;
import net.aaronterry.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    public void generateBlocks(BlockStateModelGenerator generator, Block[] blocks) {
        for (Block block : blocks) generator.registerSimpleCubeAll(block);
    }

    public void generateItems(ItemModelGenerator generator, Item[] items) {
        for (Item item : items) generator.register(item, Models.GENERATED);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateBlocks(blockStateModelGenerator, new Block[]{ModBlocks.ALIVITE_BLOCK, ModBlocks.ALIVITE_ORE});
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        generateItems(itemModelGenerator, new Item[]{ModItems.ALIVITE_CHUNK});
    }
}
