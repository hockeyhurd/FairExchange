package com.hockeyhurd.fairexchange.mod.container;

import com.hockeyhurd.hcorelib.api.tileentity.AbstractTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

/**
 * General purpose class for creating tile entities that contain an inventory
 * and are isided.
 *
 * @author hockeyhurd
 * @version 7/26/2015.
 */
public abstract class AbstractTileISided extends AbstractTile implements ISidedInventory, ITickable {

	protected ItemStack[] slots;

	public AbstractTileISided() {
		this("container.iSided");
	}

	public AbstractTileISided(String customName) {
		super(customName);

		initSlots();
	}

	/**
	 * Method provided for initializing inventory slots.
	 * <br><bold>NOTE: </bold>Super constructor calls this method, no need to re-call this method!
	 */
	protected abstract void initSlots();

	@Override
	public void readNBT(NBTTagCompound comp) {
		slots = new ItemStack[getSizeInventory()];
		NBTTagList tagList = comp.getTagList("Items", 10);

		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound temp = tagList.getCompoundTagAt(i);
			byte b0 = temp.getByte("Slot");

			if (b0 >= 0 && b0 < slots.length) slots[b0] = ItemStack.loadItemStackFromNBT(temp);
		}
	}

	@Override
	public void saveNBT(NBTTagCompound comp) {
		if (slots != null && slots.length > 0) {
			NBTTagList tagList = comp.getTagList("Items", 10);

			for (int i = 0; i < slots.length; i++) {
				if (slots[i] != null) {
					NBTTagCompound temp = new NBTTagCompound();
					temp.setByte("Slot", (byte) i);
					slots[i].writeToNBT(comp);
					tagList.appendTag(temp);
				}
			}

			comp.setTag("Items", tagList);
		}
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return new int[0];
	}

	@Override
	public abstract boolean isItemValidForSlot(int slot, ItemStack stack);

	@Override
	public boolean canInsertItem(int slot, ItemStack stack, EnumFacing side) {
		return slot >= 0 && slot < getSizeInventory() && isItemValidForSlot(slot, stack);
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack stack, EnumFacing side) {
		return true;
	}

	@Override
	public int getSizeInventory() {
		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return slots != null && slots.length > 0 ? slots[slot] : null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (slots != null && slots.length > 0) {
			ItemStack ret;

			if (slots[slot].stackSize <= amount) {
				ret = slots[slot];
				slots[slot] = null;
			}

			else {
				ret = slots[slot].splitStack(amount);
				if (slots[slot].stackSize <= 0) slots[slot] = null;
			}

			return ret;
		}

		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		slots[slot] = stack;
		if (stack != null) {
			int minMaxSize = Math.min(getInventoryStackLimit(), stack.stackSize);

			if (stack.stackSize <= 0) slots[slot] = null;
			else if (stack.stackSize > minMaxSize) slots[slot].stackSize = minMaxSize;
		}
	}

	@Override
	public boolean hasCustomInventoryName() {
		return hasCustomName();
	}

	@Override
	public int getInventoryStackLimit() {
		return 0x40;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

}
