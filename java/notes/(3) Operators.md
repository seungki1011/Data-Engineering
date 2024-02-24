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

## 1) Arithmetic Operators

* ```+```, ```-```, ```*```, ```/```, ```%```
* 수학적인 연산 수행
* 0으로 나눌려고 하는 경우 예외 발생

[아래 코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/operators/Op1.java)

```java
public class Op1 {
    public static void main(String[] args) {
        int a = 20;
        int b = 10;
        int c = 7;

        // addition
        int add = a + b;
        System.out.println("a + b = " + add);

        // subtraction
        int sub = a - b;
        System.out.println("a - b = " + sub);

        // multiplication
        int mul = a * b;
        System.out.println("a * b = " + mul);

        // division
        int div = a - b;
        System.out.println("a / b = " + div);

        // remainder operation
        // 나머지가 0 인경우
        int rem1 = a % b;
        System.out.println("a % b = " + rem1);

        // 나머지가 0이 아닌 경우
        int rem2 = a % c;
        System.out.println("a % c = " + rem2);
    }
}
```

```
a + b = 30
a - b = 10
a * b = 200
a / b = 10
a % b = 0
a % c = 6
```

<br>

---

## 2) Comparison Operators

### 숫자 비교

* ```==```, ```!=```, ```>```, ```>=```, ```<```, ```<=```
* 비교 연산
* 결과값이 참이면 ```true``` 반환

[아래 코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/operators/Op2.java)

```java
public class Op2 {
    public static void main(String[] args) {

        int a = 20;
        int b = 10;
        int c = 20;

        // 숫자 비교
        System.out.println("a = 20, b = 10, c = 20");
        System.out.println("a == b returns " + (a==b));
        System.out.println("a != b returns " + (a!=b));
        System.out.println("a > b returns " + (a>b));
        System.out.println("a >= c returns " + (a>=c));
        System.out.println("a < b returns " + (a<b));
        System.out.println("a <= b returns " + (a<=b));
        
    }
}
```

```
a = 20, b = 10, c = 20
a == b returns false
a != b returns true
a > b returns true
a >= c returns true
a < b returns false
a <= b returns false
```

<br>

### 문자열 비교

> Java는 메모리 최적화를 위해서 string literal에 대한 pool을 관리함(String Constant Pool). 특정 literal을 이용해서 string을 생성할 때 같은 literal이 pool에 존재하는 경우 재사용함. 이 때문에 ==를 사용하는 경우 예상하지 못하는 결과가 나올 수 있음. (생성자 방식을 이용한 String은 권장하지 않음.)

* ```.equals()``` 메서드 사용
  * content를 비교
  * null safe 함
* ```==```는 같은 객체를 메모리에서 참조하는지 확인
  * 원시 타입 비교할때 사용 권장

[아래 코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/operators/Op3.java)

```java
public class Op3 {
    public static void main(String[] args) {

        String str1 = "Hello World";
        String str2 = "Hello World";
        String str3 = "Bye Bye World";

        // 문자열의 비교
        // .equals() 사용

        System.out.println("str1 : Hello World, str2 : Hello World, str3 : Bye Bye World");
        System.out.println("compare hello world with hello world : " + "hello world".equals("hello world"));
        System.out.println("compare str1 with Hello World : " + str1.equals("Hello World"));
        System.out.println("compare str1 with str2 : " + str1.equals(str2));
        System.out.println("compare str1 with str3 : " + str1.equals(str3));
    }
}
```

```
str1 : Hello World, str2 : Hello World, str3 : Bye Bye World
compare hello world with hello world : true
compare str1 with Hello World : true
compare str1 with str2 : true
compare str1 with str3 : false
```

<br>

---

## 3) Logical Operators

* 논리 연산자
* ```&&```, ```||```, ```!```
  * ```&&``` : 두 조건 모두 참일 경우 ```true``` 반환, 아닌 경우 ```false```
    * AND 연산
  * ```||``` : 두 조건 중 하나라도 참이면 ```true``` 반환, 두 조건 모두 거짓인 경우 ```false```
    * OR 연산
  * ```!``` : 피연산자의 논리값에 대한 부정을 반환한다
    * 예시 ```true```를 ```false```로

<br>

---

## 4) Further Reading

* 굳이 기초 문법에 대한 예시 코드를 작성할 필요는 없을 것 같다..
* Java에서 String의 동작 방식 찾아보기
  * [https://www.geeksforgeeks.org/strings-in-java/](https://www.geeksforgeeks.org/strings-in-java/)

* 비트 연산자에 대한 내용을 찾아볼 필요가 있을까?
  * [위키피디아 Bitwise Operation](https://en.wikipedia.org/wiki/Bitwise_operation)

<br>


## Reference

---

1. [김영한의 자바 입문](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%9E%90%EB%B0%94-%EC%9E%85%EB%AC%B8)
1. [자바의 정석-기초편](https://www.youtube.com/user/MasterNKS)
1. [https://www.geeksforgeeks.org/strings-in-java/](https://www.geeksforgeeks.org/strings-in-java/)
