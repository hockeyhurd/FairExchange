package com.hockeyhurd.fairexchange.util;

import com.hockeyhurd.api.util.AbstractReference;

public class Reference extends AbstractReference {

	/** Current build number. */
	public static final short BUILD = 3;
	
	/** Current version with included build number. */
	public static final String VERSION = "v1.1." + BUILD;
	
	/** Current mod name. */
	public static final String MOD_NAME = "FairExchange";
	
	/** Not required but is available. NOTE: if not using it, set to null! */
	public static final String MOD_URL = "http://75.68.113.97:8080/downloads/" + MOD_NAME.toLowerCase() + "/versions/FairExchange-1.1.";;
	
	/**
	 * To use this class referencing, simple extend this class with your own and plug-in your own values.
	 * NOTE: Class is mostly provided as a framework for this type of localized management.
	 */
	public Reference() {
	}

}
