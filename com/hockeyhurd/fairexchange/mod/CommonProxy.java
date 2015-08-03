package com.hockeyhurd.fairexchange.mod;

import java.util.HashMap;

import com.hockeyhurd.fairexchange.tileentity.container.TileUnifier;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.hockeyhurd.api.handler.NotifyPlayerOnJoinHandler;
import com.hockeyhurd.api.handler.UpdateHandler;
import com.hockeyhurd.fairexchange.handler.CraftingEventHandler;
import com.hockeyhurd.fairexchange.handler.OreDictionaryRegisterHandler;
import com.hockeyhurd.fairexchange.manager.CraftingManager;
import com.hockeyhurd.fairexchange.util.Reference;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	protected UpdateHandler updateHandler;
	protected HashMap<String, String> map;
	public boolean updateFlag = false;
	
	public CommonProxy() {
	}
	
	public void registerRenderInformation() {
	}

	public void init() {
		registerEventHandlers();
		registerBlocks();
		registerItems();
		addOreDict();
		// registerWorldgen();
		// addFuelRegister();
		addCraftingRecipes();
		addFurnaceRecipes();
		// if (ModsLoadedHelper.te4Loaded) pulverizeRecipes();
		// if (ModsLoadedHelper.ic2Loaded) maceratorRecipes();
		registerTileEntities();
		// registerGuiHandler();
		// registerRegisters();
	}
	
	protected void registerEventHandlers() {
		MinecraftForge.EVENT_BUS.register(new OreDictionaryRegisterHandler());
		FMLCommonHandler.instance().bus().register(new CraftingEventHandler());
	}

	protected void registerBlocks() {
		GameRegistry.registerBlock(FairExchangeMain.unifier, FairExchangeMain.unifier.getUnlocalizedName());
	}

	protected void registerItems() {
		GameRegistry.registerItem(FairExchangeMain.amuletTrade, "AmuletTrade");
	}
	
	protected void addOreDict() {
		OreDictionary.registerOre("coal", Items.coal);
		OreDictionary.registerOre("coal", new ItemStack(Items.coal, 1, 1));
	}
	
	protected void addCraftingRecipes() {
		CraftingManager.init();
	}
	
	protected void addFurnaceRecipes() {
	}

	protected void registerTileEntities() {
		GameRegistry.registerTileEntity(TileUnifier.class, TileUnifier.class.getSimpleName());
	}
	
	public void registerUpdateHandler() {
		updateHandler = new UpdateHandler(Reference.class);
		updateHandler.check();
		this.map = updateHandler.getMap();
		this.updateFlag = updateHandler.getUpToDate();
		
		MinecraftForge.EVENT_BUS.register(new NotifyPlayerOnJoinHandler(updateHandler, this.map, Reference.class, this.updateFlag, true, FairExchangeMain.configHandler.allowUpdating()));
	}
	

}
