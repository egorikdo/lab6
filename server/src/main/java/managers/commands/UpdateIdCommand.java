package managers.commands;

import data.Route;
import data.generators.RouteGenerator;
import exception.NoElementException;
import managers.BaseCommandInterface;
import managers.CollectionManager;
import network.Task;
import system.Color;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;


//Команда обновляет элемент коллекции по ID
public class UpdateIdCommand implements BaseCommandInterface {
    @Override
    public Task execute(Task task, CollectionManager collectionManager) throws Exception {

        boolean elementInCollection = false;
        Long id = Long.parseLong(task.describe[1]);
        String answer = new String();
        String key_tmp;
        Hashtable<String, Route> hashtable = new Hashtable<>();
        List<String> key = new ArrayList<>(collectionManager.table.keySet());
        key.stream().forEach(it ->{
            if (!collectionManager.getTable().get(it).getId().equals(id)){
                hashtable.put(it, collectionManager.table.get(it));
            }
            else {
                hashtable.put(it, task.route);
            }
        });
        collectionManager.table =hashtable;
        return new Task(new String[]{"Успешное добавление"});
    }
    @Override
    public String getName() {
        return "update id {element}";
    }
    @Override
    public String getDescription() {
        return "Команда обновляет элемент коллекции по ID";
    }
}
