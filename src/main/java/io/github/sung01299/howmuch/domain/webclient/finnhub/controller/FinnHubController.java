package io.github.sung01299.howmuch.domain.webclient.finnhub.controller;

import io.github.sung01299.howmuch.domain.webclient.finnhub.dto.PriceDTO;
import io.github.sung01299.howmuch.domain.webclient.finnhub.service.FinnhubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FinnHubController {

    private final FinnhubService finnhubService;

    @GetMapping("/api/quote/{symbol}")
    public PriceDTO getQuote(@PathVariable("symbol") String symbol) {
        PriceDTO price = finnhubService.quote(symbol);
        System.out.println("Price: " + price.toString());
        return price;
    }

}
