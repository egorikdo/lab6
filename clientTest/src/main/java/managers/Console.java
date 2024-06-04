package managers;

import data.generators.RouteGenerator;
import network.Client;
import network.Task;
import system.Color;


import java.io.InputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Console {

    public void start() throws SocketException, UnknownHostException {
        Client client = new Client();
        Scanner scanner= new Scanner(System.in);
        RouteGenerator routeGenerator = new RouteGenerator();
        Execute_script executeScript= new Execute_script();
        while (scanner.hasNextLine()) {
            String[] command = scanner.nextLine().trim().split(" ");
            if (!(command.length ==0)){
                try {
                    Task task = new Task(command);
                    if (task.describe[0].equals("insert") ||
                            task.describe[0].equals("remove_greater") ||
                            task.describe[0].equals("remove_lower")) {
                        System.out.println("Введите ID");
                        long id = scanner.nextLong();
                        scanner.nextLine(); // Проглотить символ новой строки
                        task.route = routeGenerator.createRoute(id, scanner);
                    }
                    if (task.describe[0].equals("update_id")) {
                        task.route = routeGenerator.createRoute(Long.valueOf(task.describe[1]), scanner);
                    }
                    if (task.describe[0].equals("execute_script")) {
                        executeScript.readScript(task.describe[1], client, routeGenerator);
                        continue;
                    }

                    if (task.describe[0].equals("exit")){
                        System.exit(0);
                    }
                    client.sendTask(task);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }


}
