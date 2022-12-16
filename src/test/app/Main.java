package test.app;

import main.app.Animal;
import main.app.AnimalRepo;
import main.app.FileHandler;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Testing of \"operateAnd\"");
        System.out.println("\tTest 1: " + testOperateAnd1());
        System.out.println("\tTest 2: " + testOperateAnd2());
        System.out.println("\tTest 3: " + testOperateAnd3());
        System.out.println("\tTest 4: " + testOperateAnd4());

        System.out.println("Testing of \"operateOr\"");
        System.out.println("\tTest 1: " + testOperateOr1());
        System.out.println("\tTest 2: " + testOperateOr2());
        System.out.println("\tTest 3: " + testOperateOr3());
        System.out.println("\tTest 4: " + testOperateOr4());

        System.out.println("Testing of \"getByWeight\"");
        System.out.println("\tTest 1: " + testFindByWeight1());
        System.out.println("\tTest 2: " + testFindByWeight2());

        System.out.println("Testing of \"getByHeight\"");
        System.out.println("\tTest 1: " + testFindByHeight1());
        System.out.println("\tTest 2: " + testFindByHeight2());

        System.out.println("Testing of \"getByType\"");
        System.out.println("\tTest 1: " + testFindByFoodType1());
        System.out.println("\tTest 2: " + testFindByFoodType2());

        System.out.println("Testing of \"getAnimalsFromFile\"");
        System.out.println("\tTest 1: " + testGetAnimalsFromFile1());
        System.out.println("\tTest 2: " + testGetAnimalsFromFile2());
        System.out.println("\tTest 3: " + testGetAnimalsFromFile3());

        System.out.println("Testing of \"doRequest\"");
        System.out.println("\tTest 1: " + testDoRequest1());
        System.out.println("\tTest 2: " + testDoRequest2());
        System.out.println("\tTest 3: " + testDoRequest3());
    }

    private static boolean testOperateAnd1() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals1 = new ArrayList<>();
        animals1.add(new Animal("LIGHT", "SMALL", "ALL"));
        animals1.add(new Animal("LIGHT", "SMALL", "GRASS"));
        animals1.add(new Animal("LIGHT", "MID", "ALL"));
        animals1.add(new Animal("LIGHT", "MID", "GRASS"));
        animals1.add(new Animal("HEAVY", "SMALL", "ALL"));
        animals1.add(new Animal("HEAVY", "SMALL", "GRASS"));
        animals1.add(new Animal("HEAVY", "MID", "ALL"));
        animals1.add(new Animal("HEAVY", "MID", "GRASS"));

        ArrayList<Animal> animals2 = new ArrayList<>();
        for (Animal animal : animals1)
            animals2.add(animal);

        ArrayList<Animal> resultAnimals = animalRepo.operateAnd(animals1, animals2);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();
        for (Animal animal : animals1)
            expectedAnimals.add(animal);

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testOperateAnd2() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals1 = new ArrayList<>();
        animals1.add(new Animal("LIGHT", "MID", "GRASS"));
        animals1.add(new Animal("HEAVY", "SMALL", "ALL"));
        animals1.add(new Animal("HEAVY", "SMALL", "GRASS"));
        animals1.add(new Animal("HEAVY", "MID", "ALL"));
        animals1.add(new Animal("HEAVY", "MID", "GRASS"));

        ArrayList<Animal> animals2 = new ArrayList<>();
        animals2.add(new Animal("LIGHT", "SMALL", "ALL"));
        animals2.add(new Animal("LIGHT", "SMALL", "GRASS"));
        animals2.add(new Animal("LIGHT", "MID", "ALL"));
        animals2.add(new Animal("LIGHT", "MID", "GRASS"));
        animals2.add(animals1.get(3));
        animals2.add(animals1.get(4));

        ArrayList<Animal> resultAnimals = animalRepo.operateAnd(animals1, animals2);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();
        expectedAnimals.add(animals1.get(3));
        expectedAnimals.add(animals1.get(4));

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testOperateAnd3() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals1 = new ArrayList<>();

        ArrayList<Animal> animals2 = new ArrayList<>();
        animals2.add(new Animal("LIGHT", "SMALL", "ALL"));
        animals2.add(new Animal("LIGHT", "SMALL", "GRASS"));
        animals2.add(new Animal("LIGHT", "MID", "ALL"));
        animals2.add(new Animal("LIGHT", "MID", "GRASS"));

        ArrayList<Animal> resultAnimals = animalRepo.operateAnd(animals1, animals2);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testOperateAnd4() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals1 = new ArrayList<>();
        animals1.add(new Animal("LIGHT", "MID", "GRASS"));
        animals1.add(new Animal("HEAVY", "SMALL", "ALL"));
        animals1.add(new Animal("HEAVY", "SMALL", "GRASS"));
        animals1.add(new Animal("HEAVY", "MID", "ALL"));
        animals1.add(new Animal("HEAVY", "MID", "GRASS"));

        ArrayList<Animal> animals2 = new ArrayList<>();

        ArrayList<Animal> resultAnimals = animalRepo.operateAnd(animals1, animals2);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testOperateOr1() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals1 = new ArrayList<>();
        animals1.add(new Animal("LIGHT", "SMALL", "ALL"));
        animals1.add(new Animal("LIGHT", "SMALL", "GRASS"));
        animals1.add(new Animal("LIGHT", "MID", "ALL"));
        animals1.add(new Animal("LIGHT", "MID", "GRASS"));
        animals1.add(new Animal("HEAVY", "SMALL", "ALL"));
        animals1.add(new Animal("HEAVY", "SMALL", "GRASS"));
        animals1.add(new Animal("HEAVY", "MID", "ALL"));
        animals1.add(new Animal("HEAVY", "MID", "GRASS"));

        ArrayList<Animal> animals2 = new ArrayList<>();
        for (Animal animal : animals1)
            animals2.add(animal);

        ArrayList<Animal> resultAnimals = animalRepo.operateOr(animals1, animals2);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();
        for (Animal animal : animals1)
            expectedAnimals.add(animal);

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testOperateOr2() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals1 = new ArrayList<>();
        animals1.add(new Animal("LIGHT", "MID", "GRASS"));
        animals1.add(new Animal("HEAVY", "SMALL", "ALL"));
        animals1.add(new Animal("HEAVY", "SMALL", "GRASS"));
        animals1.add(new Animal("HEAVY", "MID", "ALL"));
        animals1.add(new Animal("HEAVY", "MID", "GRASS"));

        ArrayList<Animal> animals2 = new ArrayList<>();
        animals2.add(new Animal("LIGHT", "SMALL", "ALL"));
        animals2.add(new Animal("LIGHT", "SMALL", "GRASS"));
        animals2.add(new Animal("LIGHT", "MID", "ALL"));
        animals2.add(animals1.get(0));

        ArrayList<Animal> resultAnimals = animalRepo.operateOr(animals1, animals2);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();
        for (Animal animal : animals1)
            expectedAnimals.add(animal);
        for (int i = 0; i < 3; i++)
            expectedAnimals.add(animals2.get(i));

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testOperateOr3() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals1 = new ArrayList<>();

        ArrayList<Animal> animals2 = new ArrayList<>();
        animals2.add(new Animal("LIGHT", "SMALL", "ALL"));
        animals2.add(new Animal("LIGHT", "SMALL", "GRASS"));
        animals2.add(new Animal("LIGHT", "MID", "ALL"));

        ArrayList<Animal> resultAnimals = animalRepo.operateOr(animals1, animals2);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();
        for (Animal animal : animals2)
            expectedAnimals.add(animal);

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testOperateOr4() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals1 = new ArrayList<>();
        animals1.add(new Animal("LIGHT", "SMALL", "ALL"));
        animals1.add(new Animal("LIGHT", "SMALL", "GRASS"));
        animals1.add(new Animal("LIGHT", "MID", "ALL"));

        ArrayList<Animal> animals2 = new ArrayList<>();

        ArrayList<Animal> resultAnimals = animalRepo.operateOr(animals1, animals2);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();
        for (Animal animal : animals1)
            expectedAnimals.add(animal);

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testFindByWeight1() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("LIGHT", "SMALL", "ALL"));
        animals.add(new Animal("HEAVY", "SMALL", "GRASS"));
        animals.add(new Animal("LIGHT", "MID", "ALL"));
        animals.add(new Animal("HEAVY", "MID", "GRASS"));

        animalRepo.setAnimals(animals);

        ArrayList<Animal> resultAnimals = animalRepo.findByWeight("HEAVY", true);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();
        expectedAnimals.add(animals.get(1));
        expectedAnimals.add(animals.get(3));

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testFindByWeight2() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("LIGHT", "SMALL", "ALL"));
        animals.add(new Animal("HEAVY", "SMALL", "GRASS"));
        animals.add(new Animal("LIGHT", "MID", "ALL"));
        animals.add(new Animal("HEAVY", "MID", "GRASS"));

        animalRepo.setAnimals(animals);

        ArrayList<Animal> resultAnimals = animalRepo.findByWeight("HEAVY", false);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();
        expectedAnimals.add(animals.get(0));
        expectedAnimals.add(animals.get(2));

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testFindByHeight1() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("LIGHT", "SMALL", "ALL"));
        animals.add(new Animal("HEAVY", "SMALL", "GRASS"));
        animals.add(new Animal("LIGHT", "MID", "ALL"));
        animals.add(new Animal("HEAVY", "MID", "GRASS"));

        animalRepo.setAnimals(animals);

        ArrayList<Animal> resultAnimals = animalRepo.findByHeight("SMALL", true);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();
        expectedAnimals.add(animals.get(0));
        expectedAnimals.add(animals.get(1));

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testFindByHeight2() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("LIGHT", "SMALL", "ALL"));
        animals.add(new Animal("HEAVY", "SMALL", "GRASS"));
        animals.add(new Animal("LIGHT", "MID", "ALL"));
        animals.add(new Animal("HEAVY", "MID", "GRASS"));

        animalRepo.setAnimals(animals);

        ArrayList<Animal> resultAnimals = animalRepo.findByHeight("SMALL", false);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();
        expectedAnimals.add(animals.get(2));
        expectedAnimals.add(animals.get(3));

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testFindByFoodType1() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("LIGHT", "SMALL", "ALL"));
        animals.add(new Animal("HEAVY", "SMALL", "GRASS"));
        animals.add(new Animal("LIGHT", "MID", "ALL"));
        animals.add(new Animal("HEAVY", "MID", "GRASS"));

        animalRepo.setAnimals(animals);

        ArrayList<Animal> resultAnimals = animalRepo.findByFoodType("ALL", true);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();
        expectedAnimals.add(animals.get(0));
        expectedAnimals.add(animals.get(2));

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testFindByFoodType2() {
        AnimalRepo animalRepo = new AnimalRepo();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("LIGHT", "SMALL", "ALL"));
        animals.add(new Animal("HEAVY", "SMALL", "GRASS"));
        animals.add(new Animal("LIGHT", "MID", "ALL"));
        animals.add(new Animal("HEAVY", "MID", "GRASS"));

        animalRepo.setAnimals(animals);

        ArrayList<Animal> resultAnimals = animalRepo.findByFoodType("ALL", false);
        ArrayList<Animal> expectedAnimals = new ArrayList<>();
        expectedAnimals.add(animals.get(1));
        expectedAnimals.add(animals.get(3));

        return areEqual(resultAnimals, expectedAnimals);
    }

    private static boolean testGetAnimalsFromFile1() throws FileNotFoundException {
        FileHandler fileHandler = new FileHandler();
        String pathToAnimals = "D:\\Projects\\Java\\AnimalAccountingSystem\\src\\test\\inputData\\animals1.txt";
        ArrayList<Animal> resultAnimals = fileHandler.getAnimalsFromFile(pathToAnimals);

        return resultAnimals.size() == 8;
    }

    private static boolean testGetAnimalsFromFile2() throws FileNotFoundException {
        FileHandler fileHandler = new FileHandler();
        String pathToAnimals = "D:\\Projects\\Java\\AnimalAccountingSystem\\src\\test\\inputData\\animals2.txt";
        ArrayList<Animal> resultAnimals = fileHandler.getAnimalsFromFile(pathToAnimals);

        return resultAnimals.size() == 2;
    }

    private static boolean testGetAnimalsFromFile3() throws FileNotFoundException {
        FileHandler fileHandler = new FileHandler();
        String pathToAnimals = "D:\\Projects\\Java\\AnimalAccountingSystem\\src\\test\\inputData\\animals3.txt";
        ArrayList<Animal> resultAnimals = fileHandler.getAnimalsFromFile(pathToAnimals);

        return resultAnimals.size() == 0;
    }

    private static boolean testDoRequest1() throws FileNotFoundException {
        FileHandler fileHandler = new FileHandler();
        String pathToAnimals = "D:\\Projects\\Java\\AnimalAccountingSystem\\src\\test\\inputData\\animals1.txt";
        AnimalRepo animalRepo = new AnimalRepo();
        animalRepo.setAnimals(
                fileHandler.getAnimalsFromFile(pathToAnimals)
        );

        String pathToTask = "D:\\Projects\\Java\\AnimalAccountingSystem\\src\\test\\tasks\\task1.txt";

        int expectedNumber = 2;

        return fileHandler.doRequest(animalRepo, pathToTask) == expectedNumber;
    }

    private static boolean testDoRequest2() throws FileNotFoundException {
        FileHandler fileHandler = new FileHandler();
        String pathToAnimals = "D:\\Projects\\Java\\AnimalAccountingSystem\\src\\test\\inputData\\animals1.txt";
        AnimalRepo animalRepo = new AnimalRepo();
        animalRepo.setAnimals(
                fileHandler.getAnimalsFromFile(pathToAnimals)
        );

        String pathToTask = "D:\\Projects\\Java\\AnimalAccountingSystem\\src\\test\\tasks\\task2.txt";

        int expectedNumber = 4;

        return fileHandler.doRequest(animalRepo, pathToTask) == expectedNumber;
    }

    private static boolean testDoRequest3() throws FileNotFoundException {
        FileHandler fileHandler = new FileHandler();
        String pathToAnimals = "D:\\Projects\\Java\\AnimalAccountingSystem\\src\\test\\inputData\\animals1.txt";
        AnimalRepo animalRepo = new AnimalRepo();
        animalRepo.setAnimals(
                fileHandler.getAnimalsFromFile(pathToAnimals)
        );

        String pathToTask = "D:\\Projects\\Java\\AnimalAccountingSystem\\src\\test\\tasks\\task3.txt";

        int expectedNumber = 4;

        return fileHandler.doRequest(animalRepo, pathToTask) == expectedNumber;
    }

    private static boolean areEqual(
            ArrayList<Animal> resultAnimals,
            ArrayList<Animal> expectedAnimals
    ) {
        if (resultAnimals.size() != expectedAnimals.size())
            return false;

        for (Animal animal : resultAnimals)
            if (!expectedAnimals.contains(animal))
                return false;

        return  true;
    }

    static void checkAnimals(ArrayList<Animal> animals) {
        for (Animal animal : animals)
            System.out.println("Weight: " + animal.getWeight() + " " +
                    "Height: " + animal.getHeight() + " " + "Type: " + animal.getFoodType());
    }

    static void checkAnimal(Animal animal) {
        System.out.println("Weight: " + animal.getWeight() + " " +
                "Height: " + animal.getHeight() + " " + "Type: " + animal.getFoodType());
    }
}