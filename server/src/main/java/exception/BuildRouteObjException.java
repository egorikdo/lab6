package exception;

import system.Color;
public class BuildRouteObjException extends Exception{ //исключение в случае ошибки при создании объекта Route

    public BuildRouteObjException(String message) {
        super(Color.ANSI_RED + message + Color.ANSI_RESET);
    }
}
