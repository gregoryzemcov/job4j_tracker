package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.putIfAbsent(user.getPassport(), user.getUsername())) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        if (users.containsKey(findByPassport(passport))) {
            if (account != null && account.equals(findByRequisite(passport, users.get(new User())))) {
                Account account = new ArrayList<Account>();
                account.setRequisite();
                account.setBalance();
            }
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User u : users.keySet()) {
            if (users.containsKey(passport)) {
                user = u;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        for (User user : users) {
            user.getPassport(passport).getRequisite(requisite);
        }
        return get.;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
