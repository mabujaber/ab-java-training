package ab.training.lambda;

import java.util.ArrayList;
import java.util.List;

public class Apple {
    private String farmerName;
    private int weight = 0;
    private String color = "";


    public Apple(String farmerName,int weight, String color){
        this.weight = weight;
        this.color = color;
        this.farmerName = farmerName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static List<Apple> createApples() {

        List<Apple> apples = new ArrayList<>();
        apples.add(
                new Apple(
                        "Del Monte",
                        10, "green"));
        apples.add(
                new Apple(
                        "Astra",
                        20, "green"));
        apples.add(
                new Apple(
                        "Sharbatly",
                        40,
                        "red"));
        apples.add(
                new Apple(
                        "Goldfruit",
                        75,
                        "red"));

        return apples;
    }
}
