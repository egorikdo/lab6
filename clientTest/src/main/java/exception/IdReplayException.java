package exception;

import data.generators.IdGenerator;
import system.Color;
public class IdReplayException extends Exception{ //сключение повторяющегося id

    public IdReplayException(long id) {
        super(Color.ANSI_RED + "Такой id уже существует: " + id + Color.ANSI_RESET);
    }

}
