## Table of Contents



---

## 1) 중첩 클래스(Nested Class)

### 1.1 중첩 클래스 소개

중첩 클래스(Nested Class)란 클래스 안에 클래스를 중첩해서 정의한 클래스를 말한다.

```java
class Outer {
  //...
  
  // 중첩 클래스
  class Nested {
    //...
  }
}
```

<br>

중첩 클래스는 클래스를 정의하는 위치에 따라서 분류할 수 있다.

<br>

<p align="center">   <img src="img/nested1.png" alt="nested" style="width: 95%;"> </p>

<p align="center">중첩 클래스의 분류</p>

<br>

**정적 중첩 클래스(Static Nested Class)**

```java
class Outer {
    //...
    // 정적 중첩 클래스
		static class StaticNested {
		//... 
    }
}
```

* 정적 중첩 클래스는 앞에 `static`이 붙어있다
* 정적 중첩 클래스는 바깥 클래스와 전형 다른 클래스이다
* **바깥 클래스의 인스턴스에 소속 되지 않는다**

<br>

**내부 클래스(Inner Class)**

```java
class Outer {
   	
    private int memberVar;
   
    // 내부 클래스 - 인스턴스 변수와 같은 위치에 선언
  	class Inner {
		//... 
    }
    
		public void process() { 
        // 지역 변수
				int lcoalVar = 0; 
      	
      	// 지역 클래스 - 지역 변수와 같은 위치에 선언
    		class Local {...}
      
        Local local = new Local();
		} 
}
```

* 내부 클래스는 내부 클래스, 지역 클래스, 익명 클래스로 분류할 수 있다
  * 내부 클래스 : 인스턴스 변수와 같은 위치에 선언
  * 지역 클래스 : 지역 변수와 같은 위치에 선언
  * 익명 클래스 : 지역 클래스의 특별한 버전



* 중첩과 내부의 차이는 다음 처럼 생각하자
  * 중첩 : 어떤 것이 단순히 내부에 위치하거나 포함되는 구조
  * 내부 : 내부에 있는 구성 요소(바깥 클래스의 인스턴스에 소속된다)

<br>

> 보통 내부 클래스, 중첩 클래스를 엄밀하게 구분하지는 않는다. 상황과 문맥을 보면서 어떤 것을 사용하는 것인지 파악하자!

<br>

중첩 클래스는 언제 사용하나?

* 내부 클래스를 포함한 모든 중첩 클래스는 특정 클래스가 다른 하나의 클래스 안에서만 사용되거나, 두 클래스가 서로 긴밀히 연결되어 있는 특수한 경우에만 사용한다.
* 만약 외부의 여러 클래스가 특정 중첩 클래스를 사용한다면, 해당 클래스는 중첩 클래스로 만들면 안된다
  * 쉽게 말해서 다른 클래스에서도 중첩 클래스를 사용하면 바깥으로 빼자 그냥

<br>

---

### 1.2 정적 중첩 클래스(Static Nested Class)

#### 1.2.1 정적 중첩 클래스 예시

정적 중첩 클래스에 대해서 알아보자.

<br>

```java
public class NestedOuter {

    private static int outClassValue = 3;
    private int outInstanceValue = 2;

    static class Nested {
        private int nestedInstanceValue = 1;

        public void print() {
            // 자신의 멤버에 접근
            System.out.println(nestedInstanceValue);

            // 바깥 클래스의 인스턴스 멤버에 접근에는 접근할 수 없다.
            //System.out.println(outInstanceValue);

            // 바깥 클래스의 클래스 멤버에는 접근할 수 있다. private도 접근 가능
            System.out.println(NestedOuter.outClassValue);
        }
    }
}
```



<p align="center">   <img src="img/static1.png" alt="nested" style="width: 100%;"> </p>

* 정적 중첩 클래스 앞에는 `static`이 붙는다

  

* 자신의 멤버에는 접근 가능 (`nestedInstanceValue`)

* 바깥 클래스의 인스턴스 멤버에는 접근 불가능 (`outInstanceValue`)



