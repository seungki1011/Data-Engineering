## Table of Contents



---

## 1) Generics 소개

### 1.1 제네릭스 설명

예시 코드를 보면서 왜 제네릭스(Generics)가 필요한지 알아보자.

먼저 제네릭스를 사용하지 않고 `String`과 `Integer`를 꺼내서 사용할 수 있는 기능을 제공하는 박스를 구현해서 사용하는 경우를 살펴보자.

<br>

`IntegerBox`

```java
public class IntegerBox {

    private Integer value;

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
```

* `Integer` 값을 설정하고 꺼낼 수 있는 기능 제공

<br>

```StringBox```

```java
public class StringBox {

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
}
```

* `String` 값을 설정하고 꺼낼 수 있는 기능 제공

<br>

`BoxMain1`

```java
public class BoxMain1 {
    public static void main(String[] args) {
      
        IntegerBox integerBox = new IntegerBox();
        integerBox.setValue(10);
        Integer i = integerBox.getValue();
        System.out.println("i = " + i);

        StringBox stringBox = new StringBox();
        stringBox.setValue("string value");
        String str = stringBox.getValue();
        System.out.println("str = " + str);
    }
}
```

```
i = 10
str = string value
```

<br>

위의 `StringBox`, `IntegerBox`를 이용한 코드에는 한가지 문제가 있다. 만약 `Double`, `Float`, `Boolean` 등 새로운 타입을 담을 박스를 사용하기 위해서는 새롭게 박스를 구현해야 한다. 만약 1~2 가지의 타입만 사용한다면 큰 문제가 되지 않겠지만, 수십~수백 가지 타입을 사용하기 위해서 새로 코드를 작성하는 것은 굉장히 비효율적이다.

이를 해결하기 위해서 **제네릭스(Generics)**을 사용할 수 있다.

제네릭을 사용하는 예시를 살펴보면서, 제네릭스에 대해 알아보자. 먼저 `제네릭 클래스(Generic Class)`를 만들어보자.

<br>

`GenericBox`

```java
public class GenericBox<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
```

* `<>`(다이아몬드)를 사용한 클래스를 `제네릭 클래스`라고 한다
* 클래스명 바로 오른쪽에 `<T>`와 같은 형식으로 선언해서 제네릭 클래스로 만들 수 있고, `T`를 타입 매개변수(Type parameter)라고 한다
* 타입 매개변수 `T`를 `T` 타입이 필요한 필드나 메서드 반환 타입에 사용할 수 있다
  * 예) `private T value;`
  * 예) `public T getValue() {...}`



* 제네릭 클래스를 사용해서 클래스의 타입을 객체의 생성 시점에 정할 수 있다
* 제네릭의 타입 매개변수에는 참조 타입만 가능하다(원시 타입 불가)

<br>

제네릭 클래스를 사용하는 코드를 구현해보자.

<br>

`GenericBoxMain`

```java
public class GenericBoxMain {
    public static void main(String[] args) {

        GenericBox<Integer> integerBox = new GenericBox<Integer>();
        integerBox.setValue(100);
        // integerBox.setValue("one hundred"); // 제네릭을 통한 타입 안정성 제공
        Integer integerValue = integerBox.getValue();
        System.out.println("integerValue = " + integerValue);

        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.setValue("one hundred");
        String stringValue = stringBox.getValue();
        System.out.println("stringValue = " + stringValue);

        GenericBox<Double> doubleBox = new GenericBox<>(); // 제니릭 타입 생략 가능(타입 추론)
        doubleBox.setValue(99.9);
        Double doubleValue = doubleBox.getValue();
        System.out.println("doubleValue = " + doubleValue);

    }
}
```

```
integerValue = 100
stringValue = one hundred
doubleValue = 99.9
```

* 제네릭 클래스의 인스턴스를 다음과 같이 생성할 수 있다
  * `new GenericBox<Integer>();`
  * `Integer`는 제네릭 클래스의 타입 매개변수로 넘어가서 해당 클래스의 타입 매개변수(`T`)가 `Integer`를 사용하도록 한다



* 제네릭 클래스에 대한 인스턴스를 생성할 때 타입 추론이 가능하다
  * `GenericBox<Double> doubleBox = new GenericBox<>();`
  * `Double`이라고 명시하지 않아도 `GenericBox<Double>`에서 `Double`이라는 것을 추론할 수 있기 때문에 자동으로 `Double`을 적용해준다



