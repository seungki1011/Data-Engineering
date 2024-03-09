> HTTP에 관한 기초
>
> [인프런 - 모든 개발자를 위한 HTTP 웹 기본 지식](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard), 네트워크 하향식 접근, 등을 참고했습니다.

---

## Table of Contents

1. 웹 통신
   * 인터넷(Internet)
   * IP(Internet Protocol)
   * TCP(Transmission Control Protocol)
     * TCP 소개
     * Three way handshake
     * 데이터 전달 보증, 순서 보장
   * UDP(User Datagram Protocol)
   * PORT
   * DNS(Domain Name System)
   * URI(Uniform Name Identifier)
   * 요청의 흐름
3. HTTP
   * HTTP 소개
   * Client-Server
   * Stateless
   * Connectionless
   * HTTP Message
4. HTTP Method
   * HTTP API 설계
   * GET,POST
   * PUT, PATCH, DELETE
   * HTTP 메서드의 속성
   * HTTP 메서드의 활용
     * 클라이언트 → 서버 데이터 전송
     * 
6. HTTP 상태코드
7. HTTP 헤더
   * HTTP 헤더 소개
   * 표현(Content)
   * 협상(Accept)
   * 전송 방식
   * 헤더의 일반 정보
   * 헤더의 특별한 정보
   * 인증
   * 쿠키(Cookie)
8. 캐시(Cache)





---

## 1) 웹 통신

### 1.1 인터넷(Internet)

클라이언트(Client)과 서버(Server)간의 통신은 대다수의 경우 인터넷(Internet)을 통해서 이루어진다.



<p align="center">   <img src="img/internet1.png" alt="http" style="width: 65%;"> </p>

<p align='center'>네트워크 하향식 접근 - 인터넷</p>

<br>

위의 그림에서 볼 수 있듯이 인터넷은 전세계 수십억의 컴퓨터를 연결해주는 네트워크이다. 그러면 인터넷에서 컴퓨터(노드, 호스트) 끼리의 통신은 어떻게 이루어질까? 출발 노드에 종착 노드까지 어떤 송수신 제어와 원리에 의해 데이터의 전송이 이루어질 것이다. HTTP에 대해 알아보기 전에 기본적으로 인터넷에서의 통신이 이루어지는 프로토콜에 대해서 알아보자.

<br>

---

### 1.2 IP(Internet Protocol)

클라이언에 IP 주소를 ```100.100.100.1``` 그리고 서버에는 ```200.200.200.2```를 부여했다고 가정하자.

<p align="center">   <img src="img/ip1.png" alt="http" style="width: 90%;"> </p>

IP의 역할은 다음과 같다.

* 지정한 IP 주소(IP Address)에 데이터 전달
* 데이터를 전달할 때 패킷(packet)이라는 단위로 전달

<br>

그러면 이 IP 패킷은 어떻게 생긴 것일까?

<p align="center">   <img src="img/packet1.png" alt="http" style="width: 90%;"> </p>

<p align='center'>IP Packet</p>

* 패킷에는 전송 데이터 외에도 출발지 IP, 목적지 IP, 등의 정보를 포함한다
* IP 주소를 바탕으로 노드끼리 패킷을 전달해서 목적 IP에 도착하도록 한다

<br>

<p align="center">   <img src="img/packetsend.png" alt="http" style="width: 90%;"> </p>

* 데이터인 ```Hello, world!```를 서버가 받으면, 성공적으로 받았다는 응답을 다시 보낸다
* 패킷을 전송할 때 클라이언트 → 서버의 경로와 서버 → 클라이언트의 경로를 다를 수 있다

<br>

그림만으로 확인하면 문제가 없어보이지만, 이 IP 주소만을 가지고 컴퓨터 끼리 통신하는 방식에는 한계가 존재한다. 

다음은 IP 프로토콜이 가지는 한계다.

* 비연결성(Connectionless)
  * **패킷이 받을 대상이 없거나 서비스 불능 상태여도 패킷을 전송한다**
* 비신뢰성(Unreliable)
  * IP 프로토콜은 **최선형 전달(Best-Effort Delivery)을 사용**한다
  * **쉽게 말해서, 패킷이 중간에 사라지거나 패킷이 순서대로 전달되지 않을 수 있다**
* 포트(Port) 구분이 불가능하다
  * 같은 IP를 사용하는 서버에서 통신하는 애플리케이션 프로세스가 둘 이상이면 **포트로 구분해야 하지만, IP 프로토콜에서는 불가능하다**

<br>

이런 IP 프로토콜의 한계를 해결하기 위해서 TCP 프로토콜을 사용한다.

<br>

---

### 1.3 TCP(Transmission Control Protocol)

#### 1.3.1 TCP 소개

네트워크 계층을 설명할 때 많은 경우 OSI 7 계층을 설명한다. 그러나 OSI 7 계층의 경우 현실 세계에서 실제로 구현해서 사용한다기 보다는 개념적 모델(conceptual model)에 가깝다. 현실 세계의 인터넷의 경우 TCP/IP 4 계충으로 설명하는 것이 더 알맞은 경우가 많다(여기서 TCP/IP 4 계층도 개념적 모델이다). 관련 내용은 [네트워크 포스트]()에서 자세히 다룰 예정이다.

<br>

<p align="center">   <img src="img/networklayer.webp" alt="http" style="width: 90%;"> </p>

<p align='center'>네트워크 계층의 개념적 모델</p>

* Application Layer(애플리케이션 계층) : HTTP, FTP
* Transport Layer(전송 계층) : TCP, UDP
* Network Layer(인터넷 계층) : IP
* Network Access(Interface) Layer

<br>

다음 그림은 TCP/IP 프로토콜에서 패킷이 전송되는 대략적인 과정이다.

<p align="center">   <img src="img/protocollayer.png" alt="http" style="width: 90%;"> </p>

<p align='center'>TCP/IP Protocol</p>

* 이더넷 프레임은 [네트워크 포스트]()에서 다룰 예정이다
* 그냥 데이터가 어떤식으로 패킷이 담기고 전달되는지 인지하자

<br>

그러면 TCP/IP 패킷은 어떻게 생긴 것일까?

<p align="center">   <img src="img/tcpippacket.png" alt="http" style="width: 80%;"> </p>

<p align='center'>IP Packet + TCP Segment</p>

* TCP/IP 프로토콜에서는 TCP segment를 IP 패킷안에 추가한다
  * ~~데이터와 함께 TCP segment를 encapsulate한다고 표현하는 것 같다~~
* PORT와 관련된 정보. 전송 제어와 순서에 관한 정보, 검증 정보, 등이 들어가서 기존 IP 프로토콜의 한계를 해결한다

<br>

TCP(Transmission Control Protocol, 전송 제어 프로토콜)의 특징은 다음과 같다.

* 연결지향형(connection oriented) - 데이터를 보내기 전에 연결을 위해서 핸드셰이크(handshake)가 필요
  * 3 way handshake(connection establish)
  * 4 way handshake(connection terminate)
* 데이터 전달 보증
* 순서 보장
* TCP 연결은 단일 송신자와 단일 수진사 사이의 점대점(point-to-point) 연결

<br>

---

#### 1.3.2 Three way handshake

TCP Three-way handshake에 대해서 알아보자.

<p align="center">   <img src="img/threeway.png" alt="http" style="width: 90%;"> </p>

<p align='center'>TCP Three way Handshake</p>

1. 연결을 위해서 클라이언트에서 서버로 ```SYN```이라는 메세지를 보낸다
2. 서버가 ```SYN```을 받았으면, 요청 수락이라는 ```ACK``` 메세지와 함께 ```SYN```메세지를 다시 클라이언트로 보낸다
3. 마지막으로 클라이언트는 그러면 요청 수락인 ```ACK```를 서버로 보내고 연결이 성공적으로 이루어진다
   * 보통 이 과정에서 데이터도 함께 전송한다

* 여기서 알아야하는 것은 TCP 3 way handshake은 클라이언트와 서버간 논리적으로 연결되는 것이다. 

<br>

---

#### 1.3.3 데이터 전달 보증, 순서 보장

<br>

<p align="center">   <img src="img/datavalid1.png" alt="http" style="width: 100%;"> </p>

