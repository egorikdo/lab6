package managers.commands;

import data.Route;
import managers.BaseCommandInterface;
import managers.CollectionManager;
import network.Task;

import java.util.Hashtable;

//Команда выводит все элементы коллекции в строковом представлении
public class ShowCommand implements BaseCommandInterface {
    @Override
    public Task execute(Task task, CollectionManager collectionManager) throws Exception {
        String answer = new String();
        Hashtable<String, Route> table = collectionManager.getTable();
        for (String x : table.keySet()) {
            answer+= (table.get(x))+"\n";
        }
        if (table.isEmpty()) {
            answer = (collectionManager.getTable().getClass().getName() + " пусто");
        }
        return new Task(new String[]{answer});
    }
    @Override
    public String getName() {
        return "show";
    }
    @Override
    public String getDescription() {
        return "Команда выводит все элементы коллекции в строковом представлении";
    }
}
