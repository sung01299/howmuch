package io.github.sung01299.howmuch.domain.webclient.finnhub.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PriceDTO {
    private String symbol;
    private Double price;


}
