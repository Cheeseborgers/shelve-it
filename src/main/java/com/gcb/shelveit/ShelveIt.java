package com.gcb.shelveit;

import com.gcb.shelveit.blocks.BookShelfBlock;
import com.gcb.shelveit.blocks.BookShelfBlockEntity;
import com.gcb.shelveit.blocks.BookShelfProperties;
import com.gcb.shelveit.screenhandlers.BookShelfScreenHandler;
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
		list.add(new BookShelfProperties("white_concrete", false, 300, 30, 20,AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE)));

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
