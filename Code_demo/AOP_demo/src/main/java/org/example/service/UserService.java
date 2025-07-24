package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    public void createUser(String name) {
        System.out.println("[Business] Creating user: " + name);
    }

    public void deleteUser(String name) {
        System.out.println("[Business] Deleting user: " + name);
    }

    public void updateUser(String name) {
        System.out.println("[Business] Updating user: " + name);
        throw new RuntimeException("Simulated Exception while updating user.");
    }
}
