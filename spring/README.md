> Spring 프레임워크에 대한 이론 및 실습.
>
> 참고 강의 및 자료.
>
> * [인프런 - 김영한 : 스프링 완전 정복](https://www.inflearn.com/roadmaps/373)
> * [Udemy - Spring Boot 3, Spring 6 & Hibernate](https://www.udemy.com/course/spring-hibernate-tutorial/?couponCode=ST8MT40924)
> * [쉬운 코드 - 유튜브](https://www.youtube.com/@ez.)
> * [spring.academy](https://spring.academy/paths/spring-certified-professional-2023)

---

## Requirements

* Java 17 or 21
* Spring Boot 3.2.2
* h2database 2.2.224
* [Lombok 적용법](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(006)Lombok)

---

## Index

### [1) Spring 소개]((001)Spring%20Introduction)

1. [Introduction]((001)Spring%20Introduction#1-introduction)
   * ```Spring```, ```SpringBoot``` 소개
   * ```Gradle```
   * MVC Pattern
2. [Spring Boot Project Configuration]((001)Spring%20Introduction#2-spring-boot-project-configuration)
   * Spring Boot 프로젝트 생성하기
   * 실행 확인하기
   * View 설정하기
   * 빌드 후 실행
3. [Spring 웹 개발]((001)Spring%20Introduction#3-spring-%EC%9B%B9-%EA%B0%9C%EB%B0%9C)
   * Static Contents
   * MVC & Template Engine
   * API
4. [회원 관리 기능 개발 I]((001)Spring%20Introduction#4-%ED%9A%8C%EC%9B%90-%EA%B4%80%EB%A6%AC-%EA%B8%B0%EB%8A%A5-%EA%B0%9C%EB%B0%9C-i)
   * 비즈니스 요구 사항
   * 애플리케이션 계층 구조
   * 클래스 의존 관계
   * 회원 저장소 코드, 테스트 코드
   * 회원 서비스 코드, 테스트 코드
5. [Spring Bean & Dependency]((001)Spring%20Introduction#5-spring-bean--dependency)
   * Component Scan
   * 자바 코드로 스프링 빈 등록
6. [회원 관리 기능 개발 II]((001)Spring%20Introduction#6-%ED%9A%8C%EC%9B%90-%EA%B4%80%EB%A6%AC-%EA%B8%B0%EB%8A%A5-%EA%B0%9C%EB%B0%9C-ii)
   * 홈 화면 추가
   * 등록
   * 조회
7. [Spring DB Access]((001)Spring%20Introduction#7-spring-db-access)
   * H2 데이터베이스 Setup
   * JdbcTemplate
   * 스프링 통합 테스트
   * JPA
8. [AOP]((001)Spring%20Introduction#8-aop)
   * AOP 소개
9. [전체 요약]((001)Spring%20Introduction#%EC%A0%84%EC%B2%B4-%EC%9A%94%EC%95%BD)

---

### [2) Spring Core]((002)Spring%20Core%20-%201)

1. [Object Oriented Design(객체 지향 설계)]((002)Spring%20Core%20-%201#1-object-oriented-design%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EC%84%A4%EA%B3%84)
   * SOLID 원칙
     * SRP
     * OCP
     * LSP
     * ISP
     * DIP
     * 요약
   * OOD와 Spring
2. [Spring 핵심 원리 I - 예제 생성]((002)Spring%20Core%20-%201#2-spring-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-i---%EC%98%88%EC%A0%9C-%EC%83%9D%EC%84%B1)
   * 프로젝트 생성
   * 비즈니스 요구 사항과 설계
   * 회원 도메인 설계, 개발, 테스트
   * 주문과 할인 도메인 설계, 개발, 테스트
3. [Spring 핵심 원리 II - 객체 지향 적용]((002)Spring%20Core%20-%201#3-spring-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-ii---%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EC%A0%81%EC%9A%A9)
   * 새로운 할인 정책 개발
   * 관심사 분리
   * 새로운 구조와 할인 정책 적용
   * IoC, DI, 컨테이너
     * IoC
     * DI
     * IoC, DI 컨테이너
   * 스프링으로 전환
4. [Spring Container, Bean]((002)Spring%20Core%20-%201#4-spring-container--bean)
   * 스프링 컨테이너
   * 스프링 빈 조회
     * 컨테이너에 등록된 모든 빈 조회
     * 빈 조회하기
     * 상속관계의 빈 조회
   * ```BeanFactory```, ```ApplicationContext```
5. [Singleton Container]((002)Spring%20Core%20-%201#5-singleton-container)
   * 스프링이 없는 순수한 DI 컨테이너
   * 싱글톤 패턴(Singleton Pattern)
   * 스프링의 싱글톤 컨테이너
   * 싱글톤 방식의 주의점
   * ```@Configuration```
6. [Component Scan]((002)Spring%20Core%20-%201#6-component-scan)
   * ```@ComponentScan```, ```@Autowired```
   * ```@ComponentScan```의 탐색 위치와 스캔 대상
   * 필터, 중복 등록과 충돌
     * 필터
     * 중복 등록과 충돌돌
7. [Dependency Injection (DI, 의존관계 주입)]((002)Spring%20Core%20-%201#7-%EC%9D%98%EC%A1%B4%EA%B4%80%EA%B3%84-%EC%9E%90%EB%8F%99-%EC%A3%BC%EC%9E%85autowired)
   * DI(의존관계 주입)
     * 생성자 주입
     * 수정자 주입
     * 필드 주입
     * 메서드 주입
   * ```@Autowired``` 옵션 처리
   * 생성자 주입 권장
   * ```@Autowired 필드명```, ```@Qualifier```, ```@Primary```
     * 조회되는 빈이 2개 이상인 문제
     * ```@Autowired 필드명``` 매칭
     * ```@Qualifier```
     * ```@Primary```
   * 조회한 빈이 모두 필요한 경우
8. [Spring Bean Lifecycle Callbacks(빈 생명주기 콜백)]((002)Spring%20Core%20-%201#8-spring-bean-lifecycle-callbacks)
   * 빈 생명주기 콜백
   * 초기화, 소멸 메서드 지정
   * ```@PostConstruct```, ```@PreDestroy```
9. [Spring Bean Scope]((002)Spring%20Core%20-%201#9-spring-bean-scope)
   * Singleton vs Prototype
     * 싱글톤과 프로토타입 비교
     * 싱글톤과 프로토타입 함께 사용시의 문제
   * Provider
   * Web Scope
     * 웹 스코프 소개
     * Request Scope
10. [전체 요약]((002)Spring%20Core%20-%201#%EC%A0%84%EC%B2%B4-%EC%9A%94%EC%95%BD)

---

### [3) Spring MVC]((003)Spring%20MVC%20-%201)

1. [Web Application]((003)Spring%20MVC%20-%201#1-web-application)
   * Web Server, Was
   * Thread Pool
   * AJAX
   * SSR(서버 사이드 렌더링), CSR(클라이언트 사이드 렌더링)
2. [MVC(Model View Controller)]((003)Spring%20MVC%20-%201#2-mvcmodel-view-controller)
   * MVC 소개
   * Front Controller
   * Front Controller 도입
   * View 분리
   * Model 도입
   * 사용성 개선
   * Adapter 도입
3. [Spring MVC]((003)Spring%20MVC%20-%201#3-spring-mvc)
   * Spring MVC 구조
     * `HandlerMapping`, `HandlerAdapter`
     * `ViewResolver`
   * Spring MVC 사용해보기
   * 사용성 개선
4. [Spring MVC - 기능 살펴보기]((003)Spring%20MVC%20-%201#4-spring-mvc---%EA%B8%B0%EB%8A%A5-%EC%82%B4%ED%8E%B4%EB%B3%B4%EA%B8%B0)
   * Logging
   * `MappingController`(요청 매핑)
   * HTTP Header 조회
   * HTTP Request Parameter
     * `@RequestParam`
     * `@ModelAttribute`
   * HTTP Request Message
     * Text 전달
     * JSON 전달
   * HTTP Response
     * Static Resource 제공
     * View Template 사용
     * HTTP 메세지 사용(메세지 바디에 직접 입력)
   * `HttpMessageConverter`
   * `RequestMappingHandlerAdapter`
5. [Spring 메세지, 국제화 (Message, Internationalization)]((003)Spring%20MVC%20-%201#5-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%A9%94%EC%84%B8%EC%A7%80-%EA%B5%AD%EC%A0%9C%ED%99%94-messages-internationalization)
   * 메세지, 국제화 소개
     * 메세지
     * 국제화
   * 메세지 적용하기
     * 메세지 소스(`MessageSource`) 설정
     * 타임리프 메세지 적용
   * 국제화 적용하기
6. [검증(Validation)]((003)Spring%20MVC%20-%201#6-%EA%B2%80%EC%A6%9Dvalidation)
   * 검증 소개
   * `BindingResult`
   * 오류 코드, 메세지 처리
     * `errors.properties`
     * `rejectValue()`, `reject()`
     * `MessageCodesResolver`
     * 스프링이 직접 만든 오류 메세지 처리
   * Validator 분리
7. [Bean Validation]((003)Spring%20MVC%20-%201#7-bean-validation)
   * Bean Validation 사용해보기
   * Bean Validation 검증 순서
   * 에러 코드 수정
   * Bean Validation `ObjectError`
   * Bean Validation의 한계와 `groups`
   * Form 객체의 분리
   * `@RequestBody`에 `@Validated` 적용
8. [쿠키, 세션(Cookie, Session)]((003)Spring%20MVC%20-%201#8-%EC%BF%A0%ED%82%A4-%EC%84%B8%EC%85%98-cookie-session)
   * 로그인을 위한 요구 사항
   * 화면과 기능 구현
     * 홈 화면
     * 회원 가입
     * 로그인
   * 쿠키 사용(Cookie)
   * 세션 사용(Seesion)
     * 세션 소개
     * `HttpSession`으로 세션 구현
     * 세션 타임아웃
9. [필터, 인터셉터(Filter, Interceptor)]((003)Spring%20MVC%20-%201#9-%ED%95%84%ED%84%B0-%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0filter-interceptor)
   * 서블릿 필터(Servlet Filter) 소개
   * 필터 예시
     * 예시 1 - 사용자 요청 로깅
     * 예시 2 - 로그인 체크
   * 스프링 인터셉터(Interceptor) 소개
   * 인터셉터 예시
     * 예시 1 - 사용자 요청 로깅
     * 예시 2 - 로그인 체크
10. [오류 페이지(Error Page)]((003)Spring%20MVC%20-%201#10-%EC%98%A4%EB%A5%98-%ED%8E%98%EC%9D%B4%EC%A7%80error-page)
    * 서블릿에서의 예외 처리
       * 스프링 부트에서 제공하는 오류 페이지 기능
         * 오류 페이지 사용
         * `BasicErrorController`가 제공하는 정보
11. [API 예외 처리]((003)Spring%20MVC%20-%201#11-api-%EC%98%88%EC%99%B8-%EC%B2%98%EB%A6%AC)
    * `HandlerExceptionResolver` 소개
    * 스프링이 제공하는 `ExceptionResolver`
      * `ExceptionHandlerExceptionResolver`
    * `@ControllerAdvice`
12. [스프링 타입 컨버터]((003)Spring%20MVC%20-%201#12-%EC%8A%A4%ED%94%84%EB%A7%81-%ED%83%80%EC%9E%85-%EC%BB%A8%EB%B2%84%ED%84%B0)
    * `Converter`
    * `ConversionService`
    * `Converter` 사용하기
    * `Formatter`
    * `FormattingConversionService`
    * 스프링 제공 `Formatter`
13. [파일 업로드]((003)Spring%20MVC%20-%201#13-%ED%8C%8C%EC%9D%BC-%EC%97%85%EB%A1%9C%EB%93%9C)

---

### [4) Thymeleaf]((004)%20Thymeleaf)

1. [타임리프(Thymeleaf) 소개]((004)Thymeleaf#1-%ED%83%80%EC%9E%84%EB%A6%AC%ED%94%84thymeleaf-%EC%86%8C%EA%B0%9C)
2. [타임리프의 기본 기능]((004)Thymeleaf#2-%ED%83%80%EC%9E%84%EB%A6%AC%ED%94%84%EC%9D%98-%EA%B8%B0%EB%B3%B8-%EA%B8%B0%EB%8A%A5)
   * [`th:href`, `th:onclick`]((004)Thymeleaf#20-thhref-thonclick)
   * [`text`, `utext`]((004)Thymeleaf#21-text-utext)
   * [SpringEL]((004)Thymeleaf#22-springel)
     * 변수 표현식 사용해보기
     * 타임리프 지역 변수
   * [기본 객체]((004)Thymeleaf#23-%EA%B8%B0%EB%B3%B8-%EA%B0%9D%EC%B2%B4)
   * [유틸리티 객체]((004)Thymeleaf#24-%EC%9C%A0%ED%8B%B8%EB%A6%AC%ED%8B%B0-%EA%B0%9D%EC%B2%B4)
   * [URL 링크]((004)Thymeleaf#25-url-%EB%A7%81%ED%81%AC-%EC%A4%91%EC%9A%94)
   * [리터럴 대체]((004)Thymeleaf#26-%EB%A6%AC%ED%84%B0%EB%9F%B4-%EB%8C%80%EC%B2%B4)
   * [연산]((004)Thymeleaf#27-%EC%97%B0%EC%82%B0)
   * [속성값 설정]((004)Thymeleaf#28-%EC%86%8D%EC%84%B1%EA%B0%92-%EC%84%A4%EC%A0%95)
   * [반복(Loop)]((004)Thymeleaf#29-%EB%B0%98%EB%B3%B5loop)
   * [조건부]((004)Thymeleaf#210-%EC%A1%B0%EA%B1%B4%EB%B6%80)
   * [주석]((004)Thymeleaf#211-%EC%A3%BC%EC%84%9D)
   * [`th:block`]((004)Thymeleaf#212-thblock)
   * [자바스크립트 인라인]((004)Thymeleaf#213-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%EC%9D%B8%EB%9D%BC%EC%9D%B8)
   * [템플릿 조각, 레이아웃(template fragment, layout)]((004)Thymeleaf#2132-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%EC%9D%B8%EB%9D%BC%EC%9D%B8-each)
     * 템플릿 조각
     * 레이아웃
     * 레이아웃을 `<html>` 전체로 확장
3. [타임리프 - 스프링]((004)Thymeleaf#3-%ED%83%80%EC%9E%84%EB%A6%AC%ED%94%84---%EC%8A%A4%ED%94%84%EB%A7%81)
   * [입력 Form 처리]((004)Thymeleaf#31-%EC%9E%85%EB%A0%A5-form-%EC%B2%98%EB%A6%AC)
   * [단일 체크박스]((004)Thymeleaf#32-%EB%8B%A8%EC%9D%BC-%EC%B2%B4%ED%81%AC%EB%B0%95%EC%8A%A4)
   * [멀티 체크박스]((004)Thymeleaf#33-%EB%A9%80%ED%8B%B0-%EC%B2%B4%ED%81%AC%EB%B0%95%EC%8A%A4)

---

### [5) Java DB Access]()

1. [JDBC]()
2. 





---

## Further Reading

* AOP
* ```BeanDefinition``` - 빈 설정 메타 정보
* Dependency Lookup (DL)
* mockito

---

## P.S

* 갓영한

---

## Reference

1. [인프런 - 김영한 : 스프링 완전 정복](https://www.inflearn.com/roadmaps/373)

1. [쉬운 코드 - 유튜브](https://www.youtube.com/@ez.)

1. [https://www.geeksforgeeks.org/mvc-framework-introduction/](https://www.geeksforgeeks.org/mvc-framework-introduction/)

1. [https://docs.spring.io/spring-boot/docs/3.2.2/reference/html/index.html](https://docs.spring.io/spring-boot/docs/3.2.2/reference/html/index.html)

1. [https://en.wikipedia.org/wiki/Query_string](https://en.wikipedia.org/wiki/Query_string)

1. [https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html](https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html)
