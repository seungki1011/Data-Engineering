> Spring의 핵심 원리에 대한 이론 및 실습.
>
> [스프링 MVC - 백엔드 웹 개발 핵심 기술](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-1), [쉬운 코드 - 유튜브 채널](https://www.youtube.com/@ez.), 등을 보고 정리한 포스트 입니다.

---

## Index



















---

## 1) Web Application

### 1.1 Web Server, WAS

웹 서버는 주로 웹 브라우저에서의 HTTP 요청에 응답하여 정적 웹 컨텐츠(예: HTML 페이지, 파일, 이미지, 비디오)를 제공한다. 일반적으로 애플리케이션 서버에서 웹 컨텐츠도 제공할 수 있으나, 이 서버의 주 기능은 최종 사용자 클라이언트와 서버 측 애플리케이션 코드(이른바 **비즈니스 로직**을 표현하는 코드) 간의 상호 작용을 통해 동적 컨텐츠, 이를테면 트랜잭션 결과, 의사결정 지원, 실시간 분석 등을 생성하고 제공하는 것이다. 

<br>

* **웹 서버(Web Server)**
  * 웹 서버는 웹 사이트를 호스팅하고 간단한 요청에 대한 응답을 제공
  * 웹 서버에 사용되는 기본 프로토콜은 HTTP 프로토콜
    * FTP, SMTP를 지원하는 웹 서버도 존재
  * **대부분 정적 콘텐츠 제공**
  * 대부분의 웹서버는 멀티스레딩을 지원하지 않는다
  * 예) Nginx, Apache
* **웹 애플리케이션 서버(WAS)**
  * **프로그램 코드를 실행해서 애플리케이션 로직(비즈니스 로직)을 처리**
  * 웹 서버에 사용되는 프로토콜 외에도 추가 통신 프로토콜을 사용하여 다른 소프트웨어 구성 요소와 통신
    * 예) RMI, RPC
  * 정적 콘텐츠도 제공 가능하지만, 대부분 동적 콘텐츠를 제공
  * **애플리케이션 서버는 멀티스레딩을 사용하여 높은 확장성과 효율성을 제공(동시 요청을 위한 멀티쓰레드 지원)**
    * 요청에 외부 리소스가 필요한 경우 애플리케이션 서버는 별도의 스레드를 사용하여 이러한 상호 작용을 처리
  * 예) Tomcat, Jetty, Undertow

<br>

최근에는 웹 서버와 애플리케이션 서버의 구분이 많이 모호해졌다. 웹 서버도 프로그램을 실행하는 기능을 포함하기도 하면서, WAS도 웹 서버의 기능을 제공해주기 때문이다. 일단은 **WAS는 애플리케이션 코드를 실행하는데 더 특화**되어 있다고 생각하자.

그러면 웹 서비스를 구성할 때 "WAS만 사용하는가?" 라고 물어보면, 답은 "아니요"다. WAS만으로 시스템을 구성하면 다음과 같은 문제가 발생한다.

* WAS가 너무 많은 역할을 담당, 서버 과부하 우려
* 자원을 가장 많이 소모하는 애플리케이션 로직이 정적 리소스 때문에 수행이 어려울 수 있다
* WAS 장애시 오류 화면 노출이 불가능하다

<br>

위와 같은 문제 때문에 보통 웹 서비스 시스템을 구성할 때 WAS앞에 웹서버를 배치한다. 이렇게 구성하는 경우 다음과 같은 이점을 얻을 수 있다.

* 정적 리소스는 웹서버가 처리하도록 할 수 있다
* 이 때 웹서버는 애플리케이션 로직같은 동적인 처리는 WAS에 요청을 위임한다
* WAS는 중요한 애플리케이션 로직만 처리하도록 할 수 있다
* 정적 리소스가 많아지면 → 웹 서버 증설
* 애플리케이션 로직 처리가 많아지면 → WAS 증설
* 애플리케이션 로직이 동작하는 WAS의 경우, 장애가 날 확률이 웹서버 보다 높다
* WAS, DB 장애시 웹서버가 오류 화면을 제공해줄 수 있다

<br>

<p align="center">   <img src="img/was1.jpeg" alt="spring MVC" style="width: 100%;"> </p>

<p align='center'>Web Server, WAS</p>

<br>

---

### 1.2 Thread Pool

Thread-per-request(요청 당 스레드) 모델의 단점과, 스레드 풀(thread pool)을 이용하는 이유를 알아보자.

먼저 웹 애플리케이션에서 스레드는 무엇일까?

* 애플리케이션 코드를 하나씩 순차적으로 실행하는 것이 스레드(thread)
* 자바 메인 메서드를 처음 실행하면 main이라는 이름의 스레드가 실행
* 스레드는 한번에 하나의 코드 라인만 수행
* 이때 동시 처리가 필요한 경우 스레드를 추가로 생성해서 사용한다(multi-thread)

<br>

웹 애플리케이션에서 여러 요청이 들어올 때, 요청 마다 스레드를 생성하는 것은 단일 스레드를 이용하는 것과 달리 동시 요청을 처리할 수 있도록 해준다. 그러나 이런 요청 당 스레드(thread-per-request) 모델에는 단점들이 존재한다.

<p align="center">   <img src="img/thread3.png" alt="spring MVC" style="width: 90%;"> </p>

<p align='center'>Thread per Request</p>

