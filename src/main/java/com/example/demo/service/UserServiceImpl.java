package com.example.demo.service.impl;

import com.example.demo.modele.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        // Vérifier si l'utilisateur existe
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            // Mettre à jour les propriétés de l'utilisateur
            User updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            // Mettre à jour d'autres champs si nécessaire
            return userRepository.save(updatedUser);  // Sauvegarder l'utilisateur mis à jour
        } else {
            // Si l'utilisateur n'existe pas, retourner null ou lancer une exception
            return null;  // Ou tu peux lancer une exception personnalisée
        }
    }
}
