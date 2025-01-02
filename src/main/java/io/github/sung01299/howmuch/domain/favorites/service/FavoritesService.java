package io.github.sung01299.howmuch.domain.favorites.service;

import io.github.sung01299.howmuch.domain.favorites.entity.Favorites;
import io.github.sung01299.howmuch.domain.favorites.repository.FavoritesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FavoritesService {

    private final FavoritesRepository favoritesRepository;

    @Transactional(readOnly = true)
    public List<Favorites> getAllFavorites(Long userId) {
        return favoritesRepository.getAllFavorites(userId);
    }

    public void addFavorites(Long userId, String ticker) {
        favoritesRepository.addFavorites(userId, ticker);
    }

    public void removeFavorites(Long userId, String ticker) {
        favoritesRepository.removeFavorites(userId, ticker);
    }

}
