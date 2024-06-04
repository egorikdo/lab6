package exception;

import system.Color;

public class ArgumentException extends Exception{ //исключение неправильно введенного аргумента

    public ArgumentException(String argument){
        super(Color.ANSI_RED + "Аргумент введен неверно: " + argument + Color.ANSI_RESET);
    }
}
