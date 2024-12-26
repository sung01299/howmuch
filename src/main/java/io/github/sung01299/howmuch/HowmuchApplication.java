package io.github.sung01299.howmuch;

import io.github.sung01299.howmuch.domain.user.entity.User;
import io.github.sung01299.howmuch.domain.user.repository.UserRepository;
import io.github.sung01299.howmuch.domain.user.service.UserService;
import io.github.sung01299.howmuch.domain.user.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HowmuchApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowmuchApplication.class, args);

	}

}
