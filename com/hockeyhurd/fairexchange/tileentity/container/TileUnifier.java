package com.hockeyhurd.fairexchange.tileentity.container;

import net.minecraft.item.ItemStack;

/**
 * @author hockeyhurd
 * @version 7/26/2015.
 */
public class TileUnifier extends AbstractTileISided {

	public TileUnifier() {
		super("TileUnifier");
	}

	@Override
	protected void initSlots() {
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return true;
	}

}
