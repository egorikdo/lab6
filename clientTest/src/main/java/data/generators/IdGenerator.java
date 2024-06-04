package data.generators;

import java.lang.Math;
import java.util.ArrayList;
public class IdGenerator {
    private static final Integer min = 1000000;
    private static final Integer max = 10000000;
    private static ArrayList<Long> IdList = new ArrayList<>();

    public IdGenerator() {//Базовый конструктор
        IdList = new ArrayList<>();
    }

    public static Long generateId() { //Метод генерирует новый уникальный Id
        Long id = (long) Math.floor(Math.random() * (max - min + 1)) + min;
        while (IdList.contains(id)) {
            id = (long) Math.floor(Math.random() * (max - min + 1)) + min;
        }
        IdList.add(id);
        return id;
    }

    public static boolean checkIdUnique(long id) { //Проверяет Id на уникальность
        if(IdList.contains(id)) {
            return false;
        }
        return true;
    }

    public static void add(long id) {//Добавляет Id в список
        IdList.add(id);
    }

    public static void remove(long id) {//Убирает Id из списка
        IdList.remove(id);
    }
}
