package managers;

import data.Route;
import data.generators.IdGenerator;
import exception.NoElementException;

import java.time.LocalDateTime;
import java.util.Hashtable;


public class CollectionManager { //взаимодействие с коллекцией. Коллекция команд
    public Hashtable<String, Route> table = new Hashtable<>();
    public LocalDateTime date;

    public CollectionManager() { //Базовый конструктор
        table = new Hashtable<>();
        date = LocalDateTime.now();
        new IdGenerator();
    }

    public LocalDateTime getInDate() {
        return date;
    } //Получить дату инициализации

    public void add(String key, Route route) { //добавить маршрут по ключу
        if (table == null) {
            table = new Hashtable<>();
        }
        table.put(key, route);
        IdGenerator.add(route.getId());
    }

    public void remove(String key) throws NoElementException { //Удалить маршрут по ключу
        if (table == null || !CollectionManager.this.table.containsKey(key)) {
            throw new NoElementException(key);
        } else {
            IdGenerator.remove(CollectionManager.this.table.get(key).getId());
            table.remove(key);
        }
    }

    public Double getAverageOfDistance() {
        if (table == null) {
            return (double) 0;
        }
        int count = 0;
        for (String key : table.keySet()) {
            count += table.get(key).getDistance();
        }
        return (double) (count / table.size());
    }

    public Hashtable<String, Route> getTable() { return this.table; } //получение коллекции
}