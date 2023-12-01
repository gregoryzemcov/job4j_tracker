package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }
    /** Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска. * @return Список пользователей, которые прошли проверку.
     */

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person s: persons) {
            if (key.contains(s.getName())) {
                result.add(s);
            } else if (key.contains(s.getSurname())) {
                result.add(s);
            } else if (key.contains(s.getPhone())) {
                result.add(s);
            } else if (key.contains(s.getAddress())) {
                result.add(s);
            }
        }
        return result;
    }
}
