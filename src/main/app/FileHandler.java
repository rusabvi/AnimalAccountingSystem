package main.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    public ArrayList<Animal> getAnimalsFromFile(String pathToFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(pathToFile));
        scanner.useDelimiter("\n");     // для прохода именно по строкам
        ArrayList<Animal> animals = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.next();               // = "GREEN, LIGHT, SMALL"
            String[] words = line.split(", ");    // = ["GREEN", "LIGHT", "SMALL"]

            try {
                Animal animal = new Animal(words[0], words[1], words[2]);
                animals.add(animal);
            } catch (Exception e) {
                System.out.println("Wrong input data");
            }
        }

        scanner.close();

        return animals;
    }

    public int doRequest(AnimalRepo animalRepo, String pathToFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(pathToFile));
        scanner.useDelimiter("\n");     // для прохода именно по строкам
        ArrayList<ArrayList<Animal>> animalsList = new ArrayList<>();   // список списков животных - для последующего пересечения их

        String line = scanner.next();                   // = "weight: GREEN or RED or not BLACK, height: LIGHT, foodType: SMALL"
        scanner.close();

        String[] wordPairs = line.split(", ");    // = ["weight: GREEN or RED or not BLACK", "height: LIGHT", "foodType: SMALL"]

        for (String wordPair : wordPairs) {             // = "weight: GREEN or RED or not BLACK"
            ArrayList<Animal> animals = new ArrayList<>();
            String[] words = wordPair.split(": ");          // = ["weight", "GREEN or RED or not BLACK"]
            String parameter = words[0];                          // = "weight"
            String[] valuePairs = words[1].split(" or ");   // = ["GREEN", "RED", "not BLACK"]

            for (String valuePair : valuePairs) {                   // "not BLACK"
                boolean toChooseThis = !valuePair.contains("not ");
                String value;
                if (toChooseThis)
                    value = valuePair.split("not ")[0];
                else
                    value = valuePair.split("not ")[1];     // = "BLACK"

                if (parameter.equals("weight"))
                    animals = animalRepo.operateOr(
                            animals,
                            animalRepo.findByWeight(value, toChooseThis)
                    );

                else if (parameter.equals("height"))
                    animals = animalRepo.operateOr(
                            animals,
                            animalRepo.findByHeight(value, toChooseThis)
                    );

                else if (parameter.equals("foodType"))
                    animals = animalRepo.operateOr(
                            animals,
                            animalRepo.findByFoodType(value, toChooseThis)
                    );
            }
            animalsList.add(animals);
        }

        ArrayList<Animal> resultAnimals = animalsList.get(0);
        for (int i = 1; i < animalsList.size(); i++)
            resultAnimals = animalRepo.operateAnd(resultAnimals, animalsList.get(i));

        return resultAnimals.size();
    }
}