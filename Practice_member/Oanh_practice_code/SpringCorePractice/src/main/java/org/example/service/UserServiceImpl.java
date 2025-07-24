package org.example.service;

import org.example.dao.UserDAO;
import org.example.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void addUser(User user) {
        userDAO.save(user);
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }
}
