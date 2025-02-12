package me.quickscythe.qupit.tests.tests;

import me.quickscythe.quipt.api.data.Metadata;
import me.quickscythe.qupit.tests.messages.Message;
import me.quickscythe.quipt.api.data.registries.Registries;
import me.quickscythe.quipt.api.data.registries.Registry;
import me.quickscythe.quipt.api.data.registries.RegistryKey;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatagenTests {


    @Test
    void testMetadata(){
        JSONObject data = getNestedJson();
        Metadata metadata = Metadata.of(data);

        System.out.println(metadata.toString(2));

        assertEquals("Nest 1.1", metadata.get("nest1").get("nest1_1").value("name", String.class), "Nested name is not correct");
        assertEquals("Mustafa Miller", metadata.value("name", String.class), "Name is not correct");

    }

    private JSONObject getNestedJson() {
        JSONObject obj = new JSONObject();
        obj.put("name", "Mustafa Miller");
        obj.put("age", 18);
        JSONObject nest1 = new JSONObject();
        nest1.put("name", "Nest 1");
        nest1.put("age", 19);
        obj.put("nest1", nest1);
        JSONObject nest2 = new JSONObject();
        nest2.put("name", "Nest 2");
        nest2.put("age", 20);
        obj.put("nest2", nest2);
        JSONObject nest1_1 = new JSONObject();
        nest1_1.put("name", "Nest 1.1");
        nest1_1.put("age", 21);
        nest1.put("nest1_1", nest1_1);
        return obj;
    }

    @Test
    public void testRegistries() {
        Optional<RegistryKey> key = Registries.KEYS.register("messages");
        if (key.isEmpty()) throw new RuntimeException("Failed to register key");

        Registries.REGISTRAR.add(key.get(), new Registry<>(Message.class));
        Registry<Message> messages = Registries.REGISTRAR.get(key.get(), Message.class).orElseThrow(() -> new RuntimeException("Failed to get registry"));
        messages.register("test", new Message("Hello, World!"));

        if (messages.get("test").isPresent()) messages.get("test").get().send();

        assertTrue(messages.get("test").isPresent(), "Message is not present");
        assertEquals("Hello, World!", messages.get("test").get().message(), "Message is not correct");
    }
}
