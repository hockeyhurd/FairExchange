package com.hockeyhurd.fairexchange.manager;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
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
	public static String[] dyes;
	
	public CraftingManager() {
	}
	
	public static void init() {
		oreList = new ArrayList<ItemStack>();
		dyes = new String[ItemDye.field_150923_a.length];
		
		for (int i = 0; i < ItemDye.field_150923_a.length; i++) {
			dyes[i] = ItemDye.field_150923_a[i];
		}
		
		addShapedRecipe(new ShapedOreRecipe(new ItemStack(FairExchangeMain.amuletTrade, 1), new Object[] {
			" y ", "yzy", " y ", 'y', "gemEmerald", 'z', "ingotGold"
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.diamond, 1), new Object[] {
			"ingotGold", "ingotGold", "ingotGold", "ingotGold", AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.emerald, 1), new Object[] {
			"ingotGold", "ingotGold", "ingotGold", "ingotGold", "ingotGold", "ingotGold", "ingotGold", "ingotGold", AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.nether_star, 1), new Object[] {
			"gemEmerald", "gemEmerald", "gemEmerald", "gemEmerald", "gemEmerald", AMULET_STACK
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
		final ItemStack bronze = getItemStackFromTC("ingotBronze");
		final ItemStack alumite = getItemStackFromTC("ingotAlumite");
		final ItemStack cobalt = getItemStackFromTC("ingotCobalt");
		final ItemStack ardite = getItemStackFromTC("ingotArdite");
		final ItemStack manyullyn = getItemStackFromTC("ingotManyullyn");
		
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
		
		addShapelessRecipe(new ShapelessOreRecipe(getItemStackFromTC("ingotBronze", 4), new Object[] {
			copper, copper, copper, tin, AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(manyullyn, new Object[] {
				cobalt, cobalt, ardite, ardite, AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(ardite, new Object[] {
				alumite, alumite, alumite, AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(cobalt, new Object[] {
				ardite, ardite, ardite, AMULET_STACK
		}));
		
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.obsidian, 1), new Object[] {
				AMULET_STACK, "ingotIron", Blocks.redstone_block
		}));
		
		addDyes();
		
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
	
	private static void addDyes() {
		for (int i = 0; i < dyes.length; i++) {
			addShapelessRecipe(new ShapelessOreRecipe(getNextDye(i, 1), new Object[] {
				getDyeByIndex(i, 1), AMULET_STACK
			}));
		}
	}
	
	private static ItemStack getDyeByName(String name, int size) {
		ItemStack stack = null;
		for (int i = 0; i < dyes.length; i++) {
			if (dyes[i].equals(name)) {
				stack = new ItemStack(Items.dye, size, i);
				break;
			}
		}
		
		return stack;
	}
	
	private static ItemStack getDyeByIndex(int index, int size) {
		ItemStack stack = new ItemStack(Items.dye, size, index);
		return stack;
	}
	
	private static ItemStack getNextDye(int index, int size) {
		if (++index >= dyes.length) index = 0;
		ItemStack stack = getDyeByIndex(index, size);
		return stack;
	}

}
