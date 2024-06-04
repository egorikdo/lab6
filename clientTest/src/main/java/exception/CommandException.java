package exception;

import system.Color;
public class CommandException extends Exception{ //исключение неизвестной команды

    public CommandException(String command){
        super(Color.ANSI_RED + "Неизвестная команда: " + command + Color.ANSI_RESET);
    }

}
