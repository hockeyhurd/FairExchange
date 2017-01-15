package com.hockeyhurd.fairexchange.mod.container;

import com.hockeyhurd.hcorelib.api.tileentity.AbstractTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Generic container class to be used with most container based tileentities.
 *
 * @author hockeyhurd
 * @version 8/3/2015.
 */
public class ContainerBase extends Container {

	protected final InventoryPlayer inv;
	protected final AbstractTile te;

	protected final int xOffset, yOffset;

	/**
	 * @param inv inventory of player as reference.
	 * @param te tile entity to append to as reference.
	 */
	public ContainerBase(InventoryPlayer inv, AbstractTile te) {
		this(inv, te, 0, 0);
	}

	/**
	 * @param inv inventory of player as reference.
	 * @param te tile entity to append to as reference.
	 * @param xOffset x-offset.
	 * @param yOffset y-offset.
	 */
	public ContainerBase(InventoryPlayer inv, AbstractTile te, int xOffset, int yOffset) {
		this.inv = inv;
		this.te = te;

		this.xOffset = xOffset;
		this.yOffset = yOffset;

		addSlots();
		addPlayerSlots();
	}

	/**
	 * Abstract method used to add custom slots to container.
	 */
	protected void addSlots() {}

	/**
	 * Method used to add player slots to container.
	 */
	protected void addPlayerSlots() {
		// Adds the player inventory to gui.
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(inv, x + y * 9 + 9, xOffset + 8 + x * 18, yOffset + 84 + y * 18));
			}
		}

		// Adds the player hotbar slots to the gui.
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inv, i, xOffset + 8 + i * 18, yOffset + 142)); // 198
		}
	}

	/**
	 * gets the TE instance.
	 *
	 * @return te object.
	 */
	public AbstractTile getTE() {
		return te;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		return null;
	}

}
