package nl.spotbooking.spotbooking.service;


import nl.spotbooking.spotbooking.model.User;

import java.util.Collection;
import java.util.Optional;


public interface UserService {

    boolean userExists(String username);

    String createUser(User user);

    void updateUser(String username, User user);

    void deleteUser(String username);

    Collection<User> getUsers();

    Optional<User> getUser(String username);

}