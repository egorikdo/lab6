package data;

import java.io.Serializable;

public class Coordinates implements Serializable {

    private Long x;
    //Поле не может быть null
    private Long y;
    //Максимальное значение поля: 896, Поле не может быть null

    public Coordinates(Long x, Long y) {//Базовый конструктор
        this.x = x;
        this.y = y;
    }

    //Геттеры и сеттеры полей класса
    public Long getX() { return x; }
    public void setX(Long x) { this.x = x; }
    public Long getY() { return y; }
    public void setY(Long y) { this.y = y; }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
