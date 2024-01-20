package org.example.Entity;

import org.example.Animals.Animal;

import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

public class Cell {

//    private final Map<Type, Set<Parameter>> residents;
//
//    public Cell(Map<Type, Set<Parameter>> residents) {
//        this.residents = residents;
//    }
//
//    public Map<Type, Set<Parameter>> getResidents() {
//        return residents;
//    }

    private Animal animal;

    public Cell() {
        this.animal = getAnimal();
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return this.animal;
    }
}
