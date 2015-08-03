package com.hockeyhurd.fairexchange.gui;

import com.hockeyhurd.api.math.Vector2;
import com.hockeyhurd.fairexchange.container.ContainerUnifier;
import com.hockeyhurd.fairexchange.tileentity.container.TileUnifier;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Gui class for TileUnifier.
 *
 * @see com.hockeyhurd.fairexchange.tileentity.container.TileUnifier
 *
 * @author hockeyhurd
 * @version 8/3/2015.
 */
@SideOnly(Side.CLIENT)
public class GuiUnifier extends GuiBase {

	public GuiUnifier(InventoryPlayer inv, TileUnifier te) {
		super(new ContainerUnifier(inv, te), inv, te);
	}

	@Override
	public ResourceLocation getTexture() {
		return new ResourceLocation("fairexchange", "textures/gui/GuiUnifier.png");
	}

	@Override
	public Vector2<Integer> getSizeVec() {
		return new Vector2<Integer>(176, 180);
	}

}
