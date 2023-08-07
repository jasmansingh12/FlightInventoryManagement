package services;

import entities.User;
import repository.AppData;

import java.util.List;

public class UserManagementService {
    List<User> users;

    public void addUser(User user) {
        AppData.addUser(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
