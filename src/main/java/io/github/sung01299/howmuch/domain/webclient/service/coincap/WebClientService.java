package io.github.sung01299.howmuch.domain.webclient.service.coincap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {

    public void get(String asset) {

        // WebClient basic config
        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.coincap.io")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        // api request
        Mono<ApiResponse> response = webClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/v2/assets/" + asset)
                                .build())
                .retrieve()
                .bodyToMono(ApiResponse.class);

        ApiResponse apiResponse = response.block();

        if (apiResponse != null) {
            AssetData assetData = apiResponse.getData();
            Long timeStamp = apiResponse.getTimestamp();

            System.out.println("id: " + assetData.getId());
            System.out.println("rank: " + assetData.getRank());
            System.out.println("symbol: " + assetData.getSymbol());
            System.out.println("name: " + assetData.getName());
            System.out.println("supply: " + assetData.getSupply());
            System.out.println("maxSupply: " + assetData.getMaxSupply());
            System.out.println("marketCapUsd: " + assetData.getMarketCapUsd());
            System.out.println("volumeUsd24Hr: " + assetData.getVolumeUsd24Hr());
            System.out.println("priceUsd: " + assetData.getPriceUsd());
            System.out.println("changePercent24Hr: " + assetData.getChangePercent24Hr());
            System.out.println("vwap24Hr: " + assetData.getVwap24Hr());
            System.out.println("explorer: " + assetData.getExplorer());
            System.out.println("timeStamp = " + timeStamp);
        }
    }

}
