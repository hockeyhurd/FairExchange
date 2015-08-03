package com.hockeyhurd.fairexchange.gui;

import com.hockeyhurd.api.math.Vector2;
import com.hockeyhurd.fairexchange.container.ContainerBase;
import com.hockeyhurd.fairexchange.tileentity.AbstractTile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Base gui class.
 *
 * @author hockeyhurd
 * @version 8/3/2015.
 */
@SideOnly(Side.CLIENT)
public abstract class GuiBase extends GuiContainer {

	protected final InventoryPlayer inv;
	protected final AbstractTile te;
	protected ResourceLocation texture;

	public GuiBase(InventoryPlayer inv, AbstractTile te) {
		this(new ContainerBase(inv, te), inv, te);
	}

	public GuiBase(ContainerBase containerBase, InventoryPlayer inv, AbstractTile te) {
		super(containerBase);

		this.inv = inv;
		this.te = te;
		this.texture = getTexture();

		Vector2<Integer> sizeVec = getSizeVec();
		this.xSize = sizeVec.x;
		this.ySize = sizeVec.y;
	}

	public abstract ResourceLocation getTexture();

	public Vector2<Integer> getSizeVec() {
		return new Vector2<Integer>(176, 166);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		super.drawGuiContainerForegroundLayer(x, y);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
		GL11.glColor4f(1f, 1f, 1f, 1f);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;

		this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

	}

}
