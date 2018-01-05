package com.hockeyhurd.fairexchange.mod;

import com.hockeyhurd.fairexchange.mod.container.TileUnifier;
import com.hockeyhurd.fairexchange.mod.handler.GuiHandler;
import com.hockeyhurd.fairexchange.mod.manager.CraftingManager;
import com.hockeyhurd.fairexchange.mod.registry.ModRegistry;
import com.hockeyhurd.fairexchange.mod.util.Reference;
import com.hockeyhurd.hcorelib.api.handler.NotifyPlayerOnJoinHandler;
import com.hockeyhurd.hcorelib.api.handler.RecipeGen;
import com.hockeyhurd.hcorelib.api.handler.RecipePattern;
import com.hockeyhurd.hcorelib.api.handler.UpdateHandler;
import com.hockeyhurd.hcorelib.api.util.interfaces.ICraftableRecipe;
import com.hockeyhurd.hcorelib.api.util.interfaces.IProxy;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;

public class CommonProxy implements IProxy {

    protected UpdateHandler updateHandler;
    protected HashMap<String, String> map;
    public boolean updateFlag = false;
    protected static GuiHandler guiHandler;
    protected RecipeGen recipeGen;

    public CommonProxy() {
        recipeGen = new RecipeGen(Reference.MOD_ID);
    }

    public void registerRenderInformation() {
    }

    @Override
    public boolean isClient() {
        return false;
    }

    @Override
    public void preInit() {
        // registerBlocks(); // un-comment to regen crafting recipes to recipe output folder.
        // registerItems();  // un-comment to regen crafting recipes to recipe output folder.
        registerTileEntities();
    }

    @Override
    public void init() {
        registerGuiHandler();
        registerEventHandlers();
        addOreDict();
        addFurnaceRecipes();
        registerRenderInformation();

        if (false)
            addCraftingRecipes();
    }

    @Override
    public void postInit() {
        registerUpdateHandler();
    }

    @Override
    public void registerInputHandlers() {

    }

    @Override
    public void registerEventHandlers() {
        // MinecraftForge.EVENT_BUS.register(new OreDictionaryRegisterHandler());
        // FMLCommonHandler.instance().bus().register(new CraftingEventHandler());
    }

    protected void registerBlocks() {
    }

    protected void registerItems() {
        for (RecipePattern pattern : ((ICraftableRecipe) ModRegistry.ModItems.amuletTrade.getItem()).getRecipePatterns()) {
            if (pattern != null)
                pattern.registerRecipe(recipeGen);
        }
    }

    protected void addOreDict() {
        OreDictionary.registerOre("coal", Items.COAL);
        OreDictionary.registerOre("coal", new ItemStack(Items.COAL, 1, 1));
    }

    public void addCraftingRecipes() {
        CraftingManager.init();
        CraftingManager.generateRecipes(recipeGen);
    }

    protected void addFurnaceRecipes() {
    }

    protected void registerTileEntities() {
        GameRegistry.registerTileEntity(TileUnifier.class, TileUnifier.class.getSimpleName());
    }

    protected void registerGuiHandler() {
        if (guiHandler != null)
            NetworkRegistry.INSTANCE.registerGuiHandler(FairExchangeMain.instance, guiHandler);
        else {
            guiHandler = new GuiHandler();
            NetworkRegistry.INSTANCE.registerGuiHandler(FairExchangeMain.instance, guiHandler);
        }
    }

    @Override
    public void registerUpdateHandler() {
        updateHandler = new UpdateHandler(Reference.MOD_NAME, Reference.VERSION, Reference.MOD_URL, Reference.CHANGELOG_URL);

        if (FairExchangeMain.configHandler.allowUpdating()) {
            FairExchangeMain.logHelper.info("Checking for updates!");

            updateHandler.check();
            map = updateHandler.getMap();
            updateFlag = updateHandler.getUpToDate();

            if (!updateFlag)
                FairExchangeMain.logHelper.warn("Found an update!");
            else
                FairExchangeMain.logHelper.info("Everything is UP to date!");
        }

        else
            FairExchangeMain.logHelper.warn("Skipping checking for updates. WARNING: bugs may exist!");

        MinecraftForge.EVENT_BUS.register(new NotifyPlayerOnJoinHandler(updateHandler, map, Reference.MOD_NAME, updateFlag, true,
                FairExchangeMain.configHandler.allowUpdating()));
    }

}
