package managers.commands;


import managers.BaseCommandInterface;
import managers.CollectionManager;
import managers.Console;
import network.Task;
import system.Color;
import system.XMLwriter;


//Команда сохраняет коллекцию в файл (XML)
public class SaveCommand implements BaseCommandInterface {
    @Override
    public Task execute(Task task, CollectionManager collectionManager) throws Exception {
        XMLwriter.write(Console.data_path, collectionManager);
        return new Task(new String[]{(Color.ANSI_CYAN + "Данные сохранены в:" + Color.ANSI_RESET + "\n" + Console.data_path)});
    }
    @Override
    public String getName() {
        return "Save";
    }
    @Override
    public String getDescription() {
        return "Команда сохраняет коллекцию в файл";
    }
}
