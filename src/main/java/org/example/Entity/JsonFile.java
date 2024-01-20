package org.example.Entity;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JsonFile {

    public static void record() {
        Properties prop = new Properties();
        InputStream input = null;
        Map<String, JSONObject> animals = new HashMap<>();


        try {
            input = new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Завантажуємо проперті-файл
        try {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Отримуємо властивості, парсимо їх як JSON та зберігаємо в колекції
        animals.put("wolf", new JSONObject(prop.getProperty("wolf")));
        animals.put("snake", new JSONObject(prop.getProperty("snake")));
        animals.put("fox", new JSONObject(prop.getProperty("fox")));

        // Виводимо колекцію
        for (Map.Entry<String, JSONObject> entry : animals.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }


    }
}




//    public static void jsonReader() {
//        String path = "Characteristics.json";
//        try {
//            String content = new String(Files.readAllBytes(Paths.get(path)));
//            JSONObject json = new JSONObject(content); // use the content string to create the JSON object
//            System.out.println(json.toString(4)); // pretty print JSON with 4 spaces indentation
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public static void readJsonFile()  {
//        String path = "Characteristics.json";
//
//        Gson gson = new Gson();
//        try (FileReader reader = new FileReader(path)) {
//            Map<String, List<Map<String, Object>>> map = gson.fromJson(reader, new TypeToken<Map<String, List<Map<String, Object>>>>(){}.getType());
//            for (Map.Entry<String, List<Map<String, Object>>> entry : map.entrySet()) {
//                System.out.println(entry.getKey() + ": ");
//                for (Map<String, Object> parameterMap : entry.getValue()) {
//                    Characteristics parameter = new Characteristics();
//                    parameter.setWeight((Double) parameterMap.get("weight"));
//                    parameter.setMaxCount(((Double) parameterMap.get("maxCount")).intValue());
//                    parameter.setSpeed(((Double) parameterMap.get("speed")).intValue());
//                    parameter.setFoodNeeded((Double) parameterMap.get("foodNeeded"));
//                    System.out.println("Parameter: " + parameter);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }









