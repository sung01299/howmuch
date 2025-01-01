package io.github.sung01299.howmuch.domain.webclient.service;

import io.github.sung01299.howmuch.domain.webclient.service.coincap.WebClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class WebClientServiceTest {

    @Autowired private WebClientService webClientService;

    @Test
    void get() {
        webClientService.get("ethereum");
    }

}