package managers.commands;

import data.Route;
import data.generators.IdGenerator;
import data.generators.RouteGenerator;
import managers.BaseCommandInterface;
import managers.CollectionManager;
import network.Task;

import java.util.Hashtable;
import java.util.Scanner;

//Команда удаляет из коллекции все элементы, превышающие заданный

public class RemoveGreaterCommand implements BaseCommandInterface {

    @Override
    public Task execute(Task task, CollectionManager collectionManager) throws Exception {
        String answer= new String();
        Hashtable<String, Route> table = collectionManager.getTable();

        boolean removed = false;
        for (Route route: table.values()){
            if (route.compareTo(task.route)>0){
                removed = true;
                break;
            }
        }
        if (removed) {
            table.put(String.valueOf(task.route.getId()), task.route);
            answer= ("Элементы удалены");

        } else {
            answer=("В коллекции нет элементов, превышающих заданный");
        }
        return new Task(new String[]{answer});
    }


    @Override
    public String getName() { return "remove_greater"; }

    @Override
    public String getDescription() { return "Команда удаляет из коллекции все элементы, превышающие заданный"; }
}
