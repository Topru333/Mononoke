package com.topru.mononoke.common.registry.libs;

import com.topru.mononoke.client.Mononoke;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Lib<V> {

    public List<V> allRegistries() {
        List<V> items = new ArrayList<>();
        for (Method m : this.getClass().getMethods()) {
            if (m.getName().startsWith("get") && !m.getName().equals("getClass") && m.getParameterTypes().length == 0) {
                try {
                    V i = (V)m.invoke(this);
                    items.add(i);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        return items;
    }

    protected ResourceLocation location(@Nonnull String name) {
        return new ResourceLocation(Mononoke.MOD_ID, name);
    }
}