* 클라이언트가 데이터를 전송하면 서버는 데이터를 잘 받았다고 응답 해준다
* 데이터를 보내는 경우 패킷의 순서를 보장해준다
  * 서버에서 패킷의 순서가 잘못되었음을 인지하면 클라이언트는 패킷을 순서에 맞게 다시 보낸다

<br>

이런 것들이 가능한 이유는 TCP/IP 패킷에 전송 제어, 순서, 검증 정보, 등에 대한 정보가 포함되어 있기 때문이다! 이런 요소들이 TCP를 신뢰할 수 있는 프로토콜이라고 부를 수 있도록 해준다.

<br>

---

### 1.4 UDP(User Datagram Protocol)

UDP에 대해 알아보자.

UDP의 특징은 다음과 같다.

* 기능이 거의 없음
* 연결지향(connection oriented) X
* 데이터 전달 보증 X
* 순서 보장 X
* 단순하고 빠름
* IP에 PORT와 체크섬이 추가된 정도
* 애플리케이션 레벨에서 추가 작업을 해서 사용 가능
* 보통 TCP를 많이 사용하지만, 요즘 다시 HTTP3에서 사용되면서 각광 받는중 

<br>

---

### 1.5 PORT

포트에 대해서 알아보자.

클라이언트가 여러 서버들과 통신을 하는 상황이라고 가정해보자. 예를 들어, 같은 IP 내에서 게임, 화상통화, 웹 브라우징을 한다고 해보자.

<p align="center">   <img src="img/port1.png" alt="http" style="width: 90%;"> </p>

<p align='center'>PORT</p>



* 포트(PORT)를 이용해서 같은 IP내의 프로세스를 구분할 수 있다
* 패킷에 출발지 포트와 목적지 포트가 포함되어 있다
* 포트 넘버
  * 0 ~ 65535 : 할당 가능
  * 0 ~ 1023 (Well known PORT) : 잘 알려진 포트, 사용하지 않는 것이 좋다
    * FTP - 20, 21
    * TELNET - 23
    * HTTP - 80
    * HTTPS - 443


<br>

---

### 1.6 DNS(Domain Name System)

DNS에 대해 알아보자.

클라이언트와 서버가 통신을 할 때, 서버의 IP는 고정이 아니라 언제든지 바뀔수 있다. 또한 호스트 네임(도메인 명)을 사용하기 위해서 해당 호스트 네임에 매칭된 IP 주소가 필요하다. 여기서 호스트 네임(hostname)은 ```www.naver.com```, ```www.google.com``` 처럼 문자로 구성된 도메인 명을 말한다.

DNS는 쉽게 말해서 호스트 네임을 IP 주소로 변환해주는 디렉토리 서비스이다(이외에도 여러가지 일을 하지만 여기서 다루지 않겠다).

<p align="center">   <img src="img/dns1.png" alt="http" style="width: 90%;"> </p>

<p align='center'>DNS</p>

* DNS 서버에 도메인과 IP를 등록하면 그냥 호스트네임을 통해서 접속이 가능하다

<br>

---

### 1.7 URI(Uniform Resource Identifier)

URI, URL, URN에 대해 알아보자. 

<p align="center">   <img src="img/uri2.png" alt="http" style="width: 90%;"> </p>

<p align='center'>URI</p>

* URI(Uniform Resource Locater) : 통일된 방식으로 리소스를 구분하는데 필요한 정보
  * 리소스(resource) : URI로 식별할 수 있는 모든 것
* URL, URN은 URI에 포함된다
* URL(Locater) : 리소스가 있는 위치를 지정
* URN(Name) : 리소스에 이름을 부여
  * URN 이름만으로 실제 리소스를 찾는 방법은 보편화 되진 않았음

<br>

그러면 URL의 형식을 한번 살펴보자.

> ```scheme://[userinfo@]host[:port][/path][?query][#fragement]```

* 예시 : ```https://www.google.com:443/search?q=hello&hl=ko```

* protocol : ```https```
  * 프로토콜은 어떤 방식으로 자원에 접근할 것인가 하는 약속, 규칙
  * 예) http, https, ftp..
* userinfo
  * URL에 사용자 정보를 포함해서 인증
  * 거의 사용하지 않음
* hostname : ```www.google.com```
  * 도메인명 또는 IP 주소를 직접 사용가능
* port number : ```443```
  * 접속 포트
  * http는 80, https는 443으로 생략 가능
* path : ```/search```
  * 리소스가 위치한 경로, 계층적 구조
  * 예) ```/home/file1.png```, ```members/1004```
* query string : ```q=hello&hl=ko```
  * key=value 형태
  * 웹서버에 제공하는 파라미터
  * ?로 시작하고, &로 추가 가능
* fragment
  * html 내부 북마크 등에 사용한다
  * 예) 깃헙의 마크다운 목차
  * 서버에 전송하는 정보는 아님

<br>

---

### 1.8 웹에서의 요청의 흐름

웹 브라우저에서 요청을 보낼 때, 해당 요청의 흐름에 대해서 알아보자.

https://www.google.com/search?q=hello&hl=ko를 웹 브라우저에 입력해서 접속할때 일어나는 요청의 흐름을 살펴보자.

<p align="center">   <img src="img/request1.png" alt="http" style="width: 100%;"> </p>

1. HTTP 요청 메세지 생성
   * ```GET /search?q=hello&hl=ko HTTP/1.1```
   * ```Host: www.google.com```
   * 기타 내용
2. HTTP 요청 메세지를 소켓 라이브러리를 통해 전달하고 생성된 TCP/IP 패킷에 HTTP 메세지를 포함한다
3. 요청 패킷을 목적지(구글 서버)로 전달
4. 요청 패킷을 받고 해석 후, 서버(구글 서버)에서 응답 메세지를 생성하고 응답 패킷에 담는다
   * ```HTTP/1.1 200 OK```
   * ```Content-Type: text/html;charset=UTF-8```
   * ```Content-Length: 3423```
   * 기타 내용
   * 응답 내용 : HTML, 등..
5. 응답 패킷을 클라이언트 한테 전달
6. 클라이언트(웹브라우저)에서 받은 내용(이 경우에는 HTML)을 렌더링

<br>

<p align="center">   <img src="img/httpmessage1.png" alt="http" style="width: 90%;"> </p>

<p align='center'>HTTP 메세지 전송</p>

<br>

---

## 2) HTTP

### 2.1 HTTP 소개

HTTP(HyperText Transfer Protocol)에 대해 알아보자.

요즘 대부분의 통신은 HTTP를 통해서 이루어진다.

* HTML, text
* 이미지, 음성, 영상 파일
* **JSON, XML (API)**
* 거의 모든 형태의 데이터 전송 가능
* 서버간 데이터를 주고 받을 때도 많은 경우 HTTP 사용
* TCP를 직접 이용해서 연결하는 경우는 게임서버와 같은 특수한 경우

<br>

현재 대부분 HTTP/1.1을 사용한다

* HTTP/1.0 이하
* HTTP/1.1
  * 가장 많이 사용
  * 기반 프로토콜 : TCP
* HTTP/2
  * 성능 개선
  * 기반 프로토콜 : TCP
* HTTP/3
  * 성능 개선
  * 기반 프로토콜 : UDP

<br>

HTTP의 특징은 다음과 같다.

* 클라이언트-서버 구조
* Stateless protocol(무상태 프로토콜)
* 비연결성(connectionless)
* HTTP 메세지를 이용해서 통신
* 단순하고 확장 가능

<br>

---

### 2.2 Client - Server

HTTP는 기본적으로 클라이언트-서버 구조를 따른다.

* request response (요청-응답) 구조
* 클라이언트는 서버에 요청을 보내고 응답을 대기한다
* 서버는 받은 요청에 대한 결과를 만들어서 응답을 보낸다
* 비즈니스 로직은 오로지 서버만 다룬다

<br>

---

### 2.3 Stateless

HTTP는 무상태(stateless) 프로토콜을 지향한다. Stateless(무상태)와 Stateful(상태유지)에 대해서 알아보자.

Stateless라는 것은 다음과 같다.

* **서버가 클라이언트의 상태를 보존하지 않는다**
* 장점 : 서버의 확장성이 높다(scale-out)
* 단점 : 클라이언트가 추가 데이터를 전송해야 한다

<br>

Stateless와 Stateful에 대해 예시를 이용해서 알아보자.

