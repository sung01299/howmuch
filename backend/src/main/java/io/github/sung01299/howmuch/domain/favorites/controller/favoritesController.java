package io.github.sung01299.howmuch.domain.favorites.controller;

import io.github.sung01299.howmuch.domain.favorites.dto.FavoritesDTO;
import io.github.sung01299.howmuch.domain.favorites.entity.Favorites;
import io.github.sung01299.howmuch.domain.favorites.service.FavoritesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Favorites API", description = "Favorites related APIs")
public class favoritesController {

    private final FavoritesService favoritesService;

    /*
     양방향 참조 문제 발생 -> 해결해야함!!
     */
    @GetMapping("/api/favorites/{id}")
    public List<FavoritesDTO> getAllFavorites(@PathVariable("id") Long userId) {
        List<Favorites> allFavorites = favoritesService.getAllFavorites(userId);
        List<FavoritesDTO> favoritesDTOList = new ArrayList<>();
        for (Favorites favorites : allFavorites) {
            FavoritesDTO favoritesDTO = new FavoritesDTO();
            favoritesDTO.setTicker(favorites.getTicker());
            favoritesDTOList.add(favoritesDTO);
        }
        return favoritesDTOList;
    }

    @PostMapping("/api/favorites/{id}")
    public List<Favorites> addFavorites(@PathVariable("id") Long userId, @RequestBody FavoritesDTO favoritesDTO) {
        favoritesService.addFavorites(userId, favoritesDTO.getTicker());
        return favoritesService.getAllFavorites(userId);
    }
}
