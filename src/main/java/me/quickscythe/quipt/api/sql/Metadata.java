package me.quickscythe.quipt.api.sql;

import org.json.JSONException;
import org.json.JSONObject;

public class Metadata {

    private final JSONObject data;

    public Metadata(JSONObject data){
        this.data = data;
    }

    public Metadata get(String key){
        return new Metadata(data.getJSONObject(key));
    }

    public <E> E value(String key, Class<E> returnClass) {
        try{
            return (E) data.get(key);
        }catch (ClassCastException | JSONException e){
            throw new IllegalArgumentException("Could not find MetadataValue for " + key);
        }

    }
}
