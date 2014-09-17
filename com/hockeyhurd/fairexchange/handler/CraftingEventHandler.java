package com.hockeyhurd.fairexchange.handler;

import net.minecraft.item.ItemStack;

import com.hockeyhurd.fairexchange.mod.FairExchangeMain;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftingEventHandler {

	public CraftingEventHandler() {
	}
	
	@SubscribeEvent
	public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
		
		for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
			if (event.craftMatrix.getStackInSlot(i) != null) {
				ItemStack stack = event.craftMatrix.getStackInSlot(i);
				if (stack.getItem() != null && stack.getItem() == FairExchangeMain.amuletTrade) {
					ItemStack newStack = new ItemStack(FairExchangeMain.amuletTrade, 2, (stack.getItemDamage() + 1));
					event.craftMatrix.setInventorySlotContents(i, newStack);
				}
			}
		}
	}

}
