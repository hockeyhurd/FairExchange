package com.hockeyhurd.fairexchange.mod.creativetab;

import com.hockeyhurd.fairexchange.mod.registry.ModRegistry;
import com.hockeyhurd.hcorelib.api.creativetab.AbstractCreativeTab;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FairExchangeCreativeTab extends AbstractCreativeTab {

	public FairExchangeCreativeTab(int par1, String par2) {
		super(par1, par2);
	}
	
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() {
		return new ItemStack(ModRegistry.ModItems.amuletTrade.getItem().getItem(), 1);
	}

}
