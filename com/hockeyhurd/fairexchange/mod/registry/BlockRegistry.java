package com.hockeyhurd.fairexchange.mod.registry;

import com.hockeyhurd.hcorelib.api.block.IHBlock;
import com.hockeyhurd.hcorelib.api.util.interfaces.IForgeMod;
import net.minecraft.block.Block;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Class used for initializing and containing all blocks that are registered for this mod.
 *
 * @author hockeyhurd
 * @version 1/14/17
 */
public final class BlockRegistry {

    private final Map<String, IHBlock> blockMap;

    private static final BlockRegistry reg = new BlockRegistry();

    private BlockRegistry() {
        blockMap = new HashMap<String, IHBlock>();
    }

    public static BlockRegistry getInstance() {
        return reg;
    }

    public void init(Class<? extends IForgeMod> mainClass) {
        Field[] fields = mainClass.getFields();
        if (fields.length == 0) return;

        for (Field field : fields) {
            try {
                final Object fieldObj = field.get(mainClass);

                if (fieldObj instanceof IHBlock) {
                    final IHBlock block = (IHBlock) fieldObj;
                    blockMap.put(block.getName(), block);
                }
            }

            catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    public Map<String, IHBlock> getBlockMap() {
        return blockMap;
    }

    public Block getBlockByName(String name) {
        if (name == null || name.isEmpty() || blockMap.isEmpty()) return null;

        final IHBlock block = blockMap.get(name);

        return block != null ? block.getBlock() : null;
    }

}
