## [Index](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/JavaIndex.md)

1. [자바 소개(Introduction of Java)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(1)%20StartingJava.md)
2. [변수(Variables)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(2)%20Variables.md)
3. [연산자(Operators)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(3)%20Operators.md)
4. [조건문(Conditional)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(4)%20Conditional.md)
5. [반복문(Loop)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(5)%20Loop.md)
6. [형변환(Type Casting)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(6)%20Typecasting.md)
7. [배열(Array)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(7)%20Array.md)
8. [메서드(Method)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(8)%20Method.md)
9. [클래스(Class)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(9)%20Class.md)
10. [기본형과 참조형(Primitive Type & Reference Type)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(10)%20Reference%20Type.md)
11. [객체지향 프로그래밍(OOP)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(11)%20OOP.md)
12. [생성자(Constructor)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(12)%20Constructor.md)
13. [패키지(Package)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(13)%20Package.md)
14. [접근 제어자(Access Modifier)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(14)%20Access%20Modifier.md)
15. [Static](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(15)%20Static.md)
16. [```final```](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(16)%20Constant.md)
17. [상속(Inheritance)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(17)%20Inheritance.md)
18. [다형성(Polymorphism)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(18)%20Polymorphism.md)
19. [예외 처리(Exception Handling)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(20)%20Exception.md)
20. [```java.time```패키지](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(21)%20Date%26Time.md)
21. [```Collection``` Framework](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(22)%20Collection.md)
22. [제네릭스(Generics)]()
23. [스트림(Stream)]()
24. [쓰레드(Thread)]()

---

## 1) Typecasting

* 형변환
* 자료형을 다른 형태로 변경하는 것

<br>

---

## 2) 자동 형변환(Widening Type Casting)

* 자동 형변환, 묵시적 형변환 등에 해당
* 작은 범위의 값을 큰 범위에 넣는 것은 가능
  * 예시 ```int```의 값을 ```long```또는 ```double```에 넣기
* 큰 범위의 값을 작은 범위에 넣으면 문제 생김
  * 예시 overflow 문제

[아래 코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/typecasting/tc1.java)

```java
public class tc1 {
    public static void main(String[] args) {
        int intVal = 5;
        long longVal;
        double doubleVal;

        // 1. int 값을 long 그릇에 넣는 것은 가능
        longVal = intVal;
        System.out.println("longVal is " + longVal);

        // 2. int 값을 double 그릇에 넣는 것도 가능
        doubleVal = intVal;
        System.out.println("doubleVal is " + doubleVal);

        /*
        작은 범위를 큰 범위에 넣는 경우에는 자바가 자동으로 형변환을 해주기 때문에 다음과 같이
        명시적으로 형을 제시하지 않아도 된다.
        doubleVal = (double) intVal;
         */
    }
}
```

```
longVal is 5
doubleVal is 5.0
```

<br>

---

## 3) 명시적 형변환(Narrow Type Casting)

* 명시적 형변환, 강제 형변환 등에 해당
* 큰 범위의 값을 작은 범위의 값에 넣을 경우 명시적으로 형변환을 해야한다
* 명시적 형변환은 주의해서 사용하자
  * 데이터 손실 주의
  * ```float```과 ```int```간의 형변환시 이런 손실 문제로 ```double```사용을 권장
  * 오버플로우 문제 주의

[아래 코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/typecasting/tc2.java)

```java
public class tc2 {
    public static void main(String[] args) {
        int intVal;
        long longVal;
        double doubleVal = 10.345;

        // intVal = doubleVal; 명시적 형변환을 하지 않으면 컴파일 에러 발생
        intVal = (int) doubleVal;

        System.out.println("Original doubleVal is " + doubleVal);
        System.out.println("Value after type casting to int is " + intVal);
    }
}
```

```
original doubleVal is 10.345
Value after type casting to int is 10
```

<br>

### 계산시 형변환

* 다른 타입간의 계산은 상위 타입으로 자동 형변환

[아래 코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/typecasting/tc3.java)

```java
public class tc3 {
    public static void main(String[] args) {
        double d1;
        d1 = 10 / 4;
        System.out.println("d1 = " + d1);
        d1 = 10.0 / 4.0;
        System.out.println("d1 = " + d1);
        d1 = (double) 10 / 4;
        System.out.println("d1 = " + d1);
        d1 = 10.0 / 4;
        System.out.println("d1 = " + d1);
    }
}
```

```
10/4 is d1 = 2.0
10.0/4.0 is d1 = 2.5
(double) 10/4 is d1 = 2.5
10.0/4 is d1 = 2.5
```

<br>

---

## Further Reading

* [Upcasting, Downcasting](https://www.geeksforgeeks.org/typecasting-in-java/)

<br>

## Reference

---

1. [김영한의 자바 입문](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%9E%90%EB%B0%94-%EC%9E%85%EB%AC%B8)
1. [자바의 정석-기초편](https://www.youtube.com/user/MasterNKS)
1. [https://www.simplilearn.com/tutorials/java-tutorial/type-casting-in-java](https://www.simplilearn.com/tutorials/java-tutorial/type-casting-in-java)
1. [https://www.geeksforgeeks.org/typecasting-in-java/](https://www.geeksforgeeks.org/typecasting-in-java/)