고객이 마트에 가서 노트북을 구매하는 상황이라고 가정하자.

1. 
   * 고객 : 이 **품목 : 노트북** 얼마인가요?
   * 점원A : 100만원 입니다. (**품목: 노트북 상태유지**)
2. 
   * 고객 : **수량 : 2개**를 구매하겠습니다.
   * 점원A : 200만원 입니다. **수단 : 신용카드, 현금**중 어느 걸로 구매 하시겠어요?(**품목 : 노트북, 수량 : 2개 상태 유지**)
3. 
   * 고객 : **수단 : 신용카드**로 구매하겠습니다.
   * 점원A : 200만원 결제 완료되었습니다. (**품목 : 노트북, 수량 : 2개, 수단 : 신용카드 상태 유지**)

<br>

위의 예시에서 볼 수 있듯이 점원은 고객과의 대화에서 이전 대화의 문맥(context)을 알고 있다. 이것이 상태유자(stateful)이다.

다음은 무상태(stateless)에 대한 예시이다.

<br>

1. 
   * 고객 : 이 **품목 : 노트북** 얼마인가요?
   * 점원A : 100만원 입니다.
2. 
   * 고객 : **품목 : 노트북**을 **수량 : 2개** 구매하겠습니다.
   * 점원B : 200만원 입니다. **수단 : 신용카드, 현금**중 어느 걸로 구매 하시겠어요?
3. 
   * 고객 : **품목 : 노트북** **수량 : 2개**를 **수단 : 신용카드**로 구매하겠습니다.
   * 점원C : 200만원 결제 완료되었습니다.

<br>

무상태의 경우 이전 상황에 대한 문맥을 유지하지 않는다. 점원이 계속 바뀌는 상황이라고 볼 수 있다. 점원끼리 서로 내용을 공유하지 않는 이상 고객이 이전 점원과 했던 내용을 알수 없다. 그래서 고객은 새로운 점원을 만날때 마다 이전의 내용(context)를 전부 포함해서 구매를 진행하고 있다. 

<br>

그러면 상태유지에서 점원이 바뀌면 어떻게 될까? 점원은 당연히 이전의 대화 내용을 모르기 때문에 구매의 진행이 불가능 하다. 반면에 stateless에서는 고객이 점원이 바뀔때 마다 필요한 정보를 다 주기 때문에 구매의 진행이 가능하다.

<br>

정리하자면 다음과 같다.

* **Stateful(상태 유지)** : 중간에 다른 점원으로 바뀌면 안된다
  * 만약에 바뀐다면 해당 대화 내용(상태 정보, context)를 다음 점원에게 미리 알려줘야 한다
* **Stateless(무상태)** : 중간에 다른 점원으로 바뀌어도 OK
  * 이런 경우의 장점은 갑자기 고객이 증가해도 새로운 점원들을 대거 투입 가능하다
  * → 갑자기 클라이언트 요청이 증가해도 서버를 대거 투입 가능하다
  * 쉽게 말해서 무상태에서는 응답 서버를 쉽게 바꾸는 것이 가능하다 → 서버 증설이 쉽다

<br>

<p align="center">   <img src="img/stateless1.png" alt="http" style="width: 90%;"> </p>

<p align='center'>Stateless</p>

<br>

이렇게 좋아보이는 stateless도 한계가 존재한다.

* 무상태로 설계가 불가능한 경우도 존재한다
* 무상태(stateless)
  * 예) 로그인이 필요 없는 단순한 서비스 소개 화면
  * 무상태의 단점은 상태 유지에 비해서 데이터를 너무 많이 보내야하는 경우들이 발생한다
* 상태유지(stateful)
  * 예) 로그인
* 로그인한 사용자의 경우 로그인 했다는 상태를 서버에 유지

<br>

일반적으로 상태유지가 필요한 경우 브라우저 쿠기, 서버 세션, 등을 사용해서 상태 유지를 한다. 상태 유지는 최소한만 사용하는 것이 좋다.

<br>

---

### 2.4 Connectionless

비연결성(connectionless)에 대해서 알아보자.

만약 클라이언트와 서버가 연결을 계속 유지하는 모델이면 어떤 일이 일어날까? 클라이언트 1,2,3이 서버와 연결한 상황이라고 가정하자.

<p align="center">   <img src="img/connection1.png" alt="http" style="width: 90%;"> </p>

<p align='center'>연결 유지</p>

* 서버가 계속 연결을 유지하기 때문에 서버는 자원을 지속적으로 소모한다

<br>

그럼 클라이언트와 서버가 연결을 유지하지 않는 모델은 어떨까?

<p align="center">   <img src="img/connectionless3.png" alt="http" style="width: 87%;"> </p>

<p align='center'>Connectionless</p>

* HTTP는 기본이 연결을 유지하지 않는 모델이다
* 일반적으로 초 단위 이하의 빠른 속도로 응답
* 예) 1시간 동안 수천명이 서비스를 사용해도 실제 서버에서 동시에 처리하는 요청은 수십개 이하로 적다
  * 이유 : 사용자가 웹 브라우저에서 계속 연속해서 검색 버튼을 누리지는 않는다
* 서버 자원을 연결 유지에 비해서 효율적으로 사용할 수 있다

<br>

이런 비연결성(connectionless) 방식도 한계가 존재한다.

* TCP/IP 연결을 새로 맺어야 한다 (three way handshake에 대한 시간 추가)
* 웹 브라우저로 사이트를 요청하면 HTML 뿐만 아니라 Js, css, 추가 이미지 등 수 많은 자원이 함께 다운로드된다

<br>

이런 단점을 극복하기 위해서 지금은 HTTP **지속 연결(persistent connection)로 문제를 해결**하고 있다. 

이런 HTTP의 커넥션 관리에 대해서 조금 더 자세히 알아보자.

<br>

<p align="center">   <img src="img/persistent1.png" alt="http" style="width: 90%;"> </p>

<p align='center'>HTTP 커넥션 관리</p>

* 초기의 HTTP는 단기 커넥션(short-lived connection)을 이용했다 
  * 각각의 HTTP 요청이 직렬화(serialized)된 형태로 연결과 종료를 맺는다
    * 쉽게 말해서, 요청이 생길때 마다 TCP handshake를 이용해서 연결을 맺고 종료하는 것을 반복 했음
  * 이는 매우 비효율적이다
  * HTTP 1.0 에서 쓰던 방식
* **현재 HTTP는 지속 연결(persistent connection)을 이용한다**
  * 특정 시간 동안 연결을 유지해서 새로운 handshake를 할 필요 없이 요청과 응답이 진행된다
    * 특정 시간은 내부 메커니즘 마다 다름
  * HTTP 2,3 은 이를 더 효율적으로 개선 했음
    * HTTP pipelining, multiplexing 

<br>

---

### 2.5 HTTP Message

이전에도 봤던 HTTP 요청 메세지와 응답 메세지에 대해서 알아보자.

<p align="center">   <img src="img/msg1.png" alt="http" style="width: 100%;"> </p>

<p align='center'>요청과 응답 메세지의 구조</p>

* 요청 메세지도 body 본문을 가질 수 있음

<br>

HTTP 메세지의 공식 스펙은 다음과 같다. (rfc7230)

```
HTTP-message = start-line
							 *( header-field CRLF)
							 CRLF
							 [ message-body ]
```

<br>

HTTP 메세지의 구성 요소를 더 자세히 살펴보자.

```
GET /search?q=hello&hl=ko HTTP/1.1
Host: www.google.com

```

<br>

* **요청 시작 라인(start-line)**
  * ```start-line = request-line / status-line```
  * 요청 메세지의 경우 ```request-line```
  *  ```request-line = method 공백 request-target 공백 HTTP-version CRLF```
  * HTTP 메서드(뒤의 [HTTP Method]() 섹션에서 더 자세히 알아볼 예정)
    * GET, POST, PUT, DELETE...
    * 서버가 수행해야 할 동작을 지정한다
      * GET : 리소스 조회
      * POST : 요청 내역 처리
  * 요청 대상(request-target)
    * ```절대경로[?query]```
    * ```/```로 시작하는 경로
  * HTTP Version
    * 많은 경우 HTTP 1.1

<br>

```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
Content-Length: 3423

<html>
	<body>...</body>
</html>
```

<br>

