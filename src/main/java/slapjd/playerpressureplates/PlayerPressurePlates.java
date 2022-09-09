package slapjd.playerpressureplates;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import slapjd.playerpressureplates.blocks.PlayerPressurePlateBlock;

public class PlayerPressurePlates implements ModInitializer {
    //Values chosen to mimic obsidian and pressure plates
    public static final PlayerPressurePlateBlock OBSIDIAN_PRESSURE_PLATE = new PlayerPressurePlateBlock(FabricBlockSettings.of(Material.STONE).noCollision().requiresTool().strength(16.6f, 1200.0f));
    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("playerpressureplates", "obsidian_pressure_plate"), OBSIDIAN_PRESSURE_PLATE);
        Registry.register(Registry.ITEM, new Identifier("playerpressureplates", "obsidian_pressure_plate"), new BlockItem(OBSIDIAN_PRESSURE_PLATE, new FabricItemSettings().group(ItemGroup.REDSTONE)));
    }
}
