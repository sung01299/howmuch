package io.github.sung01299.howmuch.domain.webclient.finnhub.controller;

import io.github.sung01299.howmuch.domain.favorites.entity.Favorites;
import io.github.sung01299.howmuch.domain.favorites.service.FavoritesService;
import io.github.sung01299.howmuch.domain.webclient.finnhub.dto.PriceDTO;
import io.github.sung01299.howmuch.domain.webclient.finnhub.service.FinnhubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FinnHubController {

    private final FinnhubService finnhubService;
    private final FavoritesService favoritesService;

    @GetMapping("/api/quote/{symbol}")
    public PriceDTO getQuote(@PathVariable("symbol") String symbol) {
        PriceDTO price = finnhubService.quote(symbol);
//        System.out.println("Price: " + price.toString());
        return price;
    }

    @GetMapping("/api/quote/favorites/{id}}")
    public List<PriceDTO> getFavoritesQuote(@PathVariable("id") Long userId) {
        List<Favorites> favoritesList = favoritesService.getAllFavorites(userId);
        List<PriceDTO> priceDTOList = new ArrayList<>();
        for (Favorites favorites : favoritesList) {
            PriceDTO quote = finnhubService.quote(favorites.getTicker());
            priceDTOList.add(quote);
        }
        return priceDTOList;
    }

}
