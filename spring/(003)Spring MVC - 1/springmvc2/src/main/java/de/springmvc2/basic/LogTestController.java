package de.springmvc2.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 문자를 반환은 문자 그대로 반환(뷰 이름으로 반환 x)
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(LogTestController.class); // 대신에 getClass() 사용가능

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // 운영 서버에 무조건 남기 때문에 좋지 않다
        System.out.println("name = "+name);

        // 1. 로그 레벨 별로 정해서 출력할 수 있다
        log.trace("trace log = {}", name); // {}는 name으로 치환됨
        log.debug("debug log = {}", name);

        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);

        return "OK";
    }
}
