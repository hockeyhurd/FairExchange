package com.hockeyhurd.fairexchange.mod;

import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.hockeyhurd.api.math.TimeLapse;
import com.hockeyhurd.api.util.LogHelper;
import com.hockeyhurd.fairexchange.creativetab.FairExchangeCreativeTab;
import com.hockeyhurd.fairexchange.item.ItemAmuletTrade;
import com.hockeyhurd.fairexchange.util.ModsLoadedHelper;
import com.hockeyhurd.fairexchange.util.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_NAME, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "required-after:HCoreLib")
public class FairExchangeMain {

	@SidedProxy(clientSide = "com.hockeyhurd.fairexchange.mod.ClientProxy", serverSide = "com.hockeyhurd.fairexchange.mod.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(Reference.MOD_NAME)
	public static FairExchangeMain instance;
	
	public static LogHelper lh;
	public static final String assetDir = Reference.MOD_NAME.toLowerCase() + ":";
	public static final String modID = Reference.MOD_NAME;
	
	public static Item amuletTrade;
	
	public static CreativeTabs myCreativeTab = new FairExchangeCreativeTab(CreativeTabs.getNextID(), Reference.MOD_NAME);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		TimeLapse tl = new TimeLapse();
		lh = new LogHelper(Reference.class);
		
		lh.info("Pre-init started, looking for config info!");
		
		lh.info("Detecting other soft-dependent mods.");
		ModsLoadedHelper.init();
		
		Iterator iter = ModsLoadedHelper.getEntries().iterator();
		do {
			Entry<String, Boolean> current = (Entry<String, Boolean>) iter.next();
			if (current.getValue()) lh.info(current.getKey(), "detected! Wrapping into mod!");
			else lh.warn(current.getKey(), "not detected!");
		}
		while (iter.hasNext());
		
		lh.info("Pre-init finished succesfully after", tl.getEffectiveTimeSince(), "ms!");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		TimeLapse tl = new TimeLapse();
		lh.info("Init started");
		
		loadObj();
		proxy.init();
		proxy.registerRenderInformation();
		
		lh.info("Init finished successfully after", tl.getEffectiveTimeSince(), "ms!");
	}
	
	private void loadObj() {
		amuletTrade = new ItemAmuletTrade("AmuletTrade", assetDir);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		TimeLapse tl = new TimeLapse();
		lh.info("Post-Init started");
		
		proxy.registerUpdateHandler();
		if (!proxy.updateFlag) lh.warn("Found an update!");
		else lh.info("Everything is up to date!");
		
		lh.info("Post-Init finished successfully after", tl.getEffectiveTimeSince(), "ms!");
	}
	
	public FairExchangeMain() {
	}

}