* 바깥 클래스의 클래스 멤버(`static` 멤버)에는 접근 가능(`NestedOuter.outClassValue`)
  * `NestedOuter.outClassValue` 대신 `outClassValue` 사용 가능
  * 같은 클래스 내부에 있기 때문에 `private`이 붙어도 접근 가능

<br>

```java
public class NestedOuterMain {

    public static void main(String[] args) {
        NestedOuter outer = new NestedOuter();
        NestedOuter.Nested nested = new NestedOuter.Nested();
        nested.print();

        System.out.println("nestedClass = " + nested.getClass());
    }
}
```

<p align="center">   <img src="img/static2.png" alt="nested" style="width: 100%;"> </p>

* 정적 중첩 클래스는 `new 바깥클래스.중첩클래스()` 로 생성할 수 있다
  * 예) `NestedOuter.Nested nested = new NestedOuter.Nested();`



* 중첩 클래스는 `NestedOuter.Nested`와 같이 `바깥 클래스.중첩클래스`로 접근할 수 있다
* 여기서 `new NestedOuter()`로 만든 바깥 클래스의 인스턴스와 `new NestedOuter.Nested()`로 만든 정적 중첩 클래스의 인스턴스는 서로 아무 관계가 없는 인스턴스이다



* 정적 중첩 클래스는 바깥 클래스의 정적 필드(메서드 영역)에는 접근할 수 있다
* 바깥 클래스가 만든 인스턴스 필드에는 바로 접근 불가능하다, 왜냐하면 바깥 클래스 인스턴스의 참조에 대한 정보가 없기 때문이다

<br>

정리하자면 정적 중첩 클래스는 단지 서로 다른 클래스를 중첩해 둔 것일 뿐이다. 사실 다음과 같이 서로 다른 클래스 두 개를 따로 만든것과 비슷하다.

```java
 class NestedOuter {
   //...
 }

 class Nested {
   //...
 }
```

<br>

---

#### 1.2.2 정적 중첩 클래스를 사용하는 경우

그럼면 정적 중첩 클래스를 활용하는 경우에 대해서 알아보자.

<br>

<p align="center">   <img src="img/static3.png" alt="nested" style="width: 100%;"> </p>

* 리펙토링 전에는 개발자는 `Network`과 `NetworkMessage`를 둘다 사용해야 하나 헷갈려할 것이다
  * 두 클래스의 코드를 직접 확인하고 나서야, `Network` 클래스만 사용하고, `NetworkMessage`는 `Network` 안에서만 사용된다는 것을 알 수 있을 것이다



* 어차피 `NetworkMessage`는 바깥에서 사용되는 클래스가 아니기 때문에, `Network` 안의 정적 중첩 클래스로 만들면 된다
* 리펙토링 후, 개발자는 `NetworkMessage`가 `Network` 클래스 내부에서만 단독으로 사용하는 클래스라고 바로 인지할 수 있다

<br>

---

### 1.3 내부 클래스(Inner Class)

#### 1.3.1 내부 클래스 예시

내부 클래스에 대해서 알아보자. 

<br>

```java
public class InnerOuter { // 바깥 클래스

    private static int outClassValue = 3;
    private int outInstanceValue = 2;
		
  	// 내부 클래스
    class Inner {
        private int innerInstanceValue = 1;

        public void print() {
            // 자기 자신에 접근
            System.out.println(innerInstanceValue);

            // 외부 클래스의 인스턴스 멤버에 접근 가능, private도 접근 가능
            System.out.println(outInstanceValue);

            // 외부 클래스의 클래스 멤버에 접근 가능, private도 접근 가능
            System.out.println(outClassValue);
        }
    }
}
```

<p align="center">   <img src="img/inner1.png" alt="nested" style="width: 100%;"> </p>

* 내부 클래스는 앞에 `static` 이 붙지 않는다
  * 쉽게 이야기해서 인스턴스 멤버가 된다



* 자신의 멤버에 접근 가능 (`innerInstanceValue`)
* 바깥 클래스의 인스턴스 멤버에 접근 가능 (`outInstanceValue`)
* 바깥 클래스의 클래스 멤버(`static` 멤버)에 접근 가능 (`outClassValue`)

<br>

```java
public class InnerOuterMain {

    public static void main(String[] args) {
        InnerOuter outer = new InnerOuter();
        InnerOuter.Inner inner = outer.new Inner();
        inner.print();

        System.out.println("innerClass = " + inner.getClass());

    }
}
```

