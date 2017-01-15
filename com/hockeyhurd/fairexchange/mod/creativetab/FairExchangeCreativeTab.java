package com.hockeyhurd.fairexchange.mod.creativetab;

import com.hockeyhurd.fairexchange.mod.FairExchangeMain;
import com.hockeyhurd.hcorelib.api.creativetab.AbstractCreativeTab;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FairExchangeCreativeTab extends AbstractCreativeTab {

	public FairExchangeCreativeTab(int par1, String par2) {
		super(par1, par2);
	}
	
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return FairExchangeMain.amuletTrade;
	}

}
