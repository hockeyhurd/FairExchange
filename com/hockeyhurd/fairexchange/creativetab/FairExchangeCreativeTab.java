package com.hockeyhurd.fairexchange.creativetab;

import net.minecraft.item.Item;

import com.hockeyhurd.api.creativetab.AbstractCreativeTab;
import com.hockeyhurd.fairexchange.mod.FairExchangeMain;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FairExchangeCreativeTab extends AbstractCreativeTab {

	public FairExchangeCreativeTab(int par1, String par2) {
		super(par1, par2);
	}
	
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return FairExchangeMain.amuletTrade;
	}

}
