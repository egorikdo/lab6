package managers;

import data.Route;
import data.generators.IdGenerator;
import exception.NoElementException;

import java.time.LocalDateTime;
import java.util.Hashtable;


public class CollectionManager { //взаимодействие с коллекцией. Коллекция команд
    private static Hashtable<String, Route> table = new Hashtable<>();
    private static LocalDateTime date;

    public CollectionManager() { //Базовый конструктор
        table = new Hashtable<>();
        date = LocalDateTime.now();
        new IdGenerator();
    }

    public static LocalDateTime getInDate() {
        return date;
    } //Получить дату инициализации

    public static void add(String key, Route route) { //добавить маршрут по ключу
        if (table == null) {
            table = new Hashtable<>();
        }
        table.put(key, route);
        IdGenerator.add(route.getId());
    }

    public static void remove(String key) throws NoElementException { //Удалить маршрут по ключу
        if (table == null || !CollectionManager.table.containsKey(key)) {
            throw new NoElementException(key);
        } else {
            IdGenerator.remove(CollectionManager.table.get(key).getId());
            table.remove(key);
        }
    }

    public static Double getAverageOfDistance() {
        if (table == null) {
            return (double) 0;
        }
        int count = 0;
        for (String key : table.keySet()) {
            count += table.get(key).getDistance();
        }
        return (double) (count / table.size());
    }

    public static Hashtable<String, Route> getTable() { return table; } //получение коллекции
}