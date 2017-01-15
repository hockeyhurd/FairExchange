package com.hockeyhurd.fairexchange.block;

import com.hockeyhurd.fairexchange.mod.FairExchangeMain;
import com.hockeyhurd.fairexchange.tileentity.container.TileUnifier;
import com.hockeyhurd.hcorelib.api.block.AbstractHCoreBlockContainer;
import com.hockeyhurd.hcorelib.api.util.enums.EnumHarvestLevel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class BlockUnifier extends AbstractHCoreBlockContainer {

	private final String name;

	public BlockUnifier(Material material, String name) {
		super(material, FairExchangeMain.myCreativeTab, FairExchangeMain.assetDir, name);

		this.name = name;
	}

	@Override
	public Block getBlock() {
		return this;
	}

	@Override
	public float getBlockHardness() {
		return 1.0f;
	}

	@Override
	public EnumHarvestLevel getHarvestLevel() {
		return EnumHarvestLevel.PICKAXE_WOOD;
	}

	@Override
	public TileUnifier getTileEntity() {
		return new TileUnifier();
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos blockPos, IBlockState blockState, EntityLivingBase placer, ItemStack stack) {

	}

	@Override
	public boolean onBlockActivated(World world, BlockPos blockPos, IBlockState blockState, EntityPlayer player, EnumHand hand,
			ItemStack stack, EnumFacing sideHit, float hitX, float hitY, float hitZ) {
		if (world.isRemote) return true;

		else {
			TileUnifier te = (TileUnifier) world.getTileEntity(blockPos);

			if (te != null) {
				FMLNetworkHandler.openGui(player, FairExchangeMain.instance, 0, world, blockPos.getX(), blockPos.getY(), blockPos.getZ());
				return true;
			}

			return false;
		}
	}

}
