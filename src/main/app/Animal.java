package main.app;

public class Animal {
    private String weight;
    private String height;
    private String foodType;

    public Animal(
            String weight,
            String height,
            String foodType
    ) {
        this.weight = weight;
        this.height = height;
        this.foodType = foodType;
    }

    public String getWeight() { return weight; }
    public String getHeight() { return height; }
    public String getFoodType() { return foodType; }
}