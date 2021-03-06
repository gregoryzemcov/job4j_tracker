package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("This user not find.");
    }
    public static boolean validate(User user) throws UserInvalidException {
        boolean valid = true;
        if (!user.isValide() && user.getUsername().length() < 3) {
           valid = false;
        } else {
            throw new UserInvalidException("This user not validate");
        }
        return valid;
    }
    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User ("Valera Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            validate(user);
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException en) {
            en.printStackTrace();
        }
    }
}