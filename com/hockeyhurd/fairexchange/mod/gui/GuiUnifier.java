package com.hockeyhurd.fairexchange.mod.gui;

import com.hockeyhurd.fairexchange.mod.container.ContainerUnifier;
import com.hockeyhurd.fairexchange.mod.container.TileUnifier;
import com.hockeyhurd.hcorelib.api.math.Vector2;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Gui class for TileUnifier.
 *
 * @see com.hockeyhurd.fairexchange.mod.container.TileUnifier
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
		return new ResourceLocation("fairexchange", "textures/gui/gui_unifier.png");
	}

	@Override
	public Vector2<Integer> getSizeVec() {
		return new Vector2<Integer>(238, 256);
	}

}