* 이전 제네릭을 사용하기 전의 코드와 비교해보면, 새로운 타입을 사용할 때마다 클래스를 만들 필요가 없어졌다. 그렇다고 타입 안전성이 떨어지는 것도 아니다



<br>

제네릭 클래스를 도입하면서 얻은 이점은 다음과 같다.

* 타입 안정성 제공 : 지정한 타입 외의 타입 사용시 컴파일 에러
* 코드 유연성 제공 : 하나의 제네릭 클래스를 이용해서 여러 타입 사용 가능, 사용할 때 마다 형변환하는 것을 생략 가능



<br>

---

### 1.2 제네릭스 사용해보기

제네릭 클래스를 사용해보자.

<br>

`Pair`

```java
public class Pair<T1,T2> {

    private T1 first;
    private T2 second;

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
```

* 제네릭 클래스는 위 코드 처럼 다수의 타입 매개변수를 사용하는 것도 가능하다

<br>

```PairTest```

```java
public class PairTest {
    public static void main(String[] args) {

        Pair<Integer, String> pair1 = new Pair<>();
        pair1.setFirst(10);
        pair1.setSecond("data");
        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        System.out.println("pair1 = " + pair1);

        Pair<String, String> pair2 = new Pair<>();
        pair2.setFirst("key");
        pair2.setSecond("value");
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());
        System.out.println("pair2 = " + pair2);

        // 지네릭 클래스간 다형성은 성립
        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list = " + list);

        // 참조 변수의 지네릭 클래스 타입과 생성자의 대입된 타입은 무조건 일치해야한다
        // List<Long> list2 = new ArrayList<Integer>();
        
    }
}
```

```
10
data
pair1 = Pair{first=10, second=data}
key
value
pair2 = Pair{first=key, second=value}
list = [a, b, c]
```

* `List<MyType> list = new ArrayList<MyType>();` : 지네릭의 클래스간 다형성은 성립한다
  * `List`는 `ArrayList`의 상위 타입



* 지네릭 클래스의 지네릭 타입의 타입 인자와 생성자의 대입된 타입 인자는 일치해야 함
  * `List<Long> list2 = new ArrayList<Integer>();` 처럼 사용 불가

<br>

<p align="center">   <img src="img/generic1.png" alt="generic" style="width: 80%;"> </p>

<p align = 'center'>Integer 대신 Long을 사용해야 함</p>

<br>

---

### 1.3 타입 변수 관례(Convention)

타입 변수에 대한 관례에 대해서 알아보자.

클래스를 작성할 때, `Object` 타입 대신 타입 변수(`T`)를 선언해서 사용한다. 

<br>

```java
public class ArrayList<T> extends AbstractList<T> {
  private transient T[] elementData;
  public boolean add(T o){ 
    // ... 
  };
  // ...
}
```

* 자주 사용되는 타입 인자 약어
  * ```<T>``` : Type
  * ```<E>``` : Element
  * ```<K>``` : Key
  * ```<V>``` : Value
  * ```<N>``` : Number
  * ```<R>``` : Result



* 관례일 뿐, 필요하면 원하는 문자를 사용할 수 있다

<b>

```java
List<MyClass> myList = new ArrayList<MyClass>(); // T -> MyClass
```

* 객체를 생성시, 타입 변수(`T`) 대신 실제 타입(`MyClass`)을 지정
* 이전에도 설명했듯이 `int`, `float` 처럼 기본(원시) 타입은 타입 매개변수에 사용 불가
  * 참조형이나 래퍼 클래스를 사용


<br>

---

## 2) 제네릭 제한(Generic Constraint)

### 2.1 제한이 없을 경우의 문제점

제네릭 클래스의 타입 매개변수를 특정 타입으로 제한하는 제네릭의 제약에 대해서 알아보자. 

먼저 제네릭 제약을 도입하기 전에 일어날 수 있는 문제점을 살펴보자.

(이후의 코드는 반복되는 보일러 플레이트 코드를 줄이기 위해서 `Lombok` 사용)

<br>

구현할 코드는 

* 이동 수단을 나타내는 `Vehicle` 클래스
* `Vehicle` 클래스를 상속받는 `Car`, `Plane` 클래스
* 제네릭 클래스인 `VehicleCenter` 클래스

<br>

`Vehicle`

```java
@AllArgsConstructor
@Getter
public class Vehicle {

    private String name;
    private int volume;

    public void move() {
        System.out.println("이동 수단 이동중.");
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                '}';
    }
}
```

