package de.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MVCController {
    @GetMapping("hello-mvc") // "/hello-mvc"로 매핑된 GET 요청 핸들링
    public String helloMvc(@RequestParam("name") String name, Model model) { // 요청 URL의 name 파라미터에서 값을 추출
        model.addAttribute("name", name); // "name"이라는 attribute를 모델에 추가, URL에서 추출된 파라미터 값으로 설정
        return "hello-template"; // "hello-template"이라는 viewname을 찾음
    }
}
