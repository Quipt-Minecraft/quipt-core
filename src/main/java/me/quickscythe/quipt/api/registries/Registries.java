package me.quickscythe.quipt.api.registries;

import java.util.HashMap;
import java.util.Map;

public class Registries {

    private static final Map<String, Registry<?>> registries = new HashMap<>();

    public static <T> Registry<T> add(String name, Registry<T> registry) {
        registries.put(name, registry);
        return registry;
    }

    public static Registry<?> get(String name) {
        return registries.get(name);
    }

    public static <T> Registry<T> get(String name, Class<T> type) {
        return (Registry<T>) get(name);
    }


}
