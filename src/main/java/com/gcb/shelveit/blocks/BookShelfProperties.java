package com.gcb.shelveit.blocks;

import net.minecraft.block.AbstractBlock;

public class BookShelfProperties {

        public final String name;
        public final boolean flammable;
        public final int fuelValue;
        public final int burnTime;
        public final int spread;
        public final AbstractBlock.Settings settings;

        public BookShelfProperties(String name, boolean flammable, int fuelValue, int burnTime, int spread, AbstractBlock.Settings settings) {
                this.name = name;
                this.flammable = flammable;
                this.fuelValue = fuelValue;
                this.burnTime = burnTime;
                this.spread = spread;
                this.settings = settings;
        }

}
