> Spring 프레임워크에 대한 기초 및 실습.
>
> [인프런 - 김영한 : 스프링 완전 정복](https://www.inflearn.com/roadmaps/373)을 참고 했습니다.

---

## Requirements

* Java 17 or 21
* Spring Boot 3.2.2
* h2database 2.2.224

---

## Index

### [1) Spring 소개](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(001)Spring%20Introduction)

1. [Introduction](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(001)Spring%20Introduction#1-introduction)
   * ```Spring```, ```SpringBoot``` 소개
   * ```Gradle```
   * MVC Pattern
2. [Spring Boot Project Configuration](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(001)Spring%20Introduction#2-spring-boot-project-configuration)
   * Spring Boot 프로젝트 생성하기
   * 실행 확인하기
   * View 설정하기
   * 빌드 후 실행
3. [Spring 웹 개발](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(001)Spring%20Introduction#3-spring-%EC%9B%B9-%EA%B0%9C%EB%B0%9C)
   * Static Contents
   * MVC & Template Engine
   * API
4. [회원 관리 기능 개발 I](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(001)Spring%20Introduction#4-%ED%9A%8C%EC%9B%90-%EA%B4%80%EB%A6%AC-%EA%B8%B0%EB%8A%A5-%EA%B0%9C%EB%B0%9C-i)
   * 비즈니스 요구 사항
   * 애플리케이션 계층 구조
   * 클래스 의존 관계
   * 회원 저장소 코드, 테스트 코드
   * 회원 서비스 코드, 테스트 코드
5. [Spring Bean & Dependency](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(001)Spring%20Introduction#5-spring-bean--dependency)
   * Component Scan
   * 자바 코드로 스프링 빈 등록
6. [회원 관리 기능 개발 II](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(001)Spring%20Introduction#6-%ED%9A%8C%EC%9B%90-%EA%B4%80%EB%A6%AC-%EA%B8%B0%EB%8A%A5-%EA%B0%9C%EB%B0%9C-ii)
   * 홈 화면 추가
   * 등록
   * 조회
7. [Spring DB Access](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(001)Spring%20Introduction#7-spring-db-access)
   * H2 데이터베이스 Setup
   * JdbcTemplate
   * 스프링 통합 테스트
   * JPA
8. [AOP](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(001)Spring%20Introduction#8-aop)
   * AOP 소개
9. [전체 요약](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(001)Spring%20Introduction#%EC%A0%84%EC%B2%B4-%EC%9A%94%EC%95%BD)

---

### [2) Spring Core](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(002)Spring%20Core%20-%201)

1. [Object Oriented Design(객체 지향 설계)](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(002)Spring%20Core%20-%201#1-object-oriented-design%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EC%84%A4%EA%B3%84)
   * SOLID 원칙
     * SRP
     * OCP
     * LSP
     * ISP
     * DIP
     * 요약
   * OOD와 Spring
2. [Spring 핵심 원리 I - 예제 생성](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(002)Spring%20Core%20-%201#2-spring-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-i---%EC%98%88%EC%A0%9C-%EC%83%9D%EC%84%B1)
   * 프로젝트 생성
   * 비즈니스 요구 사항과 설계
   * 회원 도메인 설계, 개발, 테스트
   * 주문과 할인 도메인 설계, 개발, 테스트
3. [Spring 핵심 원리 II - 객체 지향 적용](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(002)Spring%20Core%20-%201#3-spring-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-ii---%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EC%A0%81%EC%9A%A9)
   * 새로운 할인 정책 개발
   * 관심사 분리
   * 새로운 구조와 할인 정책 적용
   * IoC, DI, 컨테이너
     * IoC
     * DI
     * IoC, DI 컨테이너
   * 스프링으로 전환
4. [Spring Container, Bean](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(002)Spring%20Core%20-%201#4-spring-container--bean)
   * 스프링 컨테이너
   * 스프링 빈 조회
     * 컨테이너에 등록된 모든 빈 조회
     * 빈 조회하기
     * 상속관계의 빈 조회
   * ```BeanFactory```, ```ApplicationContext```
5. [Singleton Container](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(002)Spring%20Core%20-%201#5-singleton-container)
   * 스프링이 없는 순수한 DI 컨테이너
   * 싱글톤 패턴(Singleton Pattern)
   * 스프링의 싱글톤 컨테이너
   * 싱글톤 방식의 주의점
   * ```@Configuration```
6. [Component Scan](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(002)Spring%20Core%20-%201#6-component-scan)
   * ```@ComponentScan```, ```@Autowired```
   * ```@ComponentScan```의 탐색 위치와 스캔 대상
   * 필터, 중복 등록과 충돌
     * 필터
     * 중복 등록과 충돌돌
7. [Dependency Injection (DI, 의존관계 주입)](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(002)Spring%20Core%20-%201#7-%EC%9D%98%EC%A1%B4%EA%B4%80%EA%B3%84-%EC%9E%90%EB%8F%99-%EC%A3%BC%EC%9E%85autowired)
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
8. [Spring Bean Lifecycle Callbacks(빈 생명주기 콜백)](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(002)Spring%20Core%20-%201#8-spring-bean-lifecycle-callbacks)
   * 빈 생명주기 콜백
   * 초기화, 소멸 메서드 지정
   * ```@PostConstruct```, ```@PreDestroy```
9. [Spring Bean Scope](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(002)Spring%20Core%20-%201#9-spring-bean-scope)
   * Singleton vs Prototype
     * 싱글톤과 프로토타입 비교
     * 싱글톤과 프로토타입 함께 사용시의 문제
   * Provider
   * Web Scope
     * 웹 스코프 소개
     * Request Scope
10. [전체 요약](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(002)Spring%20Core%20-%201#%EC%A0%84%EC%B2%B4-%EC%9A%94%EC%95%BD)



---

### [3) Spring MVC](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(003)Spring%20MVC%20-%201)

### [4) Jdbc]()



---

## Further Reading

* 객체 지향의 사실과 오해
* AOP
* ```BeanDefinition``` - 빈 설정 메타 정보
* ```LomBok``` 라이브러리 사용법
* Dependency Lookup (DL)
* Proxy

---

## P.S

* 갓영한

---

## Reference

1. [인프런 - 김영한 : 스프링 완전 정복](https://www.inflearn.com/roadmaps/373)

   * [스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/)
   * [스프링 핵심 원리 - 기본편](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8#)

1. [https://www.geeksforgeeks.org/mvc-framework-introduction/](https://www.geeksforgeeks.org/mvc-framework-introduction/)

1. [https://docs.spring.io/spring-boot/docs/3.2.2/reference/html/index.html](https://docs.spring.io/spring-boot/docs/3.2.2/reference/html/index.html)

1. [https://en.wikipedia.org/wiki/Query_string](https://en.wikipedia.org/wiki/Query_string)

1. [https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html](https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html)

   