* **응답 시작 라인**
  * 응답 메세지의 경우 ```status-line```
  * ```status-line = HTTP-version 공백 status-code 공백 reason-phrase CRLF```
  * HTTP version
  * HTTP 상태코드(status-code) : 요청 성공, 실패 등의 상태를 나타냄
    * 200 : 성공
    * 400 : 클라이언트 요청 오류
    * 500 : 서버 내부 오류
  * 이유 문구(reason phrase)
    * 짧은 상태 코드 설명 글
    * 예) 200 OK → OK는 대충 성공이라는 뜻

<br>

* **HTTP 헤더**
  * ```header-field = field-name : OWS field-value OWS```
    * OWS(optional whitespace) : 띄어쓰기 허용
  * HTTP 헤더의 용도는 HTTP 전송에 필요한 모든 부가정보를 제공하기 위함
    * 예) 메세지 바디의 내용, 크기, 압축, 인증, 요청 클라이언트 정보, 캐시 관리 정보, 등...
  * 필요시 임의의 헤더 추가 가능
  * 뒤의 [HTTP Header]() 섹션에서 더 자세히 다룰 예정

<br>

* **HTTP 메세지 바디**
  * 실제 전송할 데이터가 들어감
  * 예) HTML, 이미지, 영상, JSON 등.. byte로 표현할 수 있는 모든 데이터를 전송 가능

<br>

---

## 3) HTTP Method

### 3.1 HTTP API 설계 소개

HTTP API를 설계 해보면서 HTTP 메서드에 대해 알아보자.

회원 정보 관리 API를 설계한다고 해보자. 요구 사항은 다음과 같을때, 해당 요구 사항에 맞게 이름을 한번 지어보자.

* 회원 목록 조회 /read-member-list
* 회원 조회 /read-member-by-id
* 회원 등록 /create-member
* 회원 수정 /update-member
* 회원 삭제 /delete-member

<br>

위와 같이 URI를 설계하는 것은 좋은 설계일까? **URI를 설계할 때 가장 중요한것은 리소스(resource)의 식별**이다. 리소스의 의미에 대해 생각해보자.

* 리소스의 의미
  * 회원 등록, 수정, 조회하는 것이 리소스가 아니다
  * 회원이라는 개념 자체가 리소스이다

<br>

그러면 이런 리소스를 어떻게 식별하는 것이 좋을까?

* 등록, 수정, 조회하는 것을 모두 배제한다
* 회원이라는 리소스만 식별 → **회원 리소스 자체를 URI에 매핑한다**

<br>

그러면 일단 URI에 적용해보자.

* 회원 목록 조회 /members
* 회원 조회 /members/{id}
* 회원 등록 /members/{id}
* 회원 수정 /members/{id}
* 회원 삭제 /members/{id}

<br>

이때 많은 경우 난감할 것이다. 왜냐하면 회원 조회, 등록, 수정, 삭제를 구분할 수 없기 때문이다. 여기서 HTTP 메서드가 중요한 역할을 한다.

* **URI로 리소스만 식별한다**
* 리소스와 해당 리소스를 사용하는 행위를 분리 해야한다
  * 리소스 : 회원(members)
  * 행위 : 조회, 등록, 수정, 삭제
* **이 행위를 HTTP 메서드를 이용해서 구분하는 것이다!**

<br>

> 리소스라고 사용은 했지만, 최근에는 Representation이라는 표현을 사용한다.
>
> REST API → Representational State Transfer API

<br>

---

### 3.2 GET, POST

* ```GET``` : 리소를 조회
* ```POST``` : 요청 데이터 처리, 주로 등록에 사용

```PUT```, ```PATCH```. ```DELETE```은 뒤에서 더 자세히 알아볼 예정. 

<br>

#### 3.2.1 GET

* 리소스 조회
* 서버에 전달하고 싶은 데이터는 쿼리(query string)를 통해서 전달
* 메세지 바디를 이용해서 데이터를 전달할 수 있지만, 권장하지 않는다 (쉽게 말해서 GET 요청은 페이로드를 담지 말아라)

<br>

<p align="center">   <img src="img/get1.png" alt="http" style="width: 90%;"> </p>

<p align='center'>GET 요청</p>

<br>

---

#### 3.2.2 POST

* 요청 데이터 처리
* 메세지 바디를 통해 서버로 요청 데이터 전달
* 서버는 요청 데이터를 처리
  * 메세지 바디를 통해 들어온 데이터를 처리하는 모든 기능을 수행한다
* 주로 전달된 데이터로 신규 리소스 등록, 프로세스 처리에 사용한다
  * 예) 회원 가입에 필요한 데이터 전달 → 서버는 받은 데이터로 회원 가입을 처리(수행)
* 신규 리소스의 식별자는 서버가 생성한다
  * 예) ```/members``` → ```/members/100``` : 100이라는 식별자는 서버에서 부여한다
  

<br>

<p align="center">   <img src="img/post2.png" alt="http" style="width: 90%;"> </p>

<p align='center'>POST 요청</p>

<br>

```POST```의 요청 데이터를 처리한다는 것은 정확히 어떤 뜻일까?

* POST specification(스펙) 

  * > The ```POST``` method requests that the [target resource](https://www.rfc-editor.org/rfc/rfc9110#target.resource) process the representation enclosed in the request according to the resource's own specific semantics. (rfc9110)

  * ```POST``` 메서드는 대상 리소스(representation)가 리소스 고유한 의미 체계에 따라 요청에 포함 된 표현을 처리하도록 요청한다 

<br>

예를 들자면 다음과 같은 기능에 사용한다.

* Providing a block of data, such as the fields entered into an HTML form, to a data-handling process;
  * HTML 폼에 입력 된 필드와 같은 데이터 블록을 데이터 처리 프로세스에 제공
  * 예) HTML form에 입력한 정보로 회원 가입, 주문 등에 사용
* Posting a message to a bulletin board, newsgroup, mailing list, blog, or similar group of articles;
  * 게시판, 뉴스, 메일링 리스트, 블로그 또는 유사한 뉴스 그룹에 메세지 게시
  * 예) 게시판 글쓰기, 댓글 달기
* Creating a new resource that has yet to be identified by the origin server;
  * 서버가 아직 식별하지 않은 새 리소스 생성
  * 예) 신규 주문 생성
* Appending data to a resource's existing representation(s).
  * 기존 자원에 데이터 추가
  * 예) 한 문서 끝에 내용 추가하기

<br>

결론적으로 리소스 URI에 POST 요청이 오면 요청 데이터를 어떻게 처리할지 리소스 마다 정해야 한다.

POST를 사용하는 경우를 정리해보면 다음과 같다.

* 새 리소스 등록(생성)
* 요청 데이터를 처리
  * 단순히 데이터를 생성, 변경하는 것을 넘어서 **특정 프로세스를 처리해야 하는 경우**
    * 예) 주문 : 결제완료 → 배달시작 → 배달완료 처럼 단순히 값 변경을 넘어 프로세스의 상태가 변경되는 경우
  * POST의 결과로 새 리소스가 생성되지 않을 수도 있음
    * 어쩔 수 없이 리소스만으로 설계가 안되기 때문에 행위를 포함해서 URI를 설계하는 경우도 있다
    * 예) ```POST /orders/{orderId}/start-delivery``` **(컨트롤 URI)**
* 다른 메서드로 처리하기 애매한 경우
  * 예) JSON으로 조회 데이터를 넘겨야 하는데 GET 메서드를 사용하기 어려운 경우
  * 웬만해서 애매하면 POST 사용하면 됨

<br>

---

### 3.3 PUT, PATCH, DELETE

* ```PUT``` : 리소스를 대체, 해당 리소스가 없다면 생성
* ```PATCH``` : 리소소를 부분 변경
* ```DELETE``` : 리소스 삭제

이외에도 ```HEAD```, ```OPTIONS```, ```CONNECT```, ```TRACE``` 등의 HTTP 메서드도 존재한다.

<br>

조금 더 자세히 알아보자.

1. ```PUT```
   * 리소스를 대체
     * 리소스가 존재하면 완전히 대체
       * 기존의 것을 완전히 지우고 생성
     * 리소스가 없으면 생성
     * 덮어버린다고 생각하면 쉬움
     * 예) ```PUT /members/100``` 으로 요청을 넣는 경우 존재하면 완전히 대체하고, 없다면 새로 생성한다
   * **클라이언트가 리소스를 식별한다**
     * 클라이언트가 리소스 위치를 알고 URI 지정한다
     * ```POST```에서는 리소스 위치를 몰라도 됨
