package managers.commands;

import managers.BaseCommandInterface;
import managers.CollectionManager;
import managers.CommandManager;
import network.Task;
import system.Color;

import java.util.LinkedHashMap;

//Команда выводит описание всех команд

public class HelpCommand implements BaseCommandInterface {
    @Override
    public Task execute(Task task, CollectionManager collectionManager) throws Exception{
        CommandManager commandManager = new CommandManager();
        LinkedHashMap<String, BaseCommandInterface> commandList = commandManager.getCommandList();
        return new Task(new String[]{"help: вывести справку по доступным командам\n" +
                "• info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "• show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "• insert null {element} : добавить новый элемент с заданным ключом\n" +
                "• update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "• remove_key null : удалить элемент из коллекции по его ключу\n" +
                "• clear : очистить коллекцию\n" +
                "• save : сохранить коллекцию в файл\n" +
                "• execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "• exit : завершить программу (без сохранения в файл)\n" +
                "• remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                "• remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "• remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный\n" +
                "• average_of_distance : вывести среднее значение поля distance для всех элементов коллекции"});
    }
    @Override
    public String getName() {
        return "help";
    }
    @Override
    public String getDescription() {
        return "Получить информации о доступных командах";
    }
}
