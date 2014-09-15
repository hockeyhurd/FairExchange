package com.hockeyhurd.fairexchange.manager;

import com.hockeyhurd.fairexchange.mod.FairExchangeMain;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingManager {

	private static final ItemStack AMULET_STACK = new ItemStack(FairExchangeMain.amuletTrade, 1, OreDictionary.WILDCARD_VALUE);
	
	public CraftingManager() {
	}
	
	public static void init() {
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
	}
	
	private static void addRecipe(ShapedOreRecipe rec) {
		GameRegistry.addRecipe(rec);
	}

}
