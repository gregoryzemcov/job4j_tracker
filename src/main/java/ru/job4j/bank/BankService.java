package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    public void addAccount(String passport, Account account) {
        if (users.get(findByPassport(passport)) != null) {
            for (User user : users.keySet()) {
                if (user.getPassport().equals(passport)) {
                    if (!getAccounts(user).contains(account)) {
                        getAccounts(user).add(account);
                    }
                }
            }
        }
    }

    public User findByPassport(String passport) {
        User user = new User(null, null);
        for (User u : users.keySet()) {
            if (u.getPassport().equals(passport)) {
                user = u;
                break;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account1 = new Account(null, 0);
        if (users.get(findByPassport(passport)) != null) {
            for (User user : users.keySet()) {
                if (user.getPassport().equals(passport)) {
                    for (Account account : getAccounts(user)) {
                        if (account.getRequisite().equals(requisite)) {
                            account1 = account;
                        }
                    }
                }
            }
        }
        return account1;
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
