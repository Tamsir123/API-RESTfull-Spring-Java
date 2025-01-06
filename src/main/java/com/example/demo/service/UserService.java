package com.example.demo.service;

import com.example.demo.modele.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    User updateUser(Long id, User user);  // Méthode pour mettre à jour l'utilisateur
}
