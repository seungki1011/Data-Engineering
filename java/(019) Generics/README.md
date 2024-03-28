## Table of Contents

1. Generics
   * 제네릭스 소개
   * 제네릭스 사용해보기
   * 타입 변수
   * 제네릭 클래스(Generic Class)
2. `HashMap<K, V>`
3. 제네릭 제약(Generic Constraints)
   * 제한된 제네릭 클래스
   * 제네릭스의 제약
4. 와일드 카드(Wildcard, `<?>`)
5. 제네릭 메서드(Generic Method)

---

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

### 1.4 제네릭 클래스(Generic Class)

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

## 2) `HashMap<K,V>`

<br>

```java
public class HashMapGenerics {
    public static void main(String[] args) {

        HashMap<String, Person> hashMap = new HashMap<>(); // 타입 지정 생략 가능
        hashMap.put("personA", new Person("ksk", "male", 28));
        hashMap.put("personB", new Person("messi", "male", 40));

        System.out.println(hashMap.get("personA"));
        System.out.println(hashMap.get("personA").name);

        System.out.println("------------------------");

        Person person = hashMap.get("personB");
        System.out.println(person);
        System.out.println(person.name);
    }
}
```

```
de.java.generics.Person@2a139a55
ksk
------------------------
de.java.generics.Person@15db9742
messi
```

* 여러개의 타입 변수가 필요한 경우, `','`를 구분자로 선언

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

## Reference

---

1. [자바의 정석-기초편](https://www.youtube.com/user/MasterNKS)