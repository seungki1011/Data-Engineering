> 네트워크와 HTTP의 기초 정리
>
> 참고 강의 및 자료
>
> * [인프런 - 모든 개발자를 위한 HTTP 웹 기본 지식](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard)
> * HTTP 완벽 가이드
> * 네트워크 하향식 접근(Computer Networking a Top-Down Approach)
> * [널널한 개발자 - 네트워크 기초](https://www.youtube.com/watch?v=k1gyh9BlOT8&list=PLXvgR_grOs1BFH-TuqFsfHqbh-gpMbFoy)

---

## Index

### 1) [Network](https://github.com/seungki1011/Data-Engineering/tree/main/network%20and%20http/(001)Network)

---

### 2) [HTTP](https://github.com/seungki1011/Data-Engineering/tree/main/network%20and%20http/(002)HTTP)

1. [웹 통신]((002)HTTP/README.md#1-%EC%9B%B9-%ED%86%B5%EC%8B%A0)
   * 인터넷(Internet)
   * [IP(Internet Protocol)]((002)HTTP/README.md#12-ipinternet-protocol)
   * [TCP(Transmission Control Protocol)]((002)HTTP/README.md#13-tcptransmission-control-protocol)
     * TCP 소개
     * Three way handshake
     * 데이터 전달 보증, 순서 보장
   * UDP(User Datagram Protocol)
   * PORT
   * DNS(Domain Name System)
   * URI(Uniform Name Identifier)
   * [요청의 흐름]((002)HTTP/README.md#18-%EC%9B%B9%EC%97%90%EC%84%9C%EC%9D%98-%EC%9A%94%EC%B2%AD%EC%9D%98-%ED%9D%90%EB%A6%84)
2. [HTTP]((002)HTTP/README.md#2-http)
   * HTTP 소개
   * Client-Server
   * [Stateless]((002)HTTP/README.md#23-stateless)
   * [Connectionless]((002)HTTP/README.md#24-connectionless)
   * HTTP Message
3. [HTTP Method]((002)HTTP/README.md#3-http-method)
   * [HTTP API 설계]((002)HTTP/README.md#31-http-api-%EC%84%A4%EA%B3%84-%EC%86%8C%EA%B0%9C)
   * GET,POST
   * PUT, PATCH, DELETE
   * [HTTP 메서드의 속성]((002)HTTP/README.md#34-http-%EB%A9%94%EC%84%9C%EB%93%9C%EC%9D%98-%EC%86%8D%EC%84%B1)
     * 안전(Safe)
     * 멱등성(Idempotency)
     * 캐시 가능(Cacheable)
   * [HTTP 메서드의 활용]((002)HTTP/README.md#35-http-%EB%A9%94%EC%84%9C%EB%93%9C%EC%9D%98-%ED%99%9C%EC%9A%A9)
     * 클라이언트 → 서버 데이터 전송
     * HTTP API 설계
       * POST - 신규 자원 등록
       * PUT - 신규 자원 등록
       * HTML Form 사용
4. [HTTP Status Code]((002)HTTP/README.md#4-http-status-code)
   * 1xx, 2xx
   * [3xx]((002)HTTP/README.md#42-3xxredirection)
     * 3xx - Permanent Redirect
     * 3xx - Temporary Redirect
   * 4xx, 5xx
5. [HTTP Header]((002)HTTP/README.md#5-http-header)
   * [HTTP 헤더 소개]((002)HTTP/README.md#51-http-%ED%97%A4%EB%8D%94-%EC%86%8C%EA%B0%9C)
   * Representation Header(표현 헤더)
   * Content Negotiation(콘텐츠 협상)
   * 전송 방식
   * General, Request, Response Header
     * 일반 정보
     * 특별 정보
     * 인증 정보
6. [쿠키(Cookie)]((002)HTTP/README.md#6-cookie)
   * [쿠키 소개]((002)HTTP/README.md#61-%EC%BF%A0%ED%82%A4-%EC%86%8C%EA%B0%9C)
   * Cookie - Expiration
   * Cookie - Domain
   * Cookie - Path
   * Cookie - Secure
7. [캐시(Cache)]((002)HTTP/README.md#7-cache-header)
   * [캐시 소개]((002)HTTP/README.md#71-%EC%BA%90%EC%8B%9C-%EC%86%8C%EA%B0%9C)
   * [Cache Validation(`Last-Modified`, `If-Modified-Since`)]((002)HTTP/README.md#72-cache-validationlast-modified-if-modified-since)
   * Cache Validation(`ETag`)
   * `Cache-Control`

---

## Further Reading

* Four-way Handshake
* Port forwarding
* SYN flood attack
  * SYN cookie
* Multiplexing (HTTP 2)
* Socket Programming
* Web Cache(Proxy Cache)
  * Proxy Server

* CDN
* XSS
* XSRF



---

## Reference

1. [인프런 - 모든 개발자를 위한 HTTP 웹 기본 지식](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard)
2. [널널한 개발자 - 네트워크 기초](https://www.youtube.com/watch?v=k1gyh9BlOT8&list=PLXvgR_grOs1BFH-TuqFsfHqbh-gpMbFoy)
3. [https://www.computerhope.com/jargon/t/tcpip.htm](https://www.computerhope.com/jargon/t/tcpip.htm)
4. [https://www.geeksforgeeks.org/tcp-ip-model/](https://www.geeksforgeeks.org/tcp-ip-model/)
5. [https://developer.mozilla.org/ko/docs/Web/HTTP/Connection_management_in_HTTP_1.x](https://developer.mozilla.org/ko/docs/Web/HTTP/Connection_management_in_HTTP_1.x)
6. [https://developer.mozilla.org/ko/docs/Web/HTTP/Messages](https://developer.mozilla.org/ko/docs/Web/HTTP/Messages)
7. [https://httpwg.org/specs/rfc9110.html](https://httpwg.org/specs/rfc9110.html)
8. [https://developer.mozilla.org/en-US/docs/Web/HTTP/Caching#etagif-none-match](https://developer.mozilla.org/en-US/docs/Web/HTTP/Caching#etagif-none-match)
