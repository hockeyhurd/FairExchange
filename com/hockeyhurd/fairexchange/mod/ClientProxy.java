package com.hockeyhurd.fairexchange.mod;

import com.hockeyhurd.fairexchange.mod.registry.BlockRegistry;
import com.hockeyhurd.fairexchange.mod.registry.ItemRegistry;
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
		BlockRegistry.getInstance().init(FairExchangeMain.class);

		for (IHBlock block : BlockRegistry.getInstance().getBlockMap().values()) {
			if (block != null) {
				GameRegistry.register(block.getBlock());
				GameRegistry.register(block.getItemBlock().setRegistryName(block.getBlock().getRegistryName()));
				ModelRegistry.registerBlock(block);
			}
		}
	}

	@Override
	protected void registerItems() {
		ItemRegistry.getInstance().init(FairExchangeMain.class);

		for (IHItem item : ItemRegistry.getInstance().getItemMap().values()) {
			if (item != null) {
				GameRegistry.register(item.getItem());
				ModelRegistry.registerItem(item);
			}
		}
	}

	@Override
	public void registerRenderInformation() {
		registerSpecialRenderers();
	}

	private void registerSpecialRenderers() {
	}

	@Override
	public boolean isClient() {
		return true;
	}

}
