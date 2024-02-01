## 1) Method

* 메소드
* 특정 작업을 수행하는 코드의 집합
* 메소드명은 동사로
* 코드의 용이한 모듈화, 재사용성 증가 등으로 유지보수가 쉬워짐
* 메소드는 보통 멤버변수와 더불어서 클래스(class)의 속성 중 하나
* [캡슐화(encapsulation)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(11)%20OOP.md#5-encapsulation)에 대한 내용 공부 할 것
* 메소드 호출을 하면 파라미터에 인수(argument) 대입
* 값을 반환 하지 않는 경우 반환 타입 ```void```
* 메소드는 ```return```을 만나면 종료
  * ```void```는 ```return```생략 가능


```java
접근제어자 리턴타입 메소드이름(parameters) {
  // 구현
}
```

[아래 코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/method/method1.java)

```java
public class method1 {
    public static void main(String[] args) {
        System.out.println("method result 1: " + avg(1,2));
        System.out.println("method result 2: " + avg(49,78));
        startMsg();
    }

    // 1. 정적(static) 메소드 정의
    public static double avg(int a, int b){ // 선언부
        return (double) (a+b)/2; // 구현부
    }
    // 2. 값을 반환 안하는 경우 void
    public static void startMsg(){
        System.out.println("This is a start message!");
    }
}
```

```
method result 1: 1.5
method result 2: 63.5
This is a start message!
```

* **변수의 값이 복사되어서 대입된다**

<br>

---

## 2) Static Method

* 정적 메소드
* 객체(instance) 생성 없이 호출 가능
* 인스턴스 멤버와 관련 없는 작업 함
* 메소드 내에 인스턴스 변수 사용 불가
* [OOP](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(11)%20OOP.md)와 [Static](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(15)%20Static.md)에서 추가 설명

<br>

---

## 3) Instance Method

* 객체(instance) 생성 후 ```참조변수.methodName()``` 으로 호출
* [OOP](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(11)%20OOP.md)에서 추가 설명

<br>

---

## 4) Overloading

* 오버로딩
* 한 클래스 안에서 같은 이름의 메서드를 여러개 정의하는 것
* 오버로딩이 성립하기 위해서는
  * 메서드의 이름이 같아야 함
  * 매개변수의 개수 또는 타입이 달라야 함
  * 반환 타입은 영향이 없음
* 메서드는 구분하기 위한 메서드 시그니쳐는 메서드의 이름 & 매개변수 타입, 갯수
* 오버라이딩된 메소드를 호출하는 경우 파리미터 타입에 가장 알맞은 메소드 부터 선택해서 호출

<br>

### 성립하는 경우

```java
long add(int a, long b) {return a+b;}
long add(long a, int b) {return a+b;}
```

* 매개변수의 타입이 다르면 성립

### 성립하지 않는 경우

```java
int add(int a, int b) {return a+b;}
long add(int a, int b) {return (long)(a+b);}
```

* 반환 타입은 오버로딩의 성립에 영향이 없음

<br>

---

## 5) Overriding

* 오버라이딩
* 조상 클래스로 부터 상속 받 메서드의 내용 상속받는 클래스에 맞게 변경하는 것(덮어쓰는 것)
* [상속(inheritance)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(17)%20Inheritance.md)에서 추가 설명

<br>

## Reference

---

1. [김영한의 자바 입문](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%9E%90%EB%B0%94-%EC%9E%85%EB%AC%B8)
1. [자바의 정석-기초편](https://www.youtube.com/user/MasterNKS)
