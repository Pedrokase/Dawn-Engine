package io.github.pedrokase.Utils;

public class CommandUtils {


    public static Integer getInteger(String input) {
        Integer output = null;
        try {
            output = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            //TODO Add throw exception
        }
        return output;
    }
}
