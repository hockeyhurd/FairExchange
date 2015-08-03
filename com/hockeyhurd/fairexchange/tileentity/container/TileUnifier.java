package com.hockeyhurd.fairexchange.tileentity.container;

import com.hockeyhurd.api.util.OreDictParser;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * @author hockeyhurd
 * @version 7/26/2015.
 */
public class TileUnifier extends AbstractTileISided {

	private ItemStack lastTickStack;

	public TileUnifier() {
		super("TileUnifier");
	}

	@Override
	protected void initSlots() {
		this.slots = new ItemStack[9 * 2 + 1];
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return true;
	}

	@Override
	protected void updateTile() {
		if (!worldObj.isRemote && worldObj.getTotalWorldTime() % 5L == 0) {

			ItemStack srcSlot = getStackInSlot(0);
			if (srcSlot != null && srcSlot.stackSize > 0) {

				if (lastTickStack == null || !srcSlot.isItemEqual(lastTickStack)) {
					lastTickStack = srcSlot;

					List<ItemStack> oreDictStacks = OreDictParser.getFromOreDict(OreDictParser.getOreDictName(srcSlot), srcSlot.stackSize);

					if (oreDictStacks != null && !oreDictStacks.isEmpty()) {
						final int maxLim = Math.min(getSizeInventory() - 1, oreDictStacks.size());

						for (int i = 1; i < maxLim; i++) {
							// slots[i] = oreDictStacks.get(i - 1).copy();
							setInventorySlotContents(i, oreDictStacks.get(i - 1));
						}
					}
				}

				else {
					ItemStack current;
					int min = Integer.MAX_VALUE;

					for (int i = 1; i < getSizeInventory(); i++) {
						current = getStackInSlot(i);
						if (current != null) {
							min = Math.min(current.stackSize, srcSlot.stackSize);
							current.stackSize = srcSlot.stackSize;
							if (current.stackSize == 0) current = null;
						}
					}

					if (srcSlot.stackSize != min) {
						srcSlot.stackSize = min;
						if (min == 0) srcSlot = null;
					}
				}

			}

			else {
				lastTickStack = null;

				for (int i = 1; i < getSizeInventory(); i++) {
					setInventorySlotContents(i, null);
				}
			}

			lastTickStack = srcSlot;
		}

	}

}
