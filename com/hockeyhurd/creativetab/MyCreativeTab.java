package com.hockeyhurd.creativetab;

import com.hockeyhurd.mod.FairExchangeMain;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MyCreativeTab extends AbstractCreativeTab {

	public MyCreativeTab(int par1, String par2) {
		super(par1, par2);
	}
	
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return FairExchangeMain.amuletTrade;
	}

}
