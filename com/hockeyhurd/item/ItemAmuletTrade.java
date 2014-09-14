package com.hockeyhurd.item;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemAmuletTrade extends AbstractItemMetalic {

	public ItemAmuletTrade(String name, String assetDir) {
		super(name, assetDir);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

}
