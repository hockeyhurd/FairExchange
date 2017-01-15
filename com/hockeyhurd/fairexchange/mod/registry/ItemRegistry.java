package com.hockeyhurd.fairexchange.mod.registry;

import com.hockeyhurd.hcorelib.api.item.IHItem;
import com.hockeyhurd.hcorelib.api.util.interfaces.IForgeMod;
import net.minecraft.item.Item;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Class used for initializing and containing all items that are registered for this mod.
 *
 * @author hockeyhurd
 * @version 1/14/17
 */
public final class ItemRegistry {

    private final Map<String, IHItem> itemMap;

    private static final ItemRegistry reg = new ItemRegistry();

    private ItemRegistry() {
        this.itemMap = new HashMap<String, IHItem>();
    }

    public static ItemRegistry getInstance() {
        return reg;
    }

    public void init(Class<? extends IForgeMod> mainClass) {
        Field[] fields = mainClass.getFields();
        if (fields.length == 0) return;

        for (Field field : fields) {
            try {
                final Object fieldObj = field.get(mainClass);

                if (fieldObj instanceof IHItem) {
                    final IHItem item = (IHItem) fieldObj;
                    itemMap.put(item.getName(), item);
                }
            }

            catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    public Map<String, IHItem> getItemMap() {
        return itemMap;
    }

    public Item getItemByName(String name) {
        if (name == null || name.isEmpty() || itemMap.isEmpty()) return null;

        final IHItem result = itemMap.get(name);

        return result != null ? result.getItem() : null;
    }

}