2. ```PATCH```
   * 리소스 부분 변경
   * ```PUT```과는 다르게 리소스의 필드를 부분적으로 변경할 수 있다
   * ```PATCH```를 지원하지 않는 서버의 경우 그냥 ```POST```를 사용하면 됨
3. ```DELETE```
   * 리소스 제거

<br>

---

### 3.4 HTTP 메서드의 속성

HTTP 메서드의 속성에 대해서 알아보자.

<p align="center">   <img src="img/attribute1.png" alt="http" style="width: 90%;"> </p>

<p align='center'>https://ko.wikipedia.org/wiki/HTTP</p>

<br>

---

#### 3.4.1 안전(Safe)

* HTTP 메서드가 서버의 상태를 변경하지 않으면 그 메서드는 안전하다
* 쉽게 말해서, 호출해도 리소스를 변경하지 않으면 안전하다
  * ```GET```은 안전함
  * ```POST```, ```PUT```, ```PATCH```, ```DELETE``` 같은 메서드는 안전하지 않음
* 안전하다는 것은 멱등성(Idempotency)을 보장하지만, 그 반대는 아니다

<br>

---

#### 3.4.2 멱등성(Idempotency)

* 동일한 요청을 한 번 보내는 것과 여러 번 연속으로 보내는 것이 같은 효과를 지니고, 서버의 상태도 동일하게 남을 때, 해당 HTTP 메서드는 멱등(Idempotent)하다
* **쉽게 말해서 한 번 호출하든, 100번 호출하든 결과가 똑같아야 멱등하다**고 할 수 있다
* 멱등 메서드는 통계기록을 제외하면 어떠한 부수효과(side-effect)를 가져선 안된다
* **멱등은 외부 요인으로 인해 중간에 리소스가 변경되는 것 까지 고려하지는 않는다**
  * 예) 잔액을 조회했을 때 10000원 조회 → 다른 사람이 10000원 이체 → 다시 조회하면 20000원
* 멱등 메서드
  * ```GET``` : 한 번 조회하든, 100번 조회하든 같은 결과가 조회된다
  * ```PUT``` : 결과를 대체한다. 같은 요청을 여러번 해도 최종 결과는 똑같다
  * ```DELETE``` : 결과를 삭제한다. 같은 요청을 여러 번 해도 삭제된다는 결과는 똑같다
* 멱등하지 않은 메서드
  * ```POST``` : 두 번 호출하면 같은 결제가 중복해서 발생할 수 있다.

<br>

---

#### 3.4.3 캐시 가능(Cacheable)

* 한 응답은 캐시할 수 있는 HTTP 응답으로, 나중에 검색하고 사용하기 위해 저장하여 새 요청을 서버에 저장한다
  * 모든 HTTP 응답을 캐시할 수 있는 것은 아니다
* **쉽게 말해서 응답 결과 리소를 캐시해서 사용해도 되는지에 대한 여부이다**
  * 예) 이미지를 요청 → 다시 요청하는 것은 비효율적이기 때문에 브라우저에서 이미지 저장(캐시)해서 사용
* ```GET```, ```HEAD```, ```POST```, ```PATCH``` 캐시 가능
* **실제로는** ```GET```, ```HEAD``` **정도만 캐시로 사용한다**
  * 캐시를 사용하기 위해서 
  * ```POST```, ```PATCH```는 본문 내용까지 캐시 키로 고려해야한다 → 구현이 쉽지 않다다
* 캐시에 대한 것은 뒤의 HTTP 헤더의 [캐시 섹션]()에서 더 자세히 다룰 예정

<br>

---

### 3.5 HTTP 메서드의 활용

HTTP 메서드는 어떤식으로 활용되는지, 다음의 경우에 대해서 알아보자.

* 클라이언트에서 서버로 데이터 전송
* HTTP API 설계

<br>

---

#### 3.5.1 클라이언트 → 서버 데이터 전송

데이터 전달 방식을 크게 2가지로 나눌 수 있다.

* 쿼리를 통한 데이터 전송
  * ```GET```
  * 주로 정렬 필터(검색어)
* 메세지 바디를 통한 데이터 전송
  * ```POST```, ```PUT```, ```PATCH```
  * 리소스 등록, 리소스 변경
    * 예) 회원 가입, 상품 주문

<br>

그러면 클라이언트에서 서버로 데이터 전송을 하는 몇가지 상황에 대해서 알아보자.

1. **정적 데이터 조회**
   * 이미지, 정적 텍스트(문서) 같은 데이터를 조회하는 경우
   * 쿼리 파라미터 미사용
   * ```GET /static/star.jpg HTTP1.1```
   * 단순히 URI 경로만으로 조회가 가능하다

<br>

2. **동적 데이터 조회**
   * 검색, 게시판 목록에서 정렬 필터
   * ```GET /search?q=hello&hl=ko HTTP1.1```
   * 쿼리 파라미터 사용(쿼리를 통해 데이터를 전달)

<br>

3. **HTML Form을 통한 데이터 전송**
   * 회원 가입, 상품 주문, 데이터 변경
   * 폼에 데이터를 입력해서 전송하면```Content-Type: application/x-www-form-urlencoded```으로 보낸다
   * 데이터를 쿼리 스트링과 유사하게 서버에 전송함
   * 전송 데이터를 url encoding 처리
   * ```GET```을 이용할 수는 있지만, ```GET```을 사용하면 쿼리로 바꿔서 보냄
   * 주의 : ```GET```은 조회할 때만 사용하자!
   * 파일 전송할 때 ```Content-Type: multipart/form-data``` 사용
     * 파일 업로드와 같은 바이너리 데이터 전송시 사용한다
     * 다른 종류의 여러 파일과 폼의 내용을 함께 전송 가능하다
   * HTML Form 전송은 ```GET```, ```POST```만 지원한다

<br>

4. **HTTP API를 통한 데이터 전송**
   * 회원 가입, 상품 주문, 데이터 변경
   * server-to-server, 앱 클라이언트, 웹 클라이언트(AJAX)
   * 만약 JSON으로 데이터를 넘기고 싶으면
     * ```Content-Type: application/json```으로 넘기면 됨
     * JSON 데이터 전송
   * 서버-to-서버 (백엔드 시스템 통신)
   * 앱 클라이언트 (아이폰, 안드로이드)
   * 웹 클라이언트
     * HTML에서 폼 전송 대신 자바 스크립트를 통한 통신에 사용 (AJAX)
     * 예) React와 같은 웹 클라이언트와 API 통신
     * ```POST```, ```PUT```, ```PATCH``` : 메세지 바디를 통해 데이터 전송
     * ```GET``` : 조회, 쿼리로 데이터 전달
     * ```Content-Type: application/json``` 을 사실상 표준(Defacto)으로 사용

<br>

---

#### 3.5.2 HTTP API 설계

HTTP API 설계 예시를 통해 HTTP 메서드 활용을 알아보자.

이전의 [HHTP API 설계 소개]()에서 사용한 예시를 그대로 사용해보자. 회원 관리 시스템의 API를 설계하는 것이다.

* 회원 목록 조회 /members → ```GET```
* 회원 조회 /members/{id} → ```GET```
* 회원 등록 /members/{id} → ```POST```
* 회원 수정 /members/{id} → ```PATCH, PUT, POST``` 
  * 어떤 메서드를 사용할 것인지 고민해야 한다
  * 회원 수정의 경우 ```PATCH```를 사용하는 것이 베스트
  * 애매하면 ```POST```
* 회원 삭제 /members/{id} → ```DELETE```

<br>

리소스를 식별하고 행위는 HTTP 메서드를 통해서 구분한다!

<br>

---

##### 3.5.2.1 POST - 신규 자원 등록

```POST```를 이용한 신규 자원 등록의 특징은 다음과 같다.

* 클라이언트는 등록될 리소스의 URI를 모른다

  * 회원 등록 ```/members``` 에서 ```POST``` 메서드 사용
  * ```POST /members``` (클라이언트에서 어떤 식별자를 부여하는 것이 아님)

