package ru.job4j.early;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PasswordValidator {

    public static String validate(String password) {
        boolean upCase = false, loCase = false, digit = false, supp = false;
        String[] strings = new String[]{"qwerty", "password", "admin", "user", "12345"};

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        for (String s : strings) {
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
        }
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(password);
        boolean b = m.find();
        if (b) {
            supp = true;
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

