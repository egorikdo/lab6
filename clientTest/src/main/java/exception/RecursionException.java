package exception;

import system.Color;
public class RecursionException extends Exception{ //исключение позволяет выявить в файле рекурсию

    public RecursionException() {
        super(Color.ANSI_RED + "В файле рекурсия" + Color.ANSI_RESET);
    }
}
