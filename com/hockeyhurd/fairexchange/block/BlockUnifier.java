package com.hockeyhurd.fairexchange.block;

import com.hockeyhurd.fairexchange.mod.FairExchangeMain;
import com.hockeyhurd.fairexchange.tileentity.container.TileUnifier;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockUnifier extends BlockContainer {

	private final String name;

	public BlockUnifier(Material material, String name) {
		super(material);
		this.setBlockName(name);
		this.setCreativeTab(FairExchangeMain.myCreativeTab);
		this.setHardness(1f);

		this.name = name;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		blockIcon = reg.registerIcon(FairExchangeMain.assetDir + name);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int id) {
		return new TileUnifier();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote) return true;

		else {
			TileUnifier te = (TileUnifier) world.getTileEntity(x, y, z);

			if (te != null) {
				FMLNetworkHandler.openGui(player, FairExchangeMain.instance, 0, world, x, y, z);
				return true;
			}

			return false;
		}
	}

}
