package com.hockeyhurd.fairexchange.mod.registry;

import com.hockeyhurd.fairexchange.mod.util.Reference;
import com.hockeyhurd.hcorelib.api.client.util.ModelRegistry;
import com.hockeyhurd.hcorelib.mod.HCoreLibMain;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author hockeyhurd
 * @version 1/2/2018.
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MOD_ID)
public final class ModModelRegistry {

    @SubscribeEvent
    public static void registerAllModels(final ModelRegistryEvent event) {
        registerBlocks();
        registerItems();
    }

    private static void registerBlocks() {
        for (ModRegistry.ModBlocks modBlocks : ModRegistry.ModBlocks.values()) {
            if (!modBlocks.isDebugOnly() || (modBlocks.isDebugOnly() && HCoreLibMain.configHandler.isDebugMode()))
                ModelRegistry.registerBlock(modBlocks.getBlock());
        }
    }

    private static void registerItems() {
        for (ModRegistry.ModItems modItems : ModRegistry.ModItems.values()) {
            if (!modItems.isDebugOnly() || (modItems.isDebugOnly() && HCoreLibMain.configHandler.isDebugMode()))
                ModelRegistry.registerItem(modItems.getItem());
        }
    }

}
