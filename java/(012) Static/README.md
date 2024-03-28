## Table of Contents

1. `static`
2. 정적 변수(Static variable)
   * 정적 변수 소개
   * `static` 사용 vs `static` 사용하지 않기
3. 정적 메서드(Static Method)
4. 정적 임포트(Static Import)

---

## 1) Static

* 정적
  * 정적 메서드 (static method)
  * 정적 변수 (static variable)
* [Java Memory Structure](https://github.com/seungki1011/Data-Engineering/tree/main/java/(001)%20Java%20Introduction#3-java-memory-structure)

<br>

---

## 2) 정적 변수(Static Variable)

### 2.1 정적 변수 소개

* 정적 변수, 클래스 변수
* ```static```제어자를 사용해서 공용으로 함께 사용할 수 있는 변수 생성 가능
* ```static```이 붙은 멤버 변수는 메서드 영역에서 관리
* 인스턴스와 무관하게 클래스에 바로 접근해서 사용 가능(클래스 자체에 소속되어 있음)



* 클래스 변수는 해당 클래스가 JVM에 로딩되는 순간 생성됨
  * JVM이 종료되기 전까지 생존



* **공용으로 사용하기 위해 클래스에서 특별히 관리하는 녀석**으로 생각하면 편함

<br>

---

### 2.1 Without Static vs With Static

[```Data1.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/staticvariable/Data1.java)

```java
public class Data1 {
    public String name;
    public int cnt;

    public Data1(String name) {
        this.name = name;
        cnt++;
    }
}
```

<br>

[```DataMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/staticvariable/DataMain.java)

```java
public class DataMain {
    public static void main(String[] args) {
        // 각 인스턴스를 새롭게 생성하고 인스턴스 멤버인 cnt를 접근하는 것(공유되지 않음!)
        Data1 d1 = new Data1("d1");
        System.out.println(d1.name+" count : "+d1.cnt);

        Data1 d2 = new Data1("d2");
        System.out.println(d2.name+" count : "+d2.cnt);

        Data1 d3 = new Data1("d3");
        System.out.println(d3.name+" count : "+d3.cnt);
    }
}
```

```
d1 count : 1
d2 count : 1
d3 count : 1
```

<br>

[```StaticData1.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/staticvariable/StaticData1.java)

```java
public class StaticData1 {
    public String name;
    public static int cnt; // static 붙음

    public StaticData1(String name) {
        this.name = name;
        // 원래는 StaticData1.cnt++; 으로 static 변수를 사용하지만
        // 같은 클래스 내에서는 생략 가능
        cnt++;
    }
}
```

<br>

[```StaticDataMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/staticvariable/StaticDataMain.java)

```java
public class StaticDataMain {
    public static void main(String[] args) {
        // 인스턴스 참조 변수로 접근하는 것이 아니라 클래스명을 이용해서 접근
        StaticData1 d1 = new StaticData1("d1");
        System.out.println(d1.name+" count : "+StaticData1.cnt);

        StaticData1 d2 = new StaticData1("d2");
        System.out.println(d2.name+" count : "+StaticData1.cnt);

        // 인스턴스 참조 변수로 접근해도 가능은 하지만 권장하지 않음
        // 인스턴스 멤버에 cnt가 없는 것을 확인 -> 메서드 영역의 static 변수에서 확인
        StaticData1 d3 = new StaticData1("d3");
        System.out.println(d3.name+" count : "+d3.cnt);
    }
}
```

```
d1 count : 1
d2 count : 2
d3 count : 3
```

<br>

---

## 3) 정적 메서드(Static Method)

* 정적 메서드, 클래스 메서드
* 인스턴스(객체) 생성 없이 호출 가능
  * 클래스명을 통해 호출 가능



* 인스턴스 멤버와 관련 없는 작업을 함
  * 인스턴스를 사용하는 이유는 보통 인스턴스 변수를 사용하기 위한 목적이 큼
  * 단순히 기능만 제공하는 메서드면 ```static```사용을 고려
  * 간단히 메서드로 끝낼수 있는 유틸리티성 기능들에 자주 사용



* 정적(```static```) 메서드는 ```static```이 붙은 애들만 사용 가능
  * 메서드 내에 인스턴스 변수 사용 불가

<br>

[```StaticMethod1.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/staticmethod/StaticMethod1.java)

```java
public class StaticMethod1 {
    // 메서드에 static이 붙음
    public static String addDecoration(String str){
        return "=========== "+str+" ===========";
    }
}
```

<br>

[```StaticMethodMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/staticmethod/StaticMethodMain.java)

```java
public class StaticMethodMain {
    public static void main(String[] args) {
        String s = "This is the string value";
        
      	// 클래스명.메서드명 으로 접근
        String result = StaticMethod1.addDecoration(s);

        System.out.println(s);
        System.out.println(result);
    }
}
```

```
This is the string value
=========== This is the string value ===========
```

<br>

>  main() 메서드
>
> * ```main()```은 ```static```메서드이기 때문에 ```main()```이 호출하는 메서드는 무조건 ```static``` 메서드를 사용

<br>

---

## 4) Static Import

* ```static```메소드 사용시 클래스명 없이 바로 사용 가능

<br>

```java
import static java.lang.Integer.*; // Integer 클래스의 모든 static 메서드
import static java.lang.Math.random; // Math.random() 만
import static java.lang.System.out;  // System.out을 out으로 참조가능
```

* 인텔리제이 ```alt+enter``` : Add on-demand static import

<br>

---

## 5) Further Reading

* Java Permgen vs Metaspace

<br>

---

## Reference

1. [https://www.geeksforgeeks.org/java-memory-management/](https://www.geeksforgeeks.org/java-memory-management/)
1. [https://www.codelatte.io/courses/java_programming_basic/KUYNAB4TEI5KNSJV](https://www.codelatte.io/courses/java_programming_basic/KUYNAB4TEI5KNSJV)