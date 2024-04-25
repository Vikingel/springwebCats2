package Vikingel.springwebcats2.entities;

public class Cat {
    private int id;
    private String name;
    private String color;
    private double age;

    public Cat(int id, String name, String color, double age) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
    }

    //if (cost < 0)
    //throw new Exception("отрицательная цена");


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }


}


