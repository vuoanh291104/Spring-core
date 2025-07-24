package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    List<User> getAllUsers();
}
