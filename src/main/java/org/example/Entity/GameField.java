package org.example.Entity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class GameField {

    private int width;
    private int height;
    private Cell[][] cells;

    private AtomicInteger activeThreads = new AtomicInteger(0);

    public GameField(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
    }

    public void fillFieldWithAnimals() {
        ExecutorService executor = Executors.newFixedThreadPool(10); // 10 is the number of threads

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                executor.submit(() -> {
                    activeThreads.incrementAndGet();
                    activeThreads.decrementAndGet();
                });
            }
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait until all tasks are finished
        }
    }

    public int getActiveThreads() {
        return activeThreads.get();
    }

    // Other methods...

    // private Cell[][] cells = new Cell[width][height];

    public Cell[][] getCells() {
        return cells;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

//public class GameField {
//
//    private int width;
//    private int height;
//    private Cell[][] cells;
//    private AtomicInteger activeThreads = new AtomicInteger(0);
//    private Random random = new Random();
//
//    public GameField(int width, int height) {
//        this.width = width;
//        this.height = height;
//        this.cells = new Cell[width][height];
//    }
//
//    public void fillFieldWithAnimals() {
//        ExecutorService executor = Executors.newFixedThreadPool(10); // 10 is the number of threads
//
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                executor.submit(() -> {
//                    activeThreads.incrementAndGet();
//                    Animal animal;
//                    int animalType = random.nextInt(3); // Generate a random number between 0 and 2
//                    switch (animalType) {
//                        case 0:
//                            animal = new Wolf(50, 30, 3, 8); // Parameters for a wolf
//                            break;
//                        case 1:
//                            animal = new Snake(15, 30, 1, 3); // Parameters for a snake
//                            break;
//                        case 2:
//                            animal = new Fox(8, 30, 2, 2); // Parameters for a fox
//                            break;
//                        default:
//                            throw new IllegalArgumentException("Unknown animal type: " + animalType);
//                    }
//                    cells[i][j] = new Cell(animal);
//                    System.out.println("Cell at (" + i + ", " + j + ") filled with " + animal);
//                    activeThreads.decrementAndGet();
//                });
//            }
//        }
//
//        executor.shutdown();
//        while (!executor.isTerminated()) {
//            // Wait until all tasks are finished
//        }
//    }
//
//    public int getActiveThreads() {
//        return activeThreads.get();
//    }
//
//    // Other methods...
//}