* 서버가 새로 등록된 리소스 URI를 생성해준다

  * ```
    HTTP/1.1 201 Created 
    Location: /members/100
    ```

  * 서버에서 식별자 ```100```을 부여

* Collection

  * 서버가 관리하는 리소스 디렉토리
  * 서버가 리소스의 URI를 생성하고 관리한다
  * 예) ```/members```가 컬렉션에 해당

<br>

---

##### 3.5.2.2 PUT - 신규 자원 등록

```PUT``` 기반의 등록을 살펴보자. 여기서는 파일 관리 시스템의 API를 설계한다고 가정해보자.

* 파일 목록 /files → ```GET```
* 파일 조회 /files/{filename} → ```GET```
* 파일 등록 /files/{filename} → ```PUT```
* 파일 삭제 /files/{filename} → ```DELETE```
* 파일 대량 등록 /files → ```POST```

<br>

이 경우에는 파일을 등록할 때 ```PUT```을 사용한다. ```PUT```의 특징은 기존 리소스를 완전히 대체한다는 것이다. 파일 업로드의 경우 기존 파일을 지우고 다시 업로드하기 때문에 ```PUT```이 알맞다.

```PUT```를 이용한 신규 자원 등록의 특징은 다음과 같다.

* 클라이언트가 리소스 URI를 알고 있어야 한다.
  * 파일 등록 /files/{filename} → ```PUT```
  * ```PUT /files/star.jpg```
* 클라이언트가 직접 리소스의 URI를 지정한다
* Store
  * 클라이언트가 관리하는 리소스 저장소
  * 클라이언트가 리소스의 URI를 알고 관리
  * 예) ```/files```가 스토어 해당

<br>

> 대부분의 경우에는 ```POST``` 기반을 사용한다.

<br>

---

##### 3.5.2.3 HTML Form 사용

* ```GET, POST```만 지원
  * 제약이 있음
* AJAX 같은 기술을 사용해서 해결은 가능
* 현재의 예시에서는 순수히 HTML Form만 사용하는 경우를 다룬다

<br>

그러면 회원 등록에서 HTML 폼을 사용하는 경우의 API 설계를 한다고 가정해보자.

* 회원 목록 /members → ```GET```
* 회원 조회 /members/{id} → ```GET```
* 회원 등록 폼 /members/new → ```GET``` (폼을 가져오는 경우)
* 회원 등록 /members/new → ```POST``` (실제로 등록하는 경우)
* 회원 수정 폼 /members/{id}/edit → ```GET```
* 회원 수정 /members/{id}/edit → ```POST```
* 회원 삭제 /members/{id}/delete → ```POST```

<br>

위의 예시에서 볼 수 있듯이 HTML Form은 ```GET, POST```만 사용 가능하기 때문에 제약이 있다. 이런 제약을 해결하기 위해서 **컨트롤 URI를 사용**한다. 

*  **컨트롤 URI**(Control URI)
  * ```POST```의 ```/new, /edit, /delete```
  * 동사로 된 리소스 경로를 사용하는 것
  * HTTP 메서드로 해결하기 어렵거나 애매한 경우에 사용한다(HTTP API 포함)

<br>

> 참고하면 좋은 URI 설계 개념 : [https://restfulapi.net/resource-naming/](https://restfulapi.net/resource-naming/)

---

## 4) HTTP Status Code

HTTP 상태 코드에 대해서 알아보자.

<br>

---

### 4.1 1xx, 2xx(Successful)

* **1xx(Informational)**
  * 요청이 수신되어 처리중
  * 거의 사용 안함

<br>

* **2xx(Successful)**

  * **요청을 정상 처리**

  * 200 OK 
    * 요청 성공 

  * 201 Created 
    * 요청 성공해서 새로운 리소스가 생성됨
    * 응답 메세지의 Location 필드에 생성된 리소스의 URI

  * 202 Accepted
    * 요청이 접수되었으나 처리가 완료되지 않음

  * 204 No Content
    * 요청을 성공적으로 수행했지만, 응답 페이로드 본문에 보낼 데이터가 없음
    * 예) 웹 문서 편집기의 save 버튼, save 버튼의 결과로 아무 내용이 없어도 된다

<br>

---

### 4.2 3xx(Redirection)

* **3xx(Redirection)**

  * 요청을 완료하기 위해 에이전트의 추가 행동(조치)이 필요하다

  * 웹 브라우저는 3xx 응답 결과에 ```Location```헤더가 있으면, ```Location```에 주어진 URL로 이동한다(Redirect) 

  * 300 Multiple Choices
    * 거의 사용하지 않음
  * **304 Not Modified**
    * **요청된 리소스를 재전송할 필요가 없음을 나타낸다. 캐시된 자원으로의 암묵적인 리다이렉션**
      * 쉽게 말해서 클라이언트에게 리소스가 수정되지 않았음을 알려준다
      * 클라이언트는 로컬 PC에 저장된 캐시를 재사용 (캐시로 리다이렉트)
    * 응답에 메세지 바디를 포함하면 안된다 (로컬 캐시를 사용해야함)
    * 조건부 ```GET, HEAD``` 요청시 사용

<br>

---

#### 4.2.1 **3xx - Permanent Redirection(영구 리다이렉션)**

* **리다이렉션 상태 응답 코드는 요청한 리소스가 [`Location`](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Location) 헤더에 주어진 URI로 완전히 옮겨졌다는 것을 나타낸다**
  * 쉽게 말해서 리소스의 URI가 영구적으로 이동
* 예) ```/event``` → ```/new-event```
* 원래의 URL을 사용하지 않는다
* 검색 엔진에서도 변경을 인지
* **301 Moved Permanently**
  * 브라우저는 ```Location```에서 주어진 URI로 리다이렉트한다
  * 리다이렉트시 요청 메서드가 ```GET```으로 변한고, 본문이 제거될 수 있음
* **308 Permanent Redirect**
  * 301과 기능은 같지만, 리다이렉트시 요청 메서드와 본문을 유지한다
  * 웬만하면 이렇게 사용하지 않음, 그냥 요청을```GET```으로 돌리는 경우가 대부분
* 영구 리다이렉션 보다는 일시적 리다이렉션을 더 많이 사용

<br>

---

#### 4.2.2 **3xx - Temporary Redirection(일시적 리다이렉션)**

* **요청한 리소스가 `Location` 헤더에 주어진 URI로 임시로 옮겨졌다는 것을 나타낸다**
  * 쉽게 말해서 리소스의 URI가 일시적으로 변경됨
* 검색 엔진은 리소스에 대한 링크를 업데이트하지 않는다
  * 쉽게 말해서 검색 엔진 등에서 URL을 변경하면 안됨 
* **302 Found**
  * 요청한 리소스가 `Location` 헤더에 주어진 URI로 임시로 옮겨짐
  * 리다이렉트시 요청 메서드가 ```GET```으로 변하고, 본문이 제거될 수 있다
  * 보통 302를 많이 사용
* **303 See Other**
  * 302와 기능은 같음
  * 리디렉션이 요청한 리소스 자체에 연결되지 않고 다른 페이지에 연결됨을 나타낸다
  * 리다이렉트시 요청 메서드가 ```GET```으로 변경된다
* **307 Temporary Redirect**
  * 302와 기능은 같음
  * 리다이렉트시 요청 메서드와 본문을 유지한다(요청 메서드를 변경하면 안된다)
* **일시적 리다이렉트를 사용하는 상황**
  * POST/REDIRECT/GET (PRG)
  * 문제 : ```POST```로 주문후에 웹 브라우저 새로고침하는 경우 → 새로고침은 다시 요청 → 중복 주문이 발생할 수 있다
  * 해결 : ```POST``` 주문후에 주문 결과를 ```GET``` 메서드로 리다이렉트 하도록 한다 → 새로고침을 해도 결과 화면을 ```GET```으로 조회

<br>

---

### 4.3 4xx (Client Error), 5xx (Server Error)

