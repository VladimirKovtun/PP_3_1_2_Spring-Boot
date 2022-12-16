package ru.firstapp.service;

import ru.firstapp.entity.User;

import java.util.List;

public interface UserService {

    Iterable<User> showAllUsers();
    void addUser(User user);

    User getUser(Long id);

    void editUser(User user);

    void removeUser(User user);
}
