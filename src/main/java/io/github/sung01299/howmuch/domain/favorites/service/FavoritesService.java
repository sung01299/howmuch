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

    public List<Favorites> getFavorites(Long userId) {
        return favoritesRepository.getFavorites(userId);
    }

    public void addFavorites(Long userId, String ticker, String fullName) {
        favoritesRepository.addFavorites(userId, ticker, fullName);
    }

}
