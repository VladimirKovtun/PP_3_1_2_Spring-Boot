package ru.firstapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.firstapp.entity.User;
import ru.firstapp.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Component
@Transactional()
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void editUser(Long id, User user) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User userById = byId.get();
            userById.setAge(user.getAge());
            userById.setName(user.getName());
            userById.setLastName(user.getLastName());
            userById.seteMail(user.geteMail());
            userRepository.save(userById);
        }
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }
}
