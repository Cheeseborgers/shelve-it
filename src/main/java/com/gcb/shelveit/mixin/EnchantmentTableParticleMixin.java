package com.gcb.shelveit.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.EnchantingTableBlock;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantingTableBlock.class)
public class EnchantmentTableParticleMixin  {

    @Redirect(
            method = "randomDisplayTick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"
            )
    )
    private boolean isBookshelf(BlockState blockState, Block block) {
        Identifier bookshelvesIdentifier = new Identifier("bookshelves");
        Tag<Block> bookshelvesTag = BlockTags.getTagGroup().getTag(bookshelvesIdentifier);
        return blockState.isIn(bookshelvesTag);

    }

}
