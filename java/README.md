> Java 기본 개념 및 문법

## Index

---

1. [자바 소개(Introduction of Java)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(1)%20StartingJava.md)
   * High Level Language
   * Translator
   * Execution and Compiling in Java
   * Java Memory Structure
     * Method Area
     * Stack Area
     * Heap Area
2. [변수(Variables)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(2)%20Variables.md)
   * Variables
     * Primitive Type
     * Reference Type
   * Convention for Java
3. [연산자(Operators)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(3)%20Operators.md)
   * Arithmetic Operator
   * Comparison Operator
     * Number Compare
     * String Compare
   * Logical Operator
   * Assignment Operator
4. [조건문(Conditional)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(4)%20Conditional.md)
   * ```if```, ```else if```
   * ```switch```
   * 삼항연산자(Ternary Operator)
5. [반복문(Loop)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(5)%20Loop.md)
   * ```while```
   * ```do-while```
   * ```for```
   * ```for-each```
6. [형변환(Type Casting)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(6)%20Typecasting.md)
   * 자동 형변환(Widening Type Casting)
   * 명시적 형변환(Narrow Type Casting)
7. [배열(Array)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(7)%20Array.md)
   * 배열이란(Array)
   * Using Arrays
   * 2D Array
8. [메서드(Method)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(8)%20Method.md)
   * Method
   * Static Method
   * Overloading
9. [클래스(Class)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(9)%20Class.md)
   * Class & Instance
   * 객체 배열(Array of Instances)
10. [기본형과 참조형(Primitive Type & Reference Type)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(10)%20Reference%20Type.md)
    * Primitive vs Reference
    * 참조형 변수 대입
    * ```null```
    * NullPointerException(NPE)
11. [객체지향 프로그래밍(OOP)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(11)%20OOP.md)
    * OOP vs POP
    * Instance Method
    * OOP Example
    * 캡슐화(Encapsulation)
12. [생성자(Constructor)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(12)%20Constructor.md)
    * Constructor
    * ```this```
    * 생성자 사용 조건
    * 기본 생성자(Default Constructor)
    * 생성자 오버로딩(Constructor Overloading)
    * ```this()```
13. [패키지(Package)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(13)%20Package.md)
    * Package
    * ```import```
    * Package Convention
14. [접근 제어자(Access Modifier)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(14)%20Access%20Modifier.md)
    * Access Modifier
    * Using Access Modifiers
      * Field, Method
      * Constructor
      * Class
    * 캡슐화(Encapsulation)
15. [Static](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(15)%20Static.md)
    * Static
    * Static Variable
    * Static Method
    * ```static import```
16. [```final```](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(16)%20Constant.md)
    * ```final```
    * ```final``` for local variable
    * ```final``` for field
    * constant
17. [상속(Inheritance)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(17)%20Inheritance.md)
    * Inheritance
    * Single Inheritance
    * Java Inheritance Memory Allocation
    * Method Overriding
    * ```protected```
    * ```super```
    * ```super()```
18. [다형성(Polymorphism)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(18)%20Polymorphism.md)
    * Polymorphism
    * Casting
    * ```instanceof```
    * Method Overriding
    * Usage of Polymorphism
    * Abstract Class (```abstract```)
    * Interface (```interface```)
20. [예외 처리(Exception Handling)](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(20)%20Exception.md)
    * Exception, Error
    * Exception Handling
    * Exception Variable
    * Multi Catch
    * ```throw```
    * Checked, Unchecked Exception
    * ```throws```
    * ```try-catch-finally```
    * ```try with resource```
    * User Defined Exception
21. [```java.time```패키지](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(21)%20Date%26Time.md)
    * ```Date```
    * ```Calendar```
    * ```java.time```
      * ```LocalDate```
      * ```LocalTime```
      * ```LocalDateTime```
      * ```ZonedDateTime```
    * ```Period```, ```Duration```
    * ```Instant```
    * Formatter
22. [```Collection``` Framework](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(22)%20Collection.md)
    * ```Collection``` Framework
    * ```Collection```
    * ```Iterator```
    * ```List```
      * ```ArrayList```
      * ```LinkedList```
    * ```Set```
      * ```HashSet```
      * ```TreeSet```
    * ```Map```
      * ```HashMap```
    * ```Stack```, ```Queue```, ```ArrayDeque```
      * ```ArrayDeque```
    * Anonymous Class
    * ```Comparable``` & ```Comparator```
      * ```Comparable```
      * ```Comparator```