* 처리 속도보다 더 빠르게 요청이 늘어나면 어떤 일이 일어날까?
  * 요청마다 스레드가 계속 생성되기 때문에 스레드 수가 계속 늘어난다 (스레드 생성에 제한이 없다)
  * 스레드의 생성 비용은 비싼편이다 → 스레드 생성 소요시간으로 인해 요청 처리 시간이 더 오래 걸릴 수 있다
  * 스레드 수 증가 → 메모리 고갈
  * 컨텍스트 스위칭이 더 자주 발생한다 → CPU 오버헤드 증가
  * **이런 문제가 계속 늘어나면 결국에 서버 전체가 응답 불가능 상태에 빠진다!**

<br>

이런 문제를 해결하기 위해서 쓰레드 풀(thread pool)이라는 것을 사용한다.

<p align="center">   <img src="img/thread4.png" alt="spring MVC" style="width: 90%;"> </p>

<p align='center'>Thread Pool</p>

스레드 풀 동작 과정

1. 요청이 들어와서 스레드가 필요한 경우, 스레드 풀에서 이미 생성되어 있는 스레드를 꺼내서 사용한다
2. 요청에 스레드의 사용을 종료하면 해당 스레드를 스레드 풀에 다시 반납한다
3. 최대 스레드(max thread) 만큼 모두 사용중이어서 스레드 풀에 스레드가 없는 경우
   *  기다리는 요청을 거절하거나 특정 숫자만큼 대기하도록 설정할 수 있다

<br>

스레드 풀을 정리하자면 다음과 같다.

* **스레드 풀은 정해진 수 만큼의 스레드(max thread)를 미리 만들어놓고 스레드를 재사용하는 방법이다**
  * Tomcat은 기본 설정으로 max thread를 200으로 설정한다
* 미리 스레드를 만들어 놓기 때문에 스레드 생성 시간을 절약할 수 있다 → 쓰레드 생성 비용 절약, 응답 시간이 빨라진다 
* 제한된 개수의 스레드를 운용하는 것이기 때문에 스레드의 무제한 생성을 방지 할 수 있다 → 많은 요청이 들어와도 기존 요청을 안전하게 처리 가능하다

<br>

WAS의 주요 튜닝 포인트는 최대 스레드(max thread)이다.

* 최대 스레드가 너무 낮은 경우
  * 동시 요청이 많아질 때, 서버 리소스는 남아 돌지만 클라이언트는 응답 지연을 겪는다
* 최대 스레드가 너무 높은 경우
  * 동시 요청이 많아질 때, 서버의 자원(CPU, 메모리) 임계점 초과로 서버 다운

<br>

이상적인 최대 스레드 수는 작업 형태, 서버 성능, 아키텍쳐에 따라 달라질 수 있기 때문에 경험적으로 찾아야한다. 큐 사이즈에 제한이 없으면 요청이 무한히 쌓이는 위험 요인(메모리 고갈)이 될 수 있으니, 가능한 큐 사이즈를 확인해보는 것도 중요하다.

결론적으로 실제 서비스와 유사하게 성능 테스트를 해보자. (툴 : Apache ab, nGrinder 등) 

<br>

---

### 1.4 AJAX

AJAX는 Asynchronous JavaScript and XML의 약자로, 말 그대로 JavaScript와 XML을 이용한 비동기적 정보 교환 기법이다. 이름에 XML이라고 명시되어있긴 하지만 JSON이나 일반 텍스트 파일과 같은 다른 데이터 오브젝트들도 사용 가능해서 요즘엔 XML을 잘 안 쓰고 대부분 JSON을 사용한다.

AJAX의 동작 원리는 다음과 같다.

1. 브라우저가 사이트에 접속하면 서버는 사이트의 기본 구조를 담은 '템플릿'을 전달한다
2. 브라우저는 수신받은 템플릿 HTML과 CSS를 해석해 화면의 기본 모양을 랜더링한다
3. 계속해서 서버는 데이터의 요청 방식과 수신받은 데이터를 어떻게 가공해야 하는지를 기술한 자바스크립트 파일을 전달한다
4. 브라우저는 자바스크립트 파일을 해석해서 파일에 기술된 방식대로 서버에 추가 데이터를 요청한다
5. 서버는 순수 데이터를 응답으로 되돌려준다 (보통 JSON)
6. 브라우저는 수신한 데이터를 해석하여 템플릿의 적절한 위치에 삽입한다. 데이터의 가공 방식에 따라 삽입 외의 작업(변경, 삭제)을 할 수도 있다

<br>

AJAX가 등장하면서 Gmail과 같은 SPA(Single Page Application)도 점점 나오기 하기 시작했다.

<br>

---

### 1.5 SSR(Server Side Rendering), CSR(Client Side Rendering)

SSR은 요청에 대한 결과 HTML을 서버에서(Server Side) 생성해서 클라이언트에 전달하는 방식이다. SSR의 과정은 다음과 같다.

1. 클라이언트에서 요청을 보낸다
2. 서버에서 응답을 위해 즉시 렌더링 가능한 HTML을 생성한다
3. 클라이언트에 HTML을 전달한다.
   * HTML은 브라우저에서 즉시 렌더링된다
   * 클라이언트가 자바스크립트를 다운로드하기 전까지 동적으로 상호작용이 불가능하다 (JS 다운로드 전까지의 조작을 기억한다)

<br>

