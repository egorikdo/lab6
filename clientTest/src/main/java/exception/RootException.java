package exception;

import system.Color;
public class RootException extends Exception{ //root exception позволяет создать иерархию исключений

    public RootException(String message) {
        super(Color.ANSI_RED + message + Color.ANSI_RESET);
    }
}
