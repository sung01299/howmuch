package io.github.sung01299.howmuch.domain.user.repository;

import io.github.sung01299.howmuch.domain.user.entity.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public Boolean findOne(String username) {
        User user = em.createQuery("select u from User u where u.userName = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
        return user != null;
    }

}
