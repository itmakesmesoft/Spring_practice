package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") // 접속할 url 주소 입력
    public String niceToMeetYou(Model model) {  // 모델 생성을 통해 변수를 mustache로 전송할 수 있음
        model.addAttribute("username", "Daniel");
        return "greetings"; // 반환값이 파일의 이름명 -> templates/greetings.mustache -> 브라우저로 전송
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "Daniel");
        return "goodbye";
    }
}
