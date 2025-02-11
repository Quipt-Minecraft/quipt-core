package me.quickscythe.quipt.api.registries;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Registries {

    public static final Registries REGISTRAR = new Registries();

    public static final KeyRegistry KEYS = new KeyRegistry();

    private final Map<RegistryKey, Registry<?>> registries = new HashMap<>();

    public <T> Registry<T> add(RegistryKey key, Registry<T> registry) {
        registries.put(key, registry);
        return registry;
    }

    public Registry<?> get(String name) {
        return registries.getOrDefault(name, null);
    }

    public <T> Optional<Registry<T>> get(String name, Class<T> type) {
        return Optional.of((Registry<T>) registries.get(name));
    }


}
