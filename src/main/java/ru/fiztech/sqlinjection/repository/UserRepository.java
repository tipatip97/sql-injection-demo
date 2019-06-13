package ru.fiztech.sqlinjection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.fiztech.sqlinjection.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.login = :login AND u.password = :password")
    User findPair(@Param("login") String login, @Param("password") String password);

}
