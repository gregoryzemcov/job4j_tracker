package ru.job4j.ex;

import java.util.Objects;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User value : users) {
            if (Objects.equals(value.getUsername(), login)) {
                user = value;
            }
        }
            if (user == null) {
                throw new UserNotFoundException("This user is not found.");
            }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        String s = User.getUsername();
        if (!user.isValid() && s.length() < 3) {
            throw new UserInvalidException("The name is incorrect");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            if (validate(findUser(users, "Petr Arsentev"))) {
                findUser(users, "Petr Arsentev");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
