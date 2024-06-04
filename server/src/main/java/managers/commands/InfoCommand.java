package managers.commands;

import managers.BaseCommandInterface;
import managers.CollectionManager;
import network.Task;

//Команда выводит информацию о программе
public class InfoCommand implements BaseCommandInterface {
    @Override
    public Task execute(Task task, CollectionManager collectionManager) throws Exception {
        String answer = new String();
        answer+= "Тип данных: " + collectionManager.getTable().getClass().getName()+"\n";
        answer+= "Дата инициализации: " + collectionManager.getInDate()+"\n";
        answer+= "Количество маршрутов: " + collectionManager.getTable().size()+"\n";
        return new Task(new String[]{answer});
    }
    @Override
    public String getName() {
        return "info";
    }
    @Override
    public String getDescription() {
        return "Команда выводит информацию о программе";
    }
}
