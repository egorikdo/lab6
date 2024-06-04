package managers.commands;

import managers.BaseCommandInterface;
import managers.CollectionManager;
import managers.CommandManager;
import network.Task;

//Команда выводит последние команды
public class HistoryCommand implements BaseCommandInterface {
    @Override
    public Task execute(Task task, CollectionManager collectionManager) throws Exception {
        String[] sp = new String[6];
        String answer = new String();
        int n = 0;
        for (BaseCommandInterface command : CommandManager.lastCommands) {
            sp[n] = command.getName();
            n += 1;
        }
        for (int i = 0; i < 6; i++) {
            if (!(sp[i] == null)) {
                answer = answer + "-" + sp[i]+"\n";
            }
        }
        return new Task(new String[]{answer});
    }

    @Override
    public String getName() { return "history"; }

    @Override
    public String getDescription() {return "Команда выводит последние команды"; }
}
