package managers.commands;

import managers.BaseCommandInterface;
import managers.CollectionManager;
import network.Task;

//Команда очищает коллекцию

public class ClearCommand implements BaseCommandInterface {
    @Override
    public Task execute(Task task, CollectionManager collectionManager) throws Exception {
        collectionManager.getTable().clear();
        return new Task(new String[]{"Коллекция очищена"});
    }
    @Override
    public String getName() {
        return "clear";
    }
    @Override
    public String getDescription() {
        return "Команда очищает коллекцию";
    }
}
