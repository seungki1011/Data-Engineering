## 1) Generics

### 1.1 제네릭스 소개

* **컴파일시 타입 체크를 해주는 기능**
* 클래스나 메서드 레벨에서는 같지만 사용되는 타입만 다른 경우, 객체를 생성할 때 타입을 지정할 수 있음



* 제네릭스를 사용하면 타입 안정성과 코드 유연성을 제공
  * 지정한 타입 외의 타입 사용시 컴파일 에러
  * 사용할 때 마다 형변환하는 것을 생략 가능



* 타입 파라미터로 명시할 수 있는 것은 참조 타입만 가능

<br>

---

### 1.2 제네릭스 사용해보기

```java
public class GenericTest {
    public static void main(String[] args) {
      
        // 1. 제네릭 없이 ArrayList 사용해보기
        ArrayList noGenericList = new ArrayList();
        noGenericList.add(100);
        noGenericList.add(200);
        noGenericList.add("300");
        noGenericList.add("Three hundred");

        /**
         * 에러 발생! (형변환 에러)
         * 컴파일러 입장에서는 noGenericList는 Object 타입 ->
         * java.lang.String cannot be cast to java.lang.Integer
         */
        // Integer i = (Integer) noGenericList.get(2);

        System.out.println(noGenericList); // [100, 200, 300, Three hundred]

        // 2. 제네릭 사용해보기
        ArrayList<Integer> genericList = new ArrayList<>();
        genericList.add(10);
        genericList.add(20);
        // genericList.add("30"); // 컴파일 에러 발생 - Integer 타입을 넣어야 함

        /**
         * 제네릭스 덕분에 타입 체크 강화!
         * 제네릭스를 사용하는 것을 권장
         */
    }
}
```

* 지정한 타입 외의 타입 사용시 컴파일 에러
* 사용할 때 마다 형변환하는 것을 생략 가능

<br>

---

### 1.3 타입 변수

* 클래스를 작성할 때, `Object` 타입 대신 타입 변수(`T`)를 선언해서 사용한다

<br>

```java
public class ArrayList<T> extends AbstractList<T> {
  private transient T[] elementData;
  public boolean add(T o){ // 생략.. };
  // 생략..
}
```

* 자주 사용되는 타입 인자 약어
  * ```<T>``` : Type
  * ```<E>``` : Element
  * ```<K>``` : Key
  * ```<V>``` : Value
  * ```<N>``` : Number
  * ```<R>``` : Result

<b>

```java
ArrayList<MyClass> myList = new ArrayList<MyClass>(); // T -> MyClass
```

* 객체를 생성시, 타입 변수(`T`) 대신 실제 타입(`MyClass`)을 지정

<br>

---

### 1.4 Generic Class

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
        Box<Integer> intBox = new Box<Integer>(50);
        intBox.printValueType();
        System.out.println("Box value: "+ intBox.getValue());

        // 2. Create Box for String
        System.out.println("-----------String Box----------");
        Box<String> stringBox = new Box<String>("This is a string!");
        stringBox.printValueType();
        System.out.println("Box value: "+ stringBox.getValue());
      
      	// 3. 매개변수의 다형성 성립
      	ArrayList<Car> list = new ArrayList<Car>();
      	list.add(new Car());
        list.add(new TeslaCar()); // 들어가는 건 자식 타입이 들어갈 수 있음 (Car와 그 자손)
        list.add(new HyundaiCar());
      
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

* `Box<MyType> list = new ArrayList<MyType>();` : 참조변수와 생성자의 대입된 타입은 무조건 일치해야 한다



* `List<MyType> list = new ArrayList<MyType>();` : 지네릭의 클래스간 다형성은 성립한다 (대입 타입은 무조건 일치해야 함)



* 매개변수의 다형성은 성립한다



* 타입 파라미터로 명시할 수 있는 것은 참조 타입(Reference Type)만 가능하기 때문에 ```int```, ```double``` 같은 원시 타입을 이용하고 싶으면 ```Integar```, ```Double``` 같은 Wrapper Type을 이용해야 한다



* 사용자 정의 클래스도 타입 파라미터로 사용가능



<br>

---

## 2) 











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