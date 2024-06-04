package managers.commands;

import data.Route;
import data.generators.RouteGenerator;
import exception.ArgumentException;
import exception.BuildRouteObjException;
import managers.BaseCommandInterface;
import managers.CollectionManager;
import network.Task;
import system.Color;

//Команда добавляет новый элемент по ключу

public class InsertNullCommand implements BaseCommandInterface {
    @Override
    public Task execute(Task task, CollectionManager collectionManager) throws ArgumentException {
        if (task.describe.length == 2 && !collectionManager.getTable().containsKey(task.describe[1])) {
            collectionManager.add(task.describe[1], task.route);
            return new Task(new String[]{Color.ANSI_CYAN + "Добавление элемента завершено" + Color.ANSI_RESET});
        }
        else throw new ArgumentException("KEY");
    }

    @Override
    public String getName() {
        return "insert null {element}";
    }

    @Override
    public String getDescription() {
        return "Команда добавляет новый элемент по ключу";
    }
}
