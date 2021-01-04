package app.dao;

import app.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao extends CrudRepository<User, Long> {

    @Query("SELECT u from User u Where u.login = :login")
    public User findUserByLogin(@Param("login") String login);
}
