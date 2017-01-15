package com.hockeyhurd.fairexchange.mod.handler;

import com.hockeyhurd.fairexchange.mod.FairExchangeMain;
import com.hockeyhurd.fairexchange.mod.manager.CraftingManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;

public class OreDictionaryRegisterHandler {

	public OreDictionaryRegisterHandler() {
	}

	@SubscribeEvent
	public void onRegister(OreRegisterEvent event) {
		if (event.getOre() != null && (event.getName().contains("ingot") || event.getName().contains("ore") || event.getName().contains("gem") ||
				event.getName().contains("quartz"))) {

			if (!CraftingManager.oreList.contains(event.getOre())) {
				CraftingManager.oreList.add(event.getOre());
				CraftingManager.addRecipe(event.getOre());
				FairExchangeMain.logHelper.info("Registered:", event.getName());
			}
		}
	}

}
