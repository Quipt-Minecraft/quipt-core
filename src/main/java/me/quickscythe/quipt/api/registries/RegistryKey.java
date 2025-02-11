package me.quickscythe.quipt.api.registries;

public class RegistryKey {

    private String key;

    public RegistryKey(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }

    public void key(String key) {
        this.key = key;
    }
}
