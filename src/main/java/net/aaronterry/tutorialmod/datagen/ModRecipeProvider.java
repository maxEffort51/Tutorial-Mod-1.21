package net.aaronterry.tutorialmod.datagen;

import net.aaronterry.tutorialmod.block.ModBlocks;
import net.aaronterry.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public void reverseRecipe(RecipeExporter xpt, ItemConvertible base, ItemConvertible compact, RecipeCategory category) {
        offerReversibleCompactingRecipes(xpt, category, base, category, compact);
    }

    public ShapedRecipeJsonBuilder singleShaped(RecipeCategory cat, ItemConvertible result, String[] pattern, ItemConvertible hash) {
        ShapedRecipeJsonBuilder builder = ShapedRecipeJsonBuilder.create(cat, result)
                .pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2])
                .input('#', hash)
                .criterion(hasItem(hash), conditionsFromItem(hash));
        return builder;
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> smeltables = List.of(ModBlocks.ALIVITE_ORE);

        offerSmelting(exporter, smeltables, RecipeCategory.MISC, ModItems.ALIVITE_CHUNK, 2, 200, "alivite_group");

        offerBlasting(exporter, smeltables, RecipeCategory.MISC, ModItems.ALIVITE_CHUNK, 3, 100, "alivite_group");

        reverseRecipe(exporter, ModItems.ALIVITE_CHUNK, ModBlocks.ALIVITE_BLOCK, RecipeCategory.MISC);

        singleShaped(RecipeCategory.MISC, ModItems.LIVING_WAND, new String[]{"#","#","#"}, ModItems.ALIVITE_CHUNK)
                .offerTo(exporter);
    }
}