23. [제네릭스(Generics)]()
24. [스트림(Stream)]()
    * Lambda
25. [쓰레드(Thread)]()



<br>

## Requirements

---

* Java 8

<br>

---

## P.S.

---

* 모든 다이어그램은 UML 표준을 준수하지 않았습니다
* 전부 작성 후 교차 검증 예정

<br>

## 추가 예정

* [~~익명 클래스(anonymous class)~~](https://github.com/seungki1011/Data-Engineering/blob/main/java/notes/(22)%20Collection.md#8-anonymous-class) (Updated on 2024/01/16 - ```Collection```)
* 내부 클래스(inner class)
* 연결된 예외(chained exception)
* ```DecimalFormat```
* ```SimpleDateFormat```
* ```Collections```

<br>

## Reference

---

1. [김영한의 자바 입문](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%9E%90%EB%B0%94-%EC%9E%85%EB%AC%B8)

2. [김영한의 자바 기본](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B8%B0%EB%B3%B8%ED%8E%B8/dashboard)

3. [자바의 정석 기초편](https://www.youtube.com/user/MasterNKS)

4. [Java docs](https://docs.oracle.com/javase/8/docs/api/overview-summary.html)

5. [Wikipedia Bitwise Operation](https://en.wikipedia.org/wiki/Bitwise_operation)

6. [Wikipedia Diamond Problem](https://en.wikipedia.org/wiki/Multiple_inheritance#The_diamond_problem)

7. [점프 투 자바 - 인터페이스](https://wikidocs.net/217)

8. [Tistory Inpa Dev - Java NULL](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EA%B0%9C%EB%B0%9C%EC%9E%90%EB%93%A4%EC%9D%84-%EA%B4%B4%EB%A1%AD%ED%9E%88%EB%8A%94-NULL-%ED%8C%8C%ED%97%A4%EC%B9%98%EA%B8%B0)

9. [geeksforgeeks - strings in java](https://www.geeksforgeeks.org/strings-in-java/)

10. [geeksforgeeks - compilation execution in java](https://www.geeksforgeeks.org/compilation-execution-java-program/)

11. [geeksforgeeks - typecasting in java](https://www.geeksforgeeks.org/typecasting-in-java/)

12. [geeksforgeeks - multidimensional arrays in java](https://www.geeksforgeeks.org/multidimensional-arrays-in-java/)

13. [geeksforgeeks - difference between oop and pop](https://www.geeksforgeeks.org/difference-between-oop-and-pop/)

14. [geeksforgeeks - java memory management](https://www.geeksforgeeks.org/java-memory-management/)

15. [geeksforgeeks - java collections guide](https://www.geeksforgeeks.org/how-to-learn-java-collections-a-complete-guide/)

16. [codelatte - java programming basic](https://www.codelatte.io/courses/java_programming_basic/KUYNAB4TEI5KNSJV)

17. [w3schools - java inheritance](https://www.w3schools.com/java/java_inheritance.asp)

18. [javatpoint - super](https://www.javatpoint.com/super-keyword)

19. [helpteaching - high level and low level languages](https://www.helpteaching.com/lessons/1285/high-level-low-level-languages)

20. [baeldung - java foreach and counter](https://www.baeldung.com/java-foreach-counter)

21. [simplilearn - type casting in java](https://www.simplilearn.com/tutorials/java-tutorial/type-casting-in-java)

22. [tcpschool - c array 2dimensional](https://tcpschool.com/c/c_array_twoDimensional)

23. [javacodemonk - java exception class hierarchy](https://www.javacodemonk.com/java-exception-class-hierarchy-92e8224e)

24. [https://www.cs.emory.edu/~cheung/Courses/170/Syllabus/10/scope.html](https://www.cs.emory.edu/~cheung/Courses/170/Syllabus/10/scope.html)

25. [https://www.iitk.ac.in/esc101/05Aug/tutorial/essential/exceptions/definition.html](https://www.iitk.ac.in/esc101/05Aug/tutorial/essential/exceptions/definition.html)

26. https://www.nextree.co.kr/p6960/

27. https://st-lab.tistory.com/243

    
