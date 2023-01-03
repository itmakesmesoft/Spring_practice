package com.example.firstproject.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // DB가 해당 객체를 인식하도록 함
@AllArgsConstructor
@NoArgsConstructor // 디폴트 생성자를 추가하는 어노테이션
@ToString
@Getter
public class Article {

    @Id // 대표값을 지정.(고유값)
    @GeneratedValue // 번호 자동 생성 어노테이션
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article) {
        if(article.title != null) {
            this.title = article.title;
        }
        if(article.content != null) {
            this.content = article.content;
        }
    }

//    public Long getId() {
//        return id;
//    }

    // AllArgsConstructor 어노테이션이 대체
//    public Article(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }

    // ToString 어노테이션이 대체
//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
}
