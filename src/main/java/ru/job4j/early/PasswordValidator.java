package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        String specialChar = "[!@#$%&*()_+=|<>?{}\\[\\]~-]";

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        if (password.toUpperCase().contains("qwerty".toUpperCase()) || password.contains("12345")
                || password.toUpperCase().contains("password".toUpperCase())
                || password.toUpperCase().contains("admin".toUpperCase())
                || password.toUpperCase().contains("user".toUpperCase())) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }

        for (char c : password.toCharArray()) {
            if (!Character.isUpperCase(c)) {
                throw new IllegalArgumentException("Password should contain at least one uppercase letter");
            } else if (!Character.isLowerCase(c)) {
                throw new IllegalArgumentException("Password should contain at least one lowercase letter");
            } else if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Password should contain at least one figure");
            } else if (!Character.isLetterOrDigit(c)) {
                throw new IllegalArgumentException("Password should contain at least one special symbol");
            }
        }

        return password;
    }
}
