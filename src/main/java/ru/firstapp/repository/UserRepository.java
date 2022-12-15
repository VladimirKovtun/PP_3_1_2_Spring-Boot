package ru.firstapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.firstapp.entity.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
}
