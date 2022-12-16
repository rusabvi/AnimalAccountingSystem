package main.app;

import java.util.ArrayList;

public class AnimalRepo {
    private ArrayList<Animal> animals;

    public AnimalRepo() { animals = new ArrayList<>(); }

    public void setAnimals(ArrayList<Animal> animals) { this.animals = animals; }
    public ArrayList<Animal> getAnimals() { return animals; }

    // Переменная toChooseThis в следующих методах определяет, искать животных по равенству или неравенству
    //      параметра (weight, height, type). toChooseThis == false эквивалентно "НЕ"
    // Пример: вызов findByWeight("МАЛЕНЬКОЕ", true)
    //      вернёт список животных, у которых weight == "МАЛЕНЬКОЕ",
    // а вызов findByWeight("МАЛЕНЬКОЕ", false)
    //      вернёт список животных, у которых weight != "МАЛЕНЬКОЕ"

    public ArrayList<Animal> findByWeight(String weight, boolean toChooseThis) {
        ArrayList<Animal> animals = new ArrayList<>();
        for (Animal animal : this.animals) {
            if (animal.getWeight().equals(weight) == toChooseThis)  // вес совпал и выбор нужен по этому параметру
                animals.add(animal);
        }

        return animals;
    }

    public ArrayList<Animal> findByHeight(String height, boolean toChooseThis) {
        ArrayList<Animal> animals = new ArrayList<>();
        for (Animal animal : this.animals)
            if (animal.getHeight().equals(height) == toChooseThis) // рост совпал и выбор нужен по этому параметру
                animals.add(animal);
        return animals;
    }

    public ArrayList<Animal> findByFoodType(String foodType, boolean toChooseThis) {
        ArrayList<Animal> animals = new ArrayList<>();
        for (Animal animal : this.animals)
            if (animal.getFoodType().equals(foodType) == toChooseThis) // тип совпал и выбор нужен по этому параметру
                animals.add(animal);
        return animals;
    }

    // Метод вовзращает пересечение списков, то есть список элементов, которые есть в обоих списках
    public ArrayList<Animal> operateAnd(ArrayList<Animal> animals1, ArrayList<Animal> animals2) {
        ArrayList<Animal> animals = new ArrayList<>();
        if (animals1.size() == 0 || animals2.size() == 0)
            return animals;

        for (Animal animal1 : animals1)
            for (Animal animal2 : animals2) {
                if (animal1 == animal2) {
                    animals.add(animal1);
                    break;
                }
            }

        return animals;
    }

    // Метод вовзращает объединение двух списков без повторов элементов
    public ArrayList<Animal> operateOr(ArrayList<Animal> animals1, ArrayList<Animal> animals2) {
        ArrayList<Animal> animals = new ArrayList<>();
        if (animals1.size() == 0 && animals2.size() == 0)
            return animals;

        for (Animal animal : animals1)
            animals.add(animal);

        for (Animal animal : animals2)
            if (!animals.contains(animal))
                animals.add(animal);

        return animals;
    }
}