package com.hockeyhurd.fairexchange.mod.container;

import com.hockeyhurd.fairexchange.mod.registry.ModOreDictionary;
import com.hockeyhurd.hcorelib.api.tileentity.AbstractTileContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;

/**
 * @author hockeyhurd
 * @version 7/26/2015.
 */
public class TileUnifier extends AbstractTileContainer implements ITickable {

    private static final ModOreDictionary MOD_ORE_DICTIONARY = ModOreDictionary.getInstance();
    private static final int[] slotIndicies = { 0 };
    private ItemStack lastTickStack;

    public TileUnifier() {
        super("TileUnifier");
    }

    @Override
    protected void initSlotsArray() {
        slots = NonNullList.<ItemStack>withSize(12 * 6 + 1, ItemStack.EMPTY);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
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
    public int[] getSlotsForFace(EnumFacing side) {
        return slotIndicies;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return slot == 0;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, EnumFacing side) {
        return isItemValidForSlot(slot, stack);
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, EnumFacing side) {
        return slot == 0;
    }

    @Override
    public void update() {

        if (!world.isRemote && world.getTotalWorldTime() % 5L == 0) {
            final ItemStack srcSlot = getStackInSlot(0);

            if (srcSlot != ItemStack.EMPTY) {
                final NonNullList<ItemStack> oresByName = MOD_ORE_DICTIONARY.getOresByName(MOD_ORE_DICTIONARY.getOreName(srcSlot));
                final int numElem = Math.min(oresByName.size(), getSizeInventory() - 1);

                for (int i = 0; i < numElem; i++) {
                    final ItemStack putStack = oresByName.get(i);
                    putStack.setCount(srcSlot.getCount());

                    setInventorySlotContents(i + 1, putStack);
                }
            }

            else {
                for (int i = 1; i < getSizeInventory(); i++) {
                    setInventorySlotContents(i, ItemStack.EMPTY);
                }
            }
        }

    }
}
