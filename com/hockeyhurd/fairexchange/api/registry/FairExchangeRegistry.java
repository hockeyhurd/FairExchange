package com.hockeyhurd.fairexchange.api.registry;

import com.hockeyhurd.fairexchange.mod.registry.BlockRegistry;
import com.hockeyhurd.fairexchange.mod.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 * API registry for blocks and items.
 *
 * @author hockeyhurd
 * @version 1/14/17
 */
public final class FairExchangeRegistry {

    private FairExchangeRegistry() {
    }

    public static Item getItemByName(String name) {
        return ItemRegistry.getInstance().getItemByName(name);
    }

    public static Block getBlockByName(String name) {
        return BlockRegistry.getInstance().getBlockByName(name);
    }

}
