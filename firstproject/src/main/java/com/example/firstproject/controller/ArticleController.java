package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j // 로깅을 위한 어노테이션
public class ArticleController {

    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다 자동으로 연결해주는 어노테이션
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {

        //System.out.println(form.toString()); -> 로깅(log.info)으로 대체
        log.info(form.toString());
        
        // 1. DTO를 Entity로 변환
        Article article = form.toEntity();
        // System.out.println(article.toString()); -> 로깅(log.info)으로 대체
        log.info(article.toString());
        
        // 2. Repository에게 Entity를 DB에 저장하게 함
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString()); -> 로깅(log.info)으로 대체
        log.info(saved.toString());
        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = "+id);

        // 1. id로 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2. 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        // 3. 보여줄 페이지 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        // 1. 모든 aritcles를 가져오기
        List<Article> articleEntityList = articleRepository.findAll();
        
        // 2. 가져온 articles 묶음을 뷰로 전달
        model.addAttribute("articleList", articleEntityList);

        // 3. 뷰 페이지를 설정
        return "articles/index"; // articles/index.mustache
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // 수정할 데이터를 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 모델에 데이터 등록
        model.addAttribute("article", articleEntity);

        // 뷰 페이지 설정
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form) {
        log.info(form.toString());
        // 1. DTO -> Entity 변환
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        // 2. Entity -> DB 저장
        //  2-1. DB에서 기존 데이터 가져오기
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        //  2-2. 기존 데이터의 값을 갱신
        if (target != null) {
            articleRepository.save(articleEntity); // 엔티티가 db로 갱신됨
        } 

        // 3. 수정 결과 페이지로 리다이렉트
        return "redirect:/articles/" + articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete") // html에서 delete 매핑을 공식적으론 지원하지 않아 편의상 get으로 변경
    public String delete(@PathVariable Long id, RedirectAttributes attr) {
        // 1. 삭제 대상 가져오기
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString()+"_deleted");

        // 2. 대상을 삭제
        if (target != null) {
            articleRepository.delete(target); // db에서 target 삭제
            attr.addFlashAttribute("msg", "Delete completed");
        }
        
        // 3. 결과 페이지로 리다이렉트
        return "redirect:/articles";
    }
}
