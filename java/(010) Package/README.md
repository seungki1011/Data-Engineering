## Table of Contents

1. [패키지(Package)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(010)%20Package#1-package)
2. [`import`](https://github.com/seungki1011/Data-Engineering/tree/main/java/(010)%20Package#2-import)
   * `import`
   * `static` `import` 
3. [패키지 관례](https://github.com/seungki1011/Data-Engineering/tree/main/java/(010)%20Package#3-%ED%8C%A8%ED%82%A4%EC%A7%80-%EA%B4%80%EB%A1%80package-convention)

---

## 1) Package

* 패키지
* 서로 관련된 클래스들의 묶음(Package)
* 패키지는 폴더로 볼 수 있음
  * 패키지안에 패키지가 들어갈 수 있음(하위 패키지)

<br>

<p align="center">   <img src="img/package1.png" alt="package" style="width: 50%;"> </p>


```java
package de.java.newpackage;

public class NewPackage1 {
    public static void main(String[] args) {

    }
}
```

* ```de```안의 ```java```안의 ```newpackage``` : ```de.java.newpackage```

<br>

---

## 2) `import`

### 2.1 `import`

* ```import```는 사용할 클래스가 속한 패키지를 지정하는데 사용함
* ```import```문 사용시 클래스를 사용할 때 패키지명(풀네임)을 생략할 수 있음
* 같은 패키지 내의 클래스를 사용하는 경우 ```import```없이 또는 패키지 경로를 생략 가능한 상태로 사용 가능



* 같은 이름의 클래스가 있는 경우 ``import``는 둘중 하나만 선택 가능
  * 자주 사용하는 클래스를 ```import```
  * 자주 사용하지 않는 클래스는 풀 경로를 적어서 사용

<br>

**`import` 사용 x**

```java
class ImportTest {
    java.util.Date today = new java.util.Date();
}
```

<br>

**`import` 사용 o**

```java
import java.util.*;

class ImportTest {
    Date today = new Date();
}
```

* ```java.lang```패키지의 클래스는 import하지 않아도 사용할 수 있음
* ```import```문은 패키지문과 클래스 선언의 사이에 선언

<br>

> 1. ```package```
> 2. ```import```
> 3. ```class``` 선언

<br>

---

### 2.2 static import

* ```static``` 임포트 사용시 클래스명 없이 바로 사용 가능

<br>

---

## 3) 패키지 관례(Package Convention)

* [자바 관례 참고](https://github.com/seungki1011/Data-Engineering/tree/main/java/(002)%20Basic%20Syntax#2-java-convention)
* 관례라는 것은 무조건 지켜야 하는 것은 아님
* **패키지 이름은 모두 소문자**



* **패키지 이름 앞부분은 보통 회사의 도메인 네임을 거꾸로 사용**
  * 예시. ```com.company.myapp```
  * ```(회사, 조직).(제품, 서비스명).(기능적, 기술적 구분)```
  * 예시 ```org.apache.commons.lang```



* **패키지의 위계(hieararchy)를 구성할때는 보통 큰 분류에서 더 세부적인 분류로 간다**

<br>

> 위계 구조가 다음과 같다면
>
> * ```de```
>   * ```java```
>     * ```a```
>     * ```b```
>
> 패키지는 ```de.java.a```, ```de.java.b```, ```de.java```, ```de``` 총 4개가 존재함