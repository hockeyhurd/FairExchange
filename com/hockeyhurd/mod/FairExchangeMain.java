package com.hockeyhurd.mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.hockeyhurd.creativetab.MyCreativeTab;
import com.hockeyhurd.item.ItemAmuletTrade;
import com.hockeyhurd.math.TimeLapse;
import com.hockeyhurd.util.LogHelper;
import com.hockeyhurd.util.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_NAME, name = Reference.MOD_NAME, version = Reference.VERSION)
public class FairExchangeMain {

	@SidedProxy(clientSide = "com.hockeyhurd.mod.ClientProxy", serverSide = "com.hockeyhurd.mod.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(Reference.MOD_NAME)
	public static FairExchangeMain instance;
	
	public static LogHelper lh;
	public static final String assetDir = Reference.MOD_NAME.toLowerCase() + ":";
	public static final String modID = Reference.MOD_NAME;
	
	public static Item amuletTrade;
	
	public static CreativeTabs myCreativeTab = new MyCreativeTab(CreativeTabs.getNextID(), Reference.MOD_NAME);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		lh = new LogHelper(Reference.class);
		
		lh.info("Pre-init started, looking for config info!");
		TimeLapse tl = new TimeLapse();
		
		lh.info("Pre-init finished succesfully after", tl.getEffectiveTimeSince(), "ms!");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		lh.info("Init started");
		TimeLapse tl = new TimeLapse();
		
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
		lh.info("Post-Init started");
		TimeLapse tl = new TimeLapse();
		
		lh.info("Post-Init finished successfully after", tl.getEffectiveTimeSince(), "ms!");
	}
	
	public FairExchangeMain() {
	}

}
