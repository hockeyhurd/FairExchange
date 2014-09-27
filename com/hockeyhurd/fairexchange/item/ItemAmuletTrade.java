package com.hockeyhurd.fairexchange.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.hockeyhurd.api.item.AbstractItemMetalic;
import com.hockeyhurd.fairexchange.mod.FairExchangeMain;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemAmuletTrade extends AbstractItemMetalic {

	public ItemAmuletTrade(String name, String assetDir) {
		super(name, assetDir);
		this.setCreativeTab(FairExchangeMain.myCreativeTab);
		this.setMaxDamage(2000);
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag) {
		list.add(EnumChatFormatting.GREEN + "Ability: " + EnumChatFormatting.GRAY + "Allows for trading resources");
		list.add(EnumChatFormatting.GRAY + "into other useful resources.");
	}

}
