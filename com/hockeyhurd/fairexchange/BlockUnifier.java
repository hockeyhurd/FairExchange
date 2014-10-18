package com.hockeyhurd.fairexchange;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.hockeyhurd.fairexchange.mod.FairExchangeMain;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockUnifier extends Block {

	public BlockUnifier(Material material) {
		super(material);
		this.setBlockName("Unifier");
		this.setCreativeTab(FairExchangeMain.myCreativeTab);
		this.setHardness(1f);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		blockIcon = reg.registerIcon(FairExchangeMain.assetDir + "Unifier");
	}

}
