# API-RESTful-Spring-Java

## API de gestion des utilisateurs avec Spring Boot
Ce projet est une API RESTful pour la gestion des utilisateurs, développée avec Spring Boot. Il permet de créer, lire, mettre à jour et supprimer des utilisateurs via des requêtes HTTP. L'application interagit avec une base de données MySQL à l'aide de Spring Data JPA.

---

## Objectif
Le but de ce projet est de créer une API simple de gestion des utilisateurs qui inclut les fonctionnalités suivantes :
- Créer un utilisateur
- Lire tous les utilisateurs
- Lire un utilisateur spécifique par ID
- Mettre à jour un utilisateur
- Supprimer un utilisateur

---

## Structure du projet
Voici la structure de répertoires du projet :
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── demo/
│   │               ├── controller/        # Contient les endpoints REST (UserController)
│   │               ├── modele/             # Contient le modèle User
│   │               ├── repository/         # Contient le repository JPA (UserRepository)
│   │               ├── service/            # Contient l'interface et l'implémentation des services (UserService, UserServiceImpl)
│   │               └── DemoApplication.java # Point d'entrée de l'application Spring Boot
│   └── resources/
│       └── application.properties           # Fichier de configuration
```
---

## Technologies utilisées
- **Spring Boot (Java 17)**
- **Spring Data JPA**
- **MySQL** (pour la gestion de la base de données)
- **Postman** (pour tester les endpoints)

---

## Fonctionnalités des Endpoints

### 1. Créer un utilisateur (POST)
- **URL** : `/users`
- **Méthode** : `POST`
- **Description** : Crée un nouvel utilisateur dans la base de données.
- **Corps de requête** :
```json
{
    "name": "tamsir juuf",
    "email": "tamsir.juuf@example.com"
}
```
- **Réponse (succès)** :
```json
{
    "id": 1,
    "name": "tamsir juuf",
    "email": "tamsir.juuf@example.com"
}
```
- **Code de réponse** : `201 Created`

### 2. Obtenir tous les utilisateurs (GET)
- **URL** : `/users`
- **Méthode** : `GET`
- **Description** : Récupère la liste de tous les utilisateurs dans la base de données.
- **Réponse (succès)** :
```json
[
    {
        "id": 1,
        "name": "tamsir juuf",
        "email": "tamsir.juuf@example.com"
    },
    {
        "id": 2,
        "name": "fatou juuf",
        "email": "fatou.juuf@example.com"
    }
]
```
- **Code de réponse** : `200 OK`

### 3. Obtenir un utilisateur par ID (GET)
- **URL** : `/users/{id}`
- **Méthode** : `GET`
- **Description** : Récupère les informations d'un utilisateur spécifique par son ID.
- **Exemple de requête** : `/users/1`
- **Réponse (succès)** :
```json
{
    "id": 1,
    "name": "tamsir juuf",
    "email": "tamsir.diouf@example.com"
}
```
- **Code de réponse** : `200 OK`

### 4. Mettre à jour un utilisateur (PUT)
- **URL** : `/users/{id}`
- **Méthode** : `PUT`
- **Description** : Met à jour les informations d'un utilisateur existant dans la base de données.
- **Exemple de requête** :
```json
{
    "name": "tamsir updated",
    "email": "tamsir.updated@example.com"
}
```
- **Code de réponse** : `200 OK`

### 5. Supprimer un utilisateur (DELETE)
- **URL** : `/users/{id}`
- **Méthode** : `DELETE`
- **Description** : Supprime un utilisateur de la base de données par son ID.
- **Exemple de requête** : `/users/1`
- **Code de réponse** : `200 OK`

---

## Documentation Technique

### 1. `UserService` (Service Layer)
```java
public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    User updateUser(Long id, User user);
}
```

### 2. `UserController` (Controller Layer)
```java
@PutMapping("/{id}")
public String updateUser(@PathVariable Long id, @RequestBody User user) {
    User updatedUser = userService.updateUser(id, user);
    return "User with id " + id + " has been updated.";
}
```

### 3. `UserRepository` (Repository Layer)
```java
public interface UserRepository extends JpaRepository<User, Long> {
}
```

---

## Tests avec Postman

1. **POST** `/users` : Créer un utilisateur
2. **GET** `/users` : Obtenir la liste des utilisateurs
3. **GET** `/users/{id}` : Obtenir un utilisateur par ID
4. **PUT** `/users/{id}` : Mettre à jour un utilisateur
5. **DELETE** `/users/{id}` : Supprimer un utilisateur

Exemple de requête `PUT` avec Postman :
- **Méthode** : `PUT`
- **URL** : `http://localhost:8080/users/1`
- **Corps (raw, JSON)** :
```json
{
    "name": "Updated Name",
    "email": "updated.email@example.com"
}
```

---

## Conclusion
Cette application fournit une API complète pour gérer des utilisateurs avec Spring Boot, en utilisant les meilleures pratiques de développement d'API RESTful. Elle peut être étendue et adaptée pour des cas d'utilisation plus complexes.

