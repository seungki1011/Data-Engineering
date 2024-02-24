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

## 1) Conditional

* 조건문
* 특정 조건(condition)에 따라 특정 코드를 실행하는 것
* ```if```, ```else if```, ```switch```, 삼항연산자

<br>

---

## 2) if, else-if

### if

* 조건이 ```true```일 경우 특정 코드 블록 실행
* ```else```는 조건이 참이 아닌 경우 ```else```에 해당하는 코드 블럭 실행

### else if

* ```if```문의 조건이 거짓인 경우 다음 조건을 체크
* 여러가지 조건 설정하는 경우 여러개의 ```if```문을 사용하는 것 보다 ```else if```를 사용해서 불필요한 조건 검사를 피하는 것이 좋음
* 조건은 제일 많이 발생하는 조건을 최상단 조건으로 설정하는 것이 좋음

[아래 코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/conditional/con1.java)

```java
public class con1 {
    public static void main(String[] args) {

        // 1. if
        int a = 50;
        int b = 37;

        if (a>b) {
            System.out.println("a is bigger than b");
        }
        if (a>20) {
            System.out.println("a is bigger than 20");
        }

        // 2. if - else
        String c = "Hello";
        if (c.equals("Hello World!")) {
            System.out.println("String c equals to Hello World!");
        } else {
            System.out.println("String c is not Hello World!");
        }

        // 3. else if
        int age = 8;
        if (age>19) {
            System.out.println("You are a adult");
        } else if (19>=age && age>12) {
            System.out.println("You are a teenager");
        } else if (12>=age && age>1) {
            System.out.println("You are a child");
        } else {
            System.out.println("You are a infant");
        }
    }
}
```

```
a is bigger than b
a is bigger than 20
String c is not Hello World!
You are a child
```

* ```else if```를 사용하는 것은 서로 연관 조건인 경우에만 사용
* 독립된 조건이라면 그냥 ```if```문을 따로 사용

<br>

---

## 3) switch

* 조건식의 결과 값이 어떤 케이스의 값과 동일하면 해당 케이스의 코드 실행
  * ```if```문 처럼 특정 조건의 참 거짓에 따라 코드를 실행하는 것이 아님
  * ```if```문으로 그냥 다 해결 할 수 있음
* ```break```로 ```switch```문을 빠져나갈 수 있음
  * ```break```문을 넣지 않으면 다음 케이스의 코드까지 실행
* ```default```는 일치하는 케이스의 값이 없는 경우 실행

[아래 코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/conditional/con2.java)

```java
public class con2 {
    public static void main(String[] args) {
        // switch
        int choice = 2;

        switch (choice) { // choice에 조건식이 들어간다. 케이스의 값과 조건식의 값이 일치해야 해당 케이스의 코드 실행
            case 1:
                System.out.println("You chose option 1!");
                break; // exit switch block with break
            case 2:
                System.out.println("You chose option 2!");
                break;
            case 3:
                System.out.println("You chose option 3!");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        System.out.println("This is the remaining code executed after the switch block");
    }
}
```

```
You chose option 2!
This is the remaining code executed after the switch block
```

* Java 14부터 새로운 ```switch```도 생겼음

<br>

---

## 4) 삼항 연산자(Ternary Operator)

* 참과 거짓에 따른 특정 값을 구하는 경우 ```?:``` 연산자를 사용해서 ```if```문에 비해 코드를 간결화 시킬 수 있음
* 단순 표현식만 가능

```java
// condition이 true면 A 실행, false면 B 실행
(condition) ? A:B 
```

[아래 코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/conditional/con3.java)

```java
public class con3 {
    public static void main(String[] args) {
        int asset = 40000;
        String status = (asset >= 30000) ? " You can buy it!" : " You can't buy it!";
        System.out.println("With your asset " + asset + "$" + status);
    }
}
```

```
With your asset 40000$ You can buy it!
```

<br>

## Reference

---

1. [김영한의 자바 입문](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%9E%90%EB%B0%94-%EC%9E%85%EB%AC%B8)
1. [자바의 정석-기초편](https://www.youtube.com/user/MasterNKS)
