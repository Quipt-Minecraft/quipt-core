package me.quickscythe.quipt.api.registries;

import java.util.Optional;

public class KeyRegistry extends Registry<RegistryKey> {
    public KeyRegistry() {
        super(RegistryKey.class);
    }

    public Optional<RegistryKey> register(String id){
        register(id, new RegistryKey(id));
        return get(id);
    }
}
