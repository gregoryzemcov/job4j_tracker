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
        for (Person s : persons) {
            if (s.getName().contains(key) || s.getSurname().contains(key)
                    || s.getPhone().contains(key) || s.getAddress().contains(key)) {
                result.add(s);
            }
        }
        return result;
    }
}