반면에 CSR은 결과 HTML을 자바스크립트를 사용해 웹 브라우저에서 동적으로 내용을 생성해서 적용하는 것이다. CSR의 과정은 다음과 같다.

1. 클라이언트에서 요청을 보낸다
2. 서버는 클라이언트에게 비어있는 HTML과 자바스크립트 링크를 클라이언트에게 보낸다
3.  클라이언트는 자바스크립트를 요청
4. 서버는 자바스크립트를 클라이언트에게 전달
   * 자바스크립트 안에 클라이언트 로직과 HTML을 렌더링하는 코드가 들어가 있음
5. 클라이언트는 HTTP API를 가지고 데이터를 요청함
6. 서버는 해당 데이터 요청에 대한 JSON을 클라이언트에게 응답으로 전달
7. 클라이언트는 해당 데이터(JSON)를 가지고 동적으로 HTML 내용 렌더링 

<br>

SSR VS CSR의 특징을 정리해보자.

* SSR
  * 초기 로딩 속도가 빠름
  * 주로 정적인 화면에 사용
  * 모든 데이터가 담긴 HTML을 브라우저로 전달하기 때문에 SEO에 유리
  * SSR을 사용하더라도, JS를 사용해서 화면 일부를 동적으로 변경 가능
  * 관련 기술 : JSP, 타임리프(템플릿 엔진)
* CSR
  * 초기 로딩 이후의 구동 속도가 빠름
    * SSR에 비해 초기 로딩 속도가 느림
  * 주로 동적인 화면에 사용
  * 대부분 HTML의 내용이 비어있기 때문에 SEO에 불리
  * 서버 부하를 줄일 수 있음
  * 관련 기술 : React, Vue

<br>

<p align="center">   <img src="img/ssrcsr.png" alt="spring MVC" style="width: 85%;"> </p>

<p align='center'>SSR vs CSR</p>

<br>

> CSR + SSR을 동시 사용할 수 있는 웹프레임워크들도 존재

<br>

---

## 2) MVC(Model View Controller)

### 2.1 MVC 소개

기존의 서블릿이나 JSP만 사용하게 되면, **비즈니스 로직과 뷰(view)가 분리되어 있지 않았다. 결과적으로 유지보수가 어려워진다**. 예를 들자면, 비즈니스 로직을 처리하는 코드를 변경해야하는 경우 뷰가 함께 있는 코드를 수정해야한다. 반대로 UI를 변경하는 일에도 비즈니스 로직이 있는 코드도 함께 수정해야 한다.

MVC 패턴은 기존에 하나의 영역으로 처리하던 것을 컨트롤러(Controller), 뷰(View), 모델(Model)의 3개 영역으로 분리하는 디자인 패턴이다. 웹 애플리케이션의 많은 경우 이 MVC 패턴을 이용한다.

<p align="center">   <img src="img/mvc2.png" alt="spring MVC" style="width: 100%;"> </p>

<p align='center'>MVC Pattern</p>

* **컨트롤러(Controller)**: HTTP 요청을 받아서 파라미터를 검증하고, 비즈니스 로직을 실행한다. 그리고 뷰에 전달할 결과 데이터를 조회해서 모델에 담는다.
  * 컨틀로러에 비즈니스 로직을 둘 수도 있지만, 이 경우 컨트롤러가 너무 많은 역할을 담당한다
  * **비즈니스 로직을 서비스 레이어라는 계층을 별도로 만들어서 처리하는 경우가 많다**
  * 컨트롤러는 비즈니스 로직이 있는 서비스를 호출하는 역할
* **모델(Model)**: 뷰에 출력할 데이터를 담아둔다
  * 뷰는 비즈니스 로직이나 데이터 접근을 몰라도 됨
* **뷰(View)** : 모델에 담겨있는 데이터를 이용해 화면을 그린다(대부분 HTML 생성을 말한다)

<br>

---

### 2.2 Front Controller

기존 MVC 패턴의 단점은 다수의 컨트롤러에서 중복되는 코드들이다. 이런 중복 코드를 메서드로 공통화 할 순 있지만, 결국에 해당 메서드도 항상 직접 호출해야하는건 변함이 없다.

기능이 복잡해질 수록 컨트롤러에서 공통으로 처리해야 하는 부분이 점점 더 많이 증가할 것이다. 단순히 공통 기능을 메서드로 뽑으면 될 것 같지만, 결과적으로 해당 메서드를 항상 호출해야 하고, 실수로 호출하지 않으면 문제가 될 것이 다. 그리고 호출하는 것 자체도 중복이다.

이를 해결하기 위해서 **컨트롤러 호출전에 공통 기능을 처리하는 프론트 컨틀로러(Front Controller)를 도입**하면 된다. (Centralized request handling)

<br>

<p align="center">   <img src="img/front2.png" alt="spring MVC" style="width: 100%;"> </p>

<p align='center'>Front Controller</p>

* Front Controller 도입 전에는 컨트롤러의 공통 로직이 계속 중복되어서 들어갔다
* Front Controller 도입 후에는 공통의 로직을 하나의 서블릿으로 모아서 처리한다
* Front Controller의 특징은 다음과 같다
  * 프론트 컨트롤러 서블릿 하나로 클라이언트의 요청을 받는다(Centralized request handling)
  * 프론트 컨트롤러가 요청에 맞는 컨트롤러를 찾아서 호출한다
  * 프론트 컨트롤러를 제외한 나머지 컨트롤러는 서블릿을 사용하지 않아도 된다
    * 서블릿을 만들었던 이유는 싱글톤으로 관리되는 서블릿을 통해 요청을 받고 응답을 생성하기 위함이였음 → 이제는 프론트 컨틀롤러 서블릿을 통해 요청을 다 받으면 됨 → 나머지 컨틀로러는 서블릿을 사용하지 않아도 됨
