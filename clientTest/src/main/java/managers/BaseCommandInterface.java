package managers;

import network.Task;

public interface BaseCommandInterface { // базовый интерфейс для реализации команд

    Task execute(Task task) throws Exception; // Метод для выводы исполнения команды
    String getName(); //метод для вывода названия команды
    String getDescription(); //метод для вывода описания команды

}
