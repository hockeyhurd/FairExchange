package com.hockeyhurd.fairexchange.mod;

import com.hockeyhurd.fairexchange.mod.block.BlockUnifier;
import com.hockeyhurd.fairexchange.mod.creativetab.FairExchangeCreativeTab;
import com.hockeyhurd.fairexchange.mod.handler.ConfigHandler;
import com.hockeyhurd.fairexchange.mod.item.ItemAmuletTrade;
import com.hockeyhurd.fairexchange.mod.util.FairExchangeMetadata;
import com.hockeyhurd.fairexchange.mod.util.Reference;
import com.hockeyhurd.hcorelib.api.creativetab.AbstractCreativeTab;
import com.hockeyhurd.hcorelib.api.math.TimeLapse;
import com.hockeyhurd.hcorelib.api.util.LogHelper;
import com.hockeyhurd.hcorelib.api.util.interfaces.IForgeMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_NAME, acceptedMinecraftVersions = Reference.MINECRAFT_VERSION, name = Reference.MOD_NAME,
		version = Reference.VERSION, dependencies = "required-after:HCoreLib"/*, guiFactory = "com.hockeyhurd.mod.gui.config.PZGuiFactory"*/)
public class FairExchangeMain implements IForgeMod {

	@SidedProxy(clientSide = "com.hockeyhurd.fairexchange.mod.ClientProxy", serverSide = "com.hockeyhurd.fairexchange.mod.CommonProxy")
	public static CommonProxy proxy;
	
	@Mod.Instance(Reference.MOD_NAME)
	public static FairExchangeMain instance;
	
	public static LogHelper logHelper;
	public static final String assetDir = Reference.MOD_NAME.toLowerCase(); // + ":";
	public static final String modID = Reference.MOD_NAME;
	
	public static Item amuletTrade;

	public static Block unifier;
	
	public static ConfigHandler configHandler;
	public static final AbstractCreativeTab myCreativeTab = new FairExchangeCreativeTab(CreativeTabs.getNextID(), Reference.MOD_NAME);
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		TimeLapse tl = new TimeLapse();
		logHelper = new LogHelper(modID);

		final Side side = FMLCommonHandler.instance().getEffectiveSide();

		if (side == Side.CLIENT) {
			logHelper.info("Injecting mcmod.info information");

			final FairExchangeMetadata metadata = new FairExchangeMetadata(event);

			if (metadata.getResult()) logHelper.info("Injection was successful!");
			else logHelper.warn("Injection was un-successful! mcmod.info is a liar!");
		}
		
		logHelper.info("Pre-init started, looking for config info!");
		configHandler = new ConfigHandler(event, modID);
		configHandler.handleConfiguration();
		logHelper.info("Config loaded successfully! Patching mod now!");
		
		// logHelper.info("Detecting other soft-dependent mods.");

		loadObj();
		proxy.init();

		logHelper.info("Pre-init finished successfully after", tl.getEffectiveTimeSince(), "ms!");
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		TimeLapse tl = new TimeLapse();
		logHelper.info("Init started");
		
		proxy.registerRenderInformation();
		
		logHelper.info("Init finished successfully after", tl.getEffectiveTimeSince(), "ms!");
	}
	
	private void loadObj() {
		amuletTrade = new ItemAmuletTrade("amuletTrade", assetDir);

		unifier = new BlockUnifier(Material.ROCK, "unifier");
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		TimeLapse tl = new TimeLapse();
		logHelper.info("Post-Init started");
		
		if (configHandler.allowUpdating()) {
			proxy.registerUpdateHandler();
			if (!proxy.updateFlag) logHelper.warn("Found an update!");
			else logHelper.info("Everything is up to date!");
		}
		else logHelper.warn("Skipping checking for updates. WARNING: bugs may exist!");
		
		logHelper.info("Post-Init finished successfully after", tl.getEffectiveTimeSince(), "ms!");
	}

	@Override
	public void serverStartingEvent(FMLServerStartingEvent event) {
	}

	@Override
	public void serverStartedEvent(FMLServerStartedEvent event) {
	}

	public FairExchangeMain() {
	}

}
