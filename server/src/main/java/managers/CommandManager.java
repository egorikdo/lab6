package managers;

import exception.CommandException;
import managers.commands.*;
import network.Task;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;

public class CommandManager { //связь между командами и CollectionManger

    private static LinkedHashMap<String, BaseCommandInterface> commandList;
    public static ArrayDeque<BaseCommandInterface> lastCommands = new ArrayDeque<>();
    public CommandManager() {
        commandList = new LinkedHashMap<>();
        commandList.put("help", new HelpCommand());
        commandList.put("info", new InfoCommand());
        commandList.put("show", new ShowCommand());
        commandList.put("insert", new InsertNullCommand());
        commandList.put("update_id", new UpdateIdCommand());
        commandList.put("remove_key", new RemoveKeyCommand());
        commandList.put("clear", new ClearCommand());
        commandList.put("save", new SaveCommand());
        commandList.put("history", new HistoryCommand());
        commandList.put("remove_greater", new RemoveGreaterCommand());
        commandList.put("remove_lower", new RemoveLowerCommand());
        commandList.put("remove_greater_key", new RemoveGreaterKeyCommand());
        commandList.put("average_of_distance", new AverageOfDistanceCommand());
    }

    public static Task startExecuting(Task task, CollectionManager collectionManager) throws Exception {
        String commandName = task.describe[0];
        System.out.println(task.describe[0]);
        if (!commandList.containsKey(commandName)) {
            throw new CommandException(commandName);
        }
        BaseCommandInterface command = commandList.get(commandName);
        if (!(lastCommands == null) && lastCommands.size() == 14) {
            lastCommands.pop();
            lastCommands.addLast(command);
        } else {
            assert lastCommands != null;
            lastCommands.addFirst(command);
        }
        return command.execute(task, collectionManager);
    }

    public LinkedHashMap<String, BaseCommandInterface> getCommandList() {
        return commandList;
    }
}