package io.github.sung01299.howmuch.user;

import io.github.sung01299.howmuch.domain.user.entity.User;
import io.github.sung01299.howmuch.domain.user.repository.UserRepository;
import io.github.sung01299.howmuch.domain.user.service.UserService;
import io.github.sung01299.howmuch.domain.user.service.UserServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(UserServiceImpl.class)
public class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Test
    void join() {
        User user1 = new User();
        User user2 = new User();

        System.out.println("user1 = " + user1);
        System.out.println("user2 = " + user2);

        userService.join(user1);
        userService.join(user2);

        List<User> allUsers = userRepository.findAll();
        for (User user: allUsers) {
            System.out.println(user.getUserId());
        }
    }
}