* 스프링 웹 MVC의 `DispatcherServlet`이 프론트 컨트롤러 패턴으로 구현되어 있음

<br>

---

### 2.3 Front Controller 도입

프론트 컨트롤러와 나머지 컨트롤러를 구현하기 이전에, 구현할 애플리케이션의 요구사항을 간단하게 짚고 넘어가자. 

회원 관리 웹 애플리케이션 요구사항

* 회원 정보
  * 이름 : `username`
  * 나이 : `age`
* 기능 요구사항
  * 회원 저장
  * 회원 목록 조회

<br>

프론트 컨트롤러를 도입하고 점진적으로 리팩토링을 진행해보자. 프론트 컨트롤러 도입 전에 컨틀로러 인터페이스를 만들자. 프론트 컨트롤러를 제외한 나머지 컨트롤러들은 이 인턴페이스를 구현하면 된다. 프론트 컨트롤러는 이 인터페이스를 호출해서 구현과 관계없이 로직의 일관성을 가져갈 수 있다.

`ControllerV1`

```java
public interface ControllerV1 {
     void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
 }
```

이 인터페이스를 구현할 컨트롤러는 

* 회원 등록 컨트롤러
* 회원 저장 컨트롤러
* 회원 목록 컨트롤러

<br>

프론트 컨트롤러 도입을 위해 `FrontControllerServletV1`을 만들자.

```java
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")

public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();
		
  	// 컨트롤러 맵을 통해서 URL과 호출될 컨트롤러를 매핑한다
    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        String requestURI = request.getRequestURI();

        ControllerV1 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(request, response);
    }
}
```

* `urlPatterns = "/front-controller/v1/*"`:  `/front-controller/v1`를 포함한 하위 모든 요청을 이 서블릿애서 받아들인다
* `controllerMap`을 통해 URL과 호출될 컨트롤러를 매핑
* `requestURI` 를 조회해서 실제 호출할 컨트롤러를 `controllerMap` 에서 찾는다
  * 없으면 : `404 Not Found` 반환
  * 찾으면 : `controller.process(request, response);` 을 호출해서 해당 컨트롤러를 실행

<br>

그림으로 살펴보면 다음과 같다. 

<p align="center">   <img src="img/controllerv1.png" alt="spring MVC" style="width: 100%;"> </p>

<p align='center'>Front Controller V1</p>

<br>

---

### 2.4 View 분리

구현된 컨트롤러에서 뷰로 이동하는 부분에 중복이 있었다. (컨트롤러에서 JSP forward하는 부분)

```java
String viewPath = "/WEB-INF/views/new-form.jsp";
RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
dispatcher.forward(request, response);
```

<br>

중복되는 부분을 분리하기 위해서 별도로 뷰를 처리하는 객체 `MyView`를 만들고, 기존 컨트롤러들이 `MyView`를 반환하도록 컨트롤러들을 수정해보자.

이를 위해서 기존 컨트롤러 인터페이스의 구현이 `MyView`를 반환하도록 수정해야 한다.

`ControllerV2`

```java
public interface ControllerV2 {
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
```

<br>

`MyView`에서는 `render()`를 통해서 `forward`로직을 수행해서 JSP가 실행된다.

<br>

그림으로 구조를 살펴보면 다음과 같다.

<p align="center">   <img src="img/controllerv2.png" alt="spring MVC" style="width: 100%;"> </p>

<p align='center'>View seperation + Front Controller V2</p>

* `ControllerV2`를 구현한 컨트롤러들을 살펴보면, 복잡하게 뷰로 이동하던 로직들의 중복이 제거되었다
* 프론트 컨트롤러의 도입으로 `MyView` 객체의 `render()` 를 호출하는 부분을 모두 일관되게 처리할 수 있다
* 각각의 컨트롤러는 `MyView` 객체를 생성만 해서 반환하면 된다

<br>

---

### 2.5 Model 도입

Model을 도입해보자.

* 서블릿 종속성 제거
  * 컨틀로러 입장에서 `HttpServletRequest`, `HttpServletResponse`는 필요하지 않다
  * 요청 파라미터의 정보는 `Map`으로 대신 넘기도록 하면 지금 구조에서 컨트롤러가 서블릿 기술을 몰라도 동작 가능
  * `request` 개체를 모델로 사용하는 대신, 별도의 모델 객체를 만들어서 반환하면 된다
* 뷰 이름 중복 제거
  * 컨트롤러에서 지정하는 뷰 이름에 중복이 있다
  * 컨트롤러는 뷰의 논리 이름을 반환하고, 실제 물리 위치의 이름은 프론트 컨트롤러에서 처리하도록 하자 → 향후 뷰의 폴더 위치가 함께 이동해도 프론트 컨트롤러만 수정하면 된다 (논리 이름 : 의미를 나타내는 이름)
    * `/WEB-INF/views/new-form.jsp` → 논리 이름 : `new-form`
    *  `/WEB-INF/views/save-result.jsp` → 논리 이름 : `save-result`
    * `/WEB-INF/views/members.jsp` → 논리 이름 : `members`

