package com.hockeyhurd.fairexchange.mod.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;

/**
 * Container class for TileUnifier.
 *
 * @see com.hockeyhurd.fairexchange.mod.container.TileUnifier
 *
 * @author hockeyhurd
 * @version 8/3/2015.
 */
public class ContainerUnifier extends ContainerBase {

	public ContainerUnifier(InventoryPlayer inv, TileUnifier te) {
		super(inv, te, 0, 14);
	}

	@Override
	protected void addSlots() {
		this.addSlotToContainer(new Slot((TileUnifier) te, 0, 79, 21));

		for (int y = 0; y < 2; y++) {
			for (int x = 0; x < 9; x++) {
				this.addSlotToContainer(new SlotFurnaceOutput(inv.player, (TileUnifier) te, 1 + x + y * 9, 8 + x * 18, 1 + 53 + y * 18));
			}
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		return null;
	}

}
