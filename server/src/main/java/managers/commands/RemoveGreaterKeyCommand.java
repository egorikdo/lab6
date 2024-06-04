package managers.commands;

import data.Route;
import managers.BaseCommandInterface;
import managers.CollectionManager;
import network.Task;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

//Команда удаляет из коллекции все элементы, ключ которых превышает заданный
public class RemoveGreaterKeyCommand implements BaseCommandInterface {

    @Override
    public Task execute(Task task, CollectionManager collectionManager) throws Exception {
        Hashtable<String, Route> table = collectionManager.getTable();
        String answer= new String();
        boolean removed = false;
        Iterator<Route> iterator = table.values().iterator();
        while (iterator.hasNext()) {
            Route route = iterator.next();
            if (Long.parseLong(task.describe[1]) < route.getId()) {
                iterator.remove();
                removed = true;
            }
        }

        if (removed) {
            answer= ("Элементы удалены");
        } else {
            answer = ("В коллекции нет элементов, ключи которых больше заданного");
        }
        return new Task(new String[]{answer});
    }

    @Override
    public String getName() {
        return "remove_greater_key";
    }

    @Override
    public String getDescription() { return "Команда удаляет из коллекции все элементы, ключ которых превышает заданный"; }
}
