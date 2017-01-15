package com.hockeyhurd.fairexchange.mod.util;

import com.hockeyhurd.hcorelib.api.util.AbstractReference;

public class Reference extends AbstractReference {

	/** Current build number. */
	public static final short BUILD = 1;

	/** Current Subversion */
	public static final int SUB_VERSION = 2;

	/** Current major version. */
	public static final int MAJOR_VERSION = 1;

	/** Current version with included build number. */
	public static final String VERSION = "v" + MAJOR_VERSION + '.' + SUB_VERSION + '.' + BUILD;
	
	/** Current mod name. */
	public static final String MOD_NAME = "FairExchange";

	/** Current Minecraft version. */
	public static final String MINECRAFT_VERSION = "[1.10.2]";
	
	/** Not required but is available. NOTE: if not using it, set to null! */
	// public static final String MOD_URL = "http://75.68.113.97:8080/downloads/" + MOD_NAME.toLowerCase() + "/versions/FairExchange-1.1.";
	public static final String MOD_URL = "https://dl.dropboxusercontent.com/u/276611945/Minecraft/mods/" + MOD_NAME.toLowerCase() + "/versions/FairExchange-1.2.";

	/** Not required but is available. NOTE: if not using it, set to null! */
	public static final String CHANGELOG_URL = "https://dl.dropboxusercontent.com/u/276611945/minecraft/mods/" + MOD_NAME.toLowerCase() + "/changelog.txt";
	
	/**
	 * To use this class referencing, simple extend this class with your own and plug-in your own values.
	 * NOTE: Class is mostly provided as a framework for this type of localized management.
	 */
	public Reference() {
	}

}
