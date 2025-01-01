package io.github.sung01299.howmuch.domain.favorites.service;

import io.github.sung01299.howmuch.domain.favorites.entity.Favorites;
import io.github.sung01299.howmuch.domain.favorites.repository.FavoritesRepository;
import io.github.sung01299.howmuch.domain.user.entity.User;
import io.github.sung01299.howmuch.domain.user.repository.UserRepository;
import io.github.sung01299.howmuch.domain.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class FavoritesServiceTest {

    @Autowired FavoritesService favoritesService;
    @Autowired FavoritesRepository favoritesRepository;
    @Autowired UserService userService;

    @Test
    public void addFavorites() {

        User user = new User();
        user.setUserName("강해린");
        Long savedId = userService.join(user);

        favoritesService.addFavorites(savedId, "TSLA", "Tesla");
        favoritesService.addFavorites(savedId, "MSFT", "Microsoft");

        List<Favorites> favorites = favoritesService.getAllFavorites(savedId);

        Assertions.assertEquals(2, favorites.size());
    }

    @Test
    public void removeFavorites() {

        User user = new User();
        user.setUserName("강해린");
        Long savedId = userService.join(user);

        favoritesService.addFavorites(savedId, "TSLA", "Tesla");
        favoritesService.addFavorites(savedId, "MSFT", "Microsoft");

        favoritesService.removeFavorites(savedId, "TSLA");

        List<Favorites> favorites = favoritesService.getAllFavorites(savedId);

        Assertions.assertEquals(1, favorites.size());
    }
}