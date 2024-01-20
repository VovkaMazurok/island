package org.example.Entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.List;
import java.util.Map;

public class ReadJsonFile {

    public void readJsonFile() {
        String path = "src/main/resources/Characteristics.json";

        Gson gson = new Gson();
        try (FileReader reader = new FileReader(path)) {
            Map<String, List<Map<String, Object>>> map = gson.fromJson(reader, new TypeToken<Map<String, List<Map<String, Object>>>>() {
            }.getType());
            for (Map.Entry<String, List<Map<String, Object>>> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": ");
                for (Map<String, Object> parameterMap : entry.getValue()) {
                    Characteristics parameter = new Characteristics(
                            ((Double) parameterMap.get("weight")).doubleValue(),
                            ((Double) parameterMap.get("maxCount")).intValue(),
                            ((Double) parameterMap.get("speed")).intValue(),
                            ((Double) parameterMap.get("foodNeeded")).doubleValue()
                    );

                    parameter.setWeight((Double) parameterMap.get("weight"));
                    parameter.setMaxCount(((Double) parameterMap.get("maxCount")).intValue());
                    parameter.setSpeed(((Double) parameterMap.get("speed")).intValue());
                    parameter.setFoodNeeded((Double) parameterMap.get("foodNeeded"));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


//        public static Map<String, Cell> readCellFile() {
//            String cell = "src/main/resources/Cell.json";
//            Map<String, Cell> mapCell = new HashMap<>();
//
//            try (FileReader reader = new FileReader(cell)) {
//                Gson gsonCell = new Gson();
//                mapCell = gsonCell.fromJson(reader, new TypeToken<Map<String, Cell>>() {}.getType());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return mapCell;
//        }
//
//        public static Map<String, List<Animal>> readCharacteristicsFile() {
//            String pathCharacteristics = "src/main/resources/Characteristics.json";
//            Map<String, List<Animal>> mapCharacteristics = new HashMap<>();
//
//            try (FileReader reader = new FileReader(pathCharacteristics)) {
//                Gson gson = new Gson();
//                mapCharacteristics = gson.fromJson(reader, new TypeToken<Map<String, List<Animal>>>() {}.getType());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return mapCharacteristics;
//        }
//
//        public static Map<String, Map<String, Integer>> readProbabilityFile() {
//            String probability = "src/main/resources/Probability_to_eat.json";
//            Map<String, Map<String, Integer>> mapProbability = new HashMap<>();
//
//            try (FileReader reader = new FileReader(probability)) {
//                Gson gsonProbability = new Gson();
//                mapProbability = gsonProbability.fromJson(reader, new TypeToken<Map<String, Map<String, Integer>>>() {}.getType());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return mapProbability;
//        }





