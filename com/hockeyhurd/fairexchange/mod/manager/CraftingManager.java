package com.hockeyhurd.fairexchange.mod.manager;

import com.hockeyhurd.fairexchange.mod.item.ItemAmuletTrade;
import com.hockeyhurd.fairexchange.mod.registry.ModRegistry;
import com.hockeyhurd.hcorelib.api.handler.RecipeGen;
import com.hockeyhurd.hcorelib.api.handler.RecipePattern;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class CraftingManager {

    private static final ItemAmuletTrade AMULET = (ItemAmuletTrade) ModRegistry.ModItems.amuletTrade.getItem().getItem();
    public static final Set<ItemStack> oreList = new TreeSet<ItemStack>();
    private static final ItemStack AMULET_STACK = new ItemStack(AMULET, 1, OreDictionary.WILDCARD_VALUE);
    public static final String[] COLORS = new String[EnumDyeColor.values().length];

    private static final List<RecipePattern> recipes = new ArrayList<>(0x40);

    private CraftingManager() {
    }

    public static void init() {
        addRecipe(new RecipePattern("gg ", "gg ", "a  ", true).addAssociation('g', "ingotGold").addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.DIAMOND, 1)));

        addRecipe(new RecipePattern("ggg", "ggg", "agg", true).addAssociation('g', "ingotGold").addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.EMERALD, 1)));

        addRecipe(new RecipePattern("eee", "eee", "aee", true).addAssociation('e', "blockEmerald").addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.NETHER_STAR, 1)));

        addRecipe(new RecipePattern("da", "", "", false).addAssociation('d', "gemDiamond").addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.GOLD_INGOT, 4)));

        addRecipe(new RecipePattern("ea", "", "", false).addAssociation('e', "gemEmerald").addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.GOLD_INGOT, 8)));

        addRecipe(new RecipePattern("iii", "iii", "aii", true).addAssociation('i', "ingotIron").addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.GOLD_INGOT, 1)));

        addRecipe(new RecipePattern("ga", "", "", false).addAssociation('g', "ingotGold").addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.IRON_INGOT, 8)));

        addRecipe(new RecipePattern("ea", "", "", false).addAssociation('e', Items.ENDER_PEARL).addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.IRON_INGOT, 4)));

        addRecipe(new RecipePattern("qqq", "qqa", "   ", true).addAssociation('q', "gemQuartz").addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.IRON_INGOT, 3)));

        addRecipe(new RecipePattern("iii", "ia ", "   ", true).addAssociation('i', "ingotIron").addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.ENDER_PEARL, 1)));

        addRecipe(new RecipePattern("ii ", "ia ", "   ", true).addAssociation('i', "ingotIron").addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.QUARTZ, 5)));

        addRecipe(new RecipePattern("cca", "", "", true).addAssociation('c', Items.COAL).addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.REDSTONE, 2)));

        addRecipe(new RecipePattern("rra", "", "", true).addAssociation('r', "dustRedstone").addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.QUARTZ, 2)));

        addRecipe(new RecipePattern("ira", "", "", true).addAssociation('i', "ingotIron").addAssociation('r', "blockRedstone").addAssociation('a',
                AMULET).setResultStack(new ItemStack(Blocks.OBSIDIAN, 1)));

        addRecipe(new RecipePattern("ppp", "ppa", "", true).addAssociation('p', Items.BLAZE_POWDER).addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.BLAZE_ROD, 1)));

        // Here
        addRecipe(new RecipePattern("ca", "", "", true).addAssociation('c', Blocks.COBBLESTONE).addAssociation('a', AMULET).setResultStack(
                new ItemStack(Blocks.GRASS, 1)));

        addRecipe(new RecipePattern("oo ", "ooa", "", true).addAssociation('o', Blocks.OBSIDIAN).addAssociation('a', AMULET).setResultStack(
                new ItemStack(Items.IRON_INGOT, 1)));

        addRecipe(new RecipePattern("ddd", "da ", "", true).addAssociation('d', Blocks.DIRT).addAssociation('a', AMULET).setResultStack(
                new ItemStack(Blocks.GRAVEL, 1)));

        addRecipe(new RecipePattern("ga", "", "", true).addAssociation('g', Blocks.GRAVEL).addAssociation('a', AMULET).setResultStack(
                new ItemStack(Blocks.DIRT, 4)));

        addRecipe(new RecipePattern("sa", "", "", true).addAssociation('s', Blocks.SAND).addAssociation('a', AMULET).setResultStack(
                new ItemStack(Blocks.DIRT, 1)));

        addRecipe(new RecipePattern("da", "", "", true).addAssociation('d', Blocks.DIRT).addAssociation('a', AMULET).setResultStack(
                new ItemStack(Blocks.COBBLESTONE, 1)));

        /*
        addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.GRASS, 1), AMULET_STACK, Blocks.COBBLESTONE));
        addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Items.IRON_INGOT, 1), AMULET_STACK, Blocks.OBSIDIAN, Blocks.OBSIDIAN, Blocks.OBSIDIAN,
                Blocks.OBSIDIAN));
        addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.GRAVEL, 1), AMULET_STACK, Blocks.DIRT, Blocks.DIRT, Blocks.DIRT, Blocks.DIRT));
        addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.DIRT, 4), AMULET_STACK, Blocks.GRAVEL));
        addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.DIRT, 1), AMULET_STACK, Blocks.SAND));
        addShapelessRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.COBBLESTONE, 1), AMULET_STACK, Blocks.DIRT));*/

        ModdedManager.initModdedEntries();

        // Add COLORS last, as they are the most spammy.

        int i = 0;
        for (EnumDyeColor color : EnumDyeColor.values())
            COLORS[i++] = color.getName();

        // addDyesAndWools();
    }

    public static void generateRecipes(@Nonnull RecipeGen recipeGen) {
        for (RecipePattern pattern : recipes) {
            if (pattern.isShapedRecipe())
                recipeGen.addShapedRecipe(pattern);
            else
                recipeGen.addShapelessRecipe(pattern);
        }
    }

    private static void addRecipe(@Nonnull RecipePattern pattern) {
        recipes.add(pattern);
    }

    private static ItemStack getByName(String name) {
        return getByName(name, 1);
    }

    private static ItemStack getByName(String name, int size) {
        ItemStack stack = null;
        for (ItemStack current : oreList) {
            if (current.getItem().getUnlocalizedName().equals(name)) {
                stack = current;
                stack.setCount(size);
                break;
            }
        }

        return stack;
    }

    private static void addDyesAndWools() {
        for (int i = 0; i < COLORS.length; i++) {
            // addShapelessRecipe(new ShapelessOreRecipe(getNextDye(i, 1), getDyeByIndex(i, 1), AMULET_STACK));
            // addShapelessRecipe(new ShapelessOreRecipe(getNextWool(i, 1), getWoolByIndex(i, 1), AMULET_STACK));
            addRecipe(new RecipePattern("da", "", "", false).addAssociation('d', getDyeByIndex(i, 1).getItem()).addAssociation('a',
                    AMULET).setResultStack(getNextDye(i, 1)));

            addRecipe(new RecipePattern("wa", "", "", false).addAssociation('w', getWoolByIndex(i, 1).getItem()).addAssociation('a',
                    AMULET).setResultStack(getNextWool(i, 1)));
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
        private ModdedManager() {
        }

        static void initModdedEntries() {

            /*final ItemStack tinIngot = !OreDictionary.getOres("ingotTin").isEmpty() ? OreDictionary.getOres("ingotTin").get(0).copy() : null;

            final ItemStack copperIngot = !OreDictionary.getOres("ingotCopper").isEmpty() ? OreDictionary.getOres("ingotCopper").get(0).copy() : null;

            final ItemStack bronzeIngot = !OreDictionary.getOres("ingotBronze").isEmpty() ? OreDictionary.getOres("ingotBronze").get(0).copy() : null;

            final ItemStack aluminiumIngot = !OreDictionary.getOres("aluminiumIngot").isEmpty() ?
                    OreDictionary.getOres("aluminiumIngot").get(0).copy() :
                    null;

            final ItemStack alumiteIngot = !OreDictionary.getOres("alumiteIngot").isEmpty() ?
                    OreDictionary.getOres("alumiteIngot").get(0).copy() :
                    null;

            final ItemStack cobaltIngot = !OreDictionary.getOres("cobaltIngot").isEmpty() ? OreDictionary.getOres("cobaltIngot").get(0).copy() : null;

            final ItemStack arditeIngot = !OreDictionary.getOres("arditeIngot").isEmpty() ? OreDictionary.getOres("arditeIngot").get(0).copy() : null;

            final ItemStack manyullynIngot = !OreDictionary.getOres("manyullynIngot").isEmpty() ?
                    OreDictionary.getOres("manyullynIngot").get(0).copy() :
                    null;

            final ItemStack certusQuartz = !OreDictionary.getOres("crystalCertusQuartz").isEmpty() ?
                    OreDictionary.getOres("crystalCertusQuartz").get(0).copy() :
                    null;

            if (tinIngot != null) {
                tinIngot.setCount(1);
                addShapelessRecipe(new ShapelessOreRecipe(tinIngot, "ingotCopper", "ingotCopper", "ingotCopper", AMULET_STACK));

                tinIngot.setCount(3);
                addShapelessRecipe(new ShapelessOreRecipe(tinIngot, "aluminiumIngot", AMULET_STACK));
            }

            if (copperIngot != null) {
                copperIngot.setCount(3);

                addShapelessRecipe(new ShapelessOreRecipe(copperIngot, "ingotTin", AMULET_STACK));
            }

            if (bronzeIngot != null) {
                bronzeIngot.setCount(4);

                addShapelessRecipe(new ShapelessOreRecipe(bronzeIngot, "ingotCopper", "ingotCopper", "ingotCopper", "ingotTin", AMULET_STACK));
            }

            if (aluminiumIngot != null) {
                aluminiumIngot.setCount(1);
                addShapelessRecipe(new ShapelessOreRecipe(aluminiumIngot, "ingotTin", "ingotTin", "ingotTin", AMULET_STACK));
            }

            if (manyullynIngot != null) {
                manyullynIngot.setCount(1);
                addShapelessRecipe(new ShapelessOreRecipe(manyullynIngot, "cobaltIngot", "cobaltIngot", "arditeIngot", "arditeIngot", AMULET_STACK));
            }

            if (arditeIngot != null) {
                arditeIngot.setCount(1);
                addShapelessRecipe(new ShapelessOreRecipe(arditeIngot, "alumiteIngot", "alumiteIngot", "alumiteIngot", AMULET_STACK));

                arditeIngot.setCount(3);
                addShapelessRecipe(new ShapelessOreRecipe(arditeIngot, "cobaltIngot", AMULET_STACK));
            }

            if (cobaltIngot != null) {
                cobaltIngot.setCount(1);
                addShapelessRecipe(new ShapelessOreRecipe(cobaltIngot, "arditeIngot", "arditeIngot", "arditeIngot", AMULET_STACK));
            }

            if (alumiteIngot != null) {
                alumiteIngot.setCount(3);
                addShapelessRecipe(new ShapelessOreRecipe(alumiteIngot, "arditeIngot", AMULET_STACK));
            }

            if (certusQuartz != null) {
                certusQuartz.setCount(5);
                addShapelessRecipe(new ShapelessOreRecipe(certusQuartz, "ingotIron", "ingotIron", "ingotIron", "ingotIron", "ingotIron", "ingotIron",
                        AMULET_STACK));
            }*/
        }
    }

}
