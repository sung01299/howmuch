package io.github.sung01299.howmuch.domain.user.repository;

import io.github.sung01299.howmuch.domain.user.entity.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository{

    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    public List<User> findOne(String username) {
        List<User> user = em.createQuery("select u from User u where u.userName = :username", User.class)
                .setParameter("username", username)
                .getResultList();
        return user;
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(em.createQuery("select u from User u where u.email = :email", User.class).getSingleResult());
    }

}