<p align="center">   <img src="img/inner2.png" alt="nested" style="width: 100%;"> </p>

* `InnerOuter.Inner inner = outer.new Inner()` : 내부 클래스 생성
  * 내부 클래스는 바깥 클래스의 인스턴스에 소속되어야 한다
  * 따라서 내부 클래스를 생성할 때, 바깥 클래스의 인스턴스 참조가 필요하다
  * `outer` : 바깥 클래스의 인스턴스 참조를 가짐



* 내부 클래스는 바깥 클래스의 인스턴스에 소속된다,  따라서 바깥 클래스의 인스턴스 정보를 알아야 생성할 수 있다
  * 쉽게 말해서, 바깥 클래스의 인스턴스를 먼저 생성해야 내부 클래스의 인스턴스를 생성할 수 있다
  * 개념상 내부 클래스의 인스턴스는 바깥 클래스의 인스턴스 안에서 생성되는 걸로 이해하면 편하다 (실제 구현은 내부 인스턴스가 바깥 인스턴스의 참조 값을 보관한다)

<br>

정리하면, 내부 클래스는 바깥 클래스의 인스턴스 내부에서 구성 요소로 사용된다. 

<br>

---

#### 1.3.2 내부 클래스 사용하는 경우

내부 클래스를 어떻게 활용하는지 알아보자.

<br>

<p align="center">   <img src="img/inner3.png" alt="nested" style="width: 100%;"> </p>

```java
public class CarMain {
    public static void main(String[] args) {
        Car myCar = new Car("Model Y", 100);
        myCar.start();
    }
}
```

* 리펙토링 전
  * `Engine` 클래스는 `Car` 클래스에서만 사용된다
  * 엔진을 시작하기 위해서 차의 충전 레벨과 모델명이 필요함
    * `Car` 인스턴스의 참조를 생성자에 보관
    * 충전 레벨과, 모델명 확인을 위한 메서드 필요 → 이 메서들은 엔진에서만 사용하고, 다른 곳에서는 사용하지 않는다
  * 결국 `Car` 클래스는 엔진에서만 사용하는 기능을 위해서 메서드를 추가해, 충전 레벨과 모델명을 외부에 노출해야 함



* `Engine`클래스를 내부 클래스로 리펙토링 후
  * `Car`의 인스턴스 변수인 `chargeLevel`, `model`에 직접 접근 가능
  * 바깥 클래스에서 내부 클래스의 인스턴스를 생성할 때 내부 클래스의 인스턴스는 자신을 생성한 바깥 클래스의 인스턴스를 자동으로 참조한다
  * 여기서 `new Engine()` 로 생성된 `Engine` 인스턴스는 자신을 생성한 바깥의 `Car` 인스턴스를 자동으로 참조한다



* 리펙토링을 통해서 `getModel()`, `getChargeLevel()`과 같은 메서드를 제거했다
  * 기존에는 해당 메서드들을 통해서 `Car` 클래스의 정보들이 추가로 외부에 노출되고 있기 때문에 캡슐화가 잘 되지 않았다
  * 메서드를 제거해서 결과적으로 꼭 필요한 메서드만 노출함으로써 `Car`의 캡슐화를 높일 수 있다

<br>

---

### 1.4 지역 클래스(Local Class)

















---

## 8) 익명클래스(Anonymous Class)

* 이름이 없는 일회용 클래스
* 정의와 생성을 동시에 한다

<br>

[```AnonymousClassMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/collections/AnonymousClassMain.java)

```java
interface Greeting {
    void greet();
}

public class AnonymousClassMain {
    public static void main(String[] args) {
        // 익명 클래스 정의와 생성 (Greeting 인터페이스 구현)
        // 클래스의 인스턴스를 참조할 수 있는 참조 변수를 사용
        // 클래스 그 자체는 이름이 없음
        Greeting anonymousGreeting = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Greetings from the anonymous class!");
            }
        };
        // 익명 클래스의 메서드 호출
        anonymousGreeting.greet();
    }
}
```

```
Greetings from the anonymous class!
```

<br>
