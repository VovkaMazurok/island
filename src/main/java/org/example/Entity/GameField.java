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