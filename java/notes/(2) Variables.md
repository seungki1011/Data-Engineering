## 1) Variables

### 변수

* 값을 보관해고 재사용하기 위해 데이터를 담을 그릇이 존재하면 편하다
* 대부분 프로그래밍 언어는 변수(variable)라는 것을 통해 이런 기능을 제공
* ```[접근제어자] [자료형] [변수명]```

### 상수

* 상수의 경우 중간에 값이 변할 수 없음
* 초기값을 끝까지 사용
* ```final```을 이용해서 선언

### Primitive Type

#### 정수형

* ```byte``` : -128 ~ 127
* ```short``` : -32768 ~ 32767 
* ```int``` : -2147483648 ~ 2147483647
* ```long``` : - 9223372036854775808 ~ 9223372036854775807

#### 실수형

* ```float``` : single-precision 64-bit IEEE 754 floating point
* ```double``` : double-precision 64-bit IEEE 754 floating point

#### 문자형

* ```char``` : 단일 문자 표현
  * ```''```사용
* ```String```은 참조형 자료형이다

#### 논리형

* boolean : ```true```or ```false```

### Reference Type

* 기본 자료형이 아닌 모든 자료형은 참조 자료형
* 자바의 인스턴스를 가리킬 수 있는 자료형
* 메모리 주소를 저장한다
  * 참조형 변수는 객체의 주소를 저장하는 것을 숙지하자
* 대표적으로 ```String```

```java
public class VarType {
    public static void main(String[] args) {
        // Integer(정수형)
        int a = 99;
        // Long(정수형), Long은 뒤에 대문자 L 이용 권장
        long b = 888L;
        // Double(실수형)
        double c = 999.9d;
        // Boolean(논리형), true or false
        boolean d = true;
        // Character(문자 하나)
        char e = 'A';
        // String(문자열), 쌍따옴표
        String f = "This is a String";

        // 각 변수 출력
        System.out.println("int a : "+a);
        System.out.println("long b : "+c);
        System.out.println("double c : "+b);
        System.out.println("boolean d : "+d);
        System.out.println("char e : "+e);
        System.out.println("String f : "+false);

        // 숫자 자료형의 MinMax 출력
        System.out.println("Min of int : "+Integer.MIN_VALUE);
        System.out.println("Max of int : "+Integer.MAX_VALUE);

        System.out.println("Min of long : "+Long.MIN_VALUE);
        System.out.println("Max of long : "+Long.MAX_VALUE);

        System.out.println("Min of double : "+Double.MIN_VALUE);
        System.out.println("Max of double : "+Double.MAX_VALUE);
    }
}
```

```
> Task :VarType.main()
int a : 99
long b : 999.9
double c : 888
boolean d : true
char e : A
String f : false
Min of int : -2147483648
Max of int : 2147483647
Min of long : -9223372036854775808
Max of long : 9223372036854775807
Min of double : 4.9E-324
Max of double : 1.7976931348623157E308
```

## 2) Java Convention

Java의 경우 CamelCase를 이용하는 것이 사실상 표준

### 변수

* 첫글자는 소문자, 나머지 의미 구분을 위한 단어 단위의 첫 글자는 대문자
* 예시 ```camelCase```, ```myAccount```

### 클래스

* 첫글자는 대문자
* 예시 ```Main```, ```OrderDetail```

### 상수

* 상수는 모든 글자를 대문자 사용, 단어구분은 언더바 사용
* 예시 ```PI```, ```ORDER_LIMIT```

### 패키지

* 패지키는 모든 글자를 소문자 사용
* 예시 ```com.de.java```



## 3) P.S.

* 정수는 ```int```, ```long```
  * 20억이 넘어가는 경우 ```long``` 사용
* 실수는 ```double```
  * ```float```는 정밀도가 너무 낮음
* 문자는 ```String``` 이용하자



## 참고

---

1. [김영한의 자바 입문](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%9E%90%EB%B0%94-%EC%9E%85%EB%AC%B8)
1. [자바의 정석-기초편](https://www.youtube.com/user/MasterNKS)