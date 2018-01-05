package com.hockeyhurd.fairexchange.mod.item;

import com.hockeyhurd.fairexchange.mod.FairExchangeMain;
import com.hockeyhurd.hcorelib.api.handler.RecipePattern;
import com.hockeyhurd.hcorelib.api.item.AbstractHCoreItem;
import com.hockeyhurd.hcorelib.api.util.interfaces.ICraftableRecipe;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemAmuletTrade extends AbstractHCoreItem implements ICraftableRecipe {

    private static RecipePattern[] recipes;

    public ItemAmuletTrade(String name, String assetDir) {
        super(FairExchangeMain.myCreativeTab, assetDir, name);

        setMaxStackSize(1);
    }

    @Override
    public boolean hasContainerItem() {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        if (stack.getCount() <= 0)
            return null;

        return stack.copy();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(TextFormatting.GREEN + "Ability: " + TextFormatting.GRAY + "Allows for trading resources");
        list.add(TextFormatting.GRAY + "into other useful resources.");
    }

    @Override
    public RecipePattern[] getRecipePatterns() {
        if (recipes == null) {
            recipes = new RecipePattern[1];

            recipes[0] = new RecipePattern(" e ", "ege", " e ", true).addAssociation('e', "gemEmerald").addAssociation('g',
                    "ingotGold").setResultStack(new ItemStack(this, 1));
        }

        return recipes;
    }
}
