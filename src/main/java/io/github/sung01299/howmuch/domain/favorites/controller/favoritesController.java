package io.github.sung01299.howmuch.domain.favorites.controller;

import io.github.sung01299.howmuch.domain.favorites.dto.FavoritesDTO;
import io.github.sung01299.howmuch.domain.favorites.entity.Favorites;
import io.github.sung01299.howmuch.domain.favorites.service.FavoritesService;
import io.github.sung01299.howmuch.domain.user.service.UserService;
import io.github.sung01299.howmuch.domain.webclient.finnhub.service.FinnhubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class favoritesController {

    private final FavoritesService favoritesService;
    private final UserService userService;
    private final FinnhubService finnhubService;

    @GetMapping("/api/{user_id}/favorites")
    public List<Favorites> getAllFavorites(@PathVariable Long user_id) {
        return favoritesService.getAllFavorites(user_id);
    }

    @PostMapping("/api/{user_id}/favorites")
    public List<Favorites> addFavorites(@PathVariable Long user_id, @RequestBody FavoritesDTO favoritesDTO) {
        System.out.println(favoritesDTO.getTicker());
        System.out.println(favoritesDTO.getFullName());
        favoritesService.addFavorites(user_id, favoritesDTO.getTicker(), favoritesDTO.getFullName());
        return favoritesService.getAllFavorites(user_id);
    }
}
