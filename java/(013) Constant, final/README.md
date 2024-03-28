## Table of Contents

1. [`final`](https://github.com/seungki1011/Data-Engineering/tree/main/java/(013)%20Constant%2C%20final#1-final)
2. [`final`이 붙은 지역 변수(Local variable)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(013)%20Constant%2C%20final#2-final%EC%9D%B4-%EB%B6%99%EC%9D%80-local-variable)
3. [`final`이 붙은 멤버 변수(Member variable, Field)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(013)%20Constant%2C%20final#3-final%EC%9D%B4-%EB%B6%99%EC%9D%80-member-variablefield)
4. [상수(Constant)](https://github.com/seungki1011/Data-Engineering/tree/main/java/(013)%20Constant%2C%20final#4-constant)

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

## 2) `final`이 붙은 local variable

* ```final```이 붙은 변수는 재할당 불가
* 파라미터에 ```final```이 붙을 경우 메서드 내부에서 변경 불가

<br>

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

## 3) `final`이 붙은 member variable(field)

* ```static final```이 붙는 경우 전부 대문자를 사용하자(관례)
  * 상수는 전부 대문자
  * 구분은 ```_```

<br>

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