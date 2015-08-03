package com.hockeyhurd.fairexchange.handler;

import com.hockeyhurd.fairexchange.container.ContainerUnifier;
import com.hockeyhurd.fairexchange.gui.GuiUnifier;
import com.hockeyhurd.fairexchange.tileentity.container.TileUnifier;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Class container for handling all gui or container requests.
 *
 * @author hockeyhurd
 * @version 8/3/2015.
 */
public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);

		if (te instanceof TileUnifier) return new ContainerUnifier(player.inventory, (TileUnifier) te);

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);

		if (te instanceof TileUnifier) return new GuiUnifier(player.inventory, (TileUnifier) te);

		return null;
	}

}
