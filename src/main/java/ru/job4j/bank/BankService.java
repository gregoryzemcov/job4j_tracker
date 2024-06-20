package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                 accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User u : users.keySet()) {
            if (u.getPassport().equals(passport)) {
                user = u;
                break;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account1 = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    account1 = account;
                    break;
                }
            }
        }
        return account1;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account account1 = findByRequisite(sourcePassport, sourceRequisite);
        Account account2 = findByRequisite(destinationPassport, destinationRequisite);
        if (account1 != null && account1.getBalance() >= amount && account2 != null) {
            account1.setBalance(account1.getBalance() - amount);
            account2.setBalance(account2.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
