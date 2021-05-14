package com.gcb.shelveit.blocks;


import com.gcb.shelveit.ShelveIt;
import com.gcb.shelveit.screenhandlers.BookShelfScreenHandler;
import com.gcb.shelveit.utils.ImplementedInventory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;

public class BookShelfBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(27, ItemStack.EMPTY);
    private int viewerCount;

    public BookShelfBlockEntity() {
        super(ShelveIt.BOOKSHELF_BLOCK_ENTITY);
    }

    //From the ImplementedInventory Interface
    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    //These Methods are from the NamedScreenHandlerFactory Interface
    //createMenu creates the ScreenHandler itself
    //getDisplayName will Provide its name which is normally shown at the top
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        //We provide *this* to the screenHandler as our class Implements Inventory
        //Only the Server has the Inventory at the start, this will be synced to the client in the ScreenHandler
        return new BookShelfScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        Inventories.fromTag(tag, this.inventory);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        Inventories.toTag(tag, this.inventory);
        return tag;
    }

    // Gets the size of the inventory
    @Override
    public int size() {
        return this.inventory.size();
    }

    @Override
    public void onOpen(PlayerEntity player) {
        if(!player.isSpectator()) {
            if(this.viewerCount < 0) {
                this.viewerCount = 0;
            }

            ++this.viewerCount;
            assert this.world != null;
            this.world.addSyncedBlockEvent(this.pos, this.getCachedState().getBlock(), 1, this.viewerCount);

            if(this.viewerCount == 1) {
                this.world.playSound(null, this.pos, SoundEvents.ITEM_BOOK_PAGE_TURN,
                        SoundCategory.BLOCKS, 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
            }

            // Update the BlockStates
            onInvOpenOrClose();
        }
    }

    @Override
    public void onClose(PlayerEntity player) {
        if(!player.isSpectator()) {
            --this.viewerCount;
            assert this.world != null;
            this.world.addSyncedBlockEvent(this.pos, this.getCachedState().getBlock(), 1, this.viewerCount);
            if (this.viewerCount <= 0) {
                this.world.playSound(null, this.pos, SoundEvents.ITEM_BOOK_PUT,
                        SoundCategory.BLOCKS, 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
            }

            // Update the BlockStates
            onInvOpenOrClose();
        }

    }

    public void onInvOpenOrClose() {
        // Updates properties of the parents block state on opening/closing of
        // Its inventory
        Block block = this.getCachedState().getBlock();
        if (block instanceof BookShelfBlock) {
            assert this.world != null;
            world.setBlockState(pos, this.getCachedState().with(BookShelfBlock.NUMBER_OF_BOOKS, this.slotsInUse()));
        }
    }
}

