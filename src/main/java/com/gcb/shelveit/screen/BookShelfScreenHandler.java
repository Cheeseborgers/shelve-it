package com.gcb.shelveit.screen;

import com.gcb.shelveit.ShelveIt;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;


public class BookShelfScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    //This constructor gets called on the client when the server wants it to open the screenHandler,
    //The client will call the other constructor with an empty Inventory and the screenHandler will automatically
    //sync this empty inventory with the inventory on the server.
    public BookShelfScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(27));
    }

    //This constructor gets called from the BlockEntity on the server without calling the other constructor first,
    // the server knows the inventory of the container and can therefore directly provide it as an argument.
    // This inventory will then be synced to the client.
    public BookShelfScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ShelveIt.BOOKSHELF_SCREEN_HANDLER, syncId);
        int numberOfRows = 3;
        checkSize(inventory, 9 * numberOfRows);
        this.inventory = inventory;
        //some inventories do custom logic when a player opens it.
        inventory.onOpen(playerInventory.player);

        //This will place the slot in the correct locations for a 9x3 Grid. The slots exist on both server and client!
        //This will not render the background of the slots however, this is the Screens job
        int m;
        int l;

        // Book Shelf inventory
        for(l = 0; l < numberOfRows; ++l) {
            for(m = 0; m < 9; ++m) {
                this.addSlot(new BookShelfSlot(inventory, m + l * 9, 8 + m * 18, 18 + l * 18));
            }
        }

        //The player inventory
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
        //The player hotbar
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }

    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    // Shift + Player Inv Slot
    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            // Ge the item stack
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            slot.onStackChanged(originalStack, newStack);
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public void close(PlayerEntity player) {
        super.close(player);
        this.inventory.onClose(player);
    }

    @Override
    public void onContentChanged(Inventory inventory) {
        if (inventory == this.inventory) {
            ItemStack itemStack = inventory.getStack(0);
            System.out.println(itemStack);
        }
    }

}