* **4xx (Client Error)**
  * 클라이언트 오류, 잘못된 문법, 등으로 서버가 요청을 수행할 수 없음
  * **오류의 원인은 클라이언트에 있음!**
  * 쉽게 말해서 클라이언트가 이미 잘못된 요청, 데이터를 보내고 있기 때문에, 백날 재시도 해봤자 똑같이 실패함
  * **400 Bad Request**
    * 클라이언트가 잘못된 요청을 해서 서버가 요청을 처리할 수 없음
    * 요청 구문, 메세지 등의 오류
    * **클라이언트는 요청 내용을 재검토하고 보내야한다**
    * 예) 요청 파라미터 잘못, 잘못된 API 스펙
  * **401 Unauthorized**
    * 인증(Authentication)이 없음
    * 응답에 ```WWW-Authenticate```헤더와 함께 인증 방법을 설명
      * Authentication : 본인이 누구인지 확인 (로그인)
      * Authorization : 권한 부여 (ADMIN 권한 처럼 특정 리소스에 접근할 수 있는 권한, 인증이 있어야 인가 가능)
  * **403 Forbidden**
    * 인증 자격은 있지만 접근 권한이 불충분한 경우
    * 예) 사용자 권한으로 로그인 → 어드민 등급 리소스에 접근
  * **404 Not Found**
    * 요청 리소를 찾을 수 없음
    * 권한이 부족한 클라이언트에게 해당 리소스를 숨기고 싶을때 사용하기도 함

<br>

* **5xx (Server Error)**
  * 서버 오류, 서버가 정상 요청을 처리하지 못한다
  * 서버에 문제가 있는 것이기 때문에 재시도하면 성공할 수 도 있음 (서버가 복구되거나 하는 경우)
  * **500 Internal Server Error**
    * 서버내부 문제
    * 서버에 문제가 생겼는데 애매하면 그냥 500 오류 사용
  * **503 Service Unavailable**
    * 서버가 일시적인 과부하 또는 예정된 작업으로 잠시 요청을 처리할 수 없음
    * ```Retry-After``` 헤더 필드에 얼마뒤에 복구되는지 보낼 수 있음
    * 많이 사용 안함
  * 웬만히면 서버 에러를 만들지 말자! → 500대 에러로 모니터링 툴들이 트리거 될 수 있음

<br>

---

## 5) HTTP Header

HTTP 헤더에 대해서 알아보자.

### 5.1 HTTP 헤더 소개

이전에 봤던 HTTP 메세지에서 헤더 부분을 살펴보자.

<p align="center">   <img src="img/msg1.png" alt="http" style="width: 100%;"> </p>

* HTTP 헤더는 HTTP 전송에 필요한 모든 부가정보를 담고 있다
  * 예) 메세지 바디의 내용, 크기, 압축, 인증, 요청 클라이언트 정보, 캐시 관리 정보, 등
* 표준 헤더가 굉장히 많음
* 필요시 임의의 헤더도 추가 가능하다

<br>

<p align="center">   <img src="img/header3.png" alt="http" style="width: 80%;"> </p>

<p align='center'>요청, 응답 메세지</p>

<br>

과거(rfc2616)의 헤더 분류와 오늘날(rfc723x)의 헤더 분류의 변화를 알아보자.

* 엔티티(entity) → 표현(representation)으로 변화
* 메세지 본문 = 페이로드(payload)
* 메세지 본문을 통해 표현(representation) 데이터를 전달
* 표현은 요청이나 응답에서 전달할 실제 데이터
* General header : 메세지 전체에 적용되는 정보
  * 예) Connection
* Request header : 요청 정보
  * 예) User-Agent
* Response header : 응답 정보
  * 예) Server
* Representation header :  표현 데이터를 해석할 수 있는 정보를 제공한다
  * 데이터 유형, 데이터 길이, 압축 정보 등

<br>

---

### 5.2 Representation Header

표현 헤더에 대해 알아보자.

* ```Content-Type``` : 표현 데이터의 형식
  * 예) text/html, application/json
* ```Content-Encoding``` : 표현 데이터의 압축 방식
  * 표현 데이터를 압축하기 위해서 사용
  * 데이터를 전달하는 곳에서 압축 후 인코딩 헤더 추가
  * 데이터를 읽는 쪽에서 인코딩 헤더를 바탕으로 압축 해제
  * 예) gzip
* ```Content-Language``` : 표현 데이터의 언어
* ```Content-Length``` : 표현 데이터의 길이 (실제로는 페이로드 헤더에 가깝다)
  * Transfer-Encoding(전송 인코딩)을 사용하는 경우 ```Content-Length``` 사용 안함
* 표현 헤더는 요청, 응답 둘다에서 사용된다

<br>

---

### 5-3. Content Negotiation

콘텐츠 협상(Content negotiation)이란 동일한 URI에서 리소스의 서로 다른 버전을 제공하기 위해 사용하는 메커니즘으로, 사용자 에이전트가 사용자에게 제일 잘 맞는 것이 무엇인지(예를 들어, 문서의 언어, 이미지 포맷 혹은 컨텐츠 인코딩에 있어 어떤 것이 적절한지)를 명시할 수 있다.

쉽게 말해서 클라이언트가 선호하는 표현을 서버에게 요청하는 것이다.

* ```Accept``` : 클라이언트가 선호하는 미디어 타입 전달
* ```Accept-Charset``` : 클라이언트가 선호하는 문자 인코딩
* ```Accept-Encoding``` : 클라이언트가 선호하는 압축 인코딩
* ```Accept-Language``` : 클라이언트가 선호하는 언어
* 협상 헤더는 요청시에만 사용된다

<br>

협상에서의 우선순위에 대해서 알아보자.

* Quality Values(q) 값 사용
* 범위 : 0 ~ 1
  * 클수록 높은 우선순위를 가진다
* 생략시 1
* 예) ```Accept-Language: ko-KR, ko;q=0.9,en-US;q=0.8,en;q=0.7```
  * 우선 순위는 다음과 같다(높을 수록 먼저)
  * ```ko-KR``` : q 생략이기 때문에 q=1
  * ```ko;q=0.9```
  * ```en-US;q=0.8```
  * ```en;q=0.7```
* 항상 구체적인 것이 우선된다
  * 예) 보통 와일드 카드(*)를 사용하는 것이 제일 낮은 우선순위

<br>

---

### 5.4 HTTP Range Request

전송방식에 대해서 알아보자.

전송방식은 다음과 같이 나눌 수 있다.

* 단순 전송
  * ```Content-Length```를 정확히 알고 있을 때, 해당 길이를 요청하고 한번에 받음
* 압축 전송
  * ```Content-Encoding```을 통해서 압축 방식을 명시하고 압축해서 받음
* 분할 전송
  * ```Transfer-Encoding```을 명시한다
  * ```Transfer-Encoding: chunked```데이터를 덩어리로 쪼개서 보냄
  * ```Content-Length```를 명시하면 안된다
* 범위 전송
  * ```Range```를 통해서 요청하고 싶은 범위를 지정
  * 응답에서 ```Content-Range``` 에 범위와 끝 길이를 알려주고 보냄

<br>

---

### 5.5 General, Request, Response Header

#### 5.5.1 일반 정보

이중에서 일반 정보를 포함하는 헤더들에 대해서 알아보자.

* ```From``` 
  * User-Agent의 이메일 정보
  * 잘 사용 안함
  * 검색 엔진에서 주로 사용
  * 요청에서 사용
* **`Referer`**
  * **현재 요청된 페이지의 이전 웹 페이지의 주소**
  * A → B로 이동하는 경우 B를 요청할 때 ```Referer: A```를 포함해서 요청
  * `Referer`를 사용해서 **유입 경로를 분석**할 수 있다
  * 요청에서 사용
* `User-Agent` 
  * 유저 에이전트 애플리케이션 정보(웹 브라우저 정보 등)
  * 예) `User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 Chrome/86.0.4240.183 Safari/537.36`
  * 통계 정보로 사용
  * 어떤 종류의 브라우저에서 장애가 발생했는지 파악이 가능
  * 요청에서 사용
* `Server` 
  * 요청을 처리하는 ORIGIN 서버의 소프트웨어 정보
    * 오리진 서버 : 중간에 거치는 프록시 서버들이 아니라, 실제로 요청을 처리해주는 서버
  * 예) `Server: Apache/2.2.22 (Debian)`
  * 응답에서 사용
* `Date`
  * 메세지가 생성된 날짜
  * 응답에서 사용

<br>

---

#### 5.5.2 특별 정보

특별한 정보를 포함하는 헤더들에 대해서 알아보자.

