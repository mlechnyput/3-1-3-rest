package app.service;

import app.models.User;

import java.util.List;

public interface UserService {

    void createAndUpdate(User user);

    List<User> getAllUsers();

    void delete(long id);

    User findUserById(long id);

    User findUserByEmail(String email);
}
