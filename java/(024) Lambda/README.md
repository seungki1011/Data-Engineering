## Table of Contents

1. [람다 표현식(Lambda Expression)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(024)%20Lambda#1-%EB%9E%8C%EB%8B%A4-%ED%91%9C%ED%98%84%EC%8B%9Dlambda-expression)
   * 람다식 소개
2. [함수형 인터페이스(Functional Interface)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(024)%20Lambda#2-%ED%95%A8%EC%88%98%ED%98%95-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4functional-interface)
3. [메서드 참조(Method Reference)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(024)%20Lambda#3-%EB%A9%94%EC%84%9C%EB%93%9C-%EC%B0%B8%EC%A1%B0method-reference)
4. [람다의 단점](https://github.com/seungki1011/Data-Engineering/tree/main/java/(024)%20Lambda#4-%EB%9E%8C%EB%8B%A4%EC%9D%98-%EB%8B%A8%EC%A0%90)

---

## 1) 람다 표현식(Lambda Expression)

> 자바는 Java8(JDK1.8) 부터 함수형 언어들이 가지는 몇 가지 기능을 추가시켰다. 람다 표현식을 포함해서, 뒤에서 다룰 `stream`, `optional` 등이 여기에 해당한다.

<br>

### 1.1 람다식 소개

람다식에 대해서 알아보자.

람다식은 함수(메서드)를 간단한 식(expression)으로 표현하는 방법이다. 람다식은 기본적으로 익명 함수(annonymous function)이다.

<br>

람다식을 작성해보자.

```java
public class LambdaTest {
    public static void main(String[] args) {
        BinaryOperator<Integer> lambdaMax = (a, b) -> a > b ? a : b; // 람다식
    }

    int max(int a, int b) {
        return a > b ? a : b; // true면 a 반환, false 면 b 반환
    }

}
```

* 메서드의 이름과 반환타입을 제거하고 `->`를 블록`{}` 앞에 추가
* 반환값이 있는 경우 `return` 생략 가능
* `;` 생략
* 매개 변수의 타입이 추론 가능하면 생략 가능

<br>

```java
a -> a * a
(a) -> a*a // 매개변수가 하나이면 괄호 생략 가능   
 
(int a) -> a * a // 타입이 있을 경우 생략 불가
```

* 매개변수가 하나이면 괄호 생략 가능
* 타입이 있을 경우 괄호 생략 불가

<br>

```java
(int i) -> {
  System.out.println(i)
}

// 블록 안의 문장이 하나뿐이면 {} 생략 가능
(int i) -> System.out.println(i)
```

* 블록 안의 문장이 하나뿐이면 `{}` 생략 가능

<br>

---

## 2) 함수형 인터페이스(Functional Interface)

함수형 인터페이스는 **오로지 1개의 추상 메서드를 갖는 인터페이스**를 말한다.

```java
@FunctionalInterface
interface MyInterface {
    public abstract int max(int a, int b); // 추상 메서드
}
```

* `default` 메서드가 있어도, 추상 메서드가 단 1개만 존재하면 함수형 인터페이스

<br>

함수형 인터페이스를 사용해보자.

```java
public class LambdaTest2 {
    public static void main(String[] args) {
      
        // 1. 익명 클래스의 선언과 객체 생성을 동시
        MyInterface myInterface = new MyInterface() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        int i = myInterface.max(10, 20);
        System.out.println(i);

        // 2. 람다식 사용해보기 - 함수형 인터페이스 타입의 참조변수로 람다식 참조 가능하다
        // 함수형 인터페이스의 메서드와 람다식 매개변수 개수와 반환타입이 일치해야 한다
        MyInterface lambdaF = (a, b) -> a > b ? a : b;

        int value = lambdaF.max(10, 20);
        System.out.println(value);
    }
}
```

* 함수형 인터페이스 타입의 참조변수로 람다식 참조 가능
  * 람다식을 다루기 위한 참조변수 타입은 함수형 인터페이스를 이용한다
* 사용하기 위해서는 함수형 인터페이스의 메서드와 람다식 매개변수 개수와 반환타입이 일치해야 한다

<br>

```java
@FunctionalInterface
public interface MyInterface2 {
    public abstract void method ();
}
```

```java
public class LambdaTest {
    public static void main(String[] args) {
      
        LambdaTest lambdaTest = new LambdaTest();

        // 1. 함수령 인터페이스 타입의 참조 변수 사용
        MyInterface2 mI = ()-> System.out.println("call method()");
        lambdaTest.aMethod(mI);

        // 2. 람다식을 직접 넣어서 사용
        lambdaTest.aMethod(()-> System.out.println("call method()"));
    }

    void aMethod(MyInterface2 f) {
        f.method();
    }
}
```

<br>

---

## 3) 메서드 참조(Method Reference)

하나의 메서드만 호출하는 람다식은 이중 콜론 연산자 `::` 를 통해서 더 간단히 나타낼 수 있다.

<br>

```java
Integer method(String s) { // Integer.parseInt(s) 만 호출한다
  return Integer.parseInt(s);
}
```

```java
// 결과가 같다
int result = obj.method("123");
int result = Integer.parseInt("123"); // 그냥 바로 호출해도 결과가 똑같다

// 람다식을 사용
// 살펴보면 입력에 대한 정보(String 입력)를 이미 알 수 있기 때문에 필요 없다
Function<String, Integer> f = (String s) -> Integer.parseInt(s);

// 메서드 참조 사용
Function<String, Integer> f = Integer::parseInt; // ClassName::method
```

* static 메서드 참조 : `(x) -> ClassName.method(x)` 를 `ClassName::method`로 사용 가능

* 인스턴스 메서드 참조 : `(obj, x) -> obj.method(x)` 를 `ClassName::method`로 사용 가능

<br>

`::`는 호출하고자 하는 함수의 파라미터 갯수와 각각의 타입이 람다식에 전달되는 인자와 일차하는 경우, `object` 변수에 대한 선언과 파라미터 입력을 생략하고 호출하고자하는 클래스의 함수만을 입력해서 사용할 수 있다.

람다식 사용 vs 메서드 참조 사용

```java
public class MethodRefTest {
    public static void main(String[] args) {

        List<String> fruitList = Arrays.asList("Apple", "Grape", "Strawberry");

        System.out.println("--1. 람다식 사용--");
        fruitList.forEach(fruit -> System.out.println(fruit)); // String 타입 fruit
      
        System.out.println("--2. 메서드 참조 사용--");
        fruitList.forEach(System.out::println);
    }
}
```

```
--1. 람다식 사용--
Apple
Grape
Strawberry
--2. 메서드 참조 사용--
Apple
Grape
Strawberry
```

<br>

---

## 4) 람다의 단점

* 람다식을 이용하면 로그를 보면서 디버깅하기가 어려워진다 (함수의 위치, 이름 파악하기 어려움)
* 람다를 사용해서 만든 익명함수는 재사용 불가







