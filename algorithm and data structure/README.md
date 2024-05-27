>자료구조와 알고리즘에 대한 설명 및 구현. 
>
>자료구조는 자바의 컬렉션 프레임워크와 함께 설명.
>
>자바, 파이썬 이용.
>
>참고
>
>* [김영한 실전 자바](https://www.inflearn.com/roadmaps/744)
>* [자료구조 - Data Structures with Python](https://www.youtube.com/watch?v=PIidtIBCjEg&list=PLsMufJgu5933ZkBCHS7bQTx0bncjwi4PK)
>* [쉬운코드 - 데이터구조](https://www.youtube.com/watch?v=-2YpvLCT5F8&list=PLcXyemr8ZeoR82N8uZuG9xVrFIfdnLd72)

---

## Index

### 1) 자료 구조(Data Structures) with Java Collection

1. [Array]((001)DataStructure/(001)Array)
   * [자료구조(Data Structure)]((001)DataStructure/(001)Array#1-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0data-structure)
     * [자료구조란?]((001)DataStructure/(001)Array#11-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0%EB%9E%80)
     * [Big-O 표기법]((001)DataStructure/(001)Array#12-big-o-%ED%91%9C%EA%B8%B0)
       * Big-O 설명
       * Big-O 표기법 특징
   * [배열(`Array`)]((001)DataStructure/(001)Array#2-%EB%B0%B0%EC%97%B4array)
     * [배열 설명]((001)DataStructure/(001)Array#21-%EB%B0%B0%EC%97%B4-%EC%84%A4%EB%AA%85)
     * [배열 기능 구현]((001)DataStructure/(001)Array#22-%EB%B0%B0%EC%97%B4-%EA%B8%B0%EB%8A%A5-%EA%B5%AC%ED%98%84)
     * [배열의 성능과 한계]((001)DataStructure/(001)Array#23-%EB%B0%B0%EC%97%B4%EC%9D%98-%EC%84%B1%EB%8A%A5%EA%B3%BC-%ED%95%9C%EA%B3%84)
2. [List]((001)DataStructure/(002)List)
   * [`ArrayList`]((001)DataStructure/(002)List#1-arraylist)
     * [`ArrayList` 설명]((001)DataStructure/(002)List#11-arraylist-%EC%84%A4%EB%AA%85)
     * [`ArrayList` 구현]((001)DataStructure/(002)List#12-arraylist-%EA%B5%AC%ED%98%84)
     * [`ArrayList`의 한계]((001)DataStructure/(002)List#13-arraylist%EC%9D%98-%ED%95%9C%EA%B3%84)
   * [`LinkedList`]((001)DataStructure/(002)List#2-linkedlist)
     * [`LinkedList` 설명]((001)DataStructure/(002)List#21-linkedlist-%EC%84%A4%EB%AA%85)
       * 앞에 데이터(노드) 추가
       * 앞에 데이터(노드) 삭제
       * 특정 위치에 데이터(노드) 추가
     * [`LinkedList` 구현]((001)DataStructure/(002)List#22-linkedlist-%EA%B5%AC%ED%98%84)
   * [`ArrayList` vs `LinkedList`]((001)DataStructure/(002)List#3-arraylist-vs-linkedlist)
   * [`Collection` 프레임워크 소개]((001)DataStructure/(002)List#4-collection-%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8C%ED%81%AC-%EC%86%8C%EA%B0%9C)
   * [`List` 인터페이스]((001)DataStructure/(002)List#5-list-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4)
     * [`List` 설명]((001)DataStructure/(002)List#51-list-%EC%84%A4%EB%AA%85)
     * [추가적인 성능비교]((001)DataStructure/(002)List#52-%EC%B6%94%EA%B0%80%EC%A0%81%EC%9D%B8-%EC%84%B1%EB%8A%A5-%EB%B9%84%EA%B5%90)
       * `MyArrayList` vs `ArrayList`
       * `ArrayList` vs `LinkedList`

     * [`List` 인터페이스 사용해보기]((001)DataStructure/(002)List#53-list-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%B3%B4%EA%B8%B0)
3. [Set]((001)DataStructure/(003)Set)
   * [`Set`]((001)DataStructure/(003)Set#1-set)
     * [`Set` 설명]((001)DataStructure/(003)Set#11-set-%EC%84%A4%EB%AA%85)
     * [`Set` 간단 구현]((001)DataStructure/(003)Set#12-set-%EA%B0%84%EB%8B%A8-%EA%B5%AC%ED%98%84)
   * [Hash Algorithm]((001)DataStructure/(003)Set#2-hash-algorithm)
     * [해시 알고리즘 원리]((001)DataStructure/(003)Set#21-%ED%95%B4%EC%8B%9C-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%9B%90%EB%A6%AC)
     * [해시 충돌(Hash Collision)]((001)DataStructure/(003)Set#22-%ED%95%B4%EC%8B%9C-%EC%B6%A9%EB%8F%8Chash-collision)
     * [해시 인덱스 성능]((001)DataStructure/(003)Set#23-%ED%95%B4%EC%8B%9C-%EC%9D%B8%EB%8D%B1%EC%8A%A4-%EC%84%B1%EB%8A%A5)
   * [`hashCode()`]((001)DataStructure/(003)Set#3-hashcode)
     * [문자열 해시 코드]((001)DataStructure/(003)Set#31-%EB%AC%B8%EC%9E%90%EC%97%B4-%ED%95%B4%EC%8B%9C-%EC%BD%94%EB%93%9C)
     * [자바가 제공하는 `hashCode()`]((001)DataStructure/(003)Set#32-%EC%9E%90%EB%B0%94%EA%B0%80-%EC%A0%9C%EA%B3%B5%ED%95%98%EB%8A%94-hashcode)

   * [`HashSet` 구현]((001)DataStructure/(003)Set#4-hashset-%EA%B5%AC%ED%98%84)
   * [`Set` 인터페이스]((001)DataStructure/(003)Set#5-set-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4)
     * [`Set` 인터페이스 설명]((001)DataStructure/(003)Set#51-set-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4-%EC%84%A4%EB%AA%85)
     * [`Set` 인터페이스 사용해보기]((001)DataStructure/(003)Set#52-set-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%B3%B4%EA%B8%B0)
4. [Map]((001)DataStructure/(004)Map)
   * [`Map`]((001)DataStructure/(004)Map#1-map)
     * [`Map` 설명]((001)DataStructure/(004)Map#11-map-%EC%84%A4%EB%AA%85)
     * [`Map` 인터페이스]((001)DataStructure/(004)Map#12-map-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4)
     * [`HashMap` 원리]((001)DataStructure/(004)Map#13-hashmap-%EC%9B%90%EB%A6%AC)
   * [`Map` 사용하기]((001)DataStructure/(004)Map#2-map-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)
5. [Stack, Queue]((001)DataStructure/(005)Stack_Queue)
   * [`Stack`]((001)DataStructure/(005)Stack_Queue#1-stack)
     * [`Stack` 설명]((001)DataStructure/(005)Stack_Queue#11-stack-%EC%84%A4%EB%AA%85)
     * [자바에서 제공하는 `Stack`]((001)DataStructure/(005)Stack_Queue#12-%EC%9E%90%EB%B0%94%EC%97%90%EC%84%9C-%EC%A0%9C%EA%B3%B5%ED%95%98%EB%8A%94-stack)
   * [`Queue`]((001)DataStructure/(005)Stack_Queue#2-queue)
     * [`Queue` 설명]((001)DataStructure/(005)Stack_Queue#21-queue-%EC%84%A4%EB%AA%85)
     * [`Queue` 인터페이스]((001)DataStructure/(005)Stack_Queue#22-queue-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4)
   * [`Deque`]((001)DataStructure/(005)Stack_Queue#3-deque)
     * [`Deque` 인터페이스]((001)DataStructure/(005)Stack_Queue#31-deque-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4)
     * [`Deque` 사용하기]((001)DataStructure/(005)Stack_Queue#32-deque-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)

---

### 2) 자료구조 with Python

1. Tree
2. Graph

---

### 3) 알고리즘(Algorithm)

1. 정렬(Sort)
2. 완전 탐색
3. 분할정복(DaC)
4. 이분 탐색
5. 스택, 큐
6. DFS, BFS
7. Greedy Algorithm
8. DP(다이나믹 프로그래밍)



---

## Requirements

* python 3.10.0
* jupyter notebook
* Java 17 or 21

---

## Further Reading



---

## Reference

1.  [https://www.bigocheatsheet.com/](https://www.bigocheatsheet.com/)
2.  [freecodecamp.org - big o notation why it matters and why it doesnt](https://www.freecodecamp.org/korean/news/big-o-notation-why-it-matters-and-why-it-doesnt-1674cfa8a23c/)
3.  [https://en.wikipedia.org/wiki/Big_O_notation](https://en.wikipedia.org/wiki/Big_O_notation)
4.  [https://www.geeksforgeeks.org/how-to-learn-java-collections-a-complete-guide/](https://www.geeksforgeeks.org/how-to-learn-java-collections-a-complete-guide/)
