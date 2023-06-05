package ru.job4j.early;

public class PasswordValidator {
    private static final String[] STRINGS = {"qwerty", "password", "admin", "user", "12345"};

    @SuppressWarnings({"checkstyle:ConstantName", "checkstyle:SimplifyBooleanExpression"})
    public static String validate(String password) {
        boolean upCase = false;
        boolean loCase = false;
        boolean digit = false;
        boolean supp = false;

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        for (String s : STRINGS) {
            if (password.toLowerCase().contains(s)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upCase = true;
            }
            if (Character.isLowerCase(c)) {
                loCase = true;
            }
            if (Character.isDigit(c)) {
                digit = true;
            }
            if (!Character.isUpperCase(c) && !Character.isLowerCase(c) && !Character.isDigit(c)) {
                supp = true;
            }
            if (upCase && loCase && digit && supp) {
                break;
            }
        }

        if (!upCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!loCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!digit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!supp) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }

        return password;
    }
}
