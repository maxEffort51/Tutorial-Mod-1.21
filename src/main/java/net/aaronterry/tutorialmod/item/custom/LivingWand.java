package net.aaronterry.tutorialmod.item.custom;

import net.aaronterry.tutorialmod.block.ModBlocks;
import net.aaronterry.tutorialmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class LivingWand extends Item {
    private static final Map<Block, Block> WAND_ORE_MAP =
            Map.of(
                    Blocks.STONE, ModBlocks.ALIVITE_ORE,
                    Blocks.DEEPSLATE, ModBlocks.ALIVITE_ORE,
                    Blocks.COAL_ORE, ModBlocks.ALIVITE_ORE,
                    Blocks.IRON_ORE, ModBlocks.ALIVITE_ORE,
                    Blocks.COPPER_ORE, ModBlocks.ALIVITE_ORE,
                    Blocks.GOLD_ORE, ModBlocks.ALIVITE_ORE,
                    Blocks.LAPIS_ORE, ModBlocks.ALIVITE_ORE,
                    Blocks.REDSTONE_ORE, ModBlocks.ALIVITE_ORE,
                    Blocks.NETHERRACK, ModBlocks.ALIVITE_ORE,
                    Blocks.BLACKSTONE, ModBlocks.ALIVITE_ORE
            );

    public LivingWand(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (!world.isClient()) {
            BlockState changeTo = ModBlocks.ALIVITE_BLOCK.getDefaultState();
            PlayerEntity player = context.getPlayer();
            if (player == null) return ActionResult.FAIL;

            if (changesToOre(clickedBlock.getDefaultState())) changeTo = ModBlocks.ALIVITE_ORE.getDefaultState();
            if (clickedBlock == ModBlocks.ALIVITE_BLOCK) return ActionResult.FAIL;

            world.setBlockState(context.getBlockPos(), changeTo);
            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) player),
                    item -> player.sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

            world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS);
        }


        return ActionResult.SUCCESS;
    }

    private boolean changesToOre(BlockState state) {
        return state.isIn(ModTags.Blocks.WAND_TO_ORE);
    }
}
