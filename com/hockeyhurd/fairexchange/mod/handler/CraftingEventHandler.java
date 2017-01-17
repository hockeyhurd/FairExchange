package com.hockeyhurd.fairexchange.mod.handler;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class CraftingEventHandler {

	public CraftingEventHandler() {
	}
	
	@SubscribeEvent
	public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
		
		/*for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
			if (event.craftMatrix.getStackInSlot(i) != null) {
				ItemStack stack = event.craftMatrix.getStackInSlot(i);
				if (stack.getItem() != null && stack.getItem() == FairExchangeMain.amuletTrade && stack.getItemDamage() < stack.getMaxDamage()) {
					ItemStack newStack = new ItemStack(FairExchangeMain.amuletTrade, 2, (stack.getItemDamage() + 1));
					event.craftMatrix.setInventorySlotContents(i, newStack);
				}
			}
		}*/
	}

}
