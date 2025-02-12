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

    public Registry<?> get(RegistryKey key) {
        return registries.getOrDefault(key, null);
    }

    public <T> Optional<Registry<T>> get(RegistryKey key, Class<T> type) {
        return Optional.ofNullable((Registry<T>) registries.get(key));
    }


}
