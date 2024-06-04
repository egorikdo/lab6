package data;

import data.generators.IdGenerator;
import managers.Validator;

import java.io.Serializable;
import java.time.LocalDateTime;
public class Route implements Comparable<Route>, Serializable {//"Маршрут"
    private Long id; //id маршрута
    //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //название маршрута
    //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Координаты
    //Поле не может быть null
    private LocalDateTime creationDate; //Дата создания
    //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //начало маршрута
    //Поле не может быть null
    private Location to; //конец маршрута
    //Поле не может быть null
    private Double distance; //дистанция
    //Значение поля должно быть больше 1

    public Route() { //Базовый конструктор
        this.id = IdGenerator.generateId();
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDateTime.now();
        this.from = null;
        this.to = null;
        this.distance = null;
    }

    public Route(Long id) { //Конструктор с заданным id
        this.id = id;
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDateTime.now();
        this.from = null;
        this.to = null;
        this.distance = null;
    }

    public Route(String[] data) throws Exception { //Конструктор с данными, проверка корректности значений

        Validator.idIsOk(data[1]);
        Validator.notNull(data[2], "NAME");
        Validator.xCoordinateIsOk(data[3]);
        Validator.yCoordinateIsOk(data[4]);
        Validator.notNull(data[5], "DATE");
        Validator.notNull(data[6], "FromX");
        Validator.notNull(data[7], "FromY");
        Validator.notNull(data[8], "FromZ");
        Validator.notNull(data[9], "FromNAME");
        Validator.notNull(data[10], "ToX");
        Validator.notNull(data[11], "ToY");
        Validator.notNull(data[12], "ToZ");
        Validator.notNull(data[13], "ToNAME");
        Validator.distanceIsOk(data[14]);

        this.id = Long.parseLong(data[1]);
        this.name = data[2];
        this.coordinates = new Coordinates(Long.parseLong(data[3]), Long.parseLong(data[4]));
        this.creationDate = LocalDateTime.parse(data[5]);
        this.from = new Location(Float.parseFloat(data[6]), Float.parseFloat(data[7]), Float.parseFloat(data[8]), data[9]);
        this.to = new Location(Float.parseFloat(data[10]), Float.parseFloat(data[11]), Float.parseFloat(data[12]), data[13]);
        this.distance = Double.parseDouble(data[14]);
    }

    //Конвертация данных в строку для XML
    public String toXML() {
        return "id=\"" + id + "\"" +
                " name=\"" + name + "\"" +
                " x=\"" + coordinates.getX() + "\"" +
                " y=\"" + coordinates.getY() + "\"" +
                " creationDate=\"" + creationDate + "\"" +
                " FromX=\"" + from.getX() + "\"" +
                " FromY=\"" + from.getY() + "\"" +
                " FromZ=\"" + from.getZ() + "\"" +
                " FromNAME=\"" + from.getName() + "\"" +
                " ToX=\"" + to.getX() + "\"" +
                " ToY=\"" + to.getY() + "\"" +
                " ToZ=\"" + to.getZ() + "\"" +
                " ToNAME=\"" + to.getName() + "\"" +
                " distance=\"" + distance + "\"";
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", from=" + from +
                ", to=" + to +
                ", distance=" + distance +
                '}';
    }
    //Геттеры и сеттеры полей класса

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Coordinates getCoordinates() { return coordinates; }
    public void setCoordinates(Coordinates coordinates) { this.coordinates = coordinates; }
    public LocalDateTime getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }
    public Location getFrom() { return from; }
    public void setFrom(Location from) { this.from = from; }
    public Location getTo() { return to; }
    public void setTo(Location to) { this.to = to; }
    public Double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    @Override
    public int compareTo(Route r) {
        Long id = this.id;
        return id.compareTo(r.getId());
    }
}
