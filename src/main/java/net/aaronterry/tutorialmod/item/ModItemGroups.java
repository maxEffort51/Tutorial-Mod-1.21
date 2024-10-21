package net.aaronterry.tutorialmod.item;

import net.aaronterry.tutorialmod.TutorialMod;
import net.aaronterry.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ALIVITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "alivite_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.ALIVITE_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.alivite_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ALIVITE_CHUNK);
                        entries.add(ModBlocks.ALIVITE_ORE);
                        entries.add(ModBlocks.ALIVITE_BLOCK);
                        entries.add(ModItems.LIVING_WAND);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
