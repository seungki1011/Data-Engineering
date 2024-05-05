> 데이터 엔지니어링 기술 스택 연습
>
> 공부 내용 기록을 위한 레포

---

# Data Engineering 소개







---

# :computer: Computer Science

<details>
  <summary><h3>1. 컴퓨터 구조 및 운영 체제(Computer Structure and OS)(추가 예정)</h3></summary>

</details>

<details>
  <summary><h3>2. 네트워크(Network)와 HTTP</h3></summary>

  - [network and http/README.md](network%20and%20http/README.md)

  - <details>
      <summary>1. 네트워크(Network)(추가 예정)</summary>

    </details>
  - <details>
      <summary>2. HTTP(Hyper Text Transfer Protocol)</summary>
     
      1. [웹 통신](network%20and%20http/(002)HTTP/README.md#1-%EC%9B%B9-%ED%86%B5%EC%8B%A0)
         * 인터넷(Internet)
         * [IP(Internet Protocol)](network%20and%20http/(002)HTTP/README.md#12-ipinternet-protocol)
         * [TCP(Transmission Control Protocol)](network%20and%20http/(002)HTTP/README.md#13-tcptransmission-control-protocol)
           * TCP 소개
           * Three way handshake
           * 데이터 전달 보증, 순서 보장
         * UDP(User Datagram Protocol)
         * PORT
         * DNS(Domain Name System)
         * URI(Uniform Name Identifier)
         * [요청의 흐름](network%20and%20http/(002)HTTP/README.md#18-%EC%9B%B9%EC%97%90%EC%84%9C%EC%9D%98-%EC%9A%94%EC%B2%AD%EC%9D%98-%ED%9D%90%EB%A6%84)
      2. [HTTP](network%20and%20http/(002)HTTP/README.md#2-http)
         * HTTP 소개
         * Client-Server
         * [Stateless](network%20and%20http/(002)HTTP/README.md#23-stateless)
         * [Connectionless](network%20and%20http/(002)HTTP/README.md#24-connectionless)
         * HTTP Message
      3. [HTTP Method](network%20and%20http/(002)HTTP/README.md#3-http-method)
         * [HTTP API 설계](network%20and%20http/(002)HTTP/README.md#31-http-api-%EC%84%A4%EA%B3%84-%EC%86%8C%EA%B0%9C)
         * GET,POST
         * PUT, PATCH, DELETE
         * [HTTP 메서드의 속성](network%20and%20http/(002)HTTP/README.md#34-http-%EB%A9%94%EC%84%9C%EB%93%9C%EC%9D%98-%EC%86%8D%EC%84%B1)
           * 안전(Safe)
           * 멱등성(Idempotency)
           * 캐시 가능(Cacheable)
         * [HTTP 메서드의 활용](network%20and%20http/(002)HTTP/README.md#35-http-%EB%A9%94%EC%84%9C%EB%93%9C%EC%9D%98-%ED%99%9C%EC%9A%A9)
           * 클라이언트 → 서버 데이터 전송
           * HTTP API 설계
             * POST - 신규 자원 등록
             * PUT - 신규 자원 등록
             * HTML Form 사용
      4. [HTTP Status Code](network%20and%20http/(002)HTTP/README.md#4-http-status-code)
         * 1xx, 2xx
         * [3xx](network%20and%20http/(002)HTTP/README.md#42-3xxredirection)
           * 3xx - Permanent Redirect
           * 3xx - Temporary Redirect
         * 4xx, 5xx
      5. [HTTP Header](network%20and%20http/(002)HTTP/README.md#5-http-header)
         * [HTTP 헤더 소개](network%20and%20http/(002)HTTP/README.md#51-http-%ED%97%A4%EB%8D%94-%EC%86%8C%EA%B0%9C)
         * Representation Header(표현 헤더)
         * Content Negotiation(콘텐츠 협상)
         * 전송 방식
         * General, Request, Response Header
           * 일반 정보
           * 특별 정보
           * 인증 정보
      6. [쿠키(Cookie)](network%20and%20http/(002)HTTP/README.md#6-cookie)
         * [쿠키 소개](network%20and%20http/(002)HTTP/README.md#61-%EC%BF%A0%ED%82%A4-%EC%86%8C%EA%B0%9C)
         * Cookie - Expiration
         * Cookie - Domain
         * Cookie - Path
         * Cookie - Secure
      7. [캐시(Cache)](network%20and%20http/(002)HTTP/README.md#7-cache-header)
         * [캐시 소개](network%20and%20http/(002)HTTP/README.md#71-%EC%BA%90%EC%8B%9C-%EC%86%8C%EA%B0%9C)
         * [Cache Validation(`Last-Modified`, `If-Modified-Since`)](network%20and%20http/(002)HTTP/README.md#72-cache-validationlast-modified-if-modified-since)
         * Cache Validation(`ETag`)
         * `Cache-Control`
      
    </details> 

</details>

---

# :computer: ​Programming Language

<details>
  <summary><h3>1. Java</h3></summary>

  - [java/README.md](java/README.md)

  - <details>
      <summary>1. 자바 소개(Java Introduction)</summary>
      
      * [Programming Language](java/(001)%20Java%20Introduction#1-programming-language)
        * 고급 언어
        * Translator
      * [자바 동작 방식(How Java Works)](java/(001)%20Java%20Introduction#2-%EC%9E%90%EB%B0%94-%EB%8F%99%EC%9E%91-%EB%B0%A9%EC%8B%9Dhow-java-works)
      * [자바 메모리 구조(Java Memory Structure)](java/(001)%20Java%20Introduction#3-java-memory-structure)
        * 메서드 영역(Method Area)
        * 스택 영역(Stack Area)
        * 힙 영역(Heap Area)
      * [JVM, JDK, JRE](java/(001)%20Java%20Introduction#4-jvm-jdk-jre)
        * JDK
        * JRE
        * JVM
          
      
      </details>
  - <details>
      <summary>2. Basic Syntax</summary>
      
      * [변수(Variables)](java/(002)%20Basic%20Syntax#1-variables)
      * 자바 관례
      * [연산자(Operators)](java/(002)%20Basic%20Syntax#3-%EC%97%B0%EC%82%B0%EC%9E%90operators)
      * [조건문(Conditional)](java/(002)%20Basic%20Syntax#4-%EC%A1%B0%EA%B1%B4%EB%AC%B8conditional)
      * [반복문(Loop)](java/(002)%20Basic%20Syntax#5--%EB%B0%98%EB%B3%B5%EB%AC%B8loop)
        
      
      </details>
  - <details>
      <summary>3. 배열(Array)</summary>
      
      * [배열(Array)](java/(003)%20Array#1-%EB%B0%B0%EC%97%B4array)
      * [배열 사용하기](java/(003)%20Array#2-%EB%B0%B0%EC%97%B4-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%B3%B4%EA%B8%B0)
      * [2차원 배열(2D Array)](java/(003)%20Array#3-2%EC%B0%A8%EC%9B%90-%EB%B0%B0%EC%97%B42d-array)
        
      
      </details>
  - <details>
      <summary>4. 형변환(TypeCasting)</summary>
      
      * [자동 형변환](java/(004)%20Typecasting#11-%EC%9E%90%EB%8F%99-%ED%98%95%EB%B3%80%ED%99%98widening-type-casting)
      * [명시적 형변환](java/(004)%20Typecasting#12-%EB%AA%85%EC%8B%9C%EC%A0%81-%ED%98%95%EB%B3%80%ED%99%98narrow-type-casting)
      * [계산시 형변환](java/(004)%20Typecasting#13-%EA%B3%84%EC%82%B0%EC%8B%9C-%ED%98%95%EB%B3%80%ED%99%98)
        
      
      </details>
  - <details>
      <summary>5. 메서드(Method)</summary>
    
      * [메서드 소개](java/(005)%20Method#1-%EB%A9%94%EC%84%9C%EB%93%9Cmethod)
      * [`static` 메서드](java/(005)%20Method#2-static-method)
      * [인스턴스 메서드(Instance Method)](java/(005)%20Method#3-instance-method)
      * [오버로딩(Overloading)](java/(005)%20Method#4-%EC%98%A4%EB%B2%84%EB%A1%9C%EB%94%A9overloading)
      * [오버라이딩(Overriding)](java/(005)%20Method#5-%EC%98%A4%EB%B2%84%EB%9D%BC%EC%9D%B4%EB%94%A9overriding)  
        
      
      </details>
  - <details>
      <summary>6. 클래스(Class)</summary>

      * [Class, Instance](java/(006)%20Class#1-class--instance)
        * 클래스 작성, 인스턴스 생성
      * [객체 배열(Array of Objects)](java/(006)%20Class#2-array-of-instances)
        
      
      </details>
  - <details>
      <summary>7. 참조형(Reference Type)</summary>
    
      * [Primitive vs Reference](java/(007)%20Reference%20Type#1-primitive-vs-reference)
      * [참조형에 대입](java/(007)%20Reference%20Type#2-%EC%B0%B8%EC%A1%B0%ED%98%95-%EB%8C%80%EC%9E%85)
      * [`null`](java/(007)%20Reference%20Type#3-null)
      * [NullPointerException (NPE)](java/(007)%20Reference%20Type#4-nullpointerexception)

      </details>
  - <details>
      <summary>8. 객체지향 프로그래밍(OOP)</summary>
    
      * [OOP vs POP](java/(008)%20OOP%20Introduction#1-oop-vs-pop)
      * [인스턴스 메서드(Instance Method)](java/(008)%20OOP%20Introduction#2-instance-method)
      * [`static` 메서드(Static Method)](java/(008)%20OOP%20Introduction#3-static-method)
      * [캡슐화 (Encapsulation)](java/(008)%20OOP%20Introduction#4-encapsulation)
        
      
      </details>
  - <details>
      <summary>9. 생성자(Constructor)</summary>
    
      * [생성자(Constructor)](java/(009)%20Constructor#1-%EC%83%9D%EC%84%B1%EC%9E%90constructor)
      * [`this`](java/(009)%20Constructor#2-this)
      * [생성자 사용 조건](java/(009)%20Constructor#3-%EC%83%9D%EC%84%B1%EC%9E%90-%EC%82%AC%EC%9A%A9-%EC%A1%B0%EA%B1%B4)
      * [기본 생성자(Default Constructor)](java/(009)%20Constructor#4-%EA%B8%B0%EB%B3%B8-%EC%83%9D%EC%84%B1%EC%9E%90default-constructor)
      * [생성자 오버로딩](java/(009)%20Constructor#5-%EC%83%9D%EC%84%B1%EC%9E%90-%EC%98%A4%EB%B2%84%EB%A1%9C%EB%94%A9constructor-overloading_)
      * [`this()`](java/(009)%20Constructor#6-this)
        
      
      </details>
  - <details>
      <summary>10. 패키지(Package)</summary>
    
      * [패키지(Package)](java/(010)%20Package#1-package)
      * [`import`](java/(010)%20Package#2-import)
         * `import`
         * `static` `import` 
      * [패키지 관례](java/(010)%20Package#3-%ED%8C%A8%ED%82%A4%EC%A7%80-%EA%B4%80%EB%A1%80package-convention)
        
      
      </details>
  - <details>
      <summary>11. 접근 제어자(Access Modifier)</summary>
    
      * [접근 제어자(Access Modifier)](java/(011)%20Access%20Modifier#1-%EC%A0%91%EA%B7%BC-%EC%A0%9C%EC%96%B4%EC%9E%90access-modifier)
      * [접근 제어자 사용해보기](java/(011)%20Access%20Modifier#2-%EC%A0%91%EA%B7%BC-%EC%A0%9C%EC%96%B4%EC%9E%90-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%B3%B4%EA%B8%B0)
         * Field, Method
         * Constructor
         * Class
      * [캡슐화(Encapsulation)](java/(011)%20Access%20Modifier#3-%EC%BA%A1%EC%8A%90%ED%99%94encapsulation)

      </details>
  - <details>
      <summary>12. Static</summary>
    
      * [`static`](java/(012)%20Static#1-static)
      * [정적 변수(Static variable)](java/(012)%20Static#2-%EC%A0%95%EC%A0%81-%EB%B3%80%EC%88%98static-variable)
         * 정적 변수 소개
         * `static` 사용 vs `static` 사용하지 않기
      * [정적 메서드(Static Method)](java/(012)%20Static#3-%EC%A0%95%EC%A0%81-%EB%A9%94%EC%84%9C%EB%93%9Cstatic-method)
      * [정적 임포트(Static Import)](java/(012)%20Static#4-static-import)
        
      
      </details>
  - <details>
      <summary>13. final</summary>
    
      * [`final`](java/(013)%20Constant%2C%20final#1-final)
      * [`final`이 붙은 지역 변수(Local variable)](java/(013)%20Constant%2C%20final#2-final%EC%9D%B4-%EB%B6%99%EC%9D%80-local-variable)
      * [`final`이 붙은 멤버 변수(Member variable, Field)](java/(013)%20Constant%2C%20final#3-final%EC%9D%B4-%EB%B6%99%EC%9D%80-member-variablefield)
      * [상수(Constant)](java/(013)%20Constant%2C%20final#4-constant)
        
      
      </details>
  - <details>
      <summary>14. 상속(Inheritance)</summary>
    
      * [상속(Inheritance)](java/(014)%20Inheritance#1-%EC%83%81%EC%86%8Dinheritance)
         * 상속 소개
         * 상속하지 않는 경우
         * 상속하는 경우
      * [단일 상속(Single Inheritance)](java/(014)%20Inheritance#2-%EB%8B%A8%EC%9D%BC-%EC%83%81%EC%86%8Dsingle-inheritance)
      * [Java 상속의 메모리 할당 구조](java/(014)%20Inheritance#3-java-%EC%83%81%EC%86%8D%EC%9D%98-%EB%A9%94%EB%AA%A8%EB%A6%AC-%ED%95%A0%EB%8B%B9-%EA%B5%AC%EC%A1%B0)
      * [Method Overriding](java/(014)%20Inheritance#4-method-overriding)
      * [`protected`](java/(014)%20Inheritance#5-protected)
      * [`super`](java/(014)%20Inheritance#6-super)
      * [`super()`](java/(014)%20Inheritance#7-super)
        
      
      </details>
  - <details>
      <summary>15. 다형성(Polymorphism)</summary>
    
      * [다형성(Polymorphism)](java/(015)%20Polymorphism#1-%EB%8B%A4%ED%98%95%EC%84%B1polymorphism)
      * [형변환(Casting)](java/(015)%20Polymorphism#2-%ED%98%95%EB%B3%80%ED%99%98casting)
         * 다운캐스팅(Downcasting)
           * 일시적 다운캐스팅
           * 다운 캐스팅시 주의점
         * 업캐스팅(Upcasting)
      * [`instanceof`](java/(015)%20Polymorphism#3-instanceof)
      * [Method Overriding](java/(015)%20Polymorphism#4-method-overriding)
      * [다형성의 활용](java/(015)%20Polymorphism#5-%EB%8B%A4%ED%98%95%EC%84%B1%EC%9D%98-%ED%99%9C%EC%9A%A9)
         * 다형성 사용하기
         * 한계
      * [추상 클래스(abstract class)](java/(015)%20Polymorphism#6-%EC%B6%94%EC%83%81-%ED%81%B4%EB%9E%98%EC%8A%A4abstract-class)
      * [인터페이스(interface)](java/(015)%20Polymorphism#7-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4interface)
         * 인터페이스 소개
         * 인터페이스를 통한 다중구현
      
      </details>
  - <details>
      <summary>16. 불변(Immutable)</summary>
    
      * [공유](java/(027)%20Immutable%20Object#1-%EA%B3%B5%EC%9C%A0)
         * 기본형과 참조형의 공유
         * [사이드 이펙트(Side-effect)](java/(027)%20Immutable%20Object#12-%EC%82%AC%EC%9D%B4%EB%93%9C-%EC%9D%B4%ED%8E%99%ED%8A%B8side-effect)
      * [불변 객체(Immutable Object)](java/(027)%20Immutable%20Object#2-%EB%B6%88%EB%B3%80-%EA%B0%9D%EC%B2%B4immutable-object)
         * 불변 객체 소개
         * 불변 객체에서 값 변경
         * 불변이 중요한 이유
      
      </details>
  - <details>
      <summary>17. 오브젝트, 문자열(Object, String Class)</summary>
    
      * [`Object` 클래스](java/(022)%20Object%2C%20String%20Class#1-object-%ED%81%B4%EB%9E%98%EC%8A%A4)
         * `java.lang` 패키지
         * [`Object` 클래스 소개](java/(022)%20Object%2C%20String%20Class#12-object-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%86%8C%EA%B0%9C)
         * `Object` 배열
         * `toString()`
         * [`equals()`](java/(022)%20Object%2C%20String%20Class#15-equals)
      * [`String` 클래스](java/(022)%20Object%2C%20String%20Class#2-string-%ED%81%B4%EB%9E%98%EC%8A%A4)
         * `String` 클래스 소개
         * [`String` 객체 비교](java/(022)%20Object%2C%20String%20Class#22-string-%EA%B0%9D%EC%B2%B4-%EB%B9%84%EA%B5%90)
         * `String`은 불변 객체
         * [`String` 메서드](java/(022)%20Object%2C%20String%20Class#24-string-%EB%A9%94%EC%84%9C%EB%93%9C)
           * 문자열 정보 조회
           * 문자열 비교
           * 문자열 검색
           * 문자열 조작 및 변환
           * 문자열 분할 및 조합
           * 기타
         * [`StringBuilder`](java/(022)%20Object%2C%20String%20Class#25-stringbuilder)
      
      </details>
  - <details>
      <summary>18. 래퍼 클래스(Wrapper Class)</summary>
    
      * [기본형(Primitive Type)의 한계](java/(026)%20Wrapper%20Class#1-%EA%B8%B0%EB%B3%B8%ED%98%95primitive-type%EC%9D%98-%ED%95%9C%EA%B3%84)
      * [자바 래퍼 클래스(Wrapper Class)](java/(026)%20Wrapper%20Class#2-%EC%9E%90%EB%B0%94-%EB%9E%98%ED%8D%BC-%ED%81%B4%EB%9E%98%EC%8A%A4wrapper-class)
         * 래퍼 클래스 소개
         * 오토박싱(Auto-boxing)
         * 래퍼 클래스의 메서드
         * 래퍼 클래스의 성능
      * [`System`, `Math`, `Random` 클래스](java/(026)%20Wrapper%20Class#3-system-math-random-%ED%81%B4%EB%9E%98%EC%8A%A4)
         * `System` 클래스
         * `Math` 클래스
         * `Random` 클래스
      
      </details>
  - <details>
      <summary>19. 열거형(Enum)</summary>
    
      * [타입 안정성(Type-safety)](java/(020)%20Enum#1-%ED%83%80%EC%9E%85-%EC%95%88%EC%A0%95%EC%84%B1type-safety)
         * `String`은 타입 안정성이 떨어진다
         * 타입 안전 열거형 패턴(Type-safe Enum Pattern)
      * [열거형(`enum`)](java/(020)%20Enum#2-%EC%97%B4%EA%B1%B0%ED%98%95enum)
         * `enum` 사용
         * `Enum` 클래스 메서드
         * 열거형을 이용한 리펙토링
         * 열거형 정리
      
      </details>
  - <details>
      <summary>20. 중첩 클래스(Nested Class)</summary>
    
      * [중첩 클래스(Nested Class)](java/(021)%20Nested%20Class#1-%EC%A4%91%EC%B2%A9-%ED%81%B4%EB%9E%98%EC%8A%A4nested-class)
         * 중첩 클래스 소개
      * [정적 중첩 클래스(Static Nested Class)](java/(021)%20Nested%20Class#2-%EC%A0%95%EC%A0%81-%EC%A4%91%EC%B2%A9-%ED%81%B4%EB%9E%98%EC%8A%A4static-nested-class)
         * [정적 중첩 클래스 소개](java/(021)%20Nested%20Class#21-%EC%A0%95%EC%A0%81-%EC%A4%91%EC%B2%A9-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%86%8C%EA%B0%9C)
         * [정적 중첩 클래스를 사용하는 경우](java/(021)%20Nested%20Class#22-%EC%A0%95%EC%A0%81-%EC%A4%91%EC%B2%A9-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EA%B2%BD%EC%9A%B0)
      * [내부 클래스(Inner Class)](java/(021)%20Nested%20Class#3-%EB%82%B4%EB%B6%80-%ED%81%B4%EB%9E%98%EC%8A%A4inner-class)
         * [내부 클래스 소개](java/(021)%20Nested%20Class#31-%EB%82%B4%EB%B6%80-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%86%8C%EA%B0%9C)
         * [내부 클래스를 사용하는 경우](java/(021)%20Nested%20Class#32-%EB%82%B4%EB%B6%80-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EA%B2%BD%EC%9A%B0)
      * [지역 클래스(Local Class)](java/(021)%20Nested%20Class#4-%EC%A7%80%EC%97%AD-%ED%81%B4%EB%9E%98%EC%8A%A4local-class)
         * [지역 클래스 소개](java/(021)%20Nested%20Class#41-%EC%A7%80%EC%97%AD-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%86%8C%EA%B0%9C)
         * [지역 클래스 예시](java/(021)%20Nested%20Class#42-%EC%A7%80%EC%97%AD-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%98%88%EC%8B%9C)
         * [지역 변수 캡쳐(Variable Capture)](java/(021)%20Nested%20Class#43-%EC%A7%80%EC%97%AD-%EB%B3%80%EC%88%98-%EC%BA%A1%EC%B3%90variable-capture)
           * 지역 변수 캡쳐 동작 과정
           * effectively final
      * [익명 클래스(Anonymous Class)](java/(021)%20Nested%20Class#5-%EC%9D%B5%EB%AA%85%ED%81%B4%EB%9E%98%EC%8A%A4anonymous-class)
         * [익명 클래스 소개](java/(021)%20Nested%20Class#51-%EC%9D%B5%EB%AA%85-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%86%8C%EA%B0%9C)
         * [익명 클래스를 사용하는 경우](java/(021)%20Nested%20Class#52-%EC%9D%B5%EB%AA%85-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EA%B2%BD%EC%9A%B0)
           
      
      </details>
  - <details>
      <summary>21. 예외 처리(Exception Handling)</summary>
    
      * [예외, 에러(Exception, Error)](java/(016)%20Exception#1-%EC%98%88%EC%99%B8-%EC%97%90%EB%9F%ACexception-error)
         * [예외(Exception) 소개](java/(016)%20Exception#11-%EC%98%88%EC%99%B8exception-%EC%86%8C%EA%B0%9C)
         * [예외 기본 규칙](java/(016)%20Exception#11-%EC%98%88%EC%99%B8-%EA%B8%B0%EB%B3%B8-%EA%B7%9C%EC%B9%99)
      * [예외 발생시키기(`throw`)](java/(016)%20Exception#2-%EC%98%88%EC%99%B8-%EB%B0%9C%EC%83%9D%EC%8B%9C%ED%82%A4%EA%B8%B0throw)
      * [예외 처리하기(`try-catch`)](java/(016)%20Exception#3-%EC%98%88%EC%99%B8-%EC%B2%98%EB%A6%AC%ED%95%98%EA%B8%B0try-catch)
         * [`try-catch` 소개](java/(016)%20Exception#31-try-catch-%EC%86%8C%EA%B0%9C)
         * [예외 세분화](java/(016)%20Exception#32-%EC%98%88%EC%99%B8-%EC%84%B8%EB%B6%84%ED%99%94)
         * 멀티 `catch`(`|`)
      * [예외 객체 참조 변수(Exception Variable)](java/(016)%20Exception#4-%EC%98%88%EC%99%B8-%EA%B0%9D%EC%B2%B4-%EC%B0%B8%EC%A1%B0-%EB%B3%80%EC%88%98exception-variable)
      * [예외 던지기(`throws`)](java/(016)%20Exception#5-%EC%98%88%EC%99%B8-%EB%8D%98%EC%A7%80%EA%B8%B0throws)
         * [`throws` 소개](java/(016)%20Exception#51-throws-%EC%86%8C%EA%B0%9C)
         * [`throws`가 처리되는 과정](java/(016)%20Exception#52-throws%EA%B0%80-%EC%B2%98%EB%A6%AC%EB%90%98%EB%8A%94-%EA%B3%BC%EC%A0%95)
      * [Checked, Unchecked Exception](java/(016)%20Exception#6-checked-unchecked-%EC%98%88%EC%99%B8)
         * [체크, 언체크 예외 소개](java/(016)%20Exception#61-%EC%B2%B4%ED%81%AC-%EC%96%B8%EC%B2%B4%ED%81%AC-%EC%98%88%EC%99%B8-%EC%86%8C%EA%B0%9C)
         * [체크 예외(Checked Exception)](java/(016)%20Exception#62-%EC%B2%B4%ED%81%AC-%EC%98%88%EC%99%B8checked-exception)
         * [언체크 예외(Unchecked Exception, 런타임 예외)](java/(016)%20Exception#63-%EC%96%B8%EC%B2%B4%ED%81%AC-%EC%98%88%EC%99%B8unchecked-exception-%EB%9F%B0%ED%83%80%EC%9E%84-%EC%98%88%EC%99%B8)
      * [`try-catch-finally`](java/(016)%20Exception#7-try-catch-finally)
      * [`try-with-resource`](java/(016)%20Exception#8-try-with-resource)
         * [`try-with-resource` 소개](java/(016)%20Exception#81-try-with-resource-%EC%86%8C%EA%B0%9C)
         * [사용 예시 1](java/(016)%20Exception#82-%EC%82%AC%EC%9A%A9-%EC%98%88%EC%8B%9C-1)
         * [사용 예시 2](java/(016)%20Exception#83-%EC%82%AC%EC%9A%A9-%EC%98%88%EC%8B%9C-2)
      * [체크 예외를 잘 사용하지 않는 이유](java/(016)%20Exception#9-%EC%B2%B4%ED%81%AC-%EC%98%88%EC%99%B8%EB%A5%BC-%EC%9E%98-%EC%82%AC%EC%9A%A9%ED%95%98%EC%A7%80-%EC%95%8A%EB%8A%94-%EC%9D%B4%EC%9C%A0)
         * [체크 예외(Checked Exception)의 단점](java/(016)%20Exception#91-%EC%B2%B4%ED%81%AC-%EC%98%88%EC%99%B8checked-exception%EC%9D%98-%EB%8B%A8%EC%A0%90)
         * [언체크 예외(Uncheck Exception)의 사용](java/(016)%20Exception#92-%EC%96%B8%EC%B2%B4%ED%81%AC-%EC%98%88%EC%99%B8unchecked-exception-%EB%9F%B0%ED%83%80%EC%9E%84-%EC%98%88%EC%99%B8%EC%9D%98-%EC%82%AC%EC%9A%A9)
           * 언체크 예외 사용 방안
           * 언체크 예외 사용 예시
      
      </details>
  - <details>
      <summary>22. java.time 패키지</summary>
    
      * [날짜와 시간 라이브러리](java/(017)%20Date%20and%20Time#1-%EB%82%A0%EC%A7%9C%EC%99%80-%EC%8B%9C%EA%B0%84-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC)
         * 날짜와 시간의 계산
         * [날짜와 시간 라이브러리 소개](java/(017)%20Date%20and%20Time#12-%EB%82%A0%EC%A7%9C%EC%99%80-%EC%8B%9C%EA%B0%84-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC-%EC%86%8C%EA%B0%9C)
           * `java.util.Date`
           * `java.util.Calendar`
           * `java.time`
      * [`java.time` package]()
         * `LocalDate`
         * `LocalTime`
         * [`LocalDateTime`](java/(017)%20Date%20and%20Time#23-localdatetime)
         * [`ZonedDateTime`](java/(017)%20Date%20and%20Time#24-zoneddatetime)
           * `ZoneId`
           * `ZonedDateTime`
         * `OffsetDateTime`
         * [`Period`, `Duration`](java/(017)%20Date%20and%20Time#26-period-duration)
         * [`Instant`](java/(017)%20Date%20and%20Time#27-instant)
      * [ `TemporalAccessor`, `TemporalAmount`, `ChronoUnit`](java/(017)%20Date%20and%20Time#3-temporalaccessor-temporalamount-chronounit)
         *  `TemporalAccessor`, `TemporalAmount`
         *  [`ChronoUnit`, `ChronoField`](java/(017)%20Date%20and%20Time#32-chronounit-chronofield)
            * `ChronoUnit`
            * `ChronoField`
      * [날짜와 시간 조회, 조작하기](java/(017)%20Date%20and%20Time#4-%EB%82%A0%EC%A7%9C%EC%99%80-%EC%8B%9C%EA%B0%84-%EC%A1%B0%ED%9A%8C-%EC%A1%B0%EC%9E%91%ED%95%98%EA%B8%B0)
         * 조회하기
         * 조작하기
         * `with()`
      * [`Formatter`](java/(017)%20Date%20and%20Time#5-formatter)
        
      
      </details>
  - <details>
      <summary>23. 컬렉션 프레임워크(Collection)</summary>
    
      * [`Collection` 프레임워크](java/(018)%20Collection#1-collection-framework)
      * [`Collection`](java/(018)%20Collection#2-collection)
      * [`Iterator`](java/(018)%20Collection#3-iterator)
      * [`List`](java/(018)%20Collection#4-list)
         * `ArrayList`
         * `LinkedList`
      * [`Set`](java/(018)%20Collection#5-set)
         * `HashSet`
         * `TreeSet`
      * [`Map`](java/(018)%20Collection#6-map)
         * `HashMap`
      * [`Stack`, `Queue`, `ArrayDeque`](java/(018)%20Collection#7-stack-queue-arraydeque)
         * `ArrayDeque`
      * [`Comparable`, `Comparator`](java/(018)%20Collection#9-comparable--comparator)
         * `Comparable`
         * `Comparator`
      
      </details>
  - <details>
      <summary>24. 제네릭스(Generics)</summary>
    
      * [Generics](java/(019)%20Generics#1-generics)
         * 제네릭스 소개
         * 제네릭스 사용해보기
         * 타입 변수
         * 제네릭 클래스(Generic Class)
      * [`HashMap<K, V>`](java/(019)%20Generics#2-hashmapkv)
      * [제네릭 제약(Generic Constraints)](java/(019)%20Generics#3-%EC%A0%9C%EB%84%A4%EB%A6%AD-%EC%A0%9C%EC%95%BDgeneric-constraints)
         * 제한된 제네릭 클래스
         * 제네릭스의 제약
      * [와일드 카드(Wildcard, `<?>`)](java/(019)%20Generics#4-%EC%99%80%EC%9D%BC%EB%93%9C%EC%B9%B4%EB%93%9Cwildcard-)
      * [제네릭 메서드(Generic Method)](java/(019)%20Generics#5-%EC%A0%9C%EB%84%A4%EB%A6%AD-%EB%A9%94%EC%84%9C%EB%93%9Cgeneric-method)
        
      
      </details>
  - <details>
      <summary>25. 스레드(Thread)</summary>
    
      * [스레드(Thread)](java/(023)%20Thread)
         * `Thread` 클래스 상속
         * `Runnable` 인터페이스 구현
         * 스레드 사용해보기
      * [메인 스레드](java/(023)%20Thread#2-%EB%A9%94%EC%9D%B8-%EC%8A%A4%EB%A0%88%EB%93%9Cmain-thread)
      * [스레드의 I/O Blocking](java/(023)%20Thread#3-%EC%8A%A4%EB%A0%88%EB%93%9C%EC%9D%98-io-blocking)
      * [스레드 그룹(Thread Group)](java/(023)%20Thread#4-%EC%8A%A4%EB%A0%88%EB%93%9C-%EA%B7%B8%EB%A3%B9thread-group)
      * [데몬 스레드(Daemon Thread)](java/(023)%20Thread#5-%EB%8D%B0%EB%AA%AC-%EC%8A%A4%EB%A0%88%EB%93%9Cdaemon-thread)
      * [스레드 상태(Thread State)](java/(023)%20Thread#6-%EC%8A%A4%EB%A0%88%EB%93%9C%EC%9D%98-%EC%83%81%ED%83%9Cthread-state)
      * [스레드의 동기화(synchronized)](java/(023)%20Thread#7-%EC%8A%A4%EB%A0%88%EB%93%9C%EC%9D%98-%EB%8F%99%EA%B8%B0%ED%99%94-synchronized)
        
      
      </details>
  - <details>
      <summary>26. 람다(Lambda)</summary>
    
      * [람다 표현식(Lambda Expression)](java/(024)%20Lambda#1-%EB%9E%8C%EB%8B%A4-%ED%91%9C%ED%98%84%EC%8B%9Dlambda-expression)
         * 람다식 소개
      * [함수형 인터페이스(Functional Interface)](java/(024)%20Lambda#2-%ED%95%A8%EC%88%98%ED%98%95-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4functional-interface)
      * [메서드 참조(Method Reference)](java/(024)%20Lambda#3-%EB%A9%94%EC%84%9C%EB%93%9C-%EC%B0%B8%EC%A1%B0method-reference)
      * [람다의 단점](java/(024)%20Lambda#4-%EB%9E%8C%EB%8B%A4%EC%9D%98-%EB%8B%A8%EC%A0%90)
        
      
      </details>
  - <details>
      <summary>27. 스트림(Stream)</summary>
    
      * [스트림(Stream)](java/(025)%20Stream#1-%EC%8A%A4%ED%8A%B8%EB%A6%BCstream)
         * 스트림 소개
         * 스트림의 특징
           * 읽기만 함(read-only)
           * 한번만 사용(use only once), 지연 연산(lazy evaluation)
           * 병렬 스트림(parallel stream)
           * 기본형 스트림(primitive stream)
      * [스트림 생성](java/(025)%20Stream#2-%EC%8A%A4%ED%8A%B8%EB%A6%BC-%EC%83%9D%EC%84%B1)
         * 컬렉션
         * 배열
         * 난수, 특정 범위의 정수
         * `iterate()`, `generate()`
         * `Files`, `empty()`
      * [중간 연산(Intermediate Opertation)](java/(025)%20Stream#3-%EC%A4%91%EA%B0%84-%EC%97%B0%EC%82%B0intermediate-operation)
         * `skip()`, `limit()`
         * `filter()`, `distinct()`
         * `sorted()`
         * `map()`, `flatMap()`
         * `peek()`
      * [`Optional<T>`](java/(025)%20Stream#4-optionalt)
      * [최종 연산(Terminal Opertation)](java/(025)%20Stream#5-%EC%B5%9C%EC%A2%85-%EC%97%B0%EC%82%B0terminal-operation)
         * `forEach()`
         * `xxxMatch()`
         * `findxxx()`
         * `reduce()`
         * `collect()`, `Collectors`
           * `collect()` 사용하기
           * `partitioningBy()`, `groupingBy()`
      
      </details>
  - <details>
      <summary>28. JVM</summary>
      
      
      </details>
      </details>

<details>
  <summary><h3>2. Python(추가 예정)</h3></summary>

</details>

---

# 🌐 Backend

<details>
  <summary><h3>1. 스프링 프레임워크(Spring Framework)</h3></summary>

  - [spring/README.md](spring/README.md)

  - <details>
      <summary>1. Spring Introduction</summary>
    
      1. [Introduction](spring/(001)Spring%20Introduction#1-introduction)
         * ```Spring```, ```SpringBoot``` 소개
         * ```Gradle```
         * MVC Pattern
      2. [Spring Boot Project Configuration](spring/(001)Spring%20Introduction#2-spring-boot-project-configuration)
         * Spring Boot 프로젝트 생성하기
         * 실행 확인하기
         * View 설정하기
         * 빌드 후 실행
      3. [Spring 웹 개발](spring/(001)Spring%20Introduction#3-spring-%EC%9B%B9-%EA%B0%9C%EB%B0%9C)
         * Static Contents
         * MVC & Template Engine
         * API
      4. [회원 관리 기능 개발 I](spring/(001)Spring%20Introduction#4-%ED%9A%8C%EC%9B%90-%EA%B4%80%EB%A6%AC-%EA%B8%B0%EB%8A%A5-%EA%B0%9C%EB%B0%9C-i)
         * 비즈니스 요구 사항
         * 애플리케이션 계층 구조
         * 클래스 의존 관계
         * 회원 저장소 코드, 테스트 코드
         * 회원 서비스 코드, 테스트 코드
      5. [Spring Bean & Dependency](spring/(001)Spring%20Introduction#5-spring-bean--dependency)
         * Component Scan
         * 자바 코드로 스프링 빈 등록
      6. [회원 관리 기능 개발 II](spring/(001)Spring%20Introduction#6-%ED%9A%8C%EC%9B%90-%EA%B4%80%EB%A6%AC-%EA%B8%B0%EB%8A%A5-%EA%B0%9C%EB%B0%9C-ii)
         * 홈 화면 추가
         * 등록
         * 조회
      7. [Spring DB Access](spring/(001)Spring%20Introduction#7-spring-db-access)
         * H2 데이터베이스 Setup
         * JdbcTemplate
         * 스프링 통합 테스트
         * JPA
      8. [AOP](spring/(001)Spring%20Introduction#8-aop)
         * AOP 소개
      9. [전체 요약](spring/(001)Spring%20Introduction#%EC%A0%84%EC%B2%B4-%EC%9A%94%EC%95%BD)
       
    
    </details>
  - <details>
      <summary>2. Spring Core</summary>
      
      1. [Object Oriented Design(객체 지향 설계)](spring/(002)Spring%20Core%20-%201#1-object-oriented-design%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EC%84%A4%EA%B3%84)
         * SOLID 원칙
           * SRP
           * OCP
           * LSP
           * ISP
           * DIP
           * 요약
         * OOD와 Spring
      2. [Spring 핵심 원리 I - 예제 생성](spring/(002)Spring%20Core%20-%201#2-spring-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-i---%EC%98%88%EC%A0%9C-%EC%83%9D%EC%84%B1)
         * 프로젝트 생성
         * 비즈니스 요구 사항과 설계
         * 회원 도메인 설계, 개발, 테스트
         * 주문과 할인 도메인 설계, 개발, 테스트
      3. [Spring 핵심 원리 II - 객체 지향 적용](spring/(002)Spring%20Core%20-%201#3-spring-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-ii---%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EC%A0%81%EC%9A%A9)
         * 새로운 할인 정책 개발
         * 관심사 분리
         * 새로운 구조와 할인 정책 적용
         * IoC, DI, 컨테이너
           * IoC
           * DI
           * IoC, DI 컨테이너
         * 스프링으로 전환
      4. [Spring Container, Bean](spring/(002)Spring%20Core%20-%201#4-spring-container--bean)
         * 스프링 컨테이너
         * 스프링 빈 조회
           * 컨테이너에 등록된 모든 빈 조회
           * 빈 조회하기
           * 상속관계의 빈 조회
         * ```BeanFactory```, ```ApplicationContext```
      5. [Singleton Container](spring/(002)Spring%20Core%20-%201#5-singleton-container)
         * 스프링이 없는 순수한 DI 컨테이너
         * 싱글톤 패턴(Singleton Pattern)
         * 스프링의 싱글톤 컨테이너
         * 싱글톤 방식의 주의점
         * ```@Configuration```
      6. [Component Scan](spring/(002)Spring%20Core%20-%201#6-component-scan)
         * ```@ComponentScan```, ```@Autowired```
         * ```@ComponentScan```의 탐색 위치와 스캔 대상
         * 필터, 중복 등록과 충돌
           * 필터
           * 중복 등록과 충돌돌
      7. [Dependency Injection (DI, 의존관계 주입)](spring/(002)Spring%20Core%20-%201#7-%EC%9D%98%EC%A1%B4%EA%B4%80%EA%B3%84-%EC%9E%90%EB%8F%99-%EC%A3%BC%EC%9E%85autowired)
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
      8. [Spring Bean Lifecycle Callbacks(빈 생명주기 콜백)](spring/(002)Spring%20Core%20-%201#8-spring-bean-lifecycle-callbacks)
         * 빈 생명주기 콜백
         * 초기화, 소멸 메서드 지정
         * ```@PostConstruct```, ```@PreDestroy```
      9. [Spring Bean Scope](spring/(002)Spring%20Core%20-%201#9-spring-bean-scope)
         * Singleton vs Prototype
           * 싱글톤과 프로토타입 비교
           * 싱글톤과 프로토타입 함께 사용시의 문제
         * Provider
         * Web Scope
           * 웹 스코프 소개
           * Request Scope
      10. [전체 요약](spring/(002)Spring%20Core%20-%201#%EC%A0%84%EC%B2%B4-%EC%9A%94%EC%95%BD)
  
    </details>
  - <details>
      <summary>3. Spring MVC</summary>

      1. [Web Application](spring/(003)Spring%20MVC%20-%201#1-web-application)
         * Web Server, Was
         * Thread Pool
         * AJAX
         * SSR(서버 사이드 렌더링), CSR(클라이언트 사이드 렌더링)
      2. [MVC(Model View Controller)](spring/(003)Spring%20MVC%20-%201#2-mvcmodel-view-controller)
         * MVC 소개
         * Front Controller
         * Front Controller 도입
         * View 분리
         * Model 도입
         * 사용성 개선
         * Adapter 도입
      3. [Spring MVC](spring/(003)Spring%20MVC%20-%201#3-spring-mvc)
         * Spring MVC 구조
           * `HandlerMapping`, `HandlerAdapter`
           * `ViewResolver`
         * Spring MVC 사용해보기
         * 사용성 개선
      4. [Spring MVC - 기능 살펴보기](spring/(003)Spring%20MVC%20-%201#4-spring-mvc---%EA%B8%B0%EB%8A%A5-%EC%82%B4%ED%8E%B4%EB%B3%B4%EA%B8%B0)
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
      5. [Spring 메세지, 국제화 (Message, Internationalization)](spring/(003)Spring%20MVC%20-%201#5-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%A9%94%EC%84%B8%EC%A7%80-%EA%B5%AD%EC%A0%9C%ED%99%94-messages-internationalization)
         * 메세지, 국제화 소개
           * 메세지
           * 국제화
         * 메세지 적용하기
           * 메세지 소스(`MessageSource`) 설정
           * 타임리프 메세지 적용
         * 국제화 적용하기
      6. [검증(Validation)](spring/(003)Spring%20MVC%20-%201#6-%EA%B2%80%EC%A6%9Dvalidation)
         * 검증 소개
         * `BindingResult`
         * 오류 코드, 메세지 처리
           * `errors.properties`
           * `rejectValue()`, `reject()`
           * `MessageCodesResolver`
           * 스프링이 직접 만든 오류 메세지 처리
         * Validator 분리
      7. [Bean Validation](spring/(003)Spring%20MVC%20-%201#7-bean-validation)
         * Bean Validation 사용해보기
         * Bean Validation 검증 순서
         * 에러 코드 수정
         * Bean Validation `ObjectError`
         * Bean Validation의 한계와 `groups`
         * Form 객체의 분리
         * `@RequestBody`에 `@Validated` 적용
      8. [쿠키, 세션(Cookie, Session)](spring/(003)Spring%20MVC%20-%201#8-%EC%BF%A0%ED%82%A4-%EC%84%B8%EC%85%98-cookie-session)
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
      9. [필터, 인터셉터(Filter, Interceptor)](spring/(003)Spring%20MVC%20-%201#9-%ED%95%84%ED%84%B0-%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0filter-interceptor)
         * 서블릿 필터(Servlet Filter) 소개
         * 필터 예시
           * 예시 1 - 사용자 요청 로깅
           * 예시 2 - 로그인 체크
         * 스프링 인터셉터(Interceptor) 소개
         * 인터셉터 예시
           * 예시 1 - 사용자 요청 로깅
           * 예시 2 - 로그인 체크
      10. [오류 페이지(Error Page)](spring/(003)Spring%20MVC%20-%201#10-%EC%98%A4%EB%A5%98-%ED%8E%98%EC%9D%B4%EC%A7%80error-page)
          * 서블릿에서의 예외 처리
            * 스프링 부트에서 제공하는 오류 페이지 기능
              * 오류 페이지 사용
              * `BasicErrorController`가 제공하는 정보
      11. [API 예외 처리](spring/(003)Spring%20MVC%20-%201#11-api-%EC%98%88%EC%99%B8-%EC%B2%98%EB%A6%AC)
          * `HandlerExceptionResolver` 소개
          * 스프링이 제공하는 `ExceptionResolver`
            * `ExceptionHandlerExceptionResolver`
          * `@ControllerAdvice`
      12. [스프링 타입 컨버터](spring/(003)Spring%20MVC%20-%201#12-%EC%8A%A4%ED%94%84%EB%A7%81-%ED%83%80%EC%9E%85-%EC%BB%A8%EB%B2%84%ED%84%B0)
          * `Converter`
          * `ConversionService`
          * `Converter` 사용하기
          * `Formatter`
          * `FormattingConversionService`
          * 스프링 제공 `Formatter`
      13. [파일 업로드](spring/(003)Spring%20MVC%20-%201#13-%ED%8C%8C%EC%9D%BC-%EC%97%85%EB%A1%9C%EB%93%9C)

    </details>
  - <details>
      <summary>4. Thymeleaf</summary>
      
      1. [타임리프(Thymeleaf) 소개](spring/(004)Thymeleaf#1-%ED%83%80%EC%9E%84%EB%A6%AC%ED%94%84thymeleaf-%EC%86%8C%EA%B0%9C)
      2. [타임리프의 기본 기능](spring/(004)Thymeleaf#2-%ED%83%80%EC%9E%84%EB%A6%AC%ED%94%84%EC%9D%98-%EA%B8%B0%EB%B3%B8-%EA%B8%B0%EB%8A%A5)
         * [`th:href`, `th:onclick`](spring/(004)Thymeleaf#20-thhref-thonclick)
         * [`text`, `utext`](spring/(004)Thymeleaf#21-text-utext)
         * [SpringEL](spring/(004)Thymeleaf#22-springel)
           * 변수 표현식 사용해보기
           * 타임리프 지역 변수
         * [기본 객체](spring/(004)Thymeleaf#23-%EA%B8%B0%EB%B3%B8-%EA%B0%9D%EC%B2%B4)
         * [유틸리티 객체](spring/(004)Thymeleaf#24-%EC%9C%A0%ED%8B%B8%EB%A6%AC%ED%8B%B0-%EA%B0%9D%EC%B2%B4)
         * [URL 링크](spring/(004)Thymeleaf#25-url-%EB%A7%81%ED%81%AC-%EC%A4%91%EC%9A%94)
         * [리터럴 대체](spring/(004)Thymeleaf#26-%EB%A6%AC%ED%84%B0%EB%9F%B4-%EB%8C%80%EC%B2%B4)
         * [연산](spring/(004)Thymeleaf#27-%EC%97%B0%EC%82%B0)
         * [속성값 설정](spring/(004)Thymeleaf#28-%EC%86%8D%EC%84%B1%EA%B0%92-%EC%84%A4%EC%A0%95)
         * [반복(Loop)](spring/(004)Thymeleaf#29-%EB%B0%98%EB%B3%B5loop)
         * [조건부](spring/(004)Thymeleaf#210-%EC%A1%B0%EA%B1%B4%EB%B6%80)
         * [주석](spring/(004)Thymeleaf#211-%EC%A3%BC%EC%84%9D)
         * [`th:block`](spring/(004)Thymeleaf#212-thblock)
         * [자바스크립트 인라인](spring/(004)Thymeleaf#213-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%EC%9D%B8%EB%9D%BC%EC%9D%B8)
         * [템플릿 조각, 레이아웃(template fragment, layout)](spring/(004)Thymeleaf#2132-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%EC%9D%B8%EB%9D%BC%EC%9D%B8-each)
           * 템플릿 조각
           * 레이아웃
           * 레이아웃을 `<html>` 전체로 확장
      3. [타임리프 - 스프링](spring/(004)Thymeleaf#3-%ED%83%80%EC%9E%84%EB%A6%AC%ED%94%84---%EC%8A%A4%ED%94%84%EB%A7%81)
         * [입력 Form 처리](spring/(004)Thymeleaf#31-%EC%9E%85%EB%A0%A5-form-%EC%B2%98%EB%A6%AC)
         * [단일 체크박스](spring/(004)Thymeleaf#32-%EB%8B%A8%EC%9D%BC-%EC%B2%B4%ED%81%AC%EB%B0%95%EC%8A%A4)
         * [멀티 체크박스](spring/(004)Thymeleaf#33-%EB%A9%80%ED%8B%B0-%EC%B2%B4%ED%81%AC%EB%B0%95%EC%8A%A4)

    </details>

</details>

<details>
  <summary><h3>2. FastAPI(추가 예정)</h3></summary>
</details>

---

# 💾 Database

### [database/README.md](database/README.md)

<details>
  <summary><h3>1. RDBMS I</h3></summary>

  1. [데이터베이스(Database, DB) 소개](database/(001)%20Relational%20Database#1-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4database-%EC%86%8C%EA%B0%9C)
     * 데이터베이스의 정의
     * 데이터베이스 관리 시스템(DBMS)
     * 메타데이터(Metadata)
  2. [Modeling](database/(001)%20Relational%20Database#2-modeling)
     * 데이터 모델링의 정의
     * 데이터 모델링의 3단계
     * 데이터 독립성(Data Independence)
  3. [Entity, Attribute, Relationship](database/(001)%20Relational%20Database#3-entity-attribute-relationship)
     * 엔티티(Entity)
     * 속성(Attribute)
     * 관계(Relationship)
  4. [식별자(Identifier)](database/(001)%20Relational%20Database#4-%EC%8B%9D%EB%B3%84%EC%9E%90identifier)
     * 식별자의 정의
     * 식별자의 분류
     * 주식별자의 특징
     * 식별자와 비식별자 관계
  5. [테이블(Table), 키(Key)](database/(001)%20Relational%20Database#5-%ED%85%8C%EC%9D%B4%EB%B8%94table-%ED%82%A4key)
     * 테이블(Table)
     * 키(Key)의 정의
     * 키(Key)의 종류
  6. [성능 데이터 모델링](database/(001)%20Relational%20Database#6-%EC%84%B1%EB%8A%A5-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EB%AA%A8%EB%8D%B8%EB%A7%81)
     * 성능 데이터 모델링의 정의
     * 성능 데이터 모델링의 수행 시점
     * 성능 데이터 모델링의 고려 사항
  7. [정규화(Normalization)](database/(001)%20Relational%20Database#7-%EC%A0%95%EA%B7%9C%ED%99%94normalization)
     * 정규화의 정의
     * 잘못된 구조의 테이블
     * 정규화와 성능
     * [함수적 종속성(Functional Dependency, FD)](database/(001)%20Relational%20Database#74-%ED%95%A8%EC%88%98%EC%A0%81-%EC%A2%85%EC%86%8D%EC%84%B1functional-dependency-fd)
     * [정규화의 단계](database/(001)%20Relational%20Database#75-%EC%A0%95%EA%B7%9C%ED%99%94%EC%9D%98-%EB%8B%A8%EA%B3%84)
  8. [반정규화(Denormalization)]((001)%20Relational%20Database#8-%EB%B0%98%EC%A0%95%EA%B7%9C%ED%99%94denormalization)
     * 반정규화의 정의
     * 반정규화의 적용

</details>
<details>
  <summary><h3>2. SQL 기초 및 활용(MySQL)</h3></summary>

  1. [```MySQL``` 설치](database/(002)%20Using%20SQL#1-mysql-%EC%84%A4%EC%B9%98)
      * [```MySQL``` 설치와 연결](database/(002)%20Using%20SQL#11-mysql-%EC%84%A4%EC%B9%98%EC%99%80-%EC%97%B0%EA%B2%B0)
  1. [기초 SQL문 I](database/(002)%20Using%20SQL#2-%EA%B8%B0%EC%B4%88-sql%EB%AC%B8-i)
      * [데이터베이스 생성 (```CREATE```)](database/(002)%20Using%20SQL#21-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EC%83%9D%EC%84%B1)
      * [속성의 자료형 (Attribute Data Types)](database/(002)%20Using%20SQL#22-attribute-data-types)
      * [테이블 생성, Constraint 적용](database/(002)%20Using%20SQL#23-%ED%85%8C%EC%9D%B4%EB%B8%94-%EC%83%9D%EC%84%B1-constraint-%EC%A0%81%EC%9A%A9)
      * [테이블에 데이터 추가 / 수정 / 삭제 (```INSERT```/```UPDATE```/```DELETE```)](database/(002)%20Using%20SQL#24-%ED%85%8C%EC%9D%B4%EB%B8%94%EC%97%90-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%B6%94%EA%B0%80--%EC%88%98%EC%A0%95--%EC%82%AD%EC%A0%9C)
      * [데이터 조회 (```SELECT```)](database/(002)%20Using%20SQL#25-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%A1%B0%ED%9A%8C-select)
  1. [기초 SQL문 II](database/(002)%20Using%20SQL#3-%EA%B8%B0%EC%B4%88-sql%EB%AC%B8-ii)
      * [Subquery (Nested Query)](database/(002)%20Using%20SQL#31-subquery-nested-query)
      * [```NULL```과의 비교 연산, Three-valued logic](database/(002)%20Using%20SQL#32-null%EA%B3%BC%EC%9D%98-%EB%B9%84%EA%B5%90-%EC%97%B0%EC%82%B0-three-valued-logic)
      * [조인 (```JOIN```)](database/(002)%20Using%20SQL#33-%EC%A1%B0%EC%9D%B8-join)
      * [```ORDER BY```](database/(002)%20Using%20SQL#34-order-by)
      * [집계 함수 (Aggregate Function)](database/(002)%20Using%20SQL#35-aggregate-function)
      * [```GROUP BY```](database/(002)%20Using%20SQL#36-group-by)
      * [```HAVING```](database/(002)%20Using%20SQL#37-having)
      * [Examples](database/(002)%20Using%20SQL#38-%EC%A1%B0%ED%9A%8C-%EC%A7%91%EA%B3%84-%EC%98%88%EC%8B%9C)
  1. [Stored Function](database/(002)%20Using%20SQL#4-stored-function)
      * Examples
      * 저장된 Stored Function 파악하기기 
  1. [Stored Procedure](database/(002)%20Using%20SQL#5-stored-procedure)
      * Examples
      * Stored Function vs Stored Procedure
  1. [SQL Trigger](database/(002)%20Using%20SQL#6-sql-trigger)
      * Example
      * 주의 사항
  1. [인덱스(Index)](database/(002)%20Using%20SQL#7-%EC%9D%B8%EB%8D%B1%EC%8A%A4index)
      * [```INDEX``` 사용법](database/(002)%20Using%20SQL#71-index-%EC%82%AC%EC%9A%A9%EB%B2%95)
      * [인덱스 동작 방식](database/(002)%20Using%20SQL#72-%EC%9D%B8%EB%8D%B1%EC%8A%A4-%EB%8F%99%EC%9E%91-%EB%B0%A9%EC%8B%9D)
      * [인덱스를 확인하는 방법](database/(002)%20Using%20SQL#73-index%EB%A5%BC-%ED%99%95%EC%9D%B8%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95)
      * [주의 사항](database/(002)%20Using%20SQL#74-%EC%A3%BC%EC%9D%98-%EC%82%AC%ED%95%AD)
      * [Covering Index](database/(002)%20Using%20SQL#75-covering-index)
      * [Hash Index](database/(002)%20Using%20SQL#76-hash-index)
  1. [B-tree](database/(002)%20Using%20SQL#8-b-tree) (추가 예정)

</details>
<details>
  <summary><h3>3. RDBMS II</h3></summary>

  1. [트랜잭션 (Transaction)](database/(003)%20Relational%20Database%202#1-transaction)
     * [Transaction 설명](database/(003)%20Relational%20Database%202#11-transaction-%EC%84%A4%EB%AA%85)
     * [ACID](database/(003)%20Relational%20Database%202#12-acid)
  2. [동시성 제어 (Concurrency Control)](database/(003)%20Relational%20Database%202#2-concurrency-control)
     * [Schedule, Serializability](database/(003)%20Relational%20Database%202#21-schedule-serializability)
     * [Conflict](database/(003)%20Relational%20Database%202#22-conflict)
     * [Conflict Serializability](database/(003)%20Relational%20Database%202#23-conflict-serializability-protocol)
     * [Recoverability](database/(003)%20Relational%20Database%202#24-recoverability)
  3. [Isolation Level](database/(003)%20Relational%20Database%202#3-isolation-level)
     * [Dirty Read](database/(003)%20Relational%20Database%202#31-dirty-read)
     * [Non-repeatable Read](database/(003)%20Relational%20Database%202#32-non-repeatable-read)
     * [Phantom Read](database/(003)%20Relational%20Database%202#33-phantom-read)
     * [Isolation Level (SQL Standard)](database/(003)%20Relational%20Database%202#34-isolation-level-sql-standard)
     * [Dirty Write](database/(003)%20Relational%20Database%202#35-dirty-write)
     * [Lost Update](database/(003)%20Relational%20Database%202#36-lost-update)
     * [Snapshot Isolation](database/(003)%20Relational%20Database%202#37-snapshot-isolation)
  4. [Lock](database/(003)%20Relational%20Database%202#4-lock)
     * [Lock 소개](database/(003)%20Relational%20Database%202#41-lock-%EC%86%8C%EA%B0%9C)
     * [Exclusive Lock](database/(003)%20Relational%20Database%202#42-exclusive-lock-%EB%B0%B0%ED%83%80%EC%A0%81-lock)
     * [Shared Lock](database/(003)%20Relational%20Database%202#43-shared-lock-%EA%B3%B5%EC%9C%A0-lock)
     * [2PL (Two-Phased Locking)](database/(003)%20Relational%20Database%202#43-2pl-2-phase-locking)
     * [2PL의 한계](database/(003)%20Relational%20Database%202#48-2pl%EC%9D%98-%ED%95%9C%EA%B3%84)
  5. [MVCC (Multi Version Concurrency Control)](database/(003)%20Relational%20Database%202#5-mvccmulti-version-concurrency-control) (추가 예정)
  6. Distributed Database (추가 예정)
     * 파티셔닝 (Partitioning)
     * 샤딩 (Sharding)
     * 레플리케이션 (Replication)
  7. DBCP (Database Connection Pool) (추가 예정)

</details>
<details>
  <summary><h3>4. Java Database Access</h3></summary>

  1. [JDBC(Java Database Connectivity)](database/(004)Java_DB%20_Access#1-jdbcjava-database-connectivity)
     * [JDBC 소개](database/(004)Java_DB%20_Access#11-jdbc-%EC%86%8C%EA%B0%9C)
     * [JDBC 사용 - 1(`DriverManager`)](database/(004)Java_DB%20_Access#12-jdbc-%EC%82%AC%EC%9A%A9---1drivermanager)
       * 등록(`insert`)
       * 조회(`select`)
       * 수정, 삭제(`update`, `delete`)
       * 테스트 코드로 동작 확인
     * [JDBC 사용 - 2(`DBCP`)](database/(004)Java_DB%20_Access#13-jdbc-%EC%82%AC%EC%9A%A9---2dbcp)
       * `DBCP(커넥션 풀)` 소개
       * `DataSource`
       * 커넥션 풀 사용하기(`HikariDataSource`)
     * [JDBC 사용 -3(스프링 사용 x)](database/(004)Java_DB%20_Access#14-jdbc-%EC%82%AC%EC%9A%A9---3%EC%8A%A4%ED%94%84%EB%A7%81-%EC%82%AC%EC%9A%A9-x)
       * [프로젝트, DB 설정](database/(004)Java_DB%20_Access#141-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-db-%EC%85%8B%ED%8C%85)
       * [`dbutil` 구현](database/(004)Java_DB%20_Access#142-dbutil-%EA%B5%AC%ED%98%84)
       * [커넥션 생성, `DatabaseMetaData` 확인](database/(004)Java_DB%20_Access#143-%EC%BB%A4%EB%84%A5%EC%85%98-%EC%83%9D%EC%84%B1-databasemetadata-%ED%99%95%EC%9D%B8)
       * [`Statement` 사용](database/(004)Java_DB%20_Access#144-statement-%EC%82%AC%EC%9A%A9)
         * `executeQuery()`
         * `executeUpdate()`
         * `executeBatch()`
       * [`PreparedStatement` 사용](database/(004)Java_DB%20_Access#145-preparedstatement-%EC%82%AC%EC%9A%A9)
       * `CallableStatement` 사용
     * [`POJO` 클래스로 매핑](database/(004)Java_DB%20_Access#15-pojo-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%82%AC%EC%9A%A9)
       * [`POJO` 란](database/(004)Java_DB%20_Access#151-pojo%EB%9E%80)
       * [`POJO` 클래스에 매핑 후 사용](database/(004)Java_DB%20_Access#152-pojo-%ED%81%B4%EB%9E%98%EC%8A%A4%EC%97%90-%EB%A7%A4%ED%95%91-%ED%9B%84-%EC%82%AC%EC%9A%A9)
  2. [트랜잭션(Transaction)](database/(004)Java_DB%20_Access#2-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98transaction)
     * [트랜잭션 복습](database/(004)Java_DB%20_Access#21-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EB%B3%B5%EC%8A%B5)
     * [기존 트랜잭션 적용의 문제](database/(004)Java_DB%20_Access#22-%EA%B8%B0%EC%A1%B4-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EC%A0%81%EC%9A%A9%EC%9D%98-%EB%AC%B8%EC%A0%9C)
     * [스프링에서의 트랜잭션 처리](database/(004)Java_DB%20_Access#23-%EC%8A%A4%ED%94%84%EB%A7%81%EC%97%90%EC%84%9C%EC%9D%98-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EC%B2%98%EB%A6%AC)
       * `PlatformTransactionManager`
       * `TransactionTemplate`
       * `@Transactional`(트랜잭션 AOP)

</details>

---

# ⚙️ Linux





---

# 🛠️ Data Engineering

1. [AWS](aws/README.md)
2. Hadoop
   * HDFS
   * MapReduce
   * Hbase
   * Hive
3. Airflow
4. Kafka
5. Spark
6. Data Governance

---

# 📦 Container

### [container/README.md](container/README.md)

<details>
  <summary><h3>1. Docker</h3></summary>

  * [가상화(Virtualization)](container/(001)Docker#1-%EA%B0%80%EC%83%81%ED%99%94virtualization)
    * [가상화 소개](container/(001)Docker#11-%EA%B0%80%EC%83%81%ED%99%94-%EC%86%8C%EA%B0%9C)
    * [가상 머신(VM), 컨테이너(Container)](container/(001)Docker#12-%EA%B0%80%EC%83%81-%EB%A8%B8%EC%8B%A0vm-virtual-machine-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88container)
      * VM(Virtual Machine)
      * 컨테이너(Container)
  * [도커(Docker)](container/(001)Docker#2-%EB%8F%84%EC%BB%A4docker)
    * [Docker 소개](container/(001)Docker#21-docker-%EC%86%8C%EA%B0%9C)
    * [Docker Architecture](container/(001)Docker#22-docker-architecture)
    * [Docker Hub 소개](container/(001)Docker#23-docker-hub-%EC%86%8C%EA%B0%9C)
  * [Docker 사용](container/(001)Docker#3-docker-%EC%82%AC%EC%9A%A9)
    * [Dockerfile 생성](container/(001)Docker#31-dockerfile-%EC%83%9D%EC%84%B1)
    * [Docker image 빌드](container/(001)Docker#32-docker-image-%EB%B9%8C%EB%93%9C)
    * [Docker image 실행(컨테이너 실행)](container/(001)Docker#33-docker-image-%EC%8B%A4%ED%96%89%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88-%EC%8B%A4%ED%96%89)
    * [컨테이너 접속](container/(001)Docker#34-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88-%EC%A0%91%EC%86%8D)
      * 컨테이너 관련 명령
      * 컨테이너 접속하기
    * [Volume Mount](container/(001)Docker#35-volume-mount)
      * 볼륨(Volume) 소개
      * Volume Mount 하기
  * [Docker Compose](container/(001)Docker#4-docker-compose)
    * [Docker Compose 소개](container/(001)Docker#41-docker-compose-%EC%86%8C%EA%B0%9C)
    * [Docker Compose 사용하기](container/(001)Docker#42-docker-compose-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)

</details>

<details>
  <summary><h3>2. Container Orchestration(추가 예정)</h3></summary>

</details>

---

# :arrows_counterclockwise: ​CI/CD

1. CI/CD 소개
2. 깃헙 액션(Github Action)
3. 젠킨스(Jenkins)

---

# :books: Further Reading

* 빅데이터를 지탱하는 기술
* 객체지향의 사실과 오해
* Clean Coding
* Fundamentals of Data Engineering
* Designing Data-Intensive Applications
* [Why we're leaving cloud](https://world.hey.com/dhh/why-we-re-leaving-the-cloud-654b47e0)

