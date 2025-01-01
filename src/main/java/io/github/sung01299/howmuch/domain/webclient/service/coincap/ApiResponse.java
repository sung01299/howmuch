package io.github.sung01299.howmuch.domain.webclient.service.coincap;

import lombok.Getter;

@Getter
public class ApiResponse {
    private AssetData data;
    private Long timestamp;
}
