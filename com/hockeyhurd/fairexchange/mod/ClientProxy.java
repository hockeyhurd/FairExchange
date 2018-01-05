package com.hockeyhurd.fairexchange.mod;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	public ClientProxy() {
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
