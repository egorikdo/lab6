package data.generators;

import data.Coordinates;
import data.Location;
import data.Route;
import exception.ArgumentException;
import exception.BuildRouteObjException;
import managers.Validator;
import system.Color;

import java.sql.SQLOutput;
import java.util.Scanner;

public class RouteGenerator { //Класс генерирует объект Route

    public Route createRoute(Long id, Scanner scanner) throws ArgumentException, BuildRouteObjException {
        //Метод поэтапно запрашивает данные и проверяет их
        System.out.println(Color.ANSI_CYAN + "Добро пожаловвать в генератор маршрута" + Color.ANSI_RESET);
        String input, a, b, c, d;
        Coordinates coordinates;
        Location from;
        Location to;


        Route route; //id
        if (id == 0) {
            route = new Route();
        } else {
            route = new Route(id);
        }

        while (true) { //name
            try {
                System.out.print("Введите имя (" + Color.ANSI_PURPLE + "String" + Color.ANSI_RESET + "): ");
                input = scanner.nextLine();
                Validator.notNull(input, "NAME");
                route.setName(input);
                break;
            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) { //x coordinate
            try {
                System.out.print("Введите x (" + Color.ANSI_PURPLE + "Long" + Color.ANSI_RESET + ") не равный 0: ");
                input = scanner.nextLine();
                Validator.xCoordinateIsOk(input);
                a = input;
                break;
            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) { //y coordinate
            try {
                System.out.print("Введите y (" + Color.ANSI_PURPLE + "Long" + Color.ANSI_RESET + ") <= 896: ");
                input = scanner.nextLine();
                Validator.yCoordinateIsOk(input);
                b = input;
                break;
            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        coordinates = new Coordinates(Long.parseLong(a), Long.parseLong(b));
        route.setCoordinates(coordinates);

        while (true) { //ToX
            try {
                System.out.print("Введите координату X старта маршрута (" + Color.ANSI_PURPLE + "Float" + Color.ANSI_RESET + "): ");
                input = scanner.nextLine();
                Validator.notNull(input, "FromX");
                a = input;
                break;
            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) { //ToY
            try {
                System.out.print("Введите координату Y старта маршрута (" + Color.ANSI_PURPLE + "Float" + Color.ANSI_RESET + "): ");
                input = scanner.nextLine();
                Validator.notNull(input, "FromY");
                b = input;
                break;
            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) { //ToZ
            try {
                System.out.print("Введите координату Z старта маршрута (" + Color.ANSI_PURPLE + "Float" + Color.ANSI_RESET + "): ");
                input = scanner.nextLine();
                Validator.notNull(input, "FromZ");
                c = input;
                break;
            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) { //ToNAME
            try {
                System.out.print("Введите название локации, в которой начинается маршрут (" + Color.ANSI_PURPLE + "String" + Color.ANSI_RESET + "): ");
                input = scanner.nextLine();
                Validator.notNull(input, "FromNAME");
                d = input;
                break;
            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        from = new Location(Float.parseFloat(a), Float.parseFloat(b), Float.parseFloat(c), d);
        route.setFrom(from);

        while (true) { //ToX
            try {
                System.out.print("Введите координату X конца маршрута (" + Color.ANSI_PURPLE + "Float" + Color.ANSI_RESET + "): ");
                input = scanner.nextLine();
                Validator.notNull(input, "ToX");
                a = input;
                break;
            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) { //ToY
            try {
                System.out.print("Введите координату Y конца маршрута (" + Color.ANSI_PURPLE + "Float" + Color.ANSI_RESET + "): ");
                input = scanner.nextLine();
                Validator.notNull(input, "ToY");
                b = input;
                break;
            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) { //ToZ
            try {
                System.out.print("Введите координату Z конца маршрута (" + Color.ANSI_PURPLE + "Float" + Color.ANSI_RESET + "): ");
                input = scanner.nextLine();
                Validator.notNull(input, "ToZ");
                c = input;
                break;
            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) { //ToNAME
            try {
                System.out.print("Введите название локации, в которой заканчивается маршрут (" + Color.ANSI_PURPLE + "String" + Color.ANSI_RESET + "): ");
                input = scanner.nextLine();
                Validator.notNull(input, "ToNAME");
                d = input;
                break;
            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        to = new Location(Float.parseFloat(a), Float.parseFloat(b), Float.parseFloat(c), d);
        route.setTo(to);

        while (true) {
            try {
                System.out.print("Введите значение дистанции (" + Color.ANSI_PURPLE + "Double" + Color.ANSI_RESET + ") > 1: ");
                input = scanner.nextLine();
                Validator.distanceIsOk(input);
                route.setDistance(Double.parseDouble(input));
                break;
            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Происходит генерация...");
        return route;
    }
}
