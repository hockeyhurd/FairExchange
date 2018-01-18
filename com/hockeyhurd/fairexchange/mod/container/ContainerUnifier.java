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
		super(inv, te, 31, 90);
	}

	@Override
	protected void addSlots() {
		addSlotToContainer(new Slot((TileUnifier) te, 0, 111, 25));

		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 12; x++) {
				addSlotToContainer(new SlotFurnaceOutput(inv.player, (TileUnifier) te, 1 + x + y * 9, 12 + x * 18, 62 + y * 18));
			}
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		return null;
	}

}
