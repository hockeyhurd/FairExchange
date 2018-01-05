package com.hockeyhurd.fairexchange.mod.container;

import com.hockeyhurd.hcorelib.api.util.OreDictParser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

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
		slots = NonNullList.<ItemStack>withSize(9 * 2 + 1, ItemStack.EMPTY);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return null;
	}

	@Override
	public void openInventory(EntityPlayer player) {
	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return true;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {

	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
	}

	@Override
	public void update() {

		if (!world.isRemote && world.getTotalWorldTime() % 5L == 0) {

			ItemStack srcSlot = getStackInSlot(0);
			if (srcSlot != null && srcSlot.getCount() > 0) {

				if (lastTickStack == null || !srcSlot.isItemEqual(lastTickStack)) {
					lastTickStack = srcSlot;

					List<ItemStack> oreDictStacks = OreDictParser.getFromOreDict(OreDictParser.getOreDictName(srcSlot), srcSlot.getCount());

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
							min = Math.min(current.getCount(), srcSlot.getCount());
							current.setCount(srcSlot.getCount());

							if (current.getCount() == 0)
								current = ItemStack.EMPTY;
						}
					}

					if (srcSlot.getCount() != min) {
						srcSlot.setCount(min);

						if (min == 0)
						    srcSlot = ItemStack.EMPTY;
					}
				}

			}

			else {
				lastTickStack = null;

				for (int i = 1; i < getSizeInventory(); i++) {
					setInventorySlotContents(i, ItemStack.EMPTY);
				}
			}

			lastTickStack = srcSlot;
		}

	}

	@Override
	public String getName() {
		return getInventoryName();
	}

	@Override
	public boolean hasCustomName() {
		final String name = getInventoryName();
		return name != null && !name.isEmpty();
	}
}
