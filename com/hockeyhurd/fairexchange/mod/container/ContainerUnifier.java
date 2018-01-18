package com.hockeyhurd.fairexchange.mod.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;

/**
 * Container class for TileUnifier.
 *
 * @author hockeyhurd
 * @version 8/3/2015.
 * @see com.hockeyhurd.fairexchange.mod.container.TileUnifier
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
                addSlotToContainer(new SlotUnifier(inv.player, (TileUnifier) te, 1 + x + y * 9, 12 + x * 18, 62 + y * 18));
            }
        }
    }



    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        return null;
    }

    private static class SlotUnifier extends SlotFurnaceOutput {

        public SlotUnifier(EntityPlayer player, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
            super(player, inventoryIn, slotIndex, xPosition, yPosition);
        }

        @Override
        public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
            super.onSlotChanged();

            inventory.setInventorySlotContents(0, ItemStack.EMPTY);

            return stack;
        }
    }

}
