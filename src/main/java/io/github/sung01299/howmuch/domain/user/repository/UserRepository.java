package io.github.sung01299.howmuch.domain.user.repository;

import io.github.sung01299.howmuch.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