<br>

<p align="center">   <img src="img/servletdependency.png" alt="spring MVC" style="width: 90%;"> </p>

<p align='center'>MemberSaveControllerV2</p>

<br>

지금까지 컨트롤러에서 서블릿에 종속적인 `HttpServletRequest`를 사용했다. 그리고 Model도 `request.setAttribute()` 를 통해 데이터를 저장하고 뷰에 전달했다.

서블릿의 종속성을 제거하기 위해 Model을 직접 만들고, 추가로 View 이름까지 전달하는 객체를 만들어야한다. (이번 버전에서는 컨트롤러에서 HttpServletRequest를 사용할 수 없다. 따라서 직접 `request.setAttribute()` 를 호출할 수 도 없다. 따라서 Model이 별도로 필요.)

이를 위해서 `ModelView`를 만든다.

<br>

`ModelView`

```java
public class ModelView {
     private String viewName;
  
     private Map<String, Object> model = new HashMap<>();
     
  	 public ModelView(String viewName) { this.viewName = viewName; }
  
     public String getViewName() { return viewName; }
  
     public void setViewName(String viewName) { this.viewName = viewName; }
  
     public Map<String, Object> getModel() { return model; }
  
     public void setModel(Map<String, Object> model) { this.model = model; }	 
}
```

* 뷰의 이름과 뷰를 렌더링할 때 필요한 model 객체를 가지고 있다
* model은 단순히 map으로 되어 있으므로 컨트롤러에서 뷰에 필요한 데이터를 key, value로 넣어주면 된다

<br>

```ControllerV3```

```java
public interface ControllerV3 {
     ModelView process(Map<String, String> paramMap);
}
```

* `HttpServletRequest`가 제공하는 파라미터는 프론트 컨트롤러가 `paramMap`에 담아서 호출해주면 된다
* 응답 결과로 뷰 이름과 뷰에 전달할 Model 데이터를 포함하는 `ModelView` 객체를 반환하면 된다

<br>

`FrontControllerV3`

```java
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, 		IOException {

        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(), request, response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
```

* `view.render(mv.getModel(), request, response)`의 동작을 위해서 `MyView`에 필요한 메서드를 추가해야 한다



<br>

그림으로 살펴보자.

<p align="center">   <img src="img/frontcontrollerv3.png" alt="spring MVC" style="width: 100%;"> </p>

<p align='center'>Servlet Dependency elimination + Front Controller V3</p>

* `view.render(mv.getModel(), request, response)`
  * 뷰 객체를 통해서 HTML 화면을 렌더링 한다
  * 뷰 객체의 `render()` 는 모델 정보도 함께 받는다
  * JSP는 `request.getAttribute()` 로 데이터를 조회하기 때문에, 모델의 데이터를 꺼내서`request.setAttribute()` 로 담아둔다
  * JSP로 `forward` 해서 JSP를 렌더링 한다

<br>

---

### 2.6 사용성 개선

지금까지 구현한 컨트롤러의 개선 방법. 사용성이 더 편리하도록 개선해보자.

* 지금의 구조에서 컨트롤러가 `ModelView`를 반환하지 않고 `ViewName`만 반환하도록 한다

```Java
public interface ControllerV4 {
  String process(Map<String, String> paramMap, Map<String, Object> model);
 }
```

* model 객체는 파라미터로 전달해서 컨트롤러에서 그냥 사용하면 된다
* 결과로 뷰의 이름(`ViewName`)만 반환해주면 된다

<br>

```java
@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {
  /** 기존 구현 */
  
  Map<String, String> paramMap = createParamMap(request);
  Map<String, Object> model = new HashMap<>(); //추가
  
  String viewName = controller.process(paramMap, model);
  
  // 컨트롤러가 직접 뷰의 논리 이름을 반환하기 때문에 이 값을 그대로 사용해서 실제 물리 경로 찾을 수 있음
  MyView view = viewResolver(viewName);
  view.render(model, request, response);
  
  /** 기존 구현 */
}
```

* `Map<String, Object> model = new HashMap<>();` 
  * 모델 객체를 프론트 컨트롤러에서 생성해서 넘겨준다
  * 컨트롤러에서 모델 객체에 값을 담으면 여기에 그대로 담긴다

<br>

그림으로 살펴보자.

<p align="center">   <img src="img/controllerv4.png" alt="spring MVC" style="width: 100%;"> </p>

<p align='center'>Controller V3 사용성 개선</p>

<br>

---

### 2.7 Adapter

우리가 기존의 `ControllerV3` 방식으로도 개발을 하고, 개선된 컨트롤러 방식으로도 개발을 하고 싶으면 어떻게 할까? 현재의 코드로는 한가지 방식의 컨트롤러 인터페이스만 사용가능하다. 이를 해결하기 위해서 어댑터(Adapter)를 도입해보자.

> 어댑터 패턴(Adapter Pattern) : 기존의 request들이 compatible 하도록 중간에 바꿔주는 어댑터를 도입하는 패턴을 어댑터 패턴이라고 한다

<br>

어댑터를 도입한 구조를 그림으로 살펴보면 다음과 같다.

<p align="center">   <img src="img/controllerv5_1.png" alt="spring MVC" style="width: 100%;"> </p>