<br>

`Car`

```java
public class Car extends Vehicle{

    public Car(String name, int size) {
        super(name, size);
    }

    @Override
    public void move() {
        System.out.println("자동차는 달리는 중.");
    }
}
```

<br>

`Plane`

```java
public class Plane extends Vehicle{

    public Plane(String name, int size) {
        super(name, size);
    }

    public void move() {
        System.out.println("비행기는 나는 중.");
    }
}
```

<br>

`VehicleCenter`

```java
@AllArgsConstructor
public class VehicleCenter<T> {

    private T vehicle;

    public void check() {
        // object 타입의 메서드는 이용 가능
        System.out.println(vehicle.toString());

        // 특정 클래스의 메서드 사용 불가(컴파일 오류)
        // 타입은 객체 생성 순간 정해지기 때문에, 정해지기 전 시점에 메서드 사용 불가
        // System.out.println("이동 수단 연료양 = " + vehicle.getVolume());
        // vehicle.move();
    }

    public T getLargerVolume(T target) {
        // 마찬가지로 컴파일 오류
        // return vehicle.getVolume() > target.getVolume() ? vehicle : target;
        return null;
    }

}
```

* 현재 코드는 제네릭 제한을 도입하기 전인 상태
* 문제점은 `Vehicle`과 그 자손 클래스들의 메서드를 이용이 불가능하다
  * 이유는 제네릭 타입을 선언하면 자바 컴파일러 입장에서 `T`에 어떤 타입이 들어올지 예측할 수 없다
  * 물론 개발자의 입장에서는 당연히 `Vehicle`과 그 하위 타입이 들어올것을 예상하고 코드를 구현한 것이지만, 컴파일러의 입장에서는 아무것도 모르는 상태인 것이다



<br>

현 상태로 클래스들을 사용하는 코드를 작성해보자.

<br>

```NoConstraintTest```

```java
public class NoConstraintTest {
    public static void main(String[] args) {

        VehicleCenter<Car> car = new VehicleCenter<>(new Car("K5", 100));
        VehicleCenter<Plane> plane = new VehicleCenter<>(new Plane("F-16", 500));

        car.check();
        plane.check();

        // Vehicle이 아닌 것도 타입에 들어갈 수 있는 문제
        VehicleCenter<String> string = new VehicleCenter<>("string value");
        string.check();

    }
}
```

```
Vehicle{name='K5', volume=100}
Vehicle{name='F-16', volume=500}
string value
```

* `Vehicle`과 관련된 기능을 제네릭 클래스인 `VehicleCenter`를 통해서 이용하고 싶지만 불가능하다
* 타입인자로 `Vehicle`의 자손만 받고 싶지만, 제약이 없기 때문에 어떤 타입이든 들어갈 수 있음

<br>

지금까지의 문제들을 제네릭 제한을 도입하면서 해결해보자.

<br>

---

### 2.2 타입 매개변수의 제한 도입

제네릭 제한이라는 것은 결국 타입 매개변수를 원하는 범위로 제한하는 것이다.

기존의 코드를 타입 매개변수를 제한하는 코드로 변경해보고, 그 차이점에 대해 알아보자.

<br>

 `ConstraintVehicleCenter`

```java
@AllArgsConstructor
public class ConstraintVehicleCenter<T extends Vehicle> { // 타입 매개변수에 제약

    private T vehicle;

    public void check() {
        System.out.println(vehicle.toString());
        // 이제 Vehicle이 제공하는 메서드 사용 가능
        System.out.println("이동 수단 연료양 = " + vehicle.getVolume());
        vehicle.move();
    }

    public T getLargerVolume(T target) {
        return vehicle.getVolume() > target.getVolume() ? vehicle : target;
    }
}
```

* `<T extends Vehicle>` : 제네릭 제약의 핵심. 타입 매개변수 `T`에 `Vehicle`과 그 자손 클래스만 받을수 있도록 제한한다.
  * 상위 제한(upper-bound constraint)

* 타입 매개변수를 제한했기 때문에 자바 컴파일러는 `T`에 들어올수 있는 타입의 범위를 예측할 수 있음
  * `<T extends Vehicle>`의 경우 `Vehicle`과 그 자손들이 올수 있다는 것을 예측할 수 있기 때문에, 타입이 정확하게 정해진 상태가 아니어도 `Vehicle`이 제공하는 기능들을 사용할 수 있게 된다

