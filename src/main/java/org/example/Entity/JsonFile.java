package org.example.Entity;


import Organism.Characteristics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonFile {


//    public JsonFile() {
//        String path = "Characteristics_of_animals.json";
//        try {
//            String content = new String(Files.readAllBytes(Paths.get(path)));
//            JSONObject json = new JSONObject(content); // use the content string to create the JSON object
//            System.out.println(json.toString(4)); // pretty print JSON with 4 spaces indentation
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void readJsonFile()  {
        String path = "src/Parameters/11.json";

        Gson gson = new Gson();
        try (FileReader reader = new FileReader(path)) {
            Map<String, List<Map<String, Object>>> map = gson.fromJson(reader, new TypeToken<Map<String, List<Map<String, Object>>>>(){}.getType());
            for (Map.Entry<String, List<Map<String, Object>>> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": ");
                for (Map<String, Object> parameterMap : entry.getValue()) {
                    Characteristics parameter = new Characteristics();
                    parameter.setWeight((Double) parameterMap.get("weight"));
                    parameter.setMaxCount(((Double) parameterMap.get("maxCount")).intValue());
                    parameter.setSpeed(((Double) parameterMap.get("speed")).intValue());
                    parameter.setFoodNeeded((Double) parameterMap.get("foodNeeded"));
                    System.out.println("Parameter: " + parameter);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}





