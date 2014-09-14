package com.hockeyhurd.mod;

import java.util.HashMap;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	public boolean updateFlag = false;
	protected HashMap<Short, String> map;
	
	public CommonProxy() {
	}
	
	public void registerRenderInformation() {
	}

	public void init() {
		// registerEventHandlers();
		// registerBlocks();
		registerItems();
		// addOreDict();
		// registerWorldgen();
		// addFuelRegister();
		addCraftingRecipes();
		addFurnaceRecipes();
		// if (ModsLoadedHelper.te4Loaded) pulverizeRecipes();
		// if (ModsLoadedHelper.ic2Loaded) maceratorRecipes();
		// registerTileEntities();
		// registerGuiHandler();
		// registerRegisters();
	}
	
	protected void registerItems() {
		GameRegistry.registerItem(FairExchangeMain.amuletTrade, "AmuletTrade");
	}
	
	protected void addCraftingRecipes() {
		
	}
	
	protected void addFurnaceRecipes() {
		
	}
	

}
