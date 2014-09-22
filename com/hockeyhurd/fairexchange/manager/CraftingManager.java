package com.hockeyhurd.fairexchange.manager;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import tconstruct.library.TConstructRegistry;

import com.hockeyhurd.fairexchange.mod.FairExchangeMain;
import com.hockeyhurd.fairexchange.util.ModsLoadedHelper;

import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingManager {

	private static final ItemStack AMULET_STACK = new ItemStack(FairExchangeMain.amuletTrade, 1, OreDictionary.WILDCARD_VALUE);
	public static List<ItemStack> oreList;
	
	public CraftingManager() {
	}
	
	public static void init() {
		oreList = new ArrayList<ItemStack>();
		
		addShapedRecipe(new ShapedOreRecipe(new ItemStack(FairExchangeMain.amuletTrade, 1), new Object[] {
			"xyx", "yzy", "xyx", 'x', "gemDiamond", 'y', "gemEmerald", 'z', "ingotGold"
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.diamond, 1), new Object[] {
			"ingotGold", "ingotGold", "ingotGold", "ingotGold", AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.emerald, 1), new Object[] {
			"ingotGold", "ingotGold", "ingotGold", "ingotGold", "ingotGold", "ingotGold", "ingotGold", "ingotGold", AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.gold_ingot, 4), new Object[] {
			"gemDiamond", AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.gold_ingot, 8), new Object[] {
			"gemEmerald", AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.gold_ingot, 1), new Object[] {
			"ingotIron", "ingotIron", "ingotIron", "ingotIron", "ingotIron", "ingotIron", "ingotIron", "ingotIron", AMULET_STACK 
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.iron_ingot, 8), new Object[] {
			Items.gold_ingot, AMULET_STACK 
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.ender_pearl, 1), new Object[] {
			"ingotIron", "ingotIron", "ingotIron", "ingotIron", AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.iron_ingot, 4), new Object[] {
			Items.ender_pearl, AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.quartz, 3), new Object[] {
			"ingotIron", "ingotIron", "ingotIron", AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.iron_ingot, 3), new Object[] {
			Items.quartz, Items.quartz, Items.quartz, AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.redstone, 2), new Object[] {
			"coal", "coal", AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.coal, 2), new Object[] {
			Items.redstone, AMULET_STACK
		}));
		
		if (ModsLoadedHelper.tcLoaded) addTinkersRecipes();
		
	}
	
	private static void addShapedRecipe(ShapedOreRecipe rec) {
		GameRegistry.addRecipe(rec);
		if (!oreList.contains(rec.getRecipeOutput())) oreList.add(rec.getRecipeOutput());
	}
	
	private static void addShapelessRecipe(ShapelessOreRecipe rec) {
		GameRegistry.addRecipe(rec);
		if (!oreList.contains(rec.getRecipeOutput())) oreList.add(rec.getRecipeOutput());
	}
	
	public static void addRecipe(ItemStack stack) {
		if (oreList.contains(getByName("ingotTin")) && oreList.contains(getByName("ingotCopper"))) {
			addShapedRecipe(new ShapedOreRecipe(getByName("ingotTin"), new Object[] {
				"xx ", "xy ", 'x', "ingotCopper", AMULET_STACK
			}));
		}
	}
	
	private static final void addTinkersRecipes() {
		final ItemStack tin = getItemStackFromTC("ingotTin");
		final ItemStack copper = getItemStackFromTC("ingotCopper");
		final ItemStack aluminium = getItemStackFromTC("ingotAluminum");
		
		addShapelessRecipe(new ShapelessOreRecipe(tin, new Object[] {
				copper, copper, copper, AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(getItemStackFromTC("ingotCopper", 3), new Object[] {
			tin, AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(aluminium, new Object[] {
				tin, tin, tin, AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(getItemStackFromTC("ingotTin", 3), new Object[] {
			aluminium, AMULET_STACK
		}));
	}
	
	private static ItemStack getItemStackFromTC(String name) {
		return TConstructRegistry.getItemStack(name);
	}
	
	private static ItemStack getItemStackFromTC(String name, int size) {
		ItemStack stack = getItemStackFromTC(name);
		stack.stackSize = size > 0 ? size : 1;
		return stack;
	}
	
	private static ItemStack getByName(String name) {
		return getByName(name, 1);
	}
	
	private static ItemStack getByName(String name, int size) {
		ItemStack stack = null;
		for (ItemStack current : oreList) {
			if (current.getItem().getUnlocalizedName() != null && current.getItem().getUnlocalizedName().equals(name)) {
				stack = current;
				stack.stackSize = size;
				break;
			}
		}
		
		return stack;
	}

}
