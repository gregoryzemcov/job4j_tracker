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
        if (!users.putIfAbsent(user, getAccounts(user))) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        String requisite = account.getRequisite();
        double balance = account.getBalance();
        if (users.containsKey(findByPassport(passport))) {
            if (!account.equals(findByRequisite(passport, requisite))) {
                account.setRequisite(requisite);
                account.setBalance(balance);
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
        Account account = new Account();
        if (users.putIfAbsent(findByPassport(passport), getAccounts(user))) {
                if (users.containsKey(requisite)) {
                    accounts.add(Account e);
                }
            }
        return accounts;
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
