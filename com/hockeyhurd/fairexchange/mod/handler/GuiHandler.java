package com.hockeyhurd.fairexchange.mod.handler;

import com.hockeyhurd.fairexchange.mod.container.ContainerUnifier;
import com.hockeyhurd.fairexchange.mod.container.TileUnifier;
import com.hockeyhurd.fairexchange.mod.gui.GuiUnifier;
import com.hockeyhurd.hcorelib.api.math.VectorHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Class container for handling all gui or container requests.
 *
 * @author hockeyhurd
 * @version 8/3/2015.
 */
public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(VectorHelper.toBlockPos(x, y, z));

		if (te instanceof TileUnifier) return new ContainerUnifier(player.inventory, (TileUnifier) te);

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(VectorHelper.toBlockPos(x, y, z));

		if (te instanceof TileUnifier) return new GuiUnifier(player.inventory, (TileUnifier) te);

		return null;
	}

}
