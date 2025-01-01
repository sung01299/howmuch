package io.github.sung01299.howmuch.domain.webclient.service.coincap;

import lombok.Getter;

@Getter
public class AssetData {
    private String id;
    private String rank;
    private String symbol;
    private String name;
    private String supply;
    private String maxSupply;
    private String marketCapUsd;
    private String volumeUsd24Hr;
    private String priceUsd;
    private String changePercent24Hr;
    private String vwap24Hr;
    private String explorer;
}
