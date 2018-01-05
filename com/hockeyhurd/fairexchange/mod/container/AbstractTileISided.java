package com.hockeyhurd.fairexchange.mod.container;

import com.hockeyhurd.hcorelib.api.tileentity.AbstractTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;

/**
 * General purpose class for creating tile entities that contain an inventory
 * and are isided.
 *
 * @author hockeyhurd
 * @version 7/26/2015.
 */
public abstract class AbstractTileISided extends AbstractTile implements ISidedInventory, ITickable {

	protected NonNullList<ItemStack> slots;

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

    protected boolean isInventoryEmpty() {
        for (ItemStack stack : slots) {
            if (!stack.isEmpty())
                return false;
        }

        return true;
    }

    @Override
    public boolean isEmpty() {
        return isInventoryEmpty();
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

	@Override
	public void readNBT(NBTTagCompound comp) {
		slots = NonNullList.<ItemStack>withSize(getSizeInventory(), ItemStack.EMPTY);

		NBTTagList tagList = comp.getTagList("Items", 10);

		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound temp = tagList.getCompoundTagAt(i);
			byte b0 = temp.getByte("Slot");

			if (b0 >= 0 && b0 < slots.size())
				slots.set(b0, new ItemStack(temp));
		}
	}

	@Override
	public void saveNBT(NBTTagCompound comp) {
		if (slots != null) {
			NBTTagList tagList = comp.getTagList("Items", 10);

			for (int i = 0; i < slots.size(); i++) {
				if (slots.get(i) != ItemStack.EMPTY) {
					NBTTagCompound temp = new NBTTagCompound();
					temp.setByte("Slot", (byte) i);
					slots.get(i).writeToNBT(comp);
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
		return slots.size();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return slots != null ? slots.get(slot) : null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (slots != null) {
			ItemStack ret;

			if (slots.get(slot).getCount() <= amount) {
				ret = slots.get(slot);
				slots.set(slot, ItemStack.EMPTY);
			}

			else {
				ret = slots.get(slot).splitStack(amount);
				if (slots.get(slot).getCount() <= 0)
                    slots.set(slot, ItemStack.EMPTY);
			}

			return ret;
		}

		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		slots.set(slot, stack);

		if (stack != ItemStack.EMPTY) {
			int minMaxSize = Math.min(getInventoryStackLimit(), stack.getCount());

			if (stack.getCount() <= 0)
			    slots.set(slot, ItemStack.EMPTY);
			else if (stack.getCount() > minMaxSize)
			    slots.get(slot).setCount(minMaxSize);
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

}
