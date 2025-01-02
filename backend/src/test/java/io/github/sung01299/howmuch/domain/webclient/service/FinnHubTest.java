package io.github.sung01299.howmuch.domain.webclient.service;

import io.github.sung01299.howmuch.domain.webclient.finnhub.service.FinnhubService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class FinnHubTest {

    @Autowired
    FinnhubService finnhubService;

    @Test
    public void get() {
        finnhubService.quote("MSFT");
    }
}
