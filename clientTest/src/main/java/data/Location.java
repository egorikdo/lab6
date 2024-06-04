package data;

import java.io.Serializable;

public class Location implements Serializable {

    private Float x;
    //Поле не может быть null
    private Float y;
    //Поле не может быть null
    private Float z;
    //Поле не может быть null
    private String name;
    //Поле может быть null

    public Location(Float x, Float y, Float z, String name) {//Базовый конструктор
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", name='" + name + '\'' +
                '}';
    }

    //Геттеры и сеттеры полей класса
    public Float getX() { return x; }
    public void setX(Float x) { this.x = x; }
    public Float getY() { return y; }
    public void setY(Float y) { this.y = y; }
    public Float getZ() { return z; }
    public void setZ(Float z) { this.z = z; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
