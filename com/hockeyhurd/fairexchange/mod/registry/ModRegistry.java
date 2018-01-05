package com.hockeyhurd.fairexchange.mod.registry;

import com.hockeyhurd.fairexchange.mod.FairExchangeMain;
import com.hockeyhurd.fairexchange.mod.block.BlockUnifier;
import com.hockeyhurd.fairexchange.mod.item.ItemAmuletTrade;
import com.hockeyhurd.fairexchange.mod.util.Reference;
import com.hockeyhurd.hcorelib.api.block.IHBlock;
import com.hockeyhurd.hcorelib.api.item.IHItem;
import com.hockeyhurd.hcorelib.api.util.StringUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * @author hockeyhurd
 * @version 1/2/2018.
 */
public final class ModRegistry {

    private ModRegistry() {
    }

    public enum ModBlocks {
        unifier(new BlockUnifier(Material.ROCK, "unifier"), false, true);

        private IHBlock block;
        private boolean isTE;
        private boolean debugOnly;

        ModBlocks(IHBlock block, boolean isTE, boolean debugOnly) {
            this.block = block;
            this.isTE = isTE;
            this.debugOnly = debugOnly;
        }

        public IHBlock getBlock() {
            return block;
        }

        public boolean isTE() {
            return isTE;
        }

        public boolean isDebugOnly() {
            return debugOnly;
        }

        public static Block getBlockByName(String name) {
            if (!StringUtils.nullCheckString(name)) {
                FairExchangeMain.logHelper.warn("Invalid input", name, "Was this an error??");
                return null;
            }

            for (ModBlocks blocks : values()) {
                if (blocks.getBlock().getName().equals(name))
                    return blocks.getBlock().getBlock();
            }

            return null;
        }

        public static void registerBlocks(final IForgeRegistry<Block> registry) {
            for (ModBlocks modBlock : values()) {

                if (!modBlock.isDebugOnly() || (modBlock.isDebugOnly() && FairExchangeMain.configHandler.isDebugMode()))
                    registry.register(modBlock.getBlock().getBlock());
            }
        }

        public static void registerItemBlocks(final IForgeRegistry<Item> registry) {
            for (ModBlocks modBlock : values()) {
                // final Block block = modBlock.getBlock().getBlock();
                if (!modBlock.isDebugOnly() || (modBlock.isDebugOnly() && FairExchangeMain.configHandler.isDebugMode())) {
                    final ResourceLocation registryName = modBlock.getBlock().getResourceLocation();

                    registry.register(modBlock.getBlock().getItemBlock().setRegistryName(registryName));
                }
            }
        }
    }

    public enum ModItems {
        amuletTrade(new ItemAmuletTrade("amuletTrade", FairExchangeMain.assetDir), false);

        private IHItem item;
        private boolean debugOnly;

        ModItems(IHItem item, boolean debugOnly) {
            this.item = item;
            this.debugOnly = debugOnly;
        }

        public IHItem getItem() {
            return item;
        }

        public boolean isDebugOnly() {
            return debugOnly;
        }

        public static Item getItemByName(String name) {
            if (!StringUtils.nullCheckString(name)) {
                FairExchangeMain.logHelper.warn("Invalid input", name, "Was this an error??");
                return null;
            }

            for (ModItems items : values()) {
                if (items.getItem().getName().equals(name))
                    return items.getItem().getItem();
            }

            return null;
        }

        public static void register(final IForgeRegistry<Item> registry) {
            for (ModItems modItems : values()) {
                if (!modItems.isDebugOnly() || (modItems.isDebugOnly() && FairExchangeMain.configHandler.isDebugMode()))
                    registry.register(modItems.getItem().getItem());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = Reference.MOD_ID)
    public static class RegistrationHandler {

        private RegistrationHandler() {
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            ModBlocks.registerBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            ModBlocks.registerItemBlocks(event.getRegistry());
            ModItems.register(event.getRegistry());
        }
    }
}
