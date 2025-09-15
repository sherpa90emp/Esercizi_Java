package Map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("nome", "Mario");
        linkedHashMap.put("cognome", "Rossi");
        linkedHashMap.put("città", "Roma");
        linkedHashMap.put("professione", "Programmatore");

        for (Map.Entry<String, String> entry : linkedHashMap.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}
