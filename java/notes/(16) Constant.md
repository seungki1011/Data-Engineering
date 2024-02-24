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

## 1) ```final```

* ```final``` 제어자
* ```final```이 붙을 경우 값 변경이 불가
* 기본형에 붙을 경우 값 변경 불가
* 참조형에 붙은 경우 참조값(주소) 변경 불가
  * 참조값을 통해 접근하는 데이터는 변경 가능
  * 예시 : ```인스턴스명.멤버변수명```을 통해 접근하는 경우
* 바뀌면 안되는 값에 ```final```붙여 주면 됨
* 클래스에 ```final```이 붙는 경우
  * 더 이상 상속 불가(상속 끝)
  * 클래스 확장 불가

* 메서드에 ```final```이 붙는 경우
  * 오버라이딩 불가
  * 상속 받은 자식 클래스는 해당 메서드 변경(오버라이딩) 불가

<br>

---

## 2) final local variable

* ```final```이 붙은 변수는 재할당 불가
* 파라미터에 ```final```이 붙을 경우 메서드 내부에서 변경 불가

[```FinalMain1.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/constant/FinalMain1.java)

```java
public class FinalMain1 {
    public static void main(String[] args) {
        final String finalString = "This is a string value made with final";
        // 한번만 할당 가능, 새롭게 할당 시도하면 컴파일 오류
        // FINAL_STRING = "Assigning to a new value for a final variable is impossible";
        System.out.println(finalString);

        final int finalInt = 20;
        System.out.println(finalInt);

        finalMethod1(500);
    }
    static void finalMethod1(final int finalParameter) {
        System.out.println("This is the parameter passed to the method: "+finalParameter);
        // final이 붙은 파라미터는 메서드 내부에서 변경, 할당 불가
        // finalParameter = 30;
    }
}
```

```
This is a string value made with final
20
This is the parameter passed to the method: 500
```

<br>

---

## 3) final member variable(field)

* ```static final```이 붙는 경우 전부 대문자를 사용하자(관례)
  * 상수는 전부 대문자
  * 구분은 ```_```

[```FinalConstructInit.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/constant/FinalConstructInit.java)

```java
public class FinalConstructInit {
    final int finalIntValue;

    // final이 붙은 멤버변수를 필드에서 초기화하지 않은 경우 생성자를 통해서 초기화
    public FinalConstructInit(int finalIntValue) {
        this.finalIntValue = finalIntValue;
        System.out.println("Final Value Initialized using Constructor: "+this.finalIntValue);
    }
}
```

* 생성자를 통해서 초기화하는 경우 인스턴스를 새로 생성하면서 각 인스턴스에 대한 ```final``` 멤버 변수에 다른 값 할당 가능
  * 생성 이후에는 값 변경 불가

<br>

[```FinalFieldInit.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/constant/FinalFieldInit.java)

```java
public class FinalFieldInit {
    // static final이 붙은 변수는 전부 대문자 사용하자
    static final int FINAL_CONST = 40;
    final int finalInt = 30;
    // 초기값을 이미 할당하면 생성자를 통해 초기화 불가능
}
```

* ```final```을 field에서 초기화하는 경우 모든 인스턴스에서 접근하는 ```final``` 멤버 변수는 동일한 값을 가짐
  * 모든 인스턴스에 대해서 똑같이 중복으로 존재함
* ```static final```을 붙여서 사용하는 경우 ```static```영역에 단하나 존재하기 때문에 불필요한 중복 해결
* 결론: ```final```을 field에서 초기화는 경우 ```static final```을 이용하자

<br>

[```FinalMain2.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/constant/FinalMain2.java)

```java
public class FinalMain2 {
    public static void main(String[] args) {
        System.out.println("1. 생성자를 이용한 멤버 변수 초기화");
        FinalConstructInit f1 = new FinalConstructInit(10);
        FinalConstructInit f2 = new FinalConstructInit(20);
        System.out.println(f2.finalIntValue);
        System.out.println("-----------------------------------");

        System.out.println("2. Field에서의 멤버 변수 초기화");
        FinalFieldInit f3 = new FinalFieldInit();
        System.out.println("finalInt = "+f3.finalInt);
        // FINAL_CONST는 static final이 붙은 녀석
        System.out.println("FINAL_CONST = "+FinalFieldInit.FINAL_CONST);
    }
}
```

```
1. 생성자를 이용한 멤버 변수 초기화
Final Value Initialized using Constructor: 10
Final Value Initialized using Constructor: 20
20
-----------------------------------
2. Field에서의 멤버 변수 초기화
finalInt = 30
FINAL_CONST = 40
```

<br>

---

## 4) Constant

* 상수
* 상수는 ```static final```을 사용
  * ```static final```이 붙는 경우 전부 대문자를 사용하자(관례)
* 대부분 상수들은 ```public```이 붙음
  * 특정 위치에서 사용해야 하는 경우 다른 접근 제어자 사용하면 됨
* 상수는 런타임에 변경 불가

<br>

## Reference

---

1. [김영한의 자바 기본](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B8%B0%EB%B3%B8%ED%8E%B8/dashboard)
1. [자바의 정석-기초편](https://www.youtube.com/user/MasterNKS)