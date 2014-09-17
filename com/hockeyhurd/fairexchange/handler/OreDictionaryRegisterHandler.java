package com.hockeyhurd.fairexchange.handler;

import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;

import com.hockeyhurd.fairexchange.manager.CraftingManager;
import com.hockeyhurd.fairexchange.mod.FairExchangeMain;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class OreDictionaryRegisterHandler {

	public OreDictionaryRegisterHandler() {
	}

	@SubscribeEvent
	public void onRegister(OreRegisterEvent event) {
		if (event.Ore != null && (event.Name.contains("ingot") || event.Name.contains("ore") || event.Name.contains("gem") || event.Name.contains("quartz"))) {
			if (!CraftingManager.oreList.contains(event.Ore)) {
				CraftingManager.oreList.add(event.Ore);
				CraftingManager.addRecipe(event.Ore);
				FairExchangeMain.lh.info("Registered:", event.Name);
			}
		}

		else return;
	}

}
