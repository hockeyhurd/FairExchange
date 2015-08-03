package com.hockeyhurd.fairexchange.manager;

import ic2.api.item.IC2Items;

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

		addShapedRecipe(new ShapedOreRecipe(new ItemStack(FairExchangeMain.amuletTrade, 1), " y ", "yzy", " y ", 'y', "gemEmerald", 'z', "ingotGold"));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.diamond, 1), "ingotGold", "ingotGold", "ingotGold", "ingotGold", AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.emerald, 1), "ingotGold", "ingotGold", "ingotGold", "ingotGold", "ingotGold",
				"ingotGold", "ingotGold", "ingotGold", AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.nether_star, 1), "blockEmerald", "blockEmerald", "blockEmerald", "blockEmerald",
				"blockEmerald", "blockEmerald", "blockEmerald", "blockEmerald", AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.gold_ingot, 4), "gemDiamond", AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.gold_ingot, 8), "gemEmerald", AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.gold_ingot, 1), "ingotIron", "ingotIron", "ingotIron", "ingotIron", "ingotIron",
				"ingotIron", "ingotIron", "ingotIron", AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.iron_ingot, 8), Items.gold_ingot, AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.ender_pearl, 1), "ingotIron", "ingotIron", "ingotIron", "ingotIron",
				AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.iron_ingot, 4), Items.ender_pearl, AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.quartz, 5), "ingotIron", "ingotIron", "ingotIron", AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.iron_ingot, 3), Items.quartz, Items.quartz, Items.quartz, Items.quartz, Items.quartz,
				AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.redstone, 2), "coal", "coal", AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.coal, 2), Items.redstone, Items.redstone, AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.obsidian, 1), AMULET_STACK, "ingotIron", Blocks.redstone_block));


		if (ModsLoadedHelper.tcLoaded) TiCRecipeIntegration.ticInit();
		if (ModsLoadedHelper.ic2Loaded) IC2RecipeIntegration.ic2Init();

		// Add dyes last, as they are the most spammy.
		addDyes();
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
			addShapedRecipe(new ShapedOreRecipe(getByName("ingotTin"), "xx ", "xy ", 'x', "ingotCopper", AMULET_STACK));
		}
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
			addShapelessRecipe(new ShapelessOreRecipe(getNextDye(i, 1), getDyeByIndex(i, 1), AMULET_STACK));
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

	/*private static class AERecipeIntegration {
		private static final ItemStack quartzCrystal = null;
		
		private AERecipeIntegration() {
		}
	}*/
	
	private static class IC2RecipeIntegration {
		private IC2RecipeIntegration() {
		}

		private static ItemStack getItemStackFromIC2(String name) {
			return IC2Items.getItem(name);
		}

		private static ItemStack getItemStackFromIC2(String name, int size) {
			ItemStack stack = getItemStackFromIC2(name);
			stack.stackSize = size > 0 ? size : 1;
			return stack;
		}

		private static final void addIC2Recipes() {
			final ItemStack tin = getItemStackFromIC2("tinIngot");
			final ItemStack copper = getItemStackFromIC2("copperIngot");
			final ItemStack bronze = getItemStackFromIC2("bronzeIngot");

			addShapelessRecipe(new ShapelessOreRecipe(tin, copper, copper, copper, AMULET_STACK));

			addShapelessRecipe(new ShapelessOreRecipe(getItemStackFromIC2("copperIngot", 3), tin, AMULET_STACK));

			addShapelessRecipe(new ShapelessOreRecipe(getItemStackFromIC2("bronzeIngot", 4), copper, copper, copper, tin, AMULET_STACK));
		}

		static final void ic2Init() {
			addIC2Recipes();
		}
	}

	private static class TiCRecipeIntegration {
		private TiCRecipeIntegration() {
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

			addShapelessRecipe(new ShapelessOreRecipe(tin, copper, copper, copper, AMULET_STACK));

			addShapelessRecipe(new ShapelessOreRecipe(getItemStackFromTC("ingotCopper", 3), tin, AMULET_STACK));

			addShapelessRecipe(new ShapelessOreRecipe(aluminium, tin, tin, tin, AMULET_STACK));

			addShapelessRecipe(new ShapelessOreRecipe(getItemStackFromTC("ingotTin", 3), aluminium, AMULET_STACK));

			addShapelessRecipe(new ShapelessOreRecipe(getItemStackFromTC("ingotBronze", 4), copper, copper, copper, tin, AMULET_STACK));

			addShapelessRecipe(new ShapelessOreRecipe(manyullyn, cobalt, cobalt, ardite, ardite, AMULET_STACK));

			addShapelessRecipe(new ShapelessOreRecipe(ardite, alumite, alumite, alumite, AMULET_STACK));

			addShapelessRecipe(new ShapelessOreRecipe(cobalt, ardite, ardite, ardite, AMULET_STACK));
		}

		private static ItemStack getItemStackFromTC(String name) {
			return TConstructRegistry.getItemStack(name);
		}

		private static ItemStack getItemStackFromTC(String name, int size) {
			ItemStack stack = getItemStackFromTC(name);
			stack.stackSize = size > 0 ? size : 1;
			return stack;
		}

		static final void ticInit() {
			addTinkersRecipes();
		}
	}

}
