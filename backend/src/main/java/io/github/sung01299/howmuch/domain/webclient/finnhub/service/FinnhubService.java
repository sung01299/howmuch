package io.github.sung01299.howmuch.domain.webclient.finnhub.service;

import io.github.sung01299.howmuch.domain.webclient.finnhub.dto.FinnHubResponse;
import io.github.sung01299.howmuch.domain.webclient.finnhub.dto.PriceDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FinnhubService {

    @Value("${FINNHUB_API_KEY}")
    private String FINNHUB_API_KEY;

    public PriceDTO quote(String symbol) {

        // WebClient basic config
        WebClient webClient = WebClient.builder()
                .baseUrl("https://finnhub.io")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        // api request
        Mono<FinnHubResponse> response = webClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/api/v1/quote/")
                                .queryParam("symbol", symbol)
                                .queryParam("token", FINNHUB_API_KEY)
                                .build())
                .retrieve()
                .bodyToMono(FinnHubResponse.class);

        FinnHubResponse apiResponse = response.block();

        PriceDTO price = new PriceDTO();
        price.setSymbol(symbol);
        price.setPrice(apiResponse.getC());

        return price;

    }
}
