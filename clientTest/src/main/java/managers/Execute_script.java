package managers;


import data.generators.RouteGenerator;
import network.Client;
import network.Task;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Execute_script {
    private ArrayList<String> listOfPaths= new ArrayList<>();

    public void readScript(String path, Client client, RouteGenerator routeGenerator) throws IOException, ClassNotFoundException {
        FileReader fileReader= new FileReader(path);
        if (!fileReader.ready()){
            System.out.println("Что то непраильно с файлом");
        }
        else {
            Scanner scanner = new Scanner(fileReader);
            String[] commandComponents;

            try{
                while (scanner.hasNextLine()) {
                    String command = scanner.nextLine().trim();
                    commandComponents = (command + " ").split(" ", 2);
                    commandComponents[1] = commandComponents[1].trim();
                    if (!Objects.equals(commandComponents[0], "execute_script")) {
                        Task task = new Task(commandComponents);
                        if (task.describe[0].equals("insert") ||
                                task.describe[0].equals("remove_greater") ||
                                task.describe[0].equals("remove_lower")){
                            System.out.println("Введите ID");
                            long id = scanner.nextLong();
                            scanner.nextLine(); // Проглотить символ новой строки
                            task.route = routeGenerator.createRoute(id, scanner);
                        }
                        if (task.describe[0].equals("update_id")){
                            task.route = routeGenerator.createRoute(Long.valueOf(task.describe[1]), scanner);
                        }
                        if (task.describe[0].equals("exit")){
                            System.exit(0);
                        }
                        client.sendTask(task);
                    } else {
                        if (!listOfPaths.contains(commandComponents[1])) {
                            listOfPaths.add(commandComponents[1]);
                            readScript(commandComponents[1], client, routeGenerator);
                        }
                    }
                }
            }
            catch (Exception e){
            }
        }
    }
}
