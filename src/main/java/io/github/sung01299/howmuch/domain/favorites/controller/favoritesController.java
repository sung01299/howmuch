package io.github.sung01299.howmuch.domain.favorites.controller;

import io.github.sung01299.howmuch.domain.favorites.dto.FavoritesDTO;
import io.github.sung01299.howmuch.domain.favorites.entity.Favorites;
import io.github.sung01299.howmuch.domain.favorites.service.FavoritesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class favoritesController {

    private final FavoritesService favoritesService;

    @GetMapping("/api/favorites/{id}")
    public List<Favorites> getAllFavorites(@PathVariable("id") Long userId) {
        return favoritesService.getAllFavorites(userId);
    }

    @PostMapping("/api/favorites/{id}")
    public List<Favorites> addFavorites(@PathVariable("id") Long userId, @RequestBody FavoritesDTO favoritesDTO) {
        favoritesService.addFavorites(userId, favoritesDTO.getTicker());
        return favoritesService.getAllFavorites(userId);
    }
}
