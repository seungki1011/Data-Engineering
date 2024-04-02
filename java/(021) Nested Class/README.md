## Table of Contents



---

## 1) 내부 클래스(Inner Class)

내부 클래스에 대해서 알아보자. 

내부 클래스는 아주 간단히 이야기 하자면 클래스 안의 클래스이다.

<br>

```java
class A { // 외부 클래스
  
  class B { // 내부 클래스
    
  }
}
```

<br>

```java
public class ExternalClass { // ExternalClass는 InnerClass의 외부 클래스
    
    String externalString = "This is a member of the External Class!";
    InternalClass internalClass = new InternalClass();
    
    class InternalClass { // 내부 클래스
        public void method() {
            System.out.println(externalString); // 객체 생성 없이 외부 클래스 멤버에 바로 접근 가능
        }
    }
}
```

* 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근 가능 (`B` → `A` 클래스)
* 기존에는 다른 클래스에서 멤버를 접근해서 사용하기 위해서는 객체를 생성해서 사용했어야 함
* 내부 클래스는 객체 생성 없이 외부 클래스의 멤버 접근 가능
* 캡슐화를 활용 가능
  * 내부 클래스를 외부 클래스 안에 숨겨둬서 밖에서 쉽게 접근하지 못하도록 한다

<br>

```java
public class InnerMain {
    public static void main(String[] args) {
        ExternalClass externalClass = new ExternalClass(); // 외부 클래스의 객체를 먼저 생성해야 내부클래스의 객체 생성해서 사용가능
        ExternalClass.InternalClass internalClass = externalClass.new InternalClass();

        System.out.println("externalClass.externalString = "+externalClass.externalString);
        System.out.print("internalClass.method() 실행 : ");
        internalClass.method();
    }
}
```

* 내부 클래스에 사용가능한 제어자는 변수의 제어자와 동일(기존에 클래스는 `default`, `public`만 가능했음)