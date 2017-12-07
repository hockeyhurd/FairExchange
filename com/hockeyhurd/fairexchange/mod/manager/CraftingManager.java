package com.hockeyhurd.fairexchange.mod.manager;

import com.hockeyhurd.fairexchange.mod.FairExchangeMain;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.LinkedList;
import java.util.List;

public final class CraftingManager {

	private static final ItemStack AMULET_STACK = new ItemStack(FairExchangeMain.amuletTrade, 1, OreDictionary.WILDCARD_VALUE);
	public static final List<ItemStack> oreList = new LinkedList<ItemStack>();
	public static final String[] COLORS = new String[EnumDyeColor.values().length];

	public CraftingManager() {
	}

	public static void init() {
		addShapedRecipe(new ShapedOreRecipe(new ItemStack(FairExchangeMain.amuletTrade, 1), " y ", "yzy", " y ", 'y', "gemEmerald", 'z', "ingotGold"));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.DIAMOND, 1), "ingotGold", "ingotGold", "ingotGold", "ingotGold", AMULET_STACK));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.EMERALD, 1), "ingotGold", "ingotGold", "ingotGold", "ingotGold", "ingotGold",
				"ingotGold", "ingotGold", "ingotGold", AMULET_STACK));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.NETHER_STAR, 1), "blockEmerald", "blockEmerald", "blockEmerald", "blockEmerald",
				"blockEmerald", "blockEmerald", "blockEmerald", "blockEmerald", AMULET_STACK));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.GOLD_INGOT, 4), "gemDiamond", AMULET_STACK));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.GOLD_INGOT, 8), "gemEmerald", AMULET_STACK));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.GOLD_INGOT, 1), "ingotIron", "ingotIron", "ingotIron", "ingotIron", "ingotIron",
				"ingotIron", "ingotIron", "ingotIron", AMULET_STACK));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.IRON_INGOT, 8), Items.GOLD_INGOT, AMULET_STACK));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.ENDER_PEARL, 1), "ingotIron", "ingotIron", "ingotIron", "ingotIron",
				AMULET_STACK));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.IRON_INGOT, 4), Items.ENDER_PEARL, AMULET_STACK));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.QUARTZ, 5), "ingotIron", "ingotIron", "ingotIron", AMULET_STACK));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.IRON_INGOT, 3), Items.QUARTZ, Items.QUARTZ, Items.QUARTZ, Items.QUARTZ, Items.QUARTZ,
				AMULET_STACK));

		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.REDSTONE, 2), "coal", "coal", AMULET_STACK));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.QUARTZ, 2), Items.REDSTONE, Items.REDSTONE, AMULET_STACK));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.OBSIDIAN, 1), AMULET_STACK, "ingotIron", Blocks.REDSTONE_BLOCK));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.BLAZE_ROD, 1), AMULET_STACK, Items.BLAZE_POWDER, Items.BLAZE_POWDER, Items.BLAZE_POWDER, Items.BLAZE_POWDER, Items.BLAZE_POWDER));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.GRASS, 1), AMULET_STACK, Blocks.COBBLESTONE));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.IRON_INGOT, 1), AMULET_STACK, Blocks.OBSIDIAN, Blocks.OBSIDIAN, Blocks.OBSIDIAN, Blocks.OBSIDIAN));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.GRAVEL, 1), AMULET_STACK, Blocks.DIRT, Blocks.DIRT, Blocks.DIRT, Blocks.DIRT));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.DIRT, 4), AMULET_STACK, Blocks.GRAVEL));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.DIRT, 1), AMULET_STACK, Blocks.SAND));
		addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.COBBLESTONE, 1), AMULET_STACK, Blocks.DIRT));


		ModdedManager.initModdedEntries();

		// Add COLORS last, as they are the most spammy.

		int i = 0;
		for (EnumDyeColor color : EnumDyeColor.values())
			COLORS[i++] = color.getName();

		addDyesAndWools();
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

	private static void addDyesAndWools() {
		for (int i = 0; i < COLORS.length; i++) {
			addShapelessRecipe(new ShapelessOreRecipe(getNextDye(i, 1), getDyeByIndex(i, 1), AMULET_STACK));
			addShapelessRecipe(new ShapelessOreRecipe(getNextWool(i, 1), getWoolByIndex(i, 1), AMULET_STACK));
		}
	}

	private static ItemStack getDyeByName(String name, int size) {
		ItemStack stack = null;
		for (int i = 0; i < COLORS.length; i++) {
			if (COLORS[i].equals(name)) {
				stack = new ItemStack(Items.DYE, size, i);
				break;
			}
		}

		return stack;
	}

	private static ItemStack getDyeByIndex(int index, int size) {
		return new ItemStack(Items.DYE, size, index);
	}

	private static ItemStack getNextDye(int index, int size) {
		// if (++index >= COLORS.length) index = 0;
		index++;
		index %= COLORS.length;
		return getDyeByIndex(index, size);
	}

	private static ItemStack getWoolByIndex(int index, int size) {
		return new ItemStack(Blocks.WOOL, size, index);
	}

	private static ItemStack getNextWool(int index, int size) {
		index++;
		index %= COLORS.length;
		return getWoolByIndex(index, size);
	}

	private static class ModdedManager {
		private ModdedManager() {}

		static void initModdedEntries() {

			final ItemStack tinIngot = !OreDictionary.getOres("ingotTin").isEmpty() ?
					OreDictionary.getOres("ingotTin").get(0).copy() : null;

			final ItemStack copperIngot = !OreDictionary.getOres("ingotCopper").isEmpty() ?
					OreDictionary.getOres("ingotCopper").get(0).copy() : null;

			final ItemStack bronzeIngot = !OreDictionary.getOres("ingotBronze").isEmpty() ?
					OreDictionary.getOres("ingotBronze").get(0).copy() : null;

			final ItemStack aluminiumIngot = !OreDictionary.getOres("aluminiumIngot").isEmpty() ?
					OreDictionary.getOres("aluminiumIngot").get(0).copy() : null;

			final ItemStack alumiteIngot = !OreDictionary.getOres("alumiteIngot").isEmpty() ?
					OreDictionary.getOres("alumiteIngot").get(0).copy() : null;

			final ItemStack cobaltIngot = !OreDictionary.getOres("cobaltIngot").isEmpty() ?
					OreDictionary.getOres("cobaltIngot").get(0).copy() : null;

			final ItemStack arditeIngot = !OreDictionary.getOres("arditeIngot").isEmpty() ?
					OreDictionary.getOres("arditeIngot").get(0).copy() : null;

			final ItemStack manyullynIngot = !OreDictionary.getOres("manyullynIngot").isEmpty() ?
					OreDictionary.getOres("manyullynIngot").get(0).copy() : null;

			final ItemStack certusQuartz = !OreDictionary.getOres("crystalCertusQuartz").isEmpty() ?
					OreDictionary.getOres("crystalCertusQuartz").get(0).copy() : null;

			if (tinIngot != null) {
				tinIngot.stackSize = 1;
				addShapelessRecipe(new ShapelessOreRecipe(tinIngot, "ingotCopper", "ingotCopper", "ingotCopper", AMULET_STACK));

				tinIngot.stackSize = 3;
				addShapelessRecipe(new ShapelessOreRecipe(tinIngot, "aluminiumIngot", AMULET_STACK));
			}

			if (copperIngot != null) {
				copperIngot.stackSize = 3;

				addShapelessRecipe(new ShapelessOreRecipe(copperIngot, "ingotTin", AMULET_STACK));
			}


			if (bronzeIngot != null) {
				bronzeIngot.stackSize = 4;

				addShapelessRecipe(new ShapelessOreRecipe(bronzeIngot, "ingotCopper", "ingotCopper", "ingotCopper", "ingotTin", AMULET_STACK));
			}

			if (aluminiumIngot != null) {
				aluminiumIngot.stackSize = 1;
				addShapelessRecipe(new ShapelessOreRecipe(aluminiumIngot, "ingotTin", "ingotTin", "ingotTin", AMULET_STACK));
			}

			if (manyullynIngot != null) {
				manyullynIngot.stackSize = 1;
				addShapelessRecipe(new ShapelessOreRecipe(manyullynIngot, "cobaltIngot", "cobaltIngot", "arditeIngot", "arditeIngot", AMULET_STACK));
			}

			if (arditeIngot != null) {
				arditeIngot.stackSize = 1;
				addShapelessRecipe(new ShapelessOreRecipe(arditeIngot, "alumiteIngot", "alumiteIngot", "alumiteIngot", AMULET_STACK));

				arditeIngot.stackSize = 3;
				addShapelessRecipe(new ShapelessOreRecipe(arditeIngot, "cobaltIngot", AMULET_STACK));
			}

			if (cobaltIngot != null) {
				cobaltIngot.stackSize = 1;
				addShapelessRecipe(new ShapelessOreRecipe(cobaltIngot, "arditeIngot", "arditeIngot", "arditeIngot", AMULET_STACK));
			}

			if (alumiteIngot != null) {
				alumiteIngot.stackSize = 3;
				addShapelessRecipe(new ShapelessOreRecipe(alumiteIngot, "arditeIngot", AMULET_STACK));
			}

			if (certusQuartz != null) {
				certusQuartz.stackSize = 5;
				addShapelessRecipe(new ShapelessOreRecipe(certusQuartz, "ingotIron", "ingotIron", "ingotIron", "ingotIron", "ingotIron", "ingotIron", AMULET_STACK));
			}
		}
	}

}
