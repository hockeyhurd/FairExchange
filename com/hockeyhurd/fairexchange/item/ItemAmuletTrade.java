package com.hockeyhurd.fairexchange.item;

import net.minecraft.item.ItemStack;

import com.hockeyhurd.api.item.AbstractItemMetalic;
import com.hockeyhurd.fairexchange.mod.FairExchangeMain;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemAmuletTrade extends AbstractItemMetalic {

	public ItemAmuletTrade(String name, String assetDir) {
		super(name, assetDir);
		this.setCreativeTab(FairExchangeMain.myCreativeTab);
		this.setMaxDamage(1000);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

}
