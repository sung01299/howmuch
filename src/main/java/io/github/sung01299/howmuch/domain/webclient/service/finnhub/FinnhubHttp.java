package io.github.sung01299.howmuch.domain.webclient.service.finnhub;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FinnhubHttp {

    @Value("${FINNHUB_API_KEY}")
    private String FINNHUB_API_KEY;

}
