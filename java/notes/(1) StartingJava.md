

## Java Introduction

### High Level Language

* 많은 경우 고급 프로그래밍 언어는 고급언어 > 어셈블리어 > 기계어 > 하드웨어로 추상화 됨

<p align="center">   <img src="img/computer-languages.png" alt="Computer Languages"> </p>

<p align="center">출처 - https://www.cs.mtsu.edu/~xyang/2170/computerLanguages.html</p>

### Translator

* 프로그래머들이 작성한 코드를 컴퓨터가 이해할 수 있는 바이너리 형태로 변환해주는 프로그램
* [위키피디아 정의](https://en.wikipedia.org/wiki/Translator_(computing))
* [참고](https://www.helpteaching.com/lessons/1285/high-level-low-level-languages)

<p align="center">   <img src="img/translator.png" alt="translator"> </p>

<p align="center">출처 - https://www.helpteaching.com/lessons/1285/high-level-low-level-languages</p>

#### 컴파일러(compiler)

* 특정 프로그래밍 언어를 다른 프로그래밍 언어로 번역해주는 프로그램
* source code에서 object code로 변환
* 한번 컴파일하고 나면 다시 컴파일할 필요 없이 재사용 가능

#### 인터프리터(interpreter)

* 소스 코드를 한줄씩 읽으면서 실행
* 컴파일하는 경우 보다 실행 속도는 느림



### 자바의 동작

* Java의 경우 compiling과 interpretation 둘다 사용한다
* [참고](https://www.geeksforgeeks.org/compilation-execution-java-program/)
* 처음에 작성하는 코드(.java)는 자바 컴파일러(javac)에 의해 자바 바이트 코드(.class)로 변환
* 자바 바이트 코드는 JVM이 이해 가능한 언어
* JVM은 인터프리터와 JIT 컴파일러를 통해 각 운영체제에 맞는 기계어로 해석해서 실행
  * 이런 운영체제의 독립성은 자바의 주요한 특징 중 하나

<p align="center">   <img src="img/java_exec.jpeg" alt="java jvm" style="width: 70%;"> </p>

<p align="center">출처 - https://www.geeksforgeeks.org/compilation-execution-java-program/</p>

* 컴파일 : ```javac Main.java``` (```Main.class```파일 생성)
* 실행 : ```java Main```
* IDE를 사용하는 경우 보통 위의 과정을 한번에 처리해줌

## Further Reading

* JIT 컴파일러
* 클래스 로더
* JVM의 구조



## 참고

---

1. [김영한의 자바 입문](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%9E%90%EB%B0%94-%EC%9E%85%EB%AC%B8)
2. [https://www.geeksforgeeks.org/compilation-execution-java-program/](https://www.geeksforgeeks.org/compilation-execution-java-program/)
3. [https://www.helpteaching.com/lessons/1285/high-level-low-level-languages](https://www.helpteaching.com/lessons/1285/high-level-low-level-languages)
