package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // jpa와 연동한 테스트
class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;
    @Test
    @DisplayName("See all comments of specific article") // 특정 게시글의 모든 댓글 조회
    void findByArticleId() {
        // Case 1. 4번 게시글의 모든 댓글 조회
        {
            // 입력 데이터 준비
            Long articleId = 4L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 예상
            Article article = new Article(4L, "hello", "rrr");
            Comment a = new Comment(1L, article, "user1", "comment1");
            Comment b = new Comment(2L, article, "user2", "comment2");
            Comment c = new Comment(3L, article, "user3", "comment3");
            List <Comment> expected = Arrays.asList(a, b, c);

            // 검증
            assertEquals(expected.toString(), comments.toString(), "4번 게시글의 모든 댓글 조회");
        }
    }

    @Test
    @DisplayName("See all comments of specific user's")
    void findByNickname() {
        // Case 1. "user1의 모든 댓글 조회
        {
            // 입력 데이터 준비
            String nickname = "user1";
            // 실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);
            
            // 예상
            Comment a = new Comment(1L, new Article(4L, "hello", "rrr"), nickname, "comment1");
            Comment b = new Comment(4L, new Article(5L, "world", "rrrr"), nickname, "comment4");
            Comment c = new Comment(7L, new Article(6L, "spring", "rrrrr"), nickname, "comment7");
            List <Comment> expected = Arrays.asList(a, b, c);

            // 검증
            assertEquals(expected.toString(), comments.toString(), "user1의 모든 댓글 출력");
        }
    }
}