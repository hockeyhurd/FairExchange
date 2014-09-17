package com.hockeyhurd.fairexchange.manager;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.hockeyhurd.api.util.OreDictParser;
import com.hockeyhurd.fairexchange.mod.FairExchangeMain;

import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingManager {

	private static final ItemStack AMULET_STACK = new ItemStack(FairExchangeMain.amuletTrade, 1, OreDictionary.WILDCARD_VALUE);
	public static List<ItemStack> oreList;
	
	public CraftingManager() {
	}
	
	public static void init() {
		oreList = new ArrayList<ItemStack>();
		
		addRecipe(new ShapedOreRecipe(new ItemStack(FairExchangeMain.amuletTrade, 1), new Object[] {
			"xyx", "yzy", "xyx", 'x', "gemDiamond", 'y', "gemEmerald", 'z', "ingotGold"
		}));
		
		addRecipe(new ShapedOreRecipe(new ItemStack(Items.diamond, 1), new Object[] {
			"xx ", "xx ", "y  ", 'x', "ingotGold", 'y', AMULET_STACK
		}));
		
		addRecipe(new ShapedOreRecipe(new ItemStack(Items.emerald, 1), new Object[] {
			"xxx", "xxx", "yxx", 'x', "ingotGold", 'y', AMULET_STACK
		}));
		
		addRecipe(new ShapedOreRecipe(new ItemStack(Items.gold_ingot, 4), new Object[] {
			"xy", 'x', "gemDiamond", 'y', AMULET_STACK
		}));
		
		addRecipe(new ShapedOreRecipe(new ItemStack(Items.gold_ingot, 8), new Object[] {
			"xy", 'x', "gemEmerald", 'y', AMULET_STACK
		}));
		
		addRecipe(new ShapedOreRecipe(new ItemStack(Items.gold_ingot, 1), new Object[] {
			"xxx", "xxx", "yxx", 'x', "ingotIron", 'y', AMULET_STACK 
		}));
		
		addRecipe(new ShapedOreRecipe(new ItemStack(Items.redstone, 2), new Object[] {
			"yx ", "x  ", 'x', "coal", 'y', AMULET_STACK
		}));
		
		addRecipe(new ShapedOreRecipe(new ItemStack(Items.coal, 2), new Object[] {
			"yx", 'x', Items.redstone, 'y', AMULET_STACK
		}));
		
	}
	
	private static void addRecipe(ShapedOreRecipe rec) {
		GameRegistry.addRecipe(rec);
		if (!oreList.contains(rec.getRecipeOutput())) oreList.add(rec.getRecipeOutput());
	}
	
	public static void addRecipe() {
		if (oreList.contains(OreDictParser.getFromDict("ingotTin")) && oreList.contains(OreDictParser.getFromDict("ingotCopper"))) {
			addRecipe(new ShapedOreRecipe(OreDictParser.getFromDict("ingotTin"), new Object[] {
				"xx ", "xy ", 'x', "ingotCopper", AMULET_STACK
			}));
		}
	}

}
