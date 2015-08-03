package com.hockeyhurd.fairexchange.tileentity;

import com.hockeyhurd.api.math.Vector3;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * General purpose class for creating tile entities.
 *
 * @author hockeyhurd
 * @version 7/26/2015.
 */
public abstract class AbstractTile extends TileEntity {

	protected String customName;

	public AbstractTile() {
		setCustomName("container.generic");
	}

	public AbstractTile(String customName) {
		setCustomName(customName);
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public boolean hasCustomName() {
		return customName != null && customName.length() > 0 && !customName.equalsIgnoreCase("container.generic");
	}

	/**
	 * @return world coordinates of this tileentity.
	 */
	public Vector3<Integer> worldVec() {
		return new Vector3<Integer>(xCoord, yCoord, zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound comp) {
		super.readFromNBT(comp);

		readNBT(comp);

		if (comp.hasKey("CustomName")) customName = comp.getString("CustomName");
	}

	@Override
	public void writeToNBT(NBTTagCompound comp) {
		super.writeToNBT(comp);

		saveNBT(comp);

		if (this.hasCustomName()) comp.setString("CustomName", customName);
	}

	public abstract void readNBT(NBTTagCompound comp);

	public abstract void saveNBT(NBTTagCompound comp);

}
