## 1) loop

* 반복문은 특정 코드를 반복하기 위해 사용
* ```break```로 반복문 탈출하거나, ```continue```로 다시 조건식으로 다시 돌아갈 수 있음
  * ```continue```를 사용하는 경우 뒤에 오는 코드는 무시하고 돌아감

* 중첩 반복문을 통해 이중, 삼중 반복문을 구현 가능 (nested loop)

## 2) while

* 조건식이 참이면 코드 블럭 실행, 거짓이면 ```while```문 탈출
* 참인 경우 코드 블럭 실행이 끝난후 다시 조건식 검사
* 종료 시점이 명확하지 않은 경우 ```for```문에 비해 유용할 수 있음

[아래코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/loop/loop1.java)

```java
public class loop1 {
    public static void main(String[] args) {
        // while문
        int cnt = 0;
        while (cnt < 5) {
            cnt++; // cnt 1 증가
            // cnt += 1;
            System.out.println("Current cnt is : " + cnt);
        }
    }
}
```

```
Current cnt is : 1
Current cnt is : 2
Current cnt is : 3
Current cnt is : 4
Current cnt is : 5
```

## 3) do-while

* ```do```안의 코드를 먼저 한번 실행 후 조건 검사 (최초 한번은 무조건 실행)

[아래 코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/loop/loop2.java)

```java
public class loop2 {
    public static void main(String[] args) {
        // 1. do-while 1
        int cnt = 0;
        do {
            cnt++;
            System.out.println("cnt is " + cnt);
        } while(cnt < 3);

        // 2. do-while 2
        int i = 3;
        do {
            System.out.println("do will execute first");
        } while(i < 2);
    }
}
```

```
cnt is 1
cnt is 2
cnt is 3
do will execute first
```

## 4) for

* 반복 횟수가 정해져 있을때 주로 사용
* 초기값, 조건식, 증감식과 같이 반복에 대한 규칙이 한줄에 모두 들어있어서 가독성이 더 좋음
* 복잡한 조건이 필요한 경우 ```while```문이 더 적합할 수 있음

```java
for(초기값; 조건식; 증감식) {
  실행 코드 블럭
}
```

[아래 코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/loop/loop3.java)

```java
public class loop3 {
    public static void main(String[] args) {
        for (int i=0; i <= 5; i++){
            System.out.println("current i is " + i);
        }
    }
}
```

```
current i is 0
current i is 1
current i is 2
current i is 3
current i is 4
current i is 5
```

## 5) for-each

* 인덱스를 접근하기는 ```for```문이 더 쉬움
  * ```for-each```는 인덱스를 사용하기 어려움

* 배열이나 collection 등에 사용 가능
* intellij에서 ```iter```으로 간단히 생성 가능
* 파이써닉 코딩과 비슷하다고 느낌

[아래 코드](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/loop/loop4.java)

```java
public class loop4 {
    public static void main(String[] args) {
        // 1. for-each 1
        int[] numbers = {1, 2, 3};
        for (int number : numbers) {
            System.out.println(number);
        }

        // 2. for-each 2
        String[] studentNames = {"Bob", "Mike", "Shawn", "Merry"};
        for (String name : studentNames) {
            System.out.println(name);
        }
    }
}
```

```
1
2
3
Bob
Mike
Shawn
Merry
```



## 참고

---

1. [김영한의 자바 입문](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%9E%90%EB%B0%94-%EC%9E%85%EB%AC%B8)
1. [자바의 정석-기초편](https://www.youtube.com/user/MasterNKS)
1. [https://www.baeldung.com/java-foreach-counter](https://www.baeldung.com/java-foreach-counter)
