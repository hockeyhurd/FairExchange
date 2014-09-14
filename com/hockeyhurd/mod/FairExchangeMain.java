package com.hockeyhurd.mod;

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
	
	public static final String assetDir = Reference.MOD_NAME.toLowerCase() + ":";
	public static final String modID = Reference.MOD_NAME;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LogHelper.info("Pre-init started, looking for config info!");
		TimeLapse tl = new TimeLapse();
		
		LogHelper.info("Pre-init finished succesfully after", tl.getEffectiveTimeSince(), "ms!");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		LogHelper.info("Init started");
		TimeLapse tl = new TimeLapse();
		
		LogHelper.info("Init finished successfully after", tl.getEffectiveTimeSince(), "ms!");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LogHelper.info("Post-Init started");
		TimeLapse tl = new TimeLapse();
		
		LogHelper.info("Post-Init finished successfully after", tl.getEffectiveTimeSince(), "ms!");
	}
	
	public FairExchangeMain() {
	}

}
