> Java 기본 개념 및 문법
>
> 참고 강의 및 자료
>
> * [인프런 - 실전 자바 로드맵(김영한)](https://www.inflearn.com/roadmaps/744)
> *  [자바의 정석](https://www.youtube.com/watch?v=QcXLiwZPnJQ&list=PLW2UjW795-f6xWA2_MUhEVgPauhGl3xIp&index=135)
> * [생활 코딩 자바](https://www.youtube.com/watch?v=-dPXqgWQBGE&list=PLuHgQVnccGMAIluRRVsC1e79ri-dwnBmR)
>
> * 기타(블로그, 유튜브)
>
> 포스트의 폴더 번호와 인덱스 번호는 일치하지 않습니다.

---

## Index

### 1. [자바 소개(Java Introduction)]((001)%20Java%20Introduction)

* [Programming Language]((001)%20Java%20Introduction#1-programming-language)
  * 고급 언어
  * Translator
* [자바 동작 방식(How Java Works)]((001)%20Java%20Introduction#2-%EC%9E%90%EB%B0%94-%EB%8F%99%EC%9E%91-%EB%B0%A9%EC%8B%9Dhow-java-works)
* [자바 메모리 구조(Java Memory Structure)]((001)%20Java%20Introduction#3-java-memory-structure)
  * 메서드 영역(Method Area)
  * 스택 영역(Stack Area)
  * 힙 영역(Heap Area)
* [JVM, JDK, JRE]((001)%20Java%20Introduction#4-jvm-jdk-jre)
  * JDK
  * JRE
  * JVM

### 2. [Basic Syntax]((002)%20Basic%20Syntax)

* [변수(Variables)]((002)%20Basic%20Syntax#1-variables)
* 자바 관례
* [연산자(Operators)]((002)%20Basic%20Syntax#3-%EC%97%B0%EC%82%B0%EC%9E%90operators)
* [조건문(Conditional)]((002)%20Basic%20Syntax#4-%EC%A1%B0%EA%B1%B4%EB%AC%B8conditional)
* [반복문(Loop)]((002)%20Basic%20Syntax#5--%EB%B0%98%EB%B3%B5%EB%AC%B8loop)

### 3. [배열(Array)]((003)%20Array)

* 배열(Array)
* 배열 사용하기
* 2차원 배열(2D Array)

### 4. [형변환(Type Casting)]((004)%20Typecasting)

* 자동 형변환
* 명시적 형변환
* 계산시 형변환

### 5. [메서드(Method)]((005)%20Method)

* 메서드 소개
* `static` 메서드
* 인스턴스 메서드(Instance Method)
* 오버로딩(Overloading)
* 오버라이딩(Overriding)

### 6. [클래스(Class)]((006)%20Class)

* 클래스, 인스턴스(Class, Instance)
  * 클래스 작성, 인스턴스 생성
* 객체 배열(Array of Objects)

### 7. [참조형(Reference Type)]((007)%20Reference%20Type)

* Primitive vs Reference
* 참조형에 대입
* `null`
* NullPointerException (NPE)

### 8. [객체지향 프로그래밍(OOP)]((008)%20OOP%20Introduction)

* OOP vs POP
* 인스턴스 메서드(Instance Method)
* `static` 메서드(Static Method)
* 캡슐화 (Encapsulation)

### 9. [생성자(Constructor)]((009)%20Constructor)

* 생성자(Constructor)
* `this`
* 생성자 사용 조건
* 기본 생성자(Default Constructor)
* 생성자 오버로딩
* `this()`

### 10. [패키지(Package)]((010)%20Package)

* 패키지(Package)
* `import`
  * `import`
  * 정적 `import` 
* 패키지 관례

### 11. [접근 제어자(Access Modifier)]((011)%20Access%20Modifier)

* 접근 제어자(Access Modifier)
* 접근 제어자 사용해보기
  * Field, Method
  * Constructor
  * Class
* 캡슐화(Encapsulation)

### 12. [Static]((012)%20Static)

* `static`
* 정적 변수(Static variable)
  * 정적 변수 소개
  * `static` 사용 vs `static` 사용하지 않기
* 정적 메서드(Static Method)
* 정적 임포트(Static Import)

### 13. [```final```]((013)%20Constant%2C%20final)

* `final`
* `final`이 붙은 지역 변수(Local variable)
* `final`이 붙은 멤버 변수(Member variable, Field)
* 상수(Constant)

### 14. [상속(Inheritance)]((014)%20Inheritance)

* 상속(Inheritance)
  * 상속 소개
  * 상속하지 않는 경우
  * 상속하는 경우
* 단일 상속(Single Inheritance)
* Java 상속의 메모리 할당 구조
* Method Overriding
* `protected`
* `super`
* `super()`

### 15. [다형성(Polymorphism)]((015)%20Polymorphism)

* [다형성(Polymorphism)]((015)%20Polymorphism#1-%EB%8B%A4%ED%98%95%EC%84%B1polymorphism)
* [형변환(Casting)]((015)%20Polymorphism#2-%ED%98%95%EB%B3%80%ED%99%98casting)
  * 다운캐스팅(Downcasting)
    * 일시적 다운캐스팅
    * 다운 캐스팅시 주의점
  * 업캐스팅(Upcasting)
* [`instanceof`]((015)%20Polymorphism#3-instanceof)
* [Method Overriding]((015)%20Polymorphism#4-method-overriding)
* [다형성의 활용]((015)%20Polymorphism#5-%EB%8B%A4%ED%98%95%EC%84%B1%EC%9D%98-%ED%99%9C%EC%9A%A9)
  * 다형성 사용하기
  * 한계
* [추상 클래스(abstract class)]((015)%20Polymorphism#6-%EC%B6%94%EC%83%81-%ED%81%B4%EB%9E%98%EC%8A%A4abstract-class)
* [인터페이스(interface)]((015)%20Polymorphism#7-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4interface)
  * 인터페이스 소개
  * 인터페이스를 통한 다중구현

### 16. [불변(Immutable)]((027)%20Immutable%20Object)

* [공유]((027)%20Immutable%20Object#1-%EA%B3%B5%EC%9C%A0)
  * 기본형과 참조형의 공유
  * 사이드 이펙트(Side-effect)
* [불변 객체(Immutable Object)]((027)%20Immutable%20Object#2-%EB%B6%88%EB%B3%80-%EA%B0%9D%EC%B2%B4immutable-object)
  * 불변 객체 소개
  * 불변 객체에서 값 변경
  * 불변이 중요한 이유

### 17. [오브젝트, 스트링(Object, String Class)]((022)%20Object%2C%20String%20Class)

* [`Object` 클래스]((022)%20Object%2C%20String%20Class#1-object-%ED%81%B4%EB%9E%98%EC%8A%A4)
  * `java.lang` 패키지
  * [`Object` 클래스 소개]((022)%20Object%2C%20String%20Class#12-object-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%86%8C%EA%B0%9C)
  * `Object` 배열
  * `toString()`
  * [`equals()`]((022)%20Object%2C%20String%20Class#15-equals)
* [`String` 클래스]((022)%20Object%2C%20String%20Class#2-string-%ED%81%B4%EB%9E%98%EC%8A%A4)
  * `String` 클래스 소개
  * [`String` 객체 비교]((022)%20Object%2C%20String%20Class#22-string-%EA%B0%9D%EC%B2%B4-%EB%B9%84%EA%B5%90)
  * `String`은 불변 객체
  * [`String` 메서드]((022)%20Object%2C%20String%20Class#24-string-%EB%A9%94%EC%84%9C%EB%93%9C)
    * 문자열 정보 조회
    * 문자열 비교
    * 문자열 검색
    * 문자열 조작 및 변환
    * 문자열 분할 및 조합
    * 기타
  * [`StringBuilder`]((022)%20Object%2C%20String%20Class#25-stringbuilder)

### 18. [래퍼 클래스(Wrapper Class)]((026)%20Wrapper%20Class)

* [기본형(Primitive Type)의 한계]((026)%20Wrapper%20Class#1-%EA%B8%B0%EB%B3%B8%ED%98%95primitive-type%EC%9D%98-%ED%95%9C%EA%B3%84)
* [자바 래퍼 클래스(Wrapper Class)]((026)%20Wrapper%20Class#2-%EC%9E%90%EB%B0%94-%EB%9E%98%ED%8D%BC-%ED%81%B4%EB%9E%98%EC%8A%A4wrapper-class)
  * 래퍼 클래스 소개
  * 오토박싱(Auto-boxing)
  * 래퍼 클래스의 메서드
  * 래퍼 클래스의 성능
* [`System`, `Math`, `Random` 클래스]((026)%20Wrapper%20Class#3-system-math-random-%ED%81%B4%EB%9E%98%EC%8A%A4)
  * `System` 클래스
  * `Math` 클래스
  * `Random` 클래스

### 19. [열거형(Enum)]((020)%20Enum)

* [타입 안정성(Type-safety)]((020)%20Enum#1-%ED%83%80%EC%9E%85-%EC%95%88%EC%A0%95%EC%84%B1type-safety)
  * `String`은 타입 안정성이 떨어진다
  * 타입 안전 열거형 패턴(Type-safe Enum Pattern)
* [열거형(`enum`)]((020)%20Enum#2-%EC%97%B4%EA%B1%B0%ED%98%95enum)
  * `enum` 사용
  * `Enum` 클래스 메서드
  * 열거형을 이용한 리펙토링
  * 열거형 정리

### 20. [중첩 클래스(Nested Class)]((021)%20Nested%20Class)

* [중첩 클래스(Nested Class)]((021)%20Nested%20Class#1-%EC%A4%91%EC%B2%A9-%ED%81%B4%EB%9E%98%EC%8A%A4nested-class)
  * 중첩 클래스 소개
* [정적 중첩 클래스(Static Nested Class)]((021)%20Nested%20Class#2-%EC%A0%95%EC%A0%81-%EC%A4%91%EC%B2%A9-%ED%81%B4%EB%9E%98%EC%8A%A4static-nested-class)
  * [정적 중첩 클래스 소개]((021)%20Nested%20Class#21-%EC%A0%95%EC%A0%81-%EC%A4%91%EC%B2%A9-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%86%8C%EA%B0%9C)
  * [정적 중첩 클래스를 사용하는 경우]((021)%20Nested%20Class#22-%EC%A0%95%EC%A0%81-%EC%A4%91%EC%B2%A9-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EA%B2%BD%EC%9A%B0)
* [내부 클래스(Inner Class)]((021)%20Nested%20Class#3-%EB%82%B4%EB%B6%80-%ED%81%B4%EB%9E%98%EC%8A%A4inner-class)
  * [내부 클래스 소개]((021)%20Nested%20Class#31-%EB%82%B4%EB%B6%80-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%86%8C%EA%B0%9C)
  * [내부 클래스를 사용하는 경우]((021)%20Nested%20Class#32-%EB%82%B4%EB%B6%80-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EA%B2%BD%EC%9A%B0)
* [지역 클래스(Local Class)]((021)%20Nested%20Class#4-%EC%A7%80%EC%97%AD-%ED%81%B4%EB%9E%98%EC%8A%A4local-class)
  * [지역 클래스 소개]((021)%20Nested%20Class#41-%EC%A7%80%EC%97%AD-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%86%8C%EA%B0%9C)
  * [지역 클래스 예시]((021)%20Nested%20Class#42-%EC%A7%80%EC%97%AD-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%98%88%EC%8B%9C)
  * [지역 변수 캡쳐(Variable Capture)]((021)%20Nested%20Class#43-%EC%A7%80%EC%97%AD-%EB%B3%80%EC%88%98-%EC%BA%A1%EC%B3%90variable-capture)
    * 지역 변수 캡쳐 동작 과정
    * effectively final
* [익명 클래스(Anonymous Class)]((021)%20Nested%20Class#5-%EC%9D%B5%EB%AA%85%ED%81%B4%EB%9E%98%EC%8A%A4anonymous-class)
  * [익명 클래스 소개]((021)%20Nested%20Class#51-%EC%9D%B5%EB%AA%85-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%86%8C%EA%B0%9C)
  * [익명 클래스를 사용하는 경우]((021)%20Nested%20Class#52-%EC%9D%B5%EB%AA%85-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EA%B2%BD%EC%9A%B0)

### 21. [예외 처리(Exception Handling)]((016)%20Exception)

* [예외, 에러(Exception, Error)]((016)%20Exception#1-%EC%98%88%EC%99%B8-%EC%97%90%EB%9F%ACexception-error)
  * [예외(Exception) 소개]((016)%20Exception#11-%EC%98%88%EC%99%B8exception-%EC%86%8C%EA%B0%9C)
  * [예외 기본 규칙]((016)%20Exception#11-%EC%98%88%EC%99%B8-%EA%B8%B0%EB%B3%B8-%EA%B7%9C%EC%B9%99)
* [예외 발생시키기(`throw`)]((016)%20Exception#2-%EC%98%88%EC%99%B8-%EB%B0%9C%EC%83%9D%EC%8B%9C%ED%82%A4%EA%B8%B0throw)
* [예외 처리하기(`try-catch`)]((016)%20Exception#3-%EC%98%88%EC%99%B8-%EC%B2%98%EB%A6%AC%ED%95%98%EA%B8%B0try-catch)
  * [`try-catch` 소개]((016)%20Exception#31-try-catch-%EC%86%8C%EA%B0%9C)
  * [예외 세분화]((016)%20Exception#32-%EC%98%88%EC%99%B8-%EC%84%B8%EB%B6%84%ED%99%94)
  * 멀티 `catch`(`|`)
* [예외 객체 참조 변수(Exception Variable)]((016)%20Exception#4-%EC%98%88%EC%99%B8-%EA%B0%9D%EC%B2%B4-%EC%B0%B8%EC%A1%B0-%EB%B3%80%EC%88%98exception-variable)
* [예외 던지기(`throws`)]((016)%20Exception#5-%EC%98%88%EC%99%B8-%EB%8D%98%EC%A7%80%EA%B8%B0throws)
  * [`throws` 소개]((016)%20Exception#51-throws-%EC%86%8C%EA%B0%9C)
  * [`throws`가 처리되는 과정]((016)%20Exception#52-throws%EA%B0%80-%EC%B2%98%EB%A6%AC%EB%90%98%EB%8A%94-%EA%B3%BC%EC%A0%95)
* [Checked, Unchecked Exception]((016)%20Exception#6-checked-unchecked-%EC%98%88%EC%99%B8)
  * [체크, 언체크 예외 소개]((016)%20Exception#61-%EC%B2%B4%ED%81%AC-%EC%96%B8%EC%B2%B4%ED%81%AC-%EC%98%88%EC%99%B8-%EC%86%8C%EA%B0%9C)
  * [체크 예외(Checked Exception)]((016)%20Exception#62-%EC%B2%B4%ED%81%AC-%EC%98%88%EC%99%B8checked-exception)
  * [언체크 예외(Unchecked Exception, 런타임 예외)]((016)%20Exception#63-%EC%96%B8%EC%B2%B4%ED%81%AC-%EC%98%88%EC%99%B8unchecked-exception-%EB%9F%B0%ED%83%80%EC%9E%84-%EC%98%88%EC%99%B8)
* [`try-catch-finally`]((016)%20Exception#7-try-catch-finally)
* [`try-with-resource`]((016)%20Exception#8-try-with-resource)
  * [`try-with-resource` 소개]((016)%20Exception#81-try-with-resource-%EC%86%8C%EA%B0%9C)
  * [사용 예시 1]((016)%20Exception#82-%EC%82%AC%EC%9A%A9-%EC%98%88%EC%8B%9C-1)
  * [사용 예시 2]((016)%20Exception#83-%EC%82%AC%EC%9A%A9-%EC%98%88%EC%8B%9C-2)
* [체크 예외를 잘 사용하지 않는 이유]((016)%20Exception#9-%EC%B2%B4%ED%81%AC-%EC%98%88%EC%99%B8%EB%A5%BC-%EC%9E%98-%EC%82%AC%EC%9A%A9%ED%95%98%EC%A7%80-%EC%95%8A%EB%8A%94-%EC%9D%B4%EC%9C%A0)
  * [체크 예외(Checked Exception)의 단점]((016)%20Exception#91-%EC%B2%B4%ED%81%AC-%EC%98%88%EC%99%B8checked-exception%EC%9D%98-%EB%8B%A8%EC%A0%90)
  * [언체크 예외(Uncheck Exception)의 사용]((016)%20Exception#92-%EC%96%B8%EC%B2%B4%ED%81%AC-%EC%98%88%EC%99%B8unchecked-exception-%EB%9F%B0%ED%83%80%EC%9E%84-%EC%98%88%EC%99%B8%EC%9D%98-%EC%82%AC%EC%9A%A9)
    * 언체크 예외 사용 방안
    * 언체크 예외 사용 예시

### 22. [```java.time```패키지]((017)%20Date%20and%20Time#table-of-contents)

* [날짜와 시간 라이브러리]((017)%20Date%20and%20Time#1-%EB%82%A0%EC%A7%9C%EC%99%80-%EC%8B%9C%EA%B0%84-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC)
  * 날짜와 시간의 계산
  * [날짜와 시간 라이브러리 소개]((017)%20Date%20and%20Time#12-%EB%82%A0%EC%A7%9C%EC%99%80-%EC%8B%9C%EA%B0%84-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC-%EC%86%8C%EA%B0%9C)
    * `java.util.Date`
    * `java.util.Calendar`
    * `java.time`
* [`java.time` 패키지]((017)%20Date%20and%20Time#2-javatime-%ED%8C%A8%ED%82%A4%EC%A7%80)
  * `LocalDate`
  * `LocalTime`
  * [`LocalDateTime`]((017)%20Date%20and%20Time#23-localdatetime)
  * [`ZonedDateTime`]((017)%20Date%20and%20Time#24-zoneddatetime)
    * `ZoneId`
    * `ZonedDateTime`
  * `OffsetDateTime`
  * [`Period`, `Duration`]((017)%20Date%20and%20Time#26-period-duration)
  * [`Instant`]((017)%20Date%20and%20Time#27-instant)
* [ `TemporalAccessor`, `TemporalAmount`, `ChronoUnit`]((017)%20Date%20and%20Time#3-temporalaccessor-temporalamount-chronounit)
  *  `TemporalAccessor`, `TemporalAmount`
  * [`ChronoUnit`, `ChronoField`]((017)%20Date%20and%20Time#32-chronounit-chronofield)
    * `ChronoUnit`
    * `ChronoField`
* [날짜와 시간 조회, 조작하기]((017)%20Date%20and%20Time#4-%EB%82%A0%EC%A7%9C%EC%99%80-%EC%8B%9C%EA%B0%84-%EC%A1%B0%ED%9A%8C-%EC%A1%B0%EC%9E%91%ED%95%98%EA%B8%B0)
  * 조회하기
  * 조작하기
  * `with()`
* [`Formatter`]((017)%20Date%20and%20Time#5-formatter)

### 23. [제네릭스(Generics)]((019)%20Generics)

* [제네릭스(Generics)]((019)%20Generics#1-%EC%A0%9C%EB%84%A4%EB%A6%AD%EC%8A%A4generics)
  * [제네릭스 설명]((019)%20Generics#11-%EC%A0%9C%EB%84%A4%EB%A6%AD%EC%8A%A4-%EC%84%A4%EB%AA%85)
  * 제네릭스 사용해보기
  * 타입 변수 관례
* [제네릭 제한(Generic Constraint)]((019)%20Generics#2-%EC%A0%9C%EB%84%A4%EB%A6%AD-%EC%A0%9C%ED%95%9Cgeneric-constraint)
  * [제한이 없을 경우의 문제점]((019)%20Generics#21-%EC%A0%9C%ED%95%9C%EC%9D%B4-%EC%97%86%EC%9D%84-%EA%B2%BD%EC%9A%B0%EC%9D%98-%EB%AC%B8%EC%A0%9C%EC%A0%90)
  * [타입 매개변수의 제한 도입]((019)%20Generics#22-%ED%83%80%EC%9E%85-%EB%A7%A4%EA%B0%9C%EB%B3%80%EC%88%98%EC%9D%98-%EC%A0%9C%ED%95%9C-%EB%8F%84%EC%9E%85)
* [제네릭 메서드(Generic Method)]((019)%20Generics#3-%EC%A0%9C%EB%84%A4%EB%A6%AD-%EB%A9%94%EC%84%9C%EB%93%9Cgeneric-method)
  * [제네릭 메서드 설명]((019)%20Generics#31-%EC%A0%9C%EB%84%A4%EB%A6%AD-%EB%A9%94%EC%84%9C%EB%93%9C-%EC%84%A4%EB%AA%85)
  * [제네릭 메서드 사용해보기]((019)%20Generics#32-%EC%A0%9C%EB%84%A4%EB%A6%AD-%EB%A9%94%EC%84%9C%EB%93%9C-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%B3%B4%EA%B8%B0)
* [와일드카드(Wildcard, `?`)]((019)%20Generics#4-%EC%99%80%EC%9D%BC%EB%93%9C%EC%B9%B4%EB%93%9Cwildcard-)
  * [와일드카드 설명]((019)%20Generics#41-%EC%99%80%EC%9D%BC%EB%93%9C%EC%B9%B4%EB%93%9C-%EC%84%A4%EB%AA%85)
  * [제한을 사용하지 않은 와일드카드]((019)%20Generics#42-%EC%A0%9C%ED%95%9C%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%98%EC%A7%80-%EC%95%8A%EC%9D%80-%EC%99%80%EC%9D%BC%EB%93%9C-%EC%B9%B4%EB%93%9C)
  * [제네릭 메서드 vs 와일드카드]((019)%20Generics#43-%EC%A0%9C%EB%84%A4%EB%A6%AD-%EB%A9%94%EC%84%9C%EB%93%9C-vs-%EC%99%80%EC%9D%BC%EB%93%9C-%EC%B9%B4%EB%93%9C)
  * [상한, 하한 제한 와일드카드]((019)%20Generics#44-%EC%83%81%ED%95%9C-%ED%95%98%ED%95%9C-%EC%A0%9C%ED%95%9C-%EC%99%80%EC%9D%BC%EB%93%9C%EC%B9%B4%EB%93%9C)
    * 상한 제한 와일드카드(Upper-bound)
    * 하한 제한 와일드카드(Lower-bound)
  * [제네릭 클래스, 메서드를 사용해야하는 경우]((019)%20Generics#45-%EC%A0%9C%EB%84%A4%EB%A6%AD-%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%A9%94%EC%84%9C%EB%93%9C%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%B4%EC%95%BC%ED%95%98%EB%8A%94-%EA%B2%BD%EC%9A%B0)

### 24. [컬렉션 프레임워크(`Collection`)]((018)%20Collection)

* [`Collection` 프레임워크]((018)%20Collection#1-collection-%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8C%ED%81%AC)
* [`Collection`]((018)%20Collection#2-collection)
* [`Iterator`]((018)%20Collection#3-iterable-iterator)
  * [`Iterable`, `Iterator` 설명]((018)%20Collection#31-iterable-iterator-%EC%84%A4%EB%AA%85)
  * [`Iterator` 구현]((018)%20Collection#32-iterator-%EA%B5%AC%ED%98%84)
* [`List`]((018)%20Collection#4-list)
  * `ArrayList`
  * `LinkedList`
* [`Set`]((018)%20Collection#5-set)
  * `HashSet`
  * `TreeSet`
* [`Map`]((018)%20Collection#6-map)
  * `HashMap`
* [`Stack`, `Queue`, `ArrayDeque`]((018)%20Collection#7-stack-queue-arraydeque)
  * `ArrayDeque`
* [`Comparable`, `Comparator`]((018)%20Collection#8-comparable--comparator)
  * [`Comparator`]((018)%20Collection#81-comparator)
  * [`Comparable`]((018)%20Collection#82-comparable)
  * `Comparator`, `Comparable` 예시
* [컬렉션 유틸(`Collections`)]((018)%20Collection#9-%EC%BB%AC%EB%A0%89%EC%85%98-%EC%9C%A0%ED%8B%B8collections)
  * [정렬, 최댓값, 최소값]((018)%20Collection#91-%EC%A0%95%EB%A0%AC-%EC%B5%9C%EB%8C%80%EA%B0%92-%EC%B5%9C%EC%86%8C%EA%B0%92)
  * [컬렉션 생성]((018)%20Collection#92-%EC%BB%AC%EB%A0%89%EC%85%98-%EC%83%9D%EC%84%B1)
  * 멀리스레드 동기화(`SynchronizedXxx()`)

### 25. [스레드(Thread)]((023)%20Thread)

* [스레드(Thread)]((023)%20Thread)
  * `Thread` 클래스 상속
  * `Runnable` 인터페이스 구현
  * 스레드 사용해보기
* [메인 스레드]((023)%20Thread#2-%EB%A9%94%EC%9D%B8-%EC%8A%A4%EB%A0%88%EB%93%9Cmain-thread)
* [스레드의 I/O Blocking]((023)%20Thread#3-%EC%8A%A4%EB%A0%88%EB%93%9C%EC%9D%98-io-blocking)
* [스레드 그룹(Thread Group)]((023)%20Thread#4-%EC%8A%A4%EB%A0%88%EB%93%9C-%EA%B7%B8%EB%A3%B9thread-group)
* [데몬 스레드(Daemon Thread)]((023)%20Thread#5-%EB%8D%B0%EB%AA%AC-%EC%8A%A4%EB%A0%88%EB%93%9Cdaemon-thread)
* [스레드 상태(Thread State)]((023)%20Thread#6-%EC%8A%A4%EB%A0%88%EB%93%9C%EC%9D%98-%EC%83%81%ED%83%9Cthread-state)
* [스레드의 동기화(synchronized)]((023)%20Thread#7-%EC%8A%A4%EB%A0%88%EB%93%9C%EC%9D%98-%EB%8F%99%EA%B8%B0%ED%99%94-synchronized)
* [`ThreadLocal`]((023)%20Thread#8-threadlocal)
  * [동시성 문제]((023)%20Thread#81-%EB%8F%99%EC%8B%9C%EC%84%B1-%EB%AC%B8%EC%A0%9C)
  * [`ThreadLocal`을 통해 문제 해결]((023)%20Thread#82-threadlocal%EC%9D%84-%ED%86%B5%ED%95%B4-%EB%AC%B8%EC%A0%9C-%ED%95%B4%EA%B2%B0)

### 26. [람다(Lambda)]((024)%20Lambda)

* [람다 표현식(Lambda Expression)]((024)%20Lambda#1-%EB%9E%8C%EB%8B%A4-%ED%91%9C%ED%98%84%EC%8B%9Dlambda-expression)
  * 람다식 소개
* [함수형 인터페이스(Functional Interface)]((024)%20Lambda#2-%ED%95%A8%EC%88%98%ED%98%95-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4functional-interface)
* [메서드 참조(Method Reference)]((024)%20Lambda#3-%EB%A9%94%EC%84%9C%EB%93%9C-%EC%B0%B8%EC%A1%B0method-reference)
* [람다의 단점]((024)%20Lambda#4-%EB%9E%8C%EB%8B%A4%EC%9D%98-%EB%8B%A8%EC%A0%90)

### 27. [스트림(Stream)]((025)%20Stream)

* [스트림(Stream)]((025)%20Stream#1-%EC%8A%A4%ED%8A%B8%EB%A6%BCstream)
  * 스트림 소개
  * 스트림의 특징
    * 읽기만 함(read-only)
    * 한번만 사용(use only once), 지연 연산(lazy evaluation)
    * 병렬 스트림(parallel stream)
    * 기본형 스트림(primitive stream)
* [스트림 생성]((025)%20Stream#2-%EC%8A%A4%ED%8A%B8%EB%A6%BC-%EC%83%9D%EC%84%B1)
  * 컬렉션
  * 배열
  * 난수, 특정 범위의 정수
  * `iterate()`, `generate()`
  * `Files`, `empty()`
* [중간 연산(Intermediate Opertation)]((025)%20Stream#3-%EC%A4%91%EA%B0%84-%EC%97%B0%EC%82%B0intermediate-operation)
  * `skip()`, `limit()`
  * `filter()`, `distinct()`
  * `sorted()`
  * `map()`, `flatMap()`
  * `peek()`
* [`Optional<T>`]((025)%20Stream#4-optionalt)
* [최종 연산(Terminal Opertation)]((025)%20Stream#5-%EC%B5%9C%EC%A2%85-%EC%97%B0%EC%82%B0terminal-operation)
  * `forEach()`
  * `xxxMatch()`
  * `findxxx()`
  * `reduce()`
  * `collect()`, `Collectors`
    * `collect()` 사용하기
    * `partitioningBy()`, `groupingBy()`

### 28. [JVM]((028)%20JVM)

---

## Requirements

* Java 11^ 권장
* IntelliJ

<br>

---

## P.S.

* 모든 다이어그램은 UML 표준을 준수하지 않았습니다

<br>

---

## Further Reading

* 연결된 예외(Chained Exception)
* ```DecimalFormat```
* ```SimpleDateFormat```
* ```Collections```
* `Serializable`
* `java.util.function`

<br>

---

## Reference

1. [김영한의 자바 입문](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%9E%90%EB%B0%94-%EC%9E%85%EB%AC%B8)
2. [김영한의 자바 기본](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B8%B0%EB%B3%B8%ED%8E%B8/dashboard)
3. [김영한의 자바 중급](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EC%A4%91%EA%B8%89-1)
4. [자바의 정석 기초편](https://www.youtube.com/user/MasterNKS)
5. [생활 코딩 자바](https://www.youtube.com/watch?v=-dPXqgWQBGE&list=PLuHgQVnccGMAIluRRVsC1e79ri-dwnBmR)
6. [점프 투 자바](https://wikidocs.net/book/31)
7. [Java docs](https://docs.oracle.com/javase/8/docs/api/overview-summary.html)
8. [Wikipedia Bitwise Operation](https://en.wikipedia.org/wiki/Bitwise_operation)
9. [Wikipedia Diamond Problem](https://en.wikipedia.org/wiki/Multiple_inheritance#The_diamond_problem)
10. https://st-lab.tistory.com/243
