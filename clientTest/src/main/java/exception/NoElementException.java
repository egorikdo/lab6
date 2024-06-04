package exception;

import system.Color;
public class NoElementException extends Exception{ //исключение в случае отсутствия элемента в коллекции

    public NoElementException(long id){ //исключение по id
        super(Color.ANSI_RED + "В коллекции нет элемента с таким id: " + id + Color.ANSI_RESET);
    }

    public NoElementException(String key){ //исключение по ключу
        super(Color.ANSI_RED + "В коллекции нет элемента с такием ключом: " + key + Color.ANSI_RESET);
    }
}
