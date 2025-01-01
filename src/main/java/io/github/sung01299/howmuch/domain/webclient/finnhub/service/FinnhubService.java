package io.github.sung01299.howmuch.domain.webclient.finnhub.service;

import io.github.sung01299.howmuch.domain.webclient.finnhub.dto.FinnHubResponseDTO;
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

    public void quote(String symbol) {

        // WebClient basic config
        WebClient webClient = WebClient.builder()
                .baseUrl("https://finnhub.io")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        // api request
        Mono<FinnHubResponseDTO> response = webClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/api/v1/quote/")
                                .queryParam("symbol", symbol)
                                .queryParam("token", FINNHUB_API_KEY)
                                .build())
                .retrieve()
                .bodyToMono(FinnHubResponseDTO.class);

        FinnHubResponseDTO apiResponse = response.block();

        System.out.println("CurrentPrice: " + apiResponse.getC());
        System.out.println("Change: " + apiResponse.getD());
        System.out.println("PercentChange: " + apiResponse.getDp());
        System.out.println("HighPrice: " + apiResponse.getH());
        System.out.println("LowPrice: " + apiResponse.getL());
        System.out.println("OpenPrice: " + apiResponse.getO());
        System.out.println("ClosePrice: " + apiResponse.getC());
        System.out.println("TimeStamp: " + apiResponse.getT());

    }
}
