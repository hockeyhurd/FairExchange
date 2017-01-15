package com.hockeyhurd.fairexchange.mod;

import com.hockeyhurd.fairexchange.handler.CraftingEventHandler;
import com.hockeyhurd.fairexchange.handler.GuiHandler;
import com.hockeyhurd.fairexchange.handler.OreDictionaryRegisterHandler;
import com.hockeyhurd.fairexchange.manager.CraftingManager;
import com.hockeyhurd.fairexchange.tileentity.container.TileUnifier;
import com.hockeyhurd.fairexchange.util.Reference;
import com.hockeyhurd.hcorelib.api.block.IHBlock;
import com.hockeyhurd.hcorelib.api.handler.NotifyPlayerOnJoinHandler;
import com.hockeyhurd.hcorelib.api.handler.UpdateHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;

public class CommonProxy {

	protected UpdateHandler updateHandler;
	protected HashMap<String, String> map;
	public boolean updateFlag = false;
	protected static GuiHandler guiHandler;
	
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
		registerGuiHandler();
		// registerRegisters();
	}
	
	protected void registerEventHandlers() {
		MinecraftForge.EVENT_BUS.register(new OreDictionaryRegisterHandler());
		FMLCommonHandler.instance().bus().register(new CraftingEventHandler());
	}

	protected void registerBlocks() {
		GameRegistry.register(FairExchangeMain.unifier);
		GameRegistry.register(((IHBlock) FairExchangeMain.unifier).getItemBlock().setRegistryName(((IHBlock) FairExchangeMain.unifier).getBlock().getRegistryName()));
	}

	protected void registerItems() {
		GameRegistry.register(FairExchangeMain.amuletTrade);
	}
	
	protected void addOreDict() {
		OreDictionary.registerOre("coal", Items.COAL);
		OreDictionary.registerOre("coal", new ItemStack(Items.COAL, 1, 1));
	}
	
	protected void addCraftingRecipes() {
		CraftingManager.init();
	}
	
	protected void addFurnaceRecipes() {
	}

	protected void registerTileEntities() {
		GameRegistry.registerTileEntity(TileUnifier.class, TileUnifier.class.getSimpleName());
	}

	protected void registerGuiHandler() {
		if (guiHandler != null) NetworkRegistry.INSTANCE.registerGuiHandler(FairExchangeMain.instance, guiHandler);
		else {
			guiHandler = new GuiHandler();
			NetworkRegistry.INSTANCE.registerGuiHandler(FairExchangeMain.instance, guiHandler);
		}
	}

	public void registerUpdateHandler() {
		updateHandler = new UpdateHandler(Reference.MOD_NAME, Reference.VERSION, Reference.MOD_URL, Reference.CHANGELOG_URL);
		updateHandler.check();
		this.map = updateHandler.getMap();
		this.updateFlag = updateHandler.getUpToDate();

		MinecraftForge.EVENT_BUS.register(new NotifyPlayerOnJoinHandler(updateHandler, map, Reference.MOD_NAME, updateFlag, true,
				FairExchangeMain.configHandler.allowUpdating()));
	}
	

}
