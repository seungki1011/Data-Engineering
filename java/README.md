> Java 기본 개념 및 문법
>
> [인프런 - 실전 자바 로드맵(김영한)](https://www.inflearn.com/roadmaps/744)과 [자바의 정석](https://www.youtube.com/watch?v=QcXLiwZPnJQ&list=PLW2UjW795-f6xWA2_MUhEVgPauhGl3xIp&index=135), 기타(구글링, 유튜브)를 참고했습니다.
>
> 포스트의 폴더 번호와 인덱스 번호는 일치하지 않습니다.

<br>

---

## Index

1. [자바 소개(Java Introduction)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(001)%20Java%20Introduction)
   * Programming Language
     * 고급 언어
     * Translator
   * 자바 동작 방식(How Java Works)
   * 자바 메모리 구조(Java Memory Structure)
     * 메서드 영역(Method Area)
     * 스택 영역(Stack Area)
     * 힙 영역(Heap Area)
   * JVM, JDK, JRE
     * JDK
     * JRE
     * JVM
2. [Basic Syntax](https://github.com/seungki1011/Data-Engineering/tree/main/java/(002)%20Basic%20Syntax)
   * [변수(Variables)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(002)%20Basic%20Syntax#1-variables)
   * Java 관례
   * [연산자(Operators)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(002)%20Basic%20Syntax#3-%EC%97%B0%EC%82%B0%EC%9E%90operators)
   * [조건문(Conditional)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(002)%20Basic%20Syntax#4-%EC%A1%B0%EA%B1%B4%EB%AC%B8conditional)
   * [반복문(Loop)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(002)%20Basic%20Syntax#5--%EB%B0%98%EB%B3%B5%EB%AC%B8loop)
3. [배열(Array)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(003)%20Array)
   * 배열(Array)
   * 배열 사용하기
   * 2차원 배열(2D Array)
4. [형변환(Type Casting)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(004)%20Typecasting)
   * 자동 형변환
   * 명시적 형변환
   * 계산시 형변환
5. [메서드(Method)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(005)%20Method)
   * 메서드 소개
   * `static` 메서드
   * 인스턴스 메서드(Instance Method)
   * 오버로딩(Overloading)
   * 오버라이딩(Overriding)
6. [클래스(Class)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(006)%20Class)
   * 클래스, 인스턴스(Class, Instance)
     * 클래스 작성, 인스턴스 생성
   * 객체 배열(Array of Objects)
7. [참조형(Reference Type)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(007)%20Reference%20Type)
   * Primitive vs Reference
   * 참조형에 대입
   * `null`
   * NullPointerException (NPE)
8. [객체지향 프로그래밍(OOP)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(008)%20OOP%20Introduction)
   * OOP vs POP
   * 인스턴스 메서드(Instance Method)
   * `static` 메서드(Static Method)
   * 캡슐화 (Encapsulation)
9. [생성자(Constructor)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(009)%20Constructor)
   * 생성자(Constructor)
   * `this`
   * 생성자 사용 조건
   * 기본 생성자(Default Constructor)
   * 생성자 오버로딩
   * `this()`
10. [패키지(Package)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(010)%20Package)
    * 패키지(Package)
    * `import`
      * `import`
      * 정적 `import` 
    * 패키지 관례
11. [접근 제어자(Access Modifier)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(011)%20Access%20Modifier)
    * 접근 제어자(Access Modifier)
    * 접근 제어자 사용해보기
      * Field, Method
      * Constructor
      * Class
    * 캡슐화(Encapsulation)
12. [Static](https://github.com/seungki1011/Data-Engineering/tree/main/java/(012)%20Static)
    * `static`
    * 정적 변수(Static variable)
      * 정적 변수 소개
      * `static` 사용 vs `static` 사용하지 않기
    * 정적 메서드(Static Method)
    * 정적 임포트(Static Import)
13. [```final```](https://github.com/seungki1011/Data-Engineering/tree/main/java/(013)%20Constant%2C%20final)
    * `final`
    * `final`이 붙은 지역 변수(Local variable)
    * `final`이 붙은 멤버 변수(Member variable, Field)
    * 상수(Constant)
14. [상속(Inheritance)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(014)%20Inheritance)
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
15. [다형성(Polymorphism)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(015)%20Polymorphism)
    * 다형성(Polymorphism)
    * 형변환(Casting)
      * 다운캐스팅(Downcasting)
        * 일시적 다운캐스팅
        * 다운 캐스팅시 주의점
      * 업캐스팅(Upcasting)
    * `instanceof`
    * Method Overriding
    * 다형성의 활용
      * 다형성 사용하기
      * 한계
    * 추상 클래스(abstract class)
    * 인터페이스(interface)
      * 인터페이스 소개
      * 인터페이스를 통한 다중구현
16. [불변(Immutable)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(027)%20Immutable%20Object)
    * [공유](https://github.com/seungki1011/Data-Engineering/tree/main/java/(027)%20Immutable%20Object#1-%EA%B3%B5%EC%9C%A0)
      * 기본형과 참조형의 공유
      * 사이드 이펙트(Side-effect)
    * [불변 객체(Immutable Object)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(027)%20Immutable%20Object#2-%EB%B6%88%EB%B3%80-%EA%B0%9D%EC%B2%B4immutable-object)
      * 불변 객체 소개
      * 불변 객체에서 값 변경
      * 불변이 중요한 이유
17. [오브젝트, 스트링(Object, String Class)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(022)%20Object%2C%20String%20Class)
    * [`Object` 클래스](https://github.com/seungki1011/Data-Engineering/tree/main/java/(022)%20Object%2C%20String%20Class#1-object-%ED%81%B4%EB%9E%98%EC%8A%A4)
      * `java.lang` 패키지
      * [`Object` 클래스 소개](https://github.com/seungki1011/Data-Engineering/tree/main/java/(022)%20Object%2C%20String%20Class#12-object-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%86%8C%EA%B0%9C)
      * `Object` 배열
      * `toString()`
      * [`equals()`](https://github.com/seungki1011/Data-Engineering/tree/main/java/(022)%20Object%2C%20String%20Class#15-equals)
    * [`String` 클래스](https://github.com/seungki1011/Data-Engineering/tree/main/java/(022)%20Object%2C%20String%20Class#2-string-%ED%81%B4%EB%9E%98%EC%8A%A4)
      * `String` 클래스 소개
      * [`String` 객체 비교](https://github.com/seungki1011/Data-Engineering/tree/main/java/(022)%20Object%2C%20String%20Class#22-string-%EA%B0%9D%EC%B2%B4-%EB%B9%84%EA%B5%90)
      * `String`은 불변 객체
      * [`String` 메서드](https://github.com/seungki1011/Data-Engineering/tree/main/java/(022)%20Object%2C%20String%20Class#24-string-%EB%A9%94%EC%84%9C%EB%93%9C)
        * 문자열 정보 조회
        * 문자열 비교
        * 문자열 검색
        * 문자열 조작 및 변환
        * 문자열 분할 및 조합
        * 기타
      * [`StringBuilder`](https://github.com/seungki1011/Data-Engineering/tree/main/java/(022)%20Object%2C%20String%20Class#25-stringbuilder)
18. [래퍼 클래스(Wrapper Class)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(026)%20Wrapper%20Class)
19. [열거형(Enum)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(020)%20Enum)
    * 열거형(`enum`)
      * `enum` 소개
      * `enum` 사용하기
      * 열거형에 멤버 추가하기
    * 열거형을 사용하는 이유
20. [내부 클래스(Inner Class)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(021)%20Inner%20Class)
21. [예외 처리(Exception Handling)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(016)%20Exception)
    * Exception, Error
    * Exception Handling
    * `e`(Exception Variable)
    * Multi Catch
    * `throw`
    * Checked, Unchecked Exception
    * `throws`
      * `throws` 소개
      * `throws`가 처리되는 과정
      * 예외 되던지기
    * `try-catch-finally`
    * `try-catch-resource`
    * 사용자 정의 예외(User Defined Exception)
22. [```java.time```패키지](https://github.com/seungki1011/Data-Engineering/tree/main/java/(017)%20Date%20and%20Time)
    * `Date`
    * `Calendar`
    * `java.time` package
      * `LocalDate`
      * `LocalTime`
      * `LocalDateTime`
      * `ZonedDateTime`
    * Period, Duration
    * Instant
    * Formatter
23. [```Collection```](https://github.com/seungki1011/Data-Engineering/tree/main/java/(018)%20Collection)
    * 컬렉션 프레임워크
    * `Collection`
    * `Iterator`
    * `List`
      * `ArrayList`
      * `LinkedList`
    * `Set`
      * `HashSet`
      * `TreeSet`
    * `Map`
      * `HashMap`
    * `Stack`, `Queue`, `ArrayDeque`
      * `ArrayDeque`
    * 익명 클래스(anonymous class)
    * `Comparable`, `Comparator`
24. [제네릭스(Generics)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(019)%20Generics)
    * Generics
      * 제네릭스 소개
      * 제네릭스 사용해보기
      * 타입 변수
      * 제네릭 클래스(Generic Class)
    * `HashMap<K, V>`
    * 제네릭 제약(Generic Constraints)
      * 제한된 제네릭 클래스
      * 제네릭스의 제약
    * 와일드 카드(Wildcard, `<?>`)
    * 제네릭 메서드(Generic Method)
25. [스레드(Thread)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(023)%20Thread)
    * 스레드 소개
      * `Thread` 클래스
      * `Runnable` 인터페이스
    * 메인 스레드
    * 스레드의 I/O Blocking
    * 스레드 그룹(Thread Group)
    * 데몬 스레드(Daemon Thread)
    * 스레드 상태(Thread State)
    * 스레드의 동기화(synchronized)
26. [Lambda](https://github.com/seungki1011/Data-Engineering/tree/main/java/(024)%20Lambda)
    * 람다식(Lambda expression)
    * 함수형 인터페이스(functional interface)
    * 메서드 참조(method reference)
    * 람다의 단점
27. [스트림(Stream)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(025)%20Stream)
    * 스트림(Stream)
      * 스트림 소개
      * 스트림의 특징
        * 읽기만 함(read-only)
        * 한번만 사용(use only once), 지연 연산(lazy evaluation)
        * 병렬 스트림(parallel stream)
        * 기본형 스트림(primitive stream)
    * 스트림 생성
      * 컬렉션
      * 배열
      * 난수, 특정 범위의 정수
      * `iterate()`, `generate()`
      * `Files`, `empty()`
    * 중간 연산(Intermediate Opertation)
      * `skip()`, `limit()`
      * `filter()`, `distinct()`
      * `sorted()`
      * `map()`, `flatMap()`
      * `peek()`
    * `Optional<T>`
    * 최종 연산(Terminal Opertation)
      * `forEach()`
      * `xxxMatch()`
      * `findxxx()`
      * `reduce()`
      * `collect()`, `Collectors`
        * `collect()` 사용하기
        * `partitioningBy()`, `groupingBy()`
28. [JVM](https://github.com/seungki1011/Data-Engineering/tree/main/java/(028)%20JVM)

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

* 연결된 예외(chained exception)
* ```DecimalFormat```
* ```SimpleDateFormat```
* ```Collections```
* Java Serializable
* `java.util.function`

<br>

---

## Reference

1. [김영한의 자바 입문](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%9E%90%EB%B0%94-%EC%9E%85%EB%AC%B8)

2. [김영한의 자바 기본](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B8%B0%EB%B3%B8%ED%8E%B8/dashboard)

3. [김영한의 자바 중급](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EC%A4%91%EA%B8%89-1)

4. [자바의 정석 기초편](https://www.youtube.com/user/MasterNKS)

5. [Java docs](https://docs.oracle.com/javase/8/docs/api/overview-summary.html)

6. [Wikipedia Bitwise Operation](https://en.wikipedia.org/wiki/Bitwise_operation)

7. [Wikipedia Diamond Problem](https://en.wikipedia.org/wiki/Multiple_inheritance#The_diamond_problem)

8. [점프 투 자바 - 인터페이스](https://wikidocs.net/217)

9. https://st-lab.tistory.com/243