<p align='center'>Adapter 도입</p>

* **핸들러 어댑터**: 중간에 어댑터 역할을 하는 어댑터(Adapter)가 추가되었는데 이름이 핸들러 어댑터이다. 여기서 어댑터 역할을 해주는 덕분에 다양한 종류의 컨트롤러를 호출할 수 있다.
  * 어댑터는 실제 컨트롤러를 호출하고, 그 결과로 `ModelView`를 반환해야 한다 (이제부터 어댑터를 통해서 컨트롤러 호출)
  * 컨트롤러가 `ModelView`를 반환하지 못하면, 어댑터가 `ModelView`를 직접 생성해서라도 반환해야 한다



* **핸들러**: 컨트롤러의 이름을 더 넓은 범위인 핸들러로 변경했다. 그 이유는 이제 어댑터가 있기 때문에 꼭 컨트롤러의 개념 뿐만 아니라 어떠한 것이든 해당하는 종류의 어댑터만 있으면 다 처리할 수 있기 때문이다.

<br>

<p align="center">   <img src="img/controllerv5_2.png" alt="spring MVC" style="width: 100%;"> </p>

* 결론적으로 어댑터를 이용하면 프레임워크를 더 유연하고 확장성 있게 설계할 수 있다.

<br>

---

## 3) Spring MVC

### 3.1 Spring MVC 구조

우리가 이전까지 구성했던 프레임워크와 스프링 MVC를 비교해보면 구성요소가 같다는 것을 확인할 수 있다. 명칭은 다음과 같이 대응된다.

* `FrontController` → `DispatcherServlet`
* `handlerMappingMap` → `HandlerMapping`
* `MyHandlerAdapter` → `HandlerAdapter`
* `ModelView` → `ModelAndView`
* `viewResolver` → `ViewResolver`
* `MyView` → `View`

<br>

<p align="center">   <img src="img/springmvc.png" alt="spring MVC" style="width: 100%;"> </p>

<p align='center'>Spring MVC</p>

* `DispatcherServlet` : 스프링 MVC의 프론트 컨트롤러
  * `HttpServlet`을 상속 받아서 사용하고, 서블릿으로 동작한다
  * 스프링 부트는 `DispatcherServlet`을 서블릿으로 자동 등록하면서 모든 경로(`urlPatterns="/"`)에 대해 매핑한다
* `DispatcherServlet` 호출 → `HttpServlet`이 제공하는 `service()` 호출 → `FrameworkServlet.service()`를 시작으로 여러 메서드 호출 → 그 중에서 제일 중요한 것은 `DispatcherServlet.doDispatch()`의 호출이다

<br>

 `DispatcherServlet.doDispatch()`의 코드를 살펴보자.(예외처리와 인터셉터 기능은 전부 제외했다)

```java
 protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
     
     HttpServletRequest processedRequest = request;
     HandlerExecutionChain mappedHandler = null;
     ModelAndView mv = null;
   
		 // 1. 핸들러 조회
		 mappedHandler = getHandler(processedRequest); 
     if (mappedHandler == null) {
         noHandlerFound(processedRequest, response);
		 		 return; 
     }
		
     // 2. 핸들러 어댑터 조회 - 핸들러를 처리할 수 있는 어댑터
		 HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());
   
		 // 3. 핸들러 어댑터 실행 -> 4. 핸들러 어댑터를 통해 핸들러 실행 -> 5. ModelAndView 반환 
     mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
   
     processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException);
 }

 private void processDispatchResult(HttpServletRequest request, HttpServletResponse response,  HandlerExecutionChain mappedHandler, ModelAndView mv, Exception exception) throws Exception {
   	 
   	 // 뷰 렌더링 호출
     render(mv, request, response);
 }

 protected void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws  Exception {
   
     View view;
     String viewName = mv.getViewName();
		 
     // 6. 뷰 리졸버를 통해서 뷰 찾기, 7. View 반환
     view = resolveViewName(viewName, mv.getModelInternal(), locale, request);
		 
     // 8. 뷰 렌더링
     view.render(mv.getModelInternal(), request, response);
 }
```

<br>

---

#### 3.1.1 `HandlerMapping`, `HandlerAdapter`

 `HandlerMapping`, `HandlerAdapter`를 더 자세히 살펴보자.

과거에 주로 사용했던 스프링이 제공하는 컨트롤러를 이용해서 이해해보자.

```java
 public interface Controller {
   	 // 과거에 사용했던 컨트롤러
     ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse
 		 response) throws Exception;
 }
```

<br>

이 컨트롤러 인터페이스를 이용해서 컨트롤러를 구현해보자.

```java
 @Component("/springmvc/old-controller")
 public class OldController implements Controller {
   
     @Override
     public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws 	        Exception {
         System.out.println("OldController.handleRequest");
         return null;
		 } 
 }
```

* `/springmvc/old-controller`이라는 이름으로 스프링 빈 등록
* 빈의 이름으로 URL 매핑할 예정

<br>

http://localhost:8080/springmvc/old-controller을 실행해보면 `OldController.handleRequest`의 출력을 확인 할 수 있다.

그럼 이 컨트롤러의 호출 방법을 살펴보자.

* `HandlerMapping`(핸들러 매핑)
  * 핸들러 매핑에서 이 컨트롤러를 찾을 수 있어야 한다
  * 예) 스프링 빈의 이름으로 핸들러를 찾을 수 있는 핸들러 매핑이 필요하다 → `/springmvc/old-controller`으로 핸들러를 찾을 수 있는 매핑 필요
