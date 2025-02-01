package me.quickscythe.quipt.api.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class Metadata {

    private final JSONObject data;


    private Metadata(JSONObject data) {
        for (String key : data.keySet()) {
            if (data.get(key) instanceof JSONObject nestedData) {
                data.put(key, new Metadata(nestedData));
            }

        }
        this.data = data;
    }

    public static Metadata of(JSONObject data) {
        return new Metadata(data);
    }

    public Metadata get(String key) {
        return data.opt(key) instanceof Metadata metadata ? metadata : null;
    }

    public <E> E value(String key, Class<E> returnClass) {
        try {
            return (E) data.get(key);
        } catch (ClassCastException | JSONException e) {
            throw new IllegalArgumentException("Could not find MetadataValue for " + key);
        }

    }
}
