package io.github.sung01299.howmuch.domain.user.service;

import io.github.sung01299.howmuch.domain.user.dto.UserExistsResponseDTO;
import io.github.sung01299.howmuch.domain.user.entity.User;
import io.github.sung01299.howmuch.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        userRepository.save(user);
        return user.getUserId();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(String username) {
        List<User> user = userRepository.findOne(username);
        return user.isEmpty() ? null : user.get(0);
    }
}
