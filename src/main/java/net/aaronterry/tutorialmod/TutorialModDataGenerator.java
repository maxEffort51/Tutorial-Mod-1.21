package net.aaronterry.tutorialmod;

import net.aaronterry.tutorialmod.datagen.ModBlockTagProvider;
import net.aaronterry.tutorialmod.datagen.ModLootTableProvider;
import net.aaronterry.tutorialmod.datagen.ModModelProvider;
import net.aaronterry.tutorialmod.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TutorialModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
