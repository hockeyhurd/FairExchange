package com.hockeyhurd.fairexchange.mod.handler;

import com.hockeyhurd.hcorelib.api.handler.config.AbstractConfigHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler extends AbstractConfigHandler {

    private boolean updateCheck;
    private boolean debugMode;

    public ConfigHandler(FMLPreInitializationEvent event, String modID) {
        super(event, modID);
    }

    public void handleConfiguration() {
        this.loadConfig();

        this.updateCheck = this.getSuggestedConfig().getBoolean("update-check", "General", true, "Ability to turn off update checking.");
        this.debugMode = this.getSuggestedConfig().getBoolean("debug-mode", "General", false, "Adds additional WIP items/blocks and additional debug info.");

        this.saveConfig();
    }

    public boolean allowUpdating() {
        return this.updateCheck;
    }

    public boolean isDebugMode() {
        return debugMode;
    }
}
