## Table of Contents

1. 열거형(`enum`)
   * `enum` 소개
   * `enum` 사용하기
   * 열거형에 멤버 추가하기
2. 열거형을 사용하는 이유



---

## 1) 열거형(`enum`)

### 1.1 `enum` 소개

* 요소 또는 멤버라고 불리는 값의 집합으로 이루어진 자료형
* 열거형은 서로 관련된 상수들을 같이 묶어 놓은 것이라고 생각하면 편하다(상수들의 집합)
* `enum`은 자바의 특수한 클래스로 구분됨
* 상수를 정의하는 방법
  * `final static` 이용
  * 인터페이스를 통한 상수 선언
  * 이제부터 알아볼 `enum`을 사용하는 방법

<br>

---

### 1.2 `enum` 사용하기

열거형을 정의하는 방법

```java
enum EnumName {상수명1, 상수명2, ...}
```

* `상수1` : `0`, `상수2` : `1`, ... `상수n` : `n` 부여

<br>

열거형을 사용해보자.

```java
public enum Direction {
    EAST,
    SOUTH,
    WEST,
    NORTH
}
```

```java
public class EnumDirectionMain {
    public static void main(String[] args) {
        Direction dir; // 열거형 인스턴스 변수 선언

        dir = Direction.EAST;
        System.out.println(dir);

        dir = Direction.SOUTH;
        System.out.println(dir);

        // values() 사용해보기
        System.out.println("-----------values 사용해보기------------");
        Direction[] dArr = Direction.values();
        for (Direction direction : dArr) {
            System.out.println(direction);
        }
    }
}
```

```
EAST
SOUTH
-----------values 사용해보기------------
EAST
SOUTH
WEST
NORTH
```

* `values()` 열거형을 배열로 반환한다



* 모든 열거형은 `Enum`의 자손이다 → 다양한 메서드를 상속받는다
  * `ordinal()` : 열거형 상수가 정의된 순서를 반환한다(0 부터 시작)



* 열거형은 비교 연산자로 비교 불가 → `compareTo()`를 사용해야 한다

<br>

---

### 1.3 열거형에 멤버 추가하기

```java
public enum DaysOfWeek {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final int dayValue; // 정수를 저장할 필드(인스턴스 변수) 추가

    DaysOfWeek(int dayValue) { // 생성자 추가
        this.dayValue = dayValue;
    }

    public int getDayValue() {
        return dayValue;
    }
}
```

```java
public class EnumMain {
    public static void main(String[] args) {
        DaysOfWeek today = DaysOfWeek.WEDNESDAY;
        System.out.println("Today is day " + today.getDayValue());
    }
}
```

```
Today is day 3
```

* 괄호`()`안에 원하는 값을 넣어서 값을 부여할 수 있다
  * 끝에 `;` 추가해야 한다
  * 인스턴스 변수와 생성자를 새로 추가해야 사용할 수 있다
  * 사실상 생성자 호출
  * 열거형의 생성자는 외부에서 호출불가

<br>

---

## 2) 열거형을 사용하는 이유

* 허용 가능한 타입을 제한해서, type-safety를 제공한다 → 컴파일러가 잘못된 값을 넣을 경우 잡아준다
* 코드의 가독성이 좋아진다
* iteration을 지원
* 열거형은 thread-safe하다
  * lazy initialization
  * 싱글톤 인스턴스
  * 불변(immutable)
  * 모든 스레드의 enum 상수가 정합성을 가지도록 함

<br>

---

## Reference

1. [티스토리 Inpa Dev - 열거형](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%97%B4%EA%B1%B0%ED%98%95Enum-%ED%83%80%EC%9E%85-%EB%AC%B8%EB%B2%95-%ED%99%9C%EC%9A%A9-%EC%A0%95%EB%A6%AC#enum_%EC%97%B4%EA%B1%B0_%ED%83%80%EC%9E%85)

