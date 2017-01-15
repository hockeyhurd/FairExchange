package com.hockeyhurd.fairexchange.mod;

import com.hockeyhurd.fairexchange.mod.container.TileUnifier;
import com.hockeyhurd.fairexchange.mod.handler.CraftingEventHandler;
import com.hockeyhurd.fairexchange.mod.handler.GuiHandler;
import com.hockeyhurd.fairexchange.mod.handler.OreDictionaryRegisterHandler;
import com.hockeyhurd.fairexchange.mod.manager.CraftingManager;
import com.hockeyhurd.fairexchange.mod.registry.BlockRegistry;
import com.hockeyhurd.fairexchange.mod.registry.ItemRegistry;
import com.hockeyhurd.fairexchange.mod.util.Reference;
import com.hockeyhurd.hcorelib.api.block.IHBlock;
import com.hockeyhurd.hcorelib.api.handler.NotifyPlayerOnJoinHandler;
import com.hockeyhurd.hcorelib.api.handler.UpdateHandler;
import com.hockeyhurd.hcorelib.api.item.IHItem;
import com.hockeyhurd.hcorelib.api.util.interfaces.IProxy;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;

public class CommonProxy implements IProxy {

	protected UpdateHandler updateHandler;
	protected HashMap<String, String> map;
	public boolean updateFlag = false;
	protected static GuiHandler guiHandler;
	
	public CommonProxy() {
	}
	
	public void registerRenderInformation() {
	}

	@Override
	public boolean isClient() {
		return false;
	}

	public void init() {
		registerEventHandlers();
		registerBlocks();
		registerItems();
		addOreDict();
		// registerWorldgen();
		// addFuelRegister();
		// addCraftingRecipes();
		addFurnaceRecipes();
		// if (ModsLoadedHelper.te4Loaded) pulverizeRecipes();
		// if (ModsLoadedHelper.ic2Loaded) maceratorRecipes();
		registerTileEntities();
		registerGuiHandler();
		// registerRegisters();
	}

	@Override
	public void registerInputHandlers() {

	}

	@Override
	public void registerEventHandlers() {
		MinecraftForge.EVENT_BUS.register(new OreDictionaryRegisterHandler());
		FMLCommonHandler.instance().bus().register(new CraftingEventHandler());
	}

	protected void registerBlocks() {
		BlockRegistry.getInstance().init(FairExchangeMain.class);

		for (IHBlock block : BlockRegistry.getInstance().getBlockMap().values()) {
			if (block != null) {
				GameRegistry.register(block.getBlock());
				GameRegistry.register(block.getItemBlock().setRegistryName(block.getBlock().getRegistryName()));
			}
		}
	}

	protected void registerItems() {
		ItemRegistry.getInstance().init(FairExchangeMain.class);

		for (IHItem item : ItemRegistry.getInstance().getItemMap().values()) {
			if (item != null) {
				GameRegistry.register(item.getItem());
			}
		}
	}
	
	protected void addOreDict() {
		OreDictionary.registerOre("coal", Items.COAL);
		OreDictionary.registerOre("coal", new ItemStack(Items.COAL, 1, 1));
	}
	
	public void addCraftingRecipes() {
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
