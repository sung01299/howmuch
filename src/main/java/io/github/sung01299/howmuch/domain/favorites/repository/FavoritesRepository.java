package io.github.sung01299.howmuch.domain.favorites.repository;

import io.github.sung01299.howmuch.domain.favorites.entity.Favorites;
import io.github.sung01299.howmuch.domain.user.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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

    public void addFavorites(Long userId, String ticker) {
        User user = em.find(User.class, userId);
        Favorites favorites = new Favorites();
        favorites.setTicker(ticker);
        favorites.setUser(user);

        em.persist(favorites);
    }

    public List<Favorites> getAllFavorites(Long userId) {
        return em.createQuery("select f from Favorites f where f.user.userId = :userId", Favorites.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public void removeFavorites(Long userId, String ticker) {
        Query query = em.createQuery("delete from Favorites f where f.ticker = :ticker and f.user.userId = :userId")
                .setParameter("ticker", ticker)
                .setParameter("userId", userId);
        query.executeUpdate();
    }
}
