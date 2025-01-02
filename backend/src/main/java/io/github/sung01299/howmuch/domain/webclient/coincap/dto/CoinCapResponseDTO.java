package io.github.sung01299.howmuch.domain.webclient.coincap.dto;

import lombok.Getter;

@Getter
public class CoinCapResponseDTO {
    private AssetData data;
    private Long timestamp;
}
