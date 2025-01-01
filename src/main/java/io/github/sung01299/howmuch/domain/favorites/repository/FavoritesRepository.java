package io.github.sung01299.howmuch.domain.favorites.repository;

import io.github.sung01299.howmuch.domain.favorites.entity.Favorites;
import io.github.sung01299.howmuch.domain.user.entity.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FavoritesRepository {

    private final EntityManager em;

    public void save(Favorites favorites) {
        em.persist(favorites);
    }

    public void addFavorites(Long userId, String ticker, String fullName) {
        User user = em.find(User.class, userId);
        Favorites favorites = new Favorites();
        favorites.setTicker(ticker);
        favorites.setFullName(fullName);
        favorites.setUser(user);

        em.persist(favorites);
    }

    public List<Favorites> getFavorites(Long userId) {
        return em.createQuery("select f from Favorites f where f.user.userId = :userId", Favorites.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