<br>

이제 제네릭 제한을 도입한 클래스를 사용해보자.

<br>









<br>

---

## 3) 제네릭 제약(Generic Constraints)

### 3.1 제한된 제네릭 클래스

* `extends`를 이용해서 대입할 수 있는 타입을 제한할 수 있다

<br>

```java
class Person2<T extends Parent>{ // Parent의 자손 타입만 지정 가능
    ArrayList<T> list = new ArrayList<>();
}

class Person3<T extends Parent & MyInterface>{ // & MyInterface로 MyInterface 인터페이스를 구현한 클래스로 제한 가능
    ArrayList<T> list = new ArrayList<>();
}
```

```java
    Person2<Parent> p1 = new Person2<Parent>();
    Person2<Child> p2 = new Person2<Child>(); // Child는 Parent의 자손이기 때문에 가능
```

* 인터페이스의 경우에도 `extends`를 사용한다
* `<T extends Parent & MyInterface>` : `Parent`의 자손 타입이면서, `MyInterface` 인터페이스를 구현한 타입으로 제한
  * 만약 `Parent`가 이 `MyInterface`를 구현한 클래스라면 사실 필요가 없음





<br>

---

### 3.2 제네릭스의 제약

위의 `Box` 클래스를 다시 사용해보자.

<br>

```java
class Box<T> { // 타입 파라미터 'T'로 설정
    private T value;
		
  	// static T value; // static 멤버에 타입 변수 사용 불가
  
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
```

```java
public class GenericConstraintTest {
    public static void main(String[] args) {

        // 1. 타입 변수에 대입은 인스턴스 별로 다르게 가능하다
      	Box<Integer> integerBox = new Box<>(100); // Integer 객체만 저장 가능
        Box<String> stringBox = new Box<>("My name is stringBox"); // String 객체만 저장가능

        System.out.println(integerBox.getValue());
        System.out.println(integerBox.getValue().getClass());
        System.out.println("-------------------------");
        System.out.println(stringBox.getValue());
        System.out.println(stringBox.getValue().getClass());

    }
}
```

```
100
class java.lang.Integer
-------------------------
My name is stringBox
class java.lang.String
```

* 타입 변수에 대입은 인스턴스 별로 다르게 가능하다
* `static` 멤버에 타입 변수 사용 불가 → `static`이라는 것은 모든 인스턴스에 공통으로 사용가능하다는 것



* 배열을 생성할 때 타입 변수 사용불가 → `T[] toArray() { T[] tmpArr = new T[itemArr.length] };` 불가
  * `new` 다음에 `T` 불가



* 타입 변수로 배열 선언은 가능하다 → `T[] itemArr;` 가능

<br>

---

## 4) 와일드카드(Wildcard, `<?>`)

와일드 카드에 대해서 알아보자.

```java
ArrayList<? extends Product> list = new ArrayList<Tv>(); // 가능
ArrayList<? extends Product> list = new ArrayList<Computer>(); // 가능

ArrayList<Product> list = new ArrayList<Tv>(); // 불가능, 대입 타입의 불일치
```

* 대입 타입이 무조건 일치해야한다는 제약을 벗어나기 위해서 와일드 카드 사용
* 와일드 카드로 하나의 참조 변수로 대입된 타입이 다른 객체를 참조 가능해진다

<br>

> `<? extends T>` : 와일드 카드의 상한 제한. `T`와 그 자손들만 가능(가장 많이 사용) - upperbounded wildcard
>
> `<? super T>` : 와일드 카드의 하한 제한. `T`와 그 조상들만 가능 - lowerbounded wildcard
>
> `<?>` : 제한 없음. 모든 타입이 가능하다.

<br>

---

## 5) 제네릭 메서드(Generic Method)

```java
static <T> void sort(List<T>, list, Comparator<? super T> o){...}
```

* 제네릭 타입이 선언된 메서드를 제네릭 메서드라고 한다 (타입 변수는 메서드 내에서만 유효하다)

<br>

```java
class Box<T> {
  
  // 생략...
  
  static <T> void sort(List<T>, list, Comparator<? super T> o){ // 메서드의 T는 클래스의 T와 서로 별개의 타입 변수이다
    // 제네릭 메서드의 T는 메서드 내에서만 스코프를 가진다
    // 생략...
  }
 
}
```

* 클래스의 타입 매개변수 `<T>`와 메서드의 타입 매개변수 `<T>`는 별개이다

<br>