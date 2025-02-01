package me.quickscythe.qupit.tests;

import me.quickscythe.quipt.api.utils.Metadata;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {

        JSONObject data = new JSONObject();
        data.put("name", "John Doe");
        data.put("age", 25);
        JSONObject nestedData = new JSONObject();
        nestedData.put("city", "New York");
        nestedData.put("country", "USA");
        data.put("address", nestedData);
        Metadata metadata = Metadata.of(data);
        System.out.println(metadata.get("address").value("city", String.class));
        System.out.println("Hello, World!");
    }
}
