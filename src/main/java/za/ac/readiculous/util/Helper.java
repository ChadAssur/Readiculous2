package za.ac.readiculous.util;

public class Helper {


    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }


    public static boolean isValidId(long id) {
        return id > 0;
    }


    public static String capitalize(String input) {
        if (isNullOrEmpty(input)) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
    public static boolean equalsIgnoreCase(String a, String b) {
        return (a == null && b == null) || (a != null && a.equalsIgnoreCase(b));
    }


    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}
