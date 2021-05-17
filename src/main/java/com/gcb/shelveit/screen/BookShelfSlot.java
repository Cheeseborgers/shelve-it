package com.gcb.shelveit.screen;

import com.gcb.shelveit.ShelveIt;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.screen.slot.Slot;

public class BookShelfSlot extends Slot {

    public BookShelfSlot(Inventory inventory, int i, int j, int k) {
        super(inventory, i, j, k);
    }

    public boolean canInsert(ItemStack stack) {
        if (ShelveIt.BOOK_ITEMS_ONLY) {
            Item item = stack.getItem();
            if (item instanceof EnchantedBookItem
                    || item instanceof BookItem
                    || item instanceof WritableBookItem
                    || item instanceof WrittenBookItem) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