* `Host`
  * 요청한 호스트(도메인) 정보
  * **필수**
  * 하나의 서버(하나의 IP 주소)가 여러 도메인을 처리해야 할 때가 있음
    * 만약 호스트 정보가 없다면 어느 도메인에 들어가야 할지 구분을 못함
  * 요청에서 사용
* `Location`
  * 페이지 리다이렉션에 사용
  * 201 Created의 경우 `Location` 값은 요청에 의해 생성된 리소스 URI
  * 3xx Redirection의 경우 자동 리다이렉션을 위한 대상 리소스 URI
* `Allow`
  * 허용 가능한 HTTP 메서드
  * 405(Method Not Allowed)에서 응답에 포함해야 한다
  * 예) `Allow: GET, HEAD, PUT`
  * 구현되어 있는 경우는 많지는 않음
* `Retry-After`
  * 503 (Service Unavailable)에서 서비스가 언제까지 불능인지 알려줄 수 있다

<br>

---

#### 5.5.3 인증 정보

인증에 관한 헤더를 알아보자.

* `Authorization`
  * 클라이언트의 인증 정보를 서버에 전달
  * 인증에 관한 메커니즘은 종류가 굉장히 많음
* `WWW-Authenticate`
  * 리소스 접근시 필요한 인증 방법 정의
  * 401 Unauthorized 응답과 함께 사용

<br>

---

## 6) Cookie Header

### 6.1 쿠키 소개

쿠키 헤더에 대해서 알아보자.

HTTP 쿠키(웹 쿠키, 브라우저 쿠키)는 서버가 사용자의 웹 브라우저에 전송하는 작은 데이터 조각이다. 브라우저는 그 데이터 조각들을 저장해 놓았다가, 동일한 서버에 재요청 시 저장된 데이터를 함께 전송한다. **쿠키는 두 요청이 동일한 브라우저에서 들어왔는지 아닌지를 판단할 때 주로 사용**한다. 이를 이용하면 **사용자의 로그인 상태를 유지**할 수 있다. 상태가 없는(stateless) HTTP 프로토콜에서 상태 정보를 기억시켜주기 때문이다.

<br>

우리가 이전에 다루었던 stateless를 다시 복습해보자.

* HTTP는 무상태(stateless) 프로토콜
* 클라이언트와 서버가 요청과 응답을 주고 받으면 연결이 끊어진다
* 서버는 이전 요청을 기억하지 못한다
* 클라이언트와 서버는 서로 상태를 유지하지 않는다

 <br>

* ```Set-Cookie``` : 서버에서 클라이언트로 쿠키를 전달한다(응답)
* `Cookie` : 클라이언트가 서버에서 받은 쿠키를 쿠키 저장소에 저장하고, HTTP 요청시 서버로 전달한다

<br>

쿠키는 쉽게 말해서 상태 유지를 위해 사용하는 데이터 조각이다. 서버는 쿠키를 클라이언트한테 응답으로 전송하고, 브라우저는 쿠키를 쿠키 저장소에 저장 해놓는다. 이후 상태 유지를 위해 쿠키 저장소의 쿠키를 사용할 수 있다.

<br>

<p align="center">   <img src="img/cookie2.png" alt="http" style="width: 100%;"> </p>

<p align='center'>쿠키</p>

* 유저=KSK로 로그인하는 상황이다
  1. ```user=KSK```로 로그인 (```POST``` 요청)
  2. 서버는 ```Set-Cookie```를 통해서 ```user=KSK```이라는 정보를 쿠키에 포함 그리고 응답과 함께 전송
  3. 웹 브라우저의 쿠키 저장소에 받은 쿠키를 저장
  4. 웹 브라우저에서 서버에 요청을 보낼때 마다 쿠키를 찾아서 ```Cookie: user=KSK```를 사용해서 요청을 보낸다
     * 서버는 유저가 KSK임을 알 수 있게 된다
* 여기서 쿠키에 ```user=KSK```를 담았지만, 이건 위험한 방법임 → 세션키 등을 이용함 (뒤에서 자세히 알아보자)
* 쿠키가 있으면 모든 요청에 쿠키 정보를 자동으로 포함해서 보낸다 → 보안 문제 등을 방지하기 위해서 쿠키를 제약하는 방법들이 존재한다

<br>

쿠키에 대해서 다시한번 정리하고, 쿠키에 적용할 수 있는 제약에 대해 알아보자.

* 예) `set-cookie: sessionId=abcde1234; expires=Sat, 26-Dec-2024 00:00:00 GMT; path=/; domain=.google.com; Secure`
* 쿠키의 사용처
  * 사용자 로그인 세션 관리
  * 광고 정보 트래킹
* 쿠키의 정보는 항상 서버에 전송된다
  * 네트워크 트래픽 추가 유발한다는 단점이 있다
  * 최소한의 정보만 사용하는 것을 권장한다(세션 id, 인증 토큰)
  * 만약 요청할 때 마다 서버에 전송하지 않고 쿠키와 비슷하게 사용하고 싶으면?
    * 웹 스토리지 (localStorage, sessionStorage 참고)
* 쿠키에는 보안에 민감한 데이터를 절대 저장하면 안된다!
  * 예) 주민번호, 신용카드 정보

<br>

---

### 6.2 Cookie - Expiration

쿠키의 생명주기에 대해서 알아보자. (```expires```, ```max-age```)

* ```Set-Cookie: expires=Sat, 26-Dec-@024 04;39;21 GMT``` 
  * 만료일이 되면 쿠키를 삭제한다
* ```Set-Cookie: max-age=3600``` 
  * 쿠키 수명 3600초
  * 0이나 음수를 지정하면 쿠키 삭제
* 세션 쿠키 : 만료 날짜를 생략하면 브라우저 종료시 까지만 쿠키를 유지한다
* 영속 쿠키 : 만료 날짜를 입력하면 해당 날짜까지 유지

<br>

---

### 6.3 Cookie - Domain

* 예) ```domain=example.org```
* **도메인을 명시하는 경우 → 명시한 문서 기준 도메인 + 서브 도메인 포함해서 쿠키 접근**
  * ```domain=example.org```를 지정해서 쿠키 생성
    * 명시한 도메인 : ```example.org``` 
    * 서브 도메인 : ```dev.example.org``` 
* **도메인을 생략하는 경우 → 현재 문서 기준 도메인만 쿠키 접근**

<br>

---

### 6.3 Cookie - Path

* 예) ```path=/home```
* 이 경로를 포함한 하위 경로 페이지만 쿠키 접근
* 일반적으로 ```path=/```로 지정
* 예) ```path=/home```
  * `/home` 가능
  * `/home/l1` 가능
  * `/home/l1/l2` 가능
  * `/hello` 불가능

<br>

---

### 6.4 Cookie - Secure

* ```Secure```
  * 원래 쿠키는 http, https를 구분하지 않고 전송한다
  * `Secure`를 사용하면 https인 경우만 전송
* `HttpOnly`
  * XSS 공격 방지
  * 자바스크립트에서 접근 불가
  * HTTP 전송에만 사용
* `SameSite`
  * XSRF 공격 방지
  * 요청 도메인과 무키에 설정된 도메인이 같은 경우만 쿠키 전송

<br>

---

## 7) Cache Header













<br>





























<br>

---

## Further Reading

* Four-way Handshake
* SYN flood attack
  * SYN cookie
* Multiplexing (HTTP 2)
* Socket Programming
* Port forwarding
* Proxy Server
* CDN
* XSS
* XSRF



<br>

---

## Reference

1. [인프런 - 모든 개발자를 위한 HTTP 웹 기본 지식](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard)
2. 네트워크 하향식 접근
3. [https://www.computerhope.com/jargon/t/tcpip.htm](https://www.computerhope.com/jargon/t/tcpip.htm)
4. [https://www.geeksforgeeks.org/tcp-ip-model/](https://www.geeksforgeeks.org/tcp-ip-model/)
5. [https://developer.mozilla.org/ko/docs/Web/HTTP/Connection_management_in_HTTP_1.x](https://developer.mozilla.org/ko/docs/Web/HTTP/Connection_management_in_HTTP_1.x)
6. [https://developer.mozilla.org/ko/docs/Web/HTTP/Messages](https://developer.mozilla.org/ko/docs/Web/HTTP/Messages)
7. [https://httpwg.org/specs/rfc9110.html](https://httpwg.org/specs/rfc9110.html)

