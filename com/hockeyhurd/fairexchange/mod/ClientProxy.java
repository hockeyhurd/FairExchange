package com.hockeyhurd.fairexchange.mod;

import com.hockeyhurd.hcorelib.api.block.IHBlock;
import com.hockeyhurd.hcorelib.api.client.util.ModelRegistry;
import com.hockeyhurd.hcorelib.api.item.IHItem;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	public ClientProxy() {
	}

	@Override
	protected void registerBlocks() {
		GameRegistry.register(FairExchangeMain.unifier);
		GameRegistry.register(((IHBlock) FairExchangeMain.unifier).getItemBlock().setRegistryName(((IHBlock) FairExchangeMain.unifier).getBlock().getRegistryName()));
		ModelRegistry.registerBlock((IHBlock) FairExchangeMain.unifier);
	}

	@Override
	protected void registerItems() {
		GameRegistry.register(FairExchangeMain.amuletTrade);
		ModelRegistry.registerItem((IHItem) FairExchangeMain.amuletTrade);
	}

	public void registerRenderInformation() {
		registerSpecialRenderers();
	}
	
	private void registerSpecialRenderers() {
	}
	
}
