package com.hockeyhurd.item;

import net.minecraft.item.ItemStack;

import com.hockeyhurd.api.item.AbstractItemMetalic;
import com.hockeyhurd.fairexchange.FairExchangeMain;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemAmuletTrade extends AbstractItemMetalic {

	public ItemAmuletTrade(String name, String assetDir) {
		super(name, assetDir);
		this.setCreativeTab(FairExchangeMain.myCreativeTab);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

}
