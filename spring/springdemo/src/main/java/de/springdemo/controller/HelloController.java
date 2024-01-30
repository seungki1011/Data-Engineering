package de.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Controller임을 나타내는 스프링 어노테이션
public class HelloController {

    @GetMapping("hello") // "/hello"로 매핑된 GET 요청을 핸들링
    public String hello(Model model) {
        model.addAttribute("data", "loll"); // 모델로 "data"라는 attribute를 부여, 값은 "loll"
        // 이 attribute는 view에서 접근 가능
        return "hello"; // 리턴값 "hello"는 viewResolver가 hello라는 이름의 view를 찾도록 함
    }
}
