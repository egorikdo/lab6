package managers.commands;

import data.Route;
import data.generators.IdGenerator;
import data.generators.RouteGenerator;
import managers.BaseCommandInterface;
import managers.CollectionManager;
import network.Task;

import java.util.Hashtable;
import java.util.Scanner;

//Команда удаляет из коллекции все элементы, меньше, чем заданный
public class RemoveLowerCommand implements BaseCommandInterface {

    @Override
    public Task execute(Task task, CollectionManager collectionManager) throws Exception {
        Hashtable<String, Route> table = collectionManager.getTable();
        String answer = new String();

        boolean removed = false;
        for(Route route: table.values()){
            if(route.compareTo(task.route)<0){
                removed = true;
                break;
            }
        }
        if (removed) {
            table.put(String.valueOf(task.route.getId()),task.route);
            answer = ("Элементы удалены");

        } else {
            answer = ("В коллекции нет элементов, меньших, чем заданный");
        }
        return new Task(new String[]{answer});
    }


    @Override
    public String getName() { return "remove_lower"; }

    @Override
    public String getDescription() { return "Команда удаляет из коллекции все элементы, меньше, чем заданный"; }
}

