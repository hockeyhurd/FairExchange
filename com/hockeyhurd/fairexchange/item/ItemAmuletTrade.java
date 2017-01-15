package com.hockeyhurd.fairexchange.item;

import com.hockeyhurd.fairexchange.mod.FairExchangeMain;
import com.hockeyhurd.hcorelib.api.item.AbstractHCoreItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemAmuletTrade extends AbstractHCoreItem {

	public ItemAmuletTrade(String name, String assetDir) {
		super(FairExchangeMain.myCreativeTab, assetDir, name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag) {
		list.add(TextFormatting.GREEN + "Ability: " + TextFormatting.GRAY + "Allows for trading resources");
		list.add(TextFormatting.GRAY + "into other useful resources.");
	}

}
