package io.github.sung01299.howmuch.domain.favorites.repository;

import io.github.sung01299.howmuch.domain.favorites.entity.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
}
