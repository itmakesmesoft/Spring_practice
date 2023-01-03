package com.example.firstproject.service;

import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 해당 클래스는 스프링 부트와 연동되어 테스팅됨.
class ArticleServiceTest {

    @Autowired ArticleService articleService;

    @AfterEach
    void tearDown() {
    }

    @Test
    void index() {
        // 예상


        // 실제
        List<Article> articles = articleService.index();

        // 비교


    }
}