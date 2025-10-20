package za.ac.readiculous.util;

import java.time.LocalDateTime;
import java.util.Objects;

public class Helper {

    public void checkIfNull(Object obj, String fieldName) {
        if (Objects.isNull(obj)) {
            throw new IllegalArgumentException(fieldName);
        }
    }


    public static boolean isStringNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }


    public static boolean isValidLong(long id) {
        return id > 0;
    }

    public static String capitalize(String input) {
        if (isStringNullOrEmpty(input)) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static boolean equalsIgnoreCase(String a, String b) {
        return (a == null && b == null) || (a != null && a.equalsIgnoreCase(b));
    }


    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isDoubleNull(double z){
        if(z == 0.0)
            return true;
        return false;
    }

    public static boolean isObjectNull(Object object){
        if (object == null){
            return true;
        }
        return false;
    }

    public static boolean isDateNull(LocalDateTime dateTime) {
        return dateTime == null;
    }

    public static boolean isTrue(boolean b){
        if(b == true)
            return true;
        return false;
    }
}
