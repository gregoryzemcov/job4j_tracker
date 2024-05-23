package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        if (users.containsKey(findByPassport(passport))) {
            if (!users.get(findByRequisite(passport, account.getRequisite()))) {
                users.get(findByPassport(passport)).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User user = new User(null, null);
        for (User u : users.keySet()) {
            if (u.getPassport().equals(passport)) {
                user = u;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = new Account(null, 0);
        User user = new User(null, null);
        if (users.containsKey(findByPassport(passport))) {
            Collection<List<Account>> accounts = users.values();
            for (Account account1 : accounts) {
                if (account1.getRequisite().equals(requisite)) {
                    account = account1;
                }
            }
        }
        return account;
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
