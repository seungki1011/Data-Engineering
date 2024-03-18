## 1) Generics

* **컴파일시 타입 체크를 해주는 기능**
* 클래스나 메서드 레벨에서는 같지만 사용되는 타입만 다른 경우, 객체를 생성할 때 타입을 지정할 수 있음



* 제네릭스를 사용하면 타입 안정성과 코드 유연성을 제공
  * 지정한 타입 외의 타입 사용시 컴파일 에러
  * 사용할 때 마다 형변환하는 것을 생략 가능



* 타입 파라미터로 명시할 수 있는 것은 참조 타입만 가능

<br>

---

## 2) Using Generics

```java
public class ClassName<T> { // 타입 매개변수는 사용하고 싶은거 사용해도 됨
  // 클래스 구현
}
public interface InterfaceName<T> {
  // 인터페이스 구현
}
public <T> void methodName(T variableName){
  // 메서드 구현
  // T data = d; // 제네릭스의 타입 매개변수 T와 메서드 내의 타입 매개변수가 같으면 컴파일 에러 발생
  R data = d; // T가 아니라 다른 걸로 선언하면 됨
}
// 두 개의 제네릭 타입을 두는 것도 가능하다
public class ClassName2<T, K> {...}
public interface InterfaceName2<T, K> {...}


```

* 자주 사용되는 타입 인자 약어
  * ```<T>``` : Type
  * ```<E>``` : Element
  * ```<K>``` : Key
  * ```<V>``` : Value
  * ```<N>``` : Number
  * ```<R>``` : Result

<br>

---

### 2.1 Generic Class

[```GenericClassMain.java```]()

```java
class Box<T> { // 타입 파라미터 'T'로 설정
    private T value;

    public Box(T value) {
        this.value = value;
    }

    // Getter and Setter
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    // value의 type을 출력하는 메서드
    public void printValueType() {
        System.out.println("Type of value: "+value.getClass().getName());
    }
}

public class GenericClassMain {
    public static void main(String[] args) {
        // 1. Create Box for Integer
        System.out.println("----------Integer Box----------");
        Box<Integer> intBox = new Box<>(50);
        intBox.printValueType();
        System.out.println("Box value: "+ intBox.getValue());

        // 2. Create Box for String
        System.out.println("-----------String Box----------");
        Box<String> stringBox = new Box<>("This is a string!");
        stringBox.printValueType();
        System.out.println("Box value: "+ stringBox.getValue());
    }
}
```

```
----------Integer Box----------
Type of value: java.lang.Integer
Box value: 50
-----------String Box----------
Type of value: java.lang.String
Box value: This is a string!
```

* 타입 파라미터로 명시할 수 있는 것은 참조 타입(Reference Type)만 가능하기 때문에 ```int```, ```double``` 같은 원시 타입을 이용하고 싶으면 ```Integar```, ```Double``` 같은 Wrapper Type을 이용해야 한다
* 사용자 정의 클래스도 타입 파라미터로 사용가능

<br>

---

### 2.2 Generic Method













<br>

---

## 3) Constraint Generic



<br>

### 3-1) ```extends```



<br>

### 3-2) ```super```







<br>

---

## 4) Wildcard

















## Reference

---

1. [자바의 정석-기초편](https://www.youtube.com/user/MasterNKS)
1. [패스트 캠퍼스 - 한번에 끝내는 데이터 엔지니어링](https://fastcampus.co.kr/data_online_engineering)