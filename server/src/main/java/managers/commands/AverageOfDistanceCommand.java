package managers.commands;

import managers.BaseCommandInterface;
import managers.CollectionManager;
import network.Task;

//Команда выводит среднее значение поля distance для всех элементов коллекции

public class AverageOfDistanceCommand implements BaseCommandInterface {
    @Override
    public Task execute(Task task, CollectionManager collectionManager) throws Exception {
        return new Task(new String[]{"Среднее значение поля distance:" + collectionManager.getAverageOfDistance()});
    }
    @Override
    public String getName() {
        return "average_of_distance";
    }
    @Override
    public String getDescription() {
        return "Команда выводит среднее значение поля distance для всех элементов коллекции";
    }
}