* `HandlerAdapter`(핸들어 어댑터)
  * 핸들러 매핑을 통해서 찾은 핸들러를 실행할 수 있는 핸들러 어댑터가 필요하다
  * 예) `Controller` 인터페이스를 실행할 수 있는 핸들러 어댑터를 찾고 실행해야 한다

<br>

스프링은 필요한 핸들러 매핑과 어댑터를 대부분 구현해두었다. 스프링 부트는 자동으로 여러가지 `HandlerMapping`과  `HandlerAdapter`를 등록해둔다.

* `HandlerMapping`
  0. `RequestMappingHandlerMapping` : 애노테이션 기반의 컨트롤러인 `@RequestMapping`에서 사용한다
  1. `BeanNameUrlHanlderMapping` : 스프링 빈의 이름으로 핸들러를 찾는다 (위의 예시에서 사용)
* `HandlerAdapter`
  0. `RequestMappingHandlerAdapter` : 애노테이션 기반의 컨트롤러인 `@RequestMapping`에서 사용한다
  1. `HttpRequestHandlerAdapter` : `HttpRequestHandler` 처리
  2. `SimpleControllerHandlerAdapter` : `Controller` 인터페이스 처리(애노테이션X, 과거에 사용, 위의 예시에서 사용) 

<br>

개발할 때는 대부분 `@RequestMapping` 사용.

<br>

---

#### 3.1.2 `ViewResolver`

뷰 리졸버에 대해서 자세히 알아보자.

`View`를 사용할 수 있도록 위에서 구현한 `OldController`에 다음 코드를 추가해보자 `return new ModelAndView("new-form");`. 그러나 `springmvc/old-controller`에 들어가보면 에러 페이지가 나오는 것을 확인 할 수 있다. 이를 해결하기 위해서 다음 코드를 추가해보자.

`application.properties`

```java
 spring.mvc.view.prefix=/WEB-INF/views/
 spring.mvc.view.suffix=.jsp
```

* 스프링 부트는 `InternalResourceViewResolver` 라는 뷰 리졸버를 자동으로 등록한다
* `application.properties` 에 등록한 `spring.mvc.view.prefix` , `spring.mvc.view.suffix` 설정 정보를 사용해서 등록한다

<br>

스프링 부트가 자동으로 등록하는 `ViewResolver`를 몇 가지 알아보자.

1. `BeanNameViewResolver` : 빈 이름으로 뷰를 찾아서 반환한다
2. `InternalResourceViewResolver` : JSP를 처리할 수 있는 뷰를 반환한다

<br>

동작 과정을 한번 살펴보자.

1. 핸들러 어댑터 호출
   * 핸들러 어댑터를 통해 `new-form`이라는 뷰의 논리 이름을 획득한다
2. `ViewResolver` 호출
   * `new-form`이라는 뷰 이름으로 `viewResolver`를 순서대로 호출한다
   * `BeanNameViewResolver`는 `new-form`이라는 이름의 스프링 빈으로 등록된 뷰를 찾지만 없다
   * `InternalResourceViewResolver`가 호출
3. `InternalResourceViewResolver`
   * `InternalResourceView` 반환
4. `InternalResourceView` 
   * `InternalResourceView` 는 JSP처럼 포워드 `forward()` 를 호출해서 처리할 수 있는 경우에 사용한다
5. `view.render()` 
   * `view.render()` 가 호출되고 `InternalResourceView` 는 `forward()` 를 사용해서 JSP를 실행한다

<br>

* 다른 뷰는 실제 뷰를 렌더링하지만, JSP의 경우 `forward()` 통해서 해당 JSP로 이동(실행)해야 렌더링이 된다. JSP를 제외한 나머지 뷰 템플릿들은 `forward()` 과정 없이 바로 렌더링 된다.
* Thymeleaf 뷰 템플릿을 사용하면 `ThymeleafViewResolver` 를 등록해야 한다. 최근에는 라이브러리만 추가하면 스프링 부트가 이런 작업도 모두자동화해준다.

<br>

---

### 3.2 Spring MVC 사용해보기

이전의 회원 등록 애플리케이션을 스프링 MVC를 이용해서 구현해보자.

들어가기에 앞서, 스프링이 제공하는 컨트롤러는 애노테이션 기반으로 동작해서, 매우 실용적이다.

<br>

`SpringMemberControllerV2`

```java
 /**
	* 클래스 단위 -> 메서드 단위
	* @RequestMapping 클래스 레벨과 메서드 레벨 조합 
	*/

 @Controller
 @RequestMapping("/springmvc/v2/members") // 매핑 URL의 중복을 제거
 public class SpringMemberControllerV2 {
   
     private MemberRepository memberRepository = MemberRepository.getInstance();
     
     @RequestMapping("/new-form")
     public ModelAndView newForm() {
         return new ModelAndView("new-form");
		 }
   	 
     // 위의 @RequestMapping("/springmvc/v2/members")를 통해서 "/springmvc/v2/members" + "/save"으로 사용
	   @RequestMapping("/save")
     public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
         
         String username = request.getParameter("username");
         int age = Integer.parseInt(request.getParameter("age"));
         
         Member member = new Member(username, age);
         memberRepository.save(member);
         
         ModelAndView mav = new ModelAndView("save-result");
         mav.addObject("member", member); // Model 데이터 추가
         
         return mav;
     }
   	 
     // "/springmvc/v2/members" 자체가 URL
     @RequestMapping
     public ModelAndView members() {
         
         List<Member> members = memberRepository.findAll();
         
         ModelAndView mav = new ModelAndView("members");
         mav.addObject("members", members); 
         
         return mav;
} 
```

