package com.hockeyhurd.fairexchange.mod.registry;

import com.hockeyhurd.fairexchange.mod.FairExchangeMain;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author hockeyhurd
 * @version 1/9/2018.
 */
public final class ModOreDictionary {

    private static final ModOreDictionary inst = new ModOreDictionary();

    private final Map<String, Map<ResourceLocation, ItemStack>> oreMap;
    private final Map<String, NonNullList<ItemStack>> cacheMap;
    private boolean hasInit;

    private ModOreDictionary() {
        oreMap = new HashMap<>(0x40);
        cacheMap = new HashMap<>(0x40);
        hasInit = false;
    }

    public static ModOreDictionary getInstance() {
        return inst;
    }

    public void init() {
        if (!hasInit) {
            hasInit = true;

            for (String name : OreDictionary.getOreNames()) {
                if (name.contains("ingot") || name.contains("nugget") || name.contains("ore") || name.contains("gem") ||
                        name.contains("quartz") || name.contains("dust")) {

                    if (FairExchangeMain.configHandler.isDebugMode())
                        FairExchangeMain.logHelper.info("Registering:", name, "internally!");

                    final NonNullList<ItemStack> ores = OreDictionary.getOres(name);

                    for (ItemStack stack : ores) {
                        if (FairExchangeMain.configHandler.isDebugMode())
                            FairExchangeMain.logHelper.info("Registering variant:", stack.getUnlocalizedName());

                        add(name, stack);
                    }

                    if (FairExchangeMain.configHandler.isDebugMode())
                        FairExchangeMain.logHelper.info("Done!");
                }
            }
        }
    }

    private void add(@Nonnull final String name, @Nonnull final ItemStack stack) {
        // stack = stack.copy();
        // stack.setCount(1);

        if (oreMap.containsKey(name)) {
            final Map<ResourceLocation, ItemStack> internalMap = oreMap.get(name);
            final ResourceLocation location = stack.getItem().getRegistryName();

            // Only add if not already there!
            if (!internalMap.containsKey(stack.getItem().getRegistryName()))
                internalMap.put(location, stack);
        }

        else {
            final Map<ResourceLocation, ItemStack> internalMap = new TreeMap<>();
            internalMap.put(stack.getItem().getRegistryName(), stack);

            oreMap.put(name, internalMap);
        }
    }

    @Nullable
    public Map<ResourceLocation, ItemStack> getByName(@Nonnull final String name) {
        return oreMap.get(name);
    }

    @Nonnull
    public NonNullList<ItemStack> getOresByName(@Nonnull final String name) {
        if (cacheMap.containsKey(name))
            return cacheMap.get(name);

        final Map<ResourceLocation, ItemStack> internalMap = oreMap.get(name);

        if (internalMap == null)
            return NonNullList.withSize(1, ItemStack.EMPTY);

        final NonNullList<ItemStack> list = NonNullList.withSize(internalMap.values().size(), ItemStack.EMPTY);

        int index = 0;
        for (ItemStack stack : internalMap.values()) {
            list.set(index++, stack);
        }

        cacheMap.put(name, list);

        return list;
    }

    public String getOreName(@Nonnull final ItemStack stack) {
        final String name = stack.getItem().getRegistryName().getResourcePath();

        /*if (name.contains("ingot") || name.contains("nugget") || name.contains("ore") || name.contains("gem") ||
                name.contains("quartz") || name.contains("dust")) {*/

            for (Map.Entry<String, Map<ResourceLocation, ItemStack>> entry : oreMap.entrySet()) {
                final Map<ResourceLocation, ItemStack> internalMap = entry.getValue();

                for (ItemStack itemStack : internalMap.values()) {
                    if (stack.isItemEqualIgnoreDurability(itemStack))
                        return entry.getKey();
                }
            }
        // }

        return name;
    }

}
