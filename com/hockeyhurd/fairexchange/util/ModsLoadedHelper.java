package com.hockeyhurd.fairexchange.util;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import cpw.mods.fml.common.Loader;

public class ModsLoadedHelper {

	public static boolean ae2Loaded = false;
	public static boolean ic2Loaded = false;
	public static boolean te4Loaded = false;
	public static boolean tcLoaded = false;
	
	private static HashMap<String, Boolean> mapping;
	
	public ModsLoadedHelper() {
	}
	
	public static void init() {
		if (Loader.isModLoaded("appliedenergistics2")) ae2Loaded = true;
		if (Loader.isModLoaded("IC2")) ic2Loaded = true;
		if (Loader.isModLoaded("ThermalExpansion")) te4Loaded = true;
		if (Loader.isModLoaded("TConstruct")) tcLoaded = true;
		
		initMapping();
	}
	
	private static void initMapping() {
		mapping = new HashMap<String, Boolean>();
		
		mapping.put("ae2", ae2Loaded);
		mapping.put("ic2", ic2Loaded);
		mapping.put("Thermal Expansion", te4Loaded);
		mapping.put("Tinkers' Construct", tcLoaded);
	}
	
	public static final Set<Entry<String, Boolean>> getEntries() {
		return mapping.entrySet();
	}

}
