package de.springmvc2.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    /**
     * 1.
     * Spring Boot 3.0 부터는 /hello-basic 과 /hello-basic/은 다르게 취급 ("/"유지)
     * {"/hello-basic", "/hello-basic2"} 으로 다중 URL 설정 가능
     * GET 메서드 허용
     */
    @RequestMapping(value = {"/hello-basic", "/hello-basic2"}, method = RequestMethod.GET)
    public String helloBasic() {
        log.info("hello basic");
        return "OK";
    }

    /**
     * 2.
     * 축약 애노테이션 사용
     * GET 메서드 허용
     */
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "OK";
    }

    /**
     * 3. PathVariable(경로 변수) 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable String userId
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId = {} ", data);
        return "OK";
    }

    /**
     * 4. PathVariable 다중 사용
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId = {}, orderId = {}", userId, orderId);
        return "OK";
    }

    /**
     * 5. Content-Type 헤더 기반 추가 매핑(consumes)
     * consumes : 컨틀로러가 받아들이는 미디어 타입
     * consumes = "application/json"
     * consumes = "!application/json"
     * consumes = "application/*"
     * consumes = "*\/*"
     * application/json 대신 MediaType.APPLICATION_JSON_VALUE 사용 권장
     */
    // content-type이 application/json인 경우에만 호출
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "OK";
    }

    /**
     * 6. Accept 헤더 기반 추가 매핑(produces)
     * produces : 컨트롤러가 만들어내는 미디어 타입
     * produces = "application/json"
     * produces = "!application/json"
     * produces = "application/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", consumes = "application/json")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "OK";
    }
}
