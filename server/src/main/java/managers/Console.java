package managers;

import network.Task;
import system.Color;
import system.XMLreader;

import java.io.InputStream;
import java.util.Scanner;

public class Console { //чтение командной строки

    public static String data_path;
    public CollectionManager start(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        try {
            System.out.println("Загрузка данных из файла...");
            XMLreader.read("file.xml", false, collectionManager);
            data_path = "file.xml";
            System.out.println(Color.ANSI_CYAN + "Все в порядке" + Color.ANSI_RESET);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при чтении файла\n" + "file.xml");
            System.exit(0);
        }
        return collectionManager;

    }

    public Task processTask(Task task, CollectionManager collectionManager) throws Exception {
        CommandManager commandManager = new CommandManager();
        return commandManager.startExecuting(task, collectionManager);
    }

}
