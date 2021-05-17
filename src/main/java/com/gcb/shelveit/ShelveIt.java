package com.gcb.shelveit;

import com.gcb.shelveit.blocks.BookShelfBlock;
import com.gcb.shelveit.blocks.BookShelfBlockEntity;
import com.gcb.shelveit.blocks.BookShelfProperties;
import com.gcb.shelveit.screen.BookShelfScreenHandler;
import com.gcb.shelveit.screen.BookShelfSlot;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

public class ShelveIt implements ModInitializer {

	public static final String MODID = "shelveit";
	public static final String PATH = "bookshelves";

	//Config
	public static final Boolean BOOK_ITEMS_ONLY = true;
	public static final Boolean WOOL_SHELVES_BURN = true;

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MODID, PATH),
			() -> new ItemStack(Blocks.BOOKSHELF));

	public static Block BOOKSHELF_BLOCK = null;
	public static BlockItem BOOKSHELF_BLOCK_ITEM = null;
	public static BlockEntityType<BookShelfBlockEntity> BOOKSHELF_BLOCK_ENTITY = null;
	public static Identifier BOOKSHELF_ID = null;

	public static ScreenHandlerType<BookShelfScreenHandler> BOOKSHELF_SCREEN_HANDLER = null;

	@Override
	public void onInitialize() {

		System.out.println(MODID + " Is loaded!");

		ArrayList<BookShelfProperties> list = new ArrayList<>();

		//Add our shelves to the ArrayList
		list.add(new BookShelfProperties("white_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE)));
		list.add(new BookShelfProperties("black_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.BLACK_CONCRETE)));
		list.add(new BookShelfProperties("blue_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.BLUE_CONCRETE)));
		list.add(new BookShelfProperties("brown_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.BROWN_CONCRETE)));
		list.add(new BookShelfProperties("cyan_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.CYAN_CONCRETE)));
		list.add(new BookShelfProperties("gray_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.GRAY_CONCRETE)));
		list.add(new BookShelfProperties("green_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.GREEN_CONCRETE)));
		list.add(new BookShelfProperties("light_blue_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CONCRETE)));
		list.add(new BookShelfProperties("light_gray_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CONCRETE)));
		list.add(new BookShelfProperties("lime_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.LIME_CONCRETE)));
		list.add(new BookShelfProperties("magenta_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.MAGENTA_CONCRETE)));
		list.add(new BookShelfProperties("orange_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.ORANGE_CONCRETE)));
		list.add(new BookShelfProperties("pink_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
		list.add(new BookShelfProperties("purple_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.PURPLE_CONCRETE)));
		list.add(new BookShelfProperties("red_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.RED_CONCRETE)));
		list.add(new BookShelfProperties("yellow_concrete", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.YELLOW_CONCRETE)));


		list.add(new BookShelfProperties("terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.TERRACOTTA)));
		list.add(new BookShelfProperties("white_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.WHITE_TERRACOTTA)));
		list.add(new BookShelfProperties("black_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.BLACK_TERRACOTTA)));
		list.add(new BookShelfProperties("blue_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.BLUE_TERRACOTTA)));
		list.add(new BookShelfProperties("brown_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.BROWN_TERRACOTTA)));
		list.add(new BookShelfProperties("cyan_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.CYAN_TERRACOTTA)));
		list.add(new BookShelfProperties("gray_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.GRAY_TERRACOTTA)));
		list.add(new BookShelfProperties("green_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.GREEN_TERRACOTTA)));
		list.add(new BookShelfProperties("light_blue_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_TERRACOTTA)));
		list.add(new BookShelfProperties("light_gray_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_TERRACOTTA)));
		list.add(new BookShelfProperties("lime_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.LIME_TERRACOTTA)));
		list.add(new BookShelfProperties("magenta_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.MAGENTA_TERRACOTTA)));
		list.add(new BookShelfProperties("orange_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.ORANGE_TERRACOTTA)));
		list.add(new BookShelfProperties("pink_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.PINK_TERRACOTTA)));
		list.add(new BookShelfProperties("purple_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.PURPLE_TERRACOTTA)));
		list.add(new BookShelfProperties("red_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.RED_TERRACOTTA)));
		list.add(new BookShelfProperties("yellow_terracotta", false, 0, 30, 20,AbstractBlock.Settings.copy(Blocks.YELLOW_TERRACOTTA)));


		list.add(new BookShelfProperties("white_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)));
		list.add(new BookShelfProperties("black_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.BLACK_WOOL)));
		list.add(new BookShelfProperties("blue_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.BLUE_WOOL)));
		list.add(new BookShelfProperties("brown_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.BROWN_WOOL)));
		list.add(new BookShelfProperties("cyan_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.CYAN_WOOL)));
		list.add(new BookShelfProperties("gray_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
		list.add(new BookShelfProperties("green_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.GREEN_WOOL)));
		list.add(new BookShelfProperties("light_blue_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_WOOL)));
		list.add(new BookShelfProperties("light_gray_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_WOOL)));
		list.add(new BookShelfProperties("lime_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.LIME_WOOL)));
		list.add(new BookShelfProperties("magenta_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.MAGENTA_WOOL)));
		list.add(new BookShelfProperties("orange_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.ORANGE_WOOL)));
		list.add(new BookShelfProperties("pink_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.PINK_WOOL)));
		list.add(new BookShelfProperties("purple_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.PURPLE_WOOL)));
		list.add(new BookShelfProperties("red_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.RED_WOOL)));
		list.add(new BookShelfProperties("yellow_wool", WOOL_SHELVES_BURN, 100, 30, 60,AbstractBlock.Settings.copy(Blocks.YELLOW_WOOL)));

		for (BookShelfProperties shelf : list) {
			BookShelfBlock bookshelf = new BookShelfBlock(shelf.settings, true);
			BOOKSHELF_ID = new Identifier(MODID, String.format("%s_bookshelf", shelf.name));

			//Block ---------------------------------------------------------------------------------------------------
			BOOKSHELF_BLOCK = Registry.register(Registry.BLOCK, BOOKSHELF_ID, bookshelf);
			//Block Item ----------------------------------------------------------------------------------------------
			BOOKSHELF_BLOCK_ITEM = Registry.register(Registry.ITEM, BOOKSHELF_ID, new BlockItem(
					bookshelf, new Item.Settings().group(ShelveIt.ITEM_GROUP)));
			//Block Entity --------------------------------------------------------------------------------------------
			BOOKSHELF_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, BOOKSHELF_ID,
					BlockEntityType.Builder.create(BookShelfBlockEntity::new, bookshelf).build(null));
			//Block Screen handler ------------------------------------------------------------------------------------
			BOOKSHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(BOOKSHELF_ID, BookShelfScreenHandler::new);

			BlockRenderLayerMap.INSTANCE.putBlock(BOOKSHELF_BLOCK, RenderLayer.getTranslucent());

			if (shelf.flammable)
			{
				FuelRegistry.INSTANCE.add(bookshelf, shelf.fuelValue);
				FlammableBlockRegistry.getDefaultInstance().add(bookshelf, shelf.burnTime, shelf.spread);
			}

			System.out.println(MODID + ":" + shelf.name + "_bookshelf is loaded.");
		}
	}
}
