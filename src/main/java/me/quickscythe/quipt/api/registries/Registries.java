package me.quickscythe.quipt.api.registries;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Registries {

    private static final Map<String, Registry<?>> registries = new HashMap<>();

    public static <T> Registry<T> add(String name, Registry<T> registry) {
        registries.put(name, registry);
        return registry;
    }

    public static Registry<?> get(String name) {
        return registries.getOrDefault(name, null);
    }

    public static <T> Optional<Registry<T>> get(String name, Class<T> type) {
        return Optional.of((Registry<T>) registries.get(name));
    }


}
