package me.quickscythe.quipt.api.registries;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Registry<T> {

    private final Map<String, T> registry = new HashMap<>();

    public Registry() {
    }

//    public abstract void load();

    public void clear(){
        registry.clear();
    }

    public void reload(){
        clear();
//        load();
    }

    public Map<String, T> toMap() {
        return registry;
    }

    public T getOrDefault(String key, T defaultValue) {
        return registry.getOrDefault(key, defaultValue);
    }


    public void register(String id, T t) {
        registry.put(id, t);
    }

    public void registerAll(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers())) {
                try {
                    register(field.getName(), (T) field.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void forEach(Consumer<T> consumer) {
        registry.forEach((s, t) -> consumer.accept(t));
    }

    public T get(String key) {
        return getOrDefault(key, null);
    }

    public int size() {
        return registry.size();
    }
}
