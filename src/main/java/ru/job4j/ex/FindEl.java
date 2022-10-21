package ru.job4j.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(value[i], key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("This element not found.");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        for (String s : abuses) {
            if (s.equals(value)) {
                throw new ElementAbuseException("This forbidden element.");
            }
        }
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] str = {"a", "b", "c"};
        try {
            indexOf(str, "d");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
