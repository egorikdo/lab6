package managers;

import data.generators.IdGenerator;
import exception.ArgumentException;
import exception.IdReplayException;

public class Validator { //проверка параметров Route

    public static void idIsOk(String arg) throws IdReplayException, ArgumentException { //arg- аргумент строки
        // повтор id или ошибка с аргументом
        long id;
        try {
            id = Long.parseLong(arg);
        } catch(Exception e) {
            throw new ArgumentException("ID");
        }

        if (!IdGenerator.checkIdUnique(id)) {
            throw new IdReplayException(id);
        }
    }

    public static void notNull(String arg, String dataType) throws ArgumentException { //arg- аргумент строки, dataType- проверяемый тип данных
        // значение строки null
        if (arg.isEmpty() || arg.trim().isEmpty()) {
            throw new ArgumentException(dataType);
        }
    }

    public static void distanceIsOk(String arg) throws ArgumentException { //arg- аргумент строки
        //значение поля дистанция >1
        try {
            double n = Double.parseDouble(arg);
            if (n <= 1) {
                throw new ArgumentException("distance");
            }
        } catch (Exception e) {
            throw new ArgumentException("distance");
        }
    }

    public static void xCoordinateIsOk(String arg) throws ArgumentException {
        try {
            int n = Integer.parseInt(arg);
            if (n == 0){
                throw new ArgumentException("X");
            }
        } catch (Exception e) {
            throw new ArgumentException("X");
        }
    }

    public static void yCoordinateIsOk(String arg) throws ArgumentException { //arg- аргумент строки
        //значение поля max = 896
        try {
            long n = Long.parseLong(arg);
            if (n > 896) {
                throw new ArgumentException("Y");
            }
        } catch (Exception e) {
            throw new ArgumentException("Y");
        }

    }
}

