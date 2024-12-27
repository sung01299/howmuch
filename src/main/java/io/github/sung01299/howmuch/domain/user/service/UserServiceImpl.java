package io.github.sung01299.howmuch.domain.user.service;

import io.github.sung01299.howmuch.domain.user.entity.User;
import io.github.sung01299.howmuch.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public void join(User user) {
        userRepository.save(user);
    }
}
