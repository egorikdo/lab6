package managers.commands;
import exception.NoElementException;
import managers.BaseCommandInterface;
import managers.CollectionManager;
import network.Task;
import system.Color;

//Команда удаляет элемент из коллекции по его ключу
public class RemoveKeyCommand implements BaseCommandInterface {
    @Override
    public Task execute(Task task, CollectionManager collectionManager) throws Exception{
        System.out.println(Color.ANSI_CYAN + "Начало выполнения команды" + Color.ANSI_RESET);
        try {
            collectionManager.remove(task.describe[1]);
            return new Task(new String[]{(Color.ANSI_CYAN + "Элемент удален" + Color.ANSI_RESET)});
        } catch (NoElementException e) {
            System.out.println(Color.ANSI_RED + e.getMessage() + Color.ANSI_RESET);
            return new Task(new String[]{"Программа возвращена в безопасное состояние"});
        }
    }
    @Override
    public String getName() {
        return "remove_key null";
    }
    @Override
    public String getDescription() {
        return "Команда удаляет элемент из коллекции по его ключу";
    }
}
