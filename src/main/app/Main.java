package main.app;

import java.io.*;

public class Main {
    public static  void main(String[] args) throws IOException {
        String pathToAnimals = "D:\\Projects\\Java\\AnimalAccountingSystem\\src\\main\\inputData\\animals.txt"; //".src/main.inputData/animals";
        String pathToTask1 = "D:\\Projects\\Java\\AnimalAccountingSystem\\src\\main\\tasks\\task1.txt";
        String pathToTask2 = "D:\\Projects\\Java\\AnimalAccountingSystem\\src\\main\\tasks\\task2.txt";
        String pathToTask3 = "D:\\Projects\\Java\\AnimalAccountingSystem\\src\\main\\tasks\\task3.txt";

        FileHandler fileHandler = new FileHandler();
        AnimalRepo animalRepo = new AnimalRepo();
        animalRepo.setAnimals(
                fileHandler.getAnimalsFromFile(pathToAnimals)
        );

        System.out.println("Result of task1: " + fileHandler.doRequest(animalRepo, pathToTask1));
        System.out.println("Result of task2: " + fileHandler.doRequest(animalRepo, pathToTask2));
        System.out.println("Result of task3: " + fileHandler.doRequest(animalRepo, pathToTask3));
    }
}