* `@Controller`
  * 스프링이 자동으로 스프링 빈으로 등록한다. (내부에 `@Component` 애노테이션이 있어서 컴포넌트 스캔의 대상이 됨)
  * 스프링 MVC에서 애노테이션 기반 컨트롤러로 인식한다
* `@RequestMapping`
  * 요청 정보를 매핑한다
  * 해당 URL이 호출되면 이 메서드가 호출된다
  * 애노테이션을 기반으로 동작하기 때문에, 메서드의 이름은 임의로 지으면 된다
* `ModelAndView`
  * 모델과 뷰 정보를 담아서 반환
* 기존에는 분리되어 있던 컨트롤러 클래스들을 하나로 통합했다
* 클래스 레벨의 `@RequestMapping`를 이용해서 URL의 중복을 제거 할 수 있다
  * 예) 클래스 레벨 : `@RequestMapping("/springmvc/v2/members")` + 메서드 레벨 : `@RequestMapping("/new-form")`

<br>

> 기존에는 스프링 빈 중에 클래스 레벨에 `@RequestMapping`이 붙어 있었으면 `RequestMappiongHandlerMapping`이 매핑정보로 인식 했지만, **스프링 3.0 부터 클래스 레벨에 `@RequestMapping`이 붙어 있는 스프링 빈이어도 스프링 컨트롤러로 인식하지 않는다. 무조건 `@Controller`가 붙어 있어야 스프링 컨트롤러로 인식한다.**

<br>

---

### 3.3 사용성 개선

지금까지 만들었던 스프링 MVC 컨트롤러의 사용성을 개선해보자.

개선하고 싶은 부분은 다음과 같다.

* `ViewName`을 직접 반환하도록 하고 싶다(뷰의 논리 이름 반환)
* Model 파라미터를 받고 싶다
* HTTP 요청 파라미터를 직접 받고 싶다
* `@RequestMapping` 으로 URL만 매칭하는 것이 아니라, HTTP 메서드도 구분하고 싶다

<br>

개선한 코드를 살펴보자.

`SpringMemberControllerV3`

```java
 /**
  * Model 도입
  * ViewName 직접 반환
  * @RequestParam 사용
  * @RequestMapping -> @GetMapping, @PostMapping
  */

 @Controller
 @RequestMapping("/springmvc/v3/members")
 public class SpringMemberControllerV3 {
     private MemberRepository memberRepository = MemberRepository.getInstance();
     
     // @RequestMapping(value = "/new-form", method = RequestMethod.GET)
     @GetMapping("/new-form")
     public String newForm() {
         return "new-form";
     }
     
     // @RequestMapping(value = "/save", method = RequestMethod.POST)
     @PostMapping("/save")
     public String save(
             @RequestParam("username") String username,
             @RequestParam("age") int age,
             Model model) {
         Member member = new Member(username, age);
         memberRepository.save(member);
         model.addAttribute("member", member);
         return "save-result";
     }
     
     @GetMapping
     public String members(Model model) {
         List<Member> members = memberRepository.findAll();
         model.addAttribute("members", members);
         return "members";
		 } 
 }
```

* `ModelAndView`로 반환해도 되고, 뷰 이름으로 그냥 반환해도 된다
* 기존의 `HttpServletRequest request, HttpServletResponse response`를 파라미터를 직접 받도록 할 수 있다
  * 스프링은 HTTP 요청 파라미터를 `@RequestParam` 으로 받을 수 있다
  * `@RequestParam("username")` 은 `request.getParameter("username")` 와 거의 같은 코드라 생각하면 된다
  * 그냥 Model 파라미터를 받고 `model.addAttribute("member", member)` 을 사용해도 된다
* `@RequestMapping` 은 URL만 매칭하는 것이 아니라, HTTP Method도 함께 구분할 수 있도록 할 수 있다
  * 예) 처음에는 `@RequestMapping("/new-form")` → `@RequestMapping(value = "/new-form", method = RequestMethod.GET)` → `@GetMapping("/new-form")`
  * 위에서 볼 수 있듯이, `@GetMapping`, `@PostMapping` 등 으로 더 편리하게 사용할 수 있다
  * `GET`, `POST` 외에도 `PUT`, `DELETE`, `PATCH` 등의 애노테이션도 전부 구현되어 있다

<br>

---

## 4) Spring MVC 기능 살펴보기

### 4.1 Logging

로깅에 대해서 알아보자.























---

## Reference

1. [스프링 MVC - 백엔드 웹 개발 핵심 기술](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-1)
1. [쉬운 코드 - 스레드 풀](https://www.youtube.com/watch?v=B4Of4UgLfWc)
1. [https://community.fs.com/article/application-server-guide-a-detailed-perspective.html](https://community.fs.com/article/application-server-guide-a-detailed-perspective.html)
1. [https://www.geeksforgeeks.org/spring-mvc-framework/](https://www.geeksforgeeks.org/spring-mvc-framework/)
