## 1) ```Collection``` Framework

* ```Collection```(다수의 객체)을 다루기 위한 프레임워크
* 데이터를 다루기 위한 자료구조를 표현하고 사용할 수 있는 클래스들 제공
* ```Collection```,```List```, ```Set```, ```Map``` 등 과 같은 코어 인터페이스 제공
* 코어 인터페이스를 구현한 ```ArrayList```, ```LinkedList```, ```HashSet```, ```HashMap``` 등 과 같은  클래스들 제공

<br>

---

## 2) ```Collection```



<p align="center">   <img src="img/collection1.png" alt="collection inheritance" style="width: 100%;"> </p>

<p align="center">   <img src="img/collection2.png" alt="map inheritance" style="width: 100%;"> </p>

<p align='center'>geeksforgeeks - java collection inheritence</p>

* [Java docs - ```Collection```](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)

<br>

---

## 3) ```Iterator```

* 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화한 인터페이스
* 컬렉션에 ```iterator()```를 호출해서 ```Iterator```를 구현한 객체를 얻어서 사용한다
* 다시 사용하기 위해서는 새로운 ```Iterator```객체를 선언해야 함
* [Java docs - ```Iterator```](https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html)

<br>

```java
HashSet<String> hashSet = new HashSet<>();
Iterator<String> it = hashSet.iterator(); // Iterator 객체 it를 이용해서 사용

while (it.hasNext())  // 읽어올 요소가 존재하는지 확인
		System.out.println(iterator.next()); // 요소 읽어오기
}

// 다시 사용하기 위해 새로운 객체 사용
it = hashSet.iterator();
```

* ```Map```은 ```iterator()```가 없음
  * ```keySet()```, ```values()``` 등을 호출한 후에 ```iterator()``` 사용

<br>

---

## 4) ```List```

* 순서가 있고, 중복을 허용한다
* [Java docs - ```List```](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)

<br>

### 4.1 ```ArrayList```

* 저장공간으로 배열 사용(배열 기반)

[```ArrayListMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/collections/ArrayListMain.java)

```java
public class ArrayListMain {
    public static void main(String[] args) {

        // 1. ArrayList 생성
      	// Collection<String> fruits = new ArrayList<>(); // Collection 참조 변수를 이용하면 더 flexible함
        ArrayList<String> fruits = new ArrayList<>(); // String 타입만 넣을 수 있는 ArrayList
				
        // 2. ArrayList에 요소를 추가 (add)
        // add(요소)를 사용하면 끝에 추가해줌
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Grape");
        fruits.add("Mango");
        // add(인덱스, 요소) 해당 인덱스 위치에 삽입해줌
        fruits.add(2, "Blueberry"); // 2번 인덱스에 "BlueBerry" 삽입

        // 3. 요소에 접근
        // for-each문 사용
        System.out.println("---------Print the ArrayList(for-each)---------");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        // get() 사용
        System.out.println("-----------Print the ArrayList(get())----------");
        for (int i=0; i< fruits.size(); i++) {
            System.out.println(fruits.get(i)); // i번째 인덱스의 요소 반환
        }

        // 4. ArrayList의 길이 (size)
        System.out.println("-----------------------------------------------");
        System.out.println("fruits의 길이 : "+fruits.size());

        // 5. ArrayList의 요소 제거 (remove)
        System.out.println("-----------------------------------------------");
        String removeFruit = "Apple";
        fruits.remove(removeFruit);
        System.out.println(removeFruit+" has been removed from the ArrayList");

        System.out.println("---------------Updated ArrayList---------------");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println("fruits의 길이 : "+fruits.size());

        // 6. 특정 요소의 포함 여부 (contain)
        System.out.println("-----------------------------------------------");
        String searchFruit = "Grape";
        if (fruits.contains(searchFruit)) {
            System.out.println("The ArrayList contains "+searchFruit);
        } else {
            System.out.println("The ArrayList does not contain "+searchFruit);
        }
    }
}
```

```
---------Print the ArrayList(for-each)---------
Banana
Apple
Blueberry
Grape
Mango
-----------Print the ArrayList(get())----------
Banana
Apple
Blueberry
Grape
Mango
-----------------------------------------------
fruits의 길이 : 5
-----------------------------------------------
Apple has been removed from the ArrayList
---------------Updated ArrayList---------------
Banana
Blueberry
Grape
Mango
fruits의 길이 : 4
-----------------------------------------------
The ArrayList contains Grape
```

* ```remove```를 이용해 요소를 제거하는 과정
  * 삭제할 데이터의 아래 데이터를 전부 한 칸씩 위로 복사 후 덮어씀 → 마지막 데이터는 ```null```로 변경 → ```size``` 값을 하나 감소
  * 복사하는 과정이 부담되기 때문에 ```remove```를 사용하는 경우 끝 인덱스 부터 시작하는 것을 권장
    * 마지막 부터 ```remove```하는 경우 배열 복사가 없음

<br>

---

### 4.2 ```LinkedList```

* 배열의 단점
  * 크기 변경 불가. 더 큰 배열을 사용하기 위해서는 큰 배열 생성 → 복사 → 참조 변경의 과정을 거쳐야 함
  * 앞의 데이터(비순차적인 데이터)를 추가하거나 삭제하는 것이 비효율적



* 배열의 단점 보완을 위한 ```LinkedList```
* 불연속으로 존재하는 데이터를 연결
* Java의 컬렉션 프레임워크의 ```LinkedList```는 양방향 링크드 리스트(double linked list)로 구현되어 있다



* 중간에 요소 추가 또는 삭제가 많으면 ```ArrayList```보다 ```LinkedList```가 더 효율적일 수도 있음
  * 추가나 삭제가 필요하면 배열 복사같은 과정이 아니라 단순히 링크를 변경하면 됨



* 접근의 경우 ```ArrayList```가 더 빠름

<br>

```java
class Node<E> {
  Node<E> next; // 다음 노드 주소
  Node<E> prev; // 이전 노드 주소
  E item; // 데이터 저장
}
```

[```LinkedListMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/collections/LinkedListMain.java)

```java
public class LinkedListMain {
    public static void main(String[] args) {
        // 1. LinkedList 생성
        LinkedList<String> linkedList = new LinkedList<>(); // String 타입만 넣을 수 있는 ArrayList

        // 2. LinkedList에 요소를 추가 (add)
        // add(요소)를 사용하면 끝에 추가해줌
        linkedList.add("Banana");
        linkedList.add("Apple");
        linkedList.add("Apple");

        // 특정 인덱스 위치에 추가
        linkedList.add(2, "Blueberry");
        linkedList.addFirst("Orange"); // 앞에 추가
        linkedList.addLast("Mango"); // 뒤에 추가

        // 3. LinkedList 출력
        System.out.println("---------Print the LinkedList---------");
        for (String item : linkedList) {
            System.out.println(item);
        }
    }
}
```

```
---------Print the LinkedList---------
Orange
Banana
Apple
Blueberry
Apple
Mango
```

* ```ArrayList```와 마찬가지로 ```List```인터페이스를 구현하기 때문에 ```ArrayList```처럼 사용하면 됨

<br>

---

## 5) ```Set```

* 순서가 없고, 중복을 허용하지 않는다
  * 순서를 유지하고 싶으면 ```LinkedHashSet``` 사용 가능
* 집합
* [Java docs - ```Set```](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html)

<br>

### 5.1 ```HashSet```

* 저장에 해쉬 테이블(HasH Table) 사용



* 정렬 불가
  * 정렬을 위해서는 모든 요소를 ```List```에 저장하고 ```List```를 정렬



* ```hashCode()```
  * ```hashCode()```를 구현하는 방법은 다양하다
  * ```Objects.hash(데이터들)``` 같은 형태로 구현 가능



* ```equals()```와 ```hashCode()```를 오버라이드 해야 정상 동작
  * 동일한 객체는 동일한 메모리 주소를 가진다 → 동일한 객체는 동일한 해시코드를 가져야 한다
  * 두 객체가 ```equals()```로 동일하다는 뜻은, 두 객체의 ```hashCode()```도 동일해야 함 
  * 반면에 동일 해시코드 값을 가졌다고 동일 객체라는 보장은 없다



* ```retainAll()``` : 교집합
* ```addAll()``` : 합집합

<br>

[```HashSetMain1.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/collections/HashSetMain1.java)

```java
class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
		
  	// isbn은 고유하다고 가정하고 isbn만 사용 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 현재의 인스턴스가 비교하는 인스턴스(o)와 같은지 확인
        if (o == null || getClass() != o.getClass()) return false; // 같은 클래스인지 확인
        Book book = (Book) o; // isbn은 Object가 아니라 Book에 존재하기 때문에 사용하기 위해서 형변환
        return isbn.equals(book.isbn); // 두 Book 객체의 isbn이 같은지 확인
    }
	
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Title: "+title+", Author: "+author+", ISBN: "+isbn;
    }
}

public class HashSetMain1 {
    public static void main(String[] args) {
        Set<Book> hashSet = new HashSet<>();

        // 1. HashSet에 객체(책) 추가
        hashSet.add(new Book("Title1", "Author1", "ISBN123"));
        hashSet.add(new Book("Title2", "Author2", "ISBN456"));
        hashSet.add(new Book("Title3", "Author3", "ISBN789"));
        hashSet.add(new Book("Title4", "Author2", "ISBN999"));

        // 2. 똑같은 책 추가 시도 - 이미 존재하기 때문에 추가되지 않음
        hashSet.add(new Book("Title3", "Author3", "ISBN789"));

        // 3. HashSet 원소 출력
        for (Book book : hashSet) {
            System.out.println(book);
        }
    }
}
```

```
Title: Title2, Author: Author2, ISBN: ISBN456
Title: Title1, Author: Author1, ISBN: ISBN123
Title: Title4, Author: Author2, ISBN: ISBN999
Title: Title3, Author: Author3, ISBN: ISBN789
```

<br>

[```HashSetMain2.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/collections/HashSetMain2.java)

```java
public class HashSetMain {
    public static void main(String[] args) {
        // 1. HashSet 생성
      	// 요소가 String이면 equals, hashCode 오바라이딩하지 않아도 됨
        HashSet<String> hashSet = new HashSet<>();

        // 2. HashSet에 원소 추가 (중복 비허용)
        hashSet.add("Math");
        hashSet.add("English");
        hashSet.add("Philosophy");
        hashSet.add("Chemistry");
        hashSet.add("Chemistry");

        // 3. Iterator를 사용해서 HashSet의 원소 출력
        System.out.println("----------Print HashSet using Iterator----------");
        System.out.println("Elements in the HashSet:");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 4. 특정 원소가 HashSet에 존재하는지 확인
        System.out.println("------------------------------------------------");
        String searchElement = "Math";
        if (hashSet.contains(searchElement)) {
            System.out.println(searchElement + " is present in the HashSet.");
        } else {
            System.out.println(searchElement + " is not present in the HashSet.");
        }

        // 5. HashSet에서 원소 제거
        System.out.println("------------------------------------------------");
        String removeElement = "Chemistry";
        hashSet.remove(removeElement);
        System.out.println(removeElement + " has been removed from the HashSet.");

        // 6. Updated HashSet 출력
        System.out.println("---------Updated Elements in the HashSet---------");
        for (String fruit : hashSet) {
            System.out.println(fruit);
        }

        // 7. HashSet의 크기
        System.out.println("------------------------------------------------");
        int size = hashSet.size();
        System.out.println("Size of the HashSet: " + size);

        // 8. HashSet 비우기
        hashSet.clear();
        System.out.println("HashSet is now empty.");
    }
}
```

```
----------Print HashSet using Iterator----------
Elements in the HashSet:
English
Chemistry
Math
Philosophy
------------------------------------------------
Math is present in the HashSet.
------------------------------------------------
Chemistry has been removed from the HashSet.
---------Updated Elements in the HashSet---------
English
Math
Philosophy
------------------------------------------------
Size of the HashSet: 3
HashSet is now empty.
```

<br>

---

### 5.2 ```TreeSet```

* 정렬과 탐색에 유리



* Java의 ```TreeSet```은 Red-Black Tree로 구현
  * Red-Black Tree는 Binary Search Tree(BST)의 일종



* ```HashSet```에 비해 데이터 추가, 삭제하는 시간이 더 소요



* ```TreeSet```은 요소들이 정렬이 되어서 들어감
  * ```Comparator``` 또는 ```Comparable``` 사용 (비교 기준이 필요함)

<br>


```java
public class TreeNode<E> {
		E data; // 저장할 객체
  	TreeNode<E> left; // 왼쪽 자식 노드 주소
  	TreeNode<E> right; // 오른쪽 자식 노드 주소
}
```

<br>

[```TreeSetMain1.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/collections/TreeSetMain1.java)

```java
class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        if (this.age > otherPerson.age) { // 먼저 나이부터 비교
            return 1;
        } else if (this.age == otherPerson.age) {
            return this.name.compareTo(otherPerson.name); // 만약 나이가 같으면 이름 비교
        } else {
            return -1;
        }
    }
		
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + " is "+age+" years old.";
    }
}

public class TreeSetMain1 {
    public static void main(String[] args) {
        Set<Person> personSet = new TreeSet<>();

        // 1. 사람 추가
        personSet.add(new Person("Alice", 35));
        personSet.add(new Person("Bob", 17));
        personSet.add(new Person("Charlie", 25));
        personSet.add(new Person("David", 22));
        personSet.add(new Person("David", 12));
        personSet.add(new Person("Jessie", 35));
        personSet.add(new Person("Mark", 35));
        personSet.add(new Person("Andy", 25));
        personSet.add(new Person("Andy", 25)); // 중복된 요소는 추가되지 않음

        // 2. 각 요소 출력
        for (Person person : personSet) {
            System.out.println(person);
        }
    }
}
```

```
David is 12 years old.
Bob is 17 years old.
David is 22 years old.
Andy is 25 years old.
Charlie is 25 years old.
Alice is 35 years old.
Jessie is 35 years old.
Mark is 35 years old.
```

* 따로 클래스를 만들어서 사용하는 경우 정렬 기준(```Comparable```, ```Comparator```)을 구현해야 함
  * ```equals```과 ```hashCode```도 구현

<br>

[```TreeSetMain2.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/collections/TreeSetMain2.java)

```java
public class TreeSetMain2 {
    public static void main(String[] args) {
        // 1. 들어갈 데이터가 Integer인 TreeSet 생성
        TreeSet<Integer> treeSet = new TreeSet<>();

        // 2. TreeSet에 요소 추가
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(6);
        treeSet.add(5); // 중복 추가해도 추가되지 않음

        // 3. TreeSet의 요소 출력해보기 - 정렬되어 있는 것을 확인할 수 있음
        for (Integer i : treeSet) {
            System.out.println(i);
        }

        // 4. 가장 첫 요소(가장 작은 요소) 출력
        System.out.println("First Element: "+treeSet.first());

        // 5. 가장 마지막 요소(가장 큰 요소) 출력
        System.out.println("Last Element: "+treeSet.last());

        // 6. 주어진 기준(3) 보다 큰 요소 중에 제일 작은 요소 출력
        System.out.println("Element higher than 3: "+treeSet.higher(3));

        // 7. subSet() - 주어진 범위내의 집합
        System.out.println("treeSet.subSet(2,6) = "+treeSet.subSet(2,6)); // 2이상 6미만

        // 8. headSet() - 주어진 기준(5) 미만의 집합
        System.out.println("treeSet.headSet(5) = "+treeSet.headSet(5));

        // 9. tailSet() - 주어진 기준(6) 이상의 집합
        System.out.println("treeSet.tailSet(6) = "+treeSet.tailSet(6));
    }
}
```

```
1
2
3
5
6
8
First Element: 1
Last Element: 8
Element higher than 3: 5
treeSet.subSet(2,6) = [2, 3, 5]
treeSet.headSet(5) = [1, 2, 3]
treeSet.tailSet(6) = [6, 8]
```

<br>

---

## 6) ```Map```

* 순서가 없고, 키의 중복은 허용하지 않는다 (값의 중복은 가능)
  * 순서 유지가 필요하다면 ```LinkedHashMap``` 사용



* Key-Value 쌍으로 데이터 저장
* ```HashTable```은 동기화 되어있음 (Synchronization o)
* ```HashMap```은 동기화 되어있지 않음 (Synchronization x)
* ```TreeMap```은 이진탐색 트리의 속성을 가지고 있음
* [Java docs - ```Map```](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)



* Hashing
  * 해쉬 함수(hash function)로 해시 테이블(hash table)에 데이터를 저장하고 검색
  * 해시 테이블은 배열과 링크드 리스트가 조합된 형태 (사전 비슷하게 생각하면 됨)

<br>

---


### 6.1 ```HashMap```

* 보통 ```HashMap```을 많이 사용함
* ```HashMap```은 동기화 되어있지 않음 (Synchronization x)
* single-thread에서 더 좋은 성능
* 하나의 ```null``` key 가능, 복수의 ```null``` value 허용

<br>

[```HashMapMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/collections/HashMapMain.java)

```java
public class HashMapMain {
    public static void main(String[] args) {
        // HashMap 생성 - student(key) : grade(value)
        Map<String, Integer> studentGrades = new HashMap<>();

        // 1. put() - Add entries to the HashMap
        studentGrades.put("Alice", 90);
        studentGrades.put("Bob", 85);
        studentGrades.put("Charlie", 92);
        studentGrades.put("David", 88);

        // 2. HashMap의 Key-Value 출력해보기
        System.out.println("-----------print entries of HashMap------------");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println("Key: "+entry.getKey()+", Value: "+entry.getValue());
        }

        // 2. get() - Retrieve the grade for a specific student
        System.out.println("-------retrieve value of a specific key--------");
        int charlieGrade = studentGrades.get("Charlie");
        System.out.println("Charlie's Grade: " + charlieGrade);

        // 3. containsKey() - Check if the HashMap contains a specific key
        System.out.println("-----------------------------------------------");
        boolean hasAlice = studentGrades.containsKey("Alice");
        System.out.println("Does it contain Alice?: " + hasAlice);

        // 4. size() - Get the number of entries in the HashMap
        int numberOfStudents = studentGrades.size();
        System.out.println("Number of Students: " + numberOfStudents);

        // 5. keySet() - Get a set of all keys in the HashMap
        System.out.println("Students: " + studentGrades.keySet());

        // 6. values() - Get a collection of all values in the HashMap
        System.out.println("Grades: " + studentGrades.values());

        // 7. entrySet() - Get a set of key-value pairs (entries) in the HashMap
        System.out.println("Entries: " + studentGrades.entrySet());

        // 8. remove() - Remove a specific entry from the HashMap
        studentGrades.remove("Bob");
        System.out.println("HashMap after removing Bob: " + studentGrades);

        // 9. clear() - Remove all entries from the HashMap
        studentGrades.clear();
        System.out.println("HashMap after clearing: " + studentGrades);
    }
}
```

```
-----------print entries of HashMap------------
Key: Bob, Value: 85
Key: Alice, Value: 90
Key: Charlie, Value: 92
Key: David, Value: 88
-------retrieve value of a specific key--------
Charlie's Grade: 92
-----------------------------------------------
Does it contain Alice?: true
Number of Students: 4
Students: [Bob, Alice, Charlie, David]
Grades: [85, 90, 92, 88]
Entries: [Bob=85, Alice=90, Charlie=92, David=88]
HashMap after removing Bob: {Alice=90, Charlie=92, David=88}
HashMap after clearing: {}
```

<br>

---

## 7) ```Stack```, ```Queue```, ```ArrayDeque```

* ```Stack``` : Last in First Out (LIFO)
* ```Queue``` : First in First Out (FIFO)
* ```ArrayDeque```는 ```Stack```, ```Queue```의 기능 모두 포함
* [Java docs - ```ArrayDeque```](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html)

<br>

---

### 7.1 ```ArrayDeque```

* ```Stack``` 보다 많이 사용
* 양 끝에서 삽입과 반환이 가능함

<br>

[```ArrayDequeMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/collections/ArrayDequeMain.java)

```java
public class ArrayDequeMain {
    public static void main(String[] args) {
        // ArrayDeque 생성
        ArrayDeque<String> taskQueue = new ArrayDeque<>();

        // 1. addFirst(), addLast() 사용
        // addFirst() - 요소를 앞에서 부터 삽입
        System.out.println("---------Using addFirst(), addLast()---------");
        taskQueue.addFirst("Task 1");
        taskQueue.addFirst("Task 2");

        // addLast() - 요소를 뒤에서 부터 삽입
        taskQueue.addLast("Task 3");
        taskQueue.addLast("Task 4");

        // deque 출력
        System.out.println(taskQueue);
        // deque 비우기
        taskQueue.clear();

        // 2. offerFirst(), offerLast() 사용
        // 요소를 삽입하는 동작 자체는 addFirst, addLast와 똑같음
        System.out.println("-------Using offerFirst(), offerLast()-------");
        taskQueue.offerFirst("Task A");
        taskQueue.offerFirst("Task B");

        taskQueue.offerLast("Task C");
        taskQueue.offerLast("Task D");

        System.out.println(taskQueue);
        taskQueue.clear();

        // 3. push, pop 사용
        System.out.println("-------Using push()-------");
        // push()는 요소를 앞에 삽입
        taskQueue.push("Urgent Task 1");
        taskQueue.push("Urgent Task 2");

        System.out.println(taskQueue);

        // pop()은 앞의 요소 제거 후 반환
        System.out.println("The returned element after pop(): "+taskQueue.pop());
        System.out.println("The returned element after pop(): "+taskQueue.pop());

        System.out.println("-------After pop()-------");
        System.out.println(taskQueue);
    }
}
```

```
---------Using addFirst(), addLast()---------
[Task 2, Task 1, Task 3, Task 4]
-------Using offerFirst(), offerLast()-------
[Task B, Task A, Task C, Task D]
-------Using push()-------
[Urgent Task 2, Urgent Task 1]
The returned element after pop(): Urgent Task 2
The returned element after pop(): Urgent Task 1
-------After pop()-------
[]
```

* ```offerFirst```, ```offerLast```는 ```addFirst```, ```addLast```와 다르게 큐의 크기 문제가 발생시 ```false```를 반환한다. (```addFirst```는 ```IllegalStateException``` )

> `IllegalStateException` - if the element cannot be added at this time due to capacity restrictions

<br>

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

---

## 9) ```Comparable``` & ```Comparator```

* 객체를 비교하기 위해서 사용(정렬 기준을 제시)
* ```sort()``` 디폴트는 오름차순
* ```compareTo``` 또는 ```compare```를 통해서 사용자가 정한 기준을 토대로 양수, 0, 음수 중 하나가 반환 → 정렬 기준에 사용

<br>

### 9.1 ```Comparable```

* ```Comparable``` 인터페이스
  * ```compareTo(T o)``` 메서드 구현
* 자기 자신과 매개변수 객체 비교
* [Java docs - ```Comparable```](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)

<br>

[```ComparableMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/collections/ComparableMain.java)

```java
class Fruit implements Comparable<Fruit> {
    private String name;
    private int quantity;

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Implement compareTo method for natural ordering(오름차순)
    @Override
    public int compareTo(Fruit other) {
        // 자기 자신의 quantity와 넘긴 매개변수 객체의 quantity 비교
        /*
        if(this.quantity > other.quantity) {
            return 1;
        } else if (this.quantity == other.quantity) {
            return 0;
        } else {
            return -1;
        }
        */
        return this.quantity - other.quantity; // 범위 넘어가는 경우 주의
      	// 내림차순으로 정렬하고 싶은 경우
      	// return -(this.quantity - other.quantity);
    }		

    @Override
    public String toString() {
        return "Fruit{name='" + name + "', quantity=" + quantity + '}';
    }
}

public class ComparableMain {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Apple", 10));
        fruits.add(new Fruit("Banana", 5));
        fruits.add(new Fruit("Orange", 8));
        fruits.add(new Fruit("Orange", 2));

        // Sort using natural ordering (compareTo method)
        Collections.sort(fruits);

        // Print sorted list
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```

```
Fruit{name='Orange', quantity=2}
Fruit{name='Banana', quantity=5}
Fruit{name='Orange', quantity=8}
Fruit{name='Apple', quantity=10}
```

* ```compareTo```를 구현할 때 두 값을 빼는 경우, 타입 범위를 넘어서는 것을 주의하자
  * 필요한 경우 그냥 ```if-else```문으로 구현



* 만약 ```quantity```가 아니라 ```name```의 사전순서로 정렬하는 경우

<br>

```java
@Override
public int compareTo(Fruit other) {
    return this.name.compareTo(other.name); // String의 compareTo를 사용(Comparable의 compareTo와 다름)
}
```

```
Fruit{name='Apple', quantity=10}
Fruit{name='Banana', quantity=5}
Fruit{name='Orange', quantity=8}
Fruit{name='Orange', quantity=2}
```

<br>

---

### 9.2 ```Comparator```

* ```Comparator``` 인터페이스
  * ```compare(T o1, T o2)``` 메서드 구현
* 두 매개변수 객체 비교
* [Java docs - ```Comparator```](https://docs.oracle.com/javase/8/docs/api/index.html?java/util/Comparator.html)
* ```Comparator```를 구현해서 사용할 수 도 있지만, 익명 클래스를 사용하면 코드가 더 일관성 있음
  * 익명 객체를 여러개 생성해서 다른 비교를 위해 사용하는 것도 가능

<br>

[```ComparatorMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/collections/ComparatorMain.java)

```java
class Fruit2 {
    private String name;
    int quantity; // 편의상 private 생략, 원래는 get 메서드를 정의해서 데이터를 접근해야함

    public Fruit2(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Fruit{name='" + name + "', quantity=" + quantity + '}';
    }
}

public class ComparatorMain {
    public static void main(String[] args) {
        List<Fruit2> fruits = new ArrayList<>();
        fruits.add(new Fruit2("Apple", 10));
        fruits.add(new Fruit2("Grape", 19));
        fruits.add(new Fruit2("Banana", 5));
        fruits.add(new Fruit2("Orange", 8));
        fruits.add(new Fruit2("Orange", 2));

        Collections.sort(fruits, comparator); // 아래에서 정의한 comparator 사용

        // Print sorted list
        for (Fruit2 fruit : fruits) {
            System.out.println(fruit);
        }
    }
    // 익명 클래스를 사용해서 Comparator의 기능 사용
    public static Comparator<Fruit2> comparator = new Comparator<Fruit2>() {
        @Override
        public int compare(Fruit2 o1, Fruit2 o2) {
            return o1.quantity - o2.quantity; // 오름차순 정렬 가능
          	// return (o1.name1).compareTo(o2.name2) // name을 기준으로 
        }
    };
  	
  	// 익명 클래스 하나더 생성해서 사용가능
    public static Comparator<Fruit2> comparator2 = new Comparator<Fruit2>() {
        @Override
        public int compare(Fruit2 o1, Fruit2 o2) {
            return -(o1.quantity - o2.quantity); // 내림차순 정렬 가능
        }
    };
}
```

```
Fruit{name='Orange', quantity=2}
Fruit{name='Banana', quantity=5}
Fruit{name='Orange', quantity=8}
Fruit{name='Apple', quantity=10}
Fruit{name='Grape', quantity=19}
```

<br>

---

## Reference

1. [패스트 캠퍼스 - 한번에 끝내는 데이터 엔지니어링](https://fastcampus.co.kr/data_online_engineering)
1. [https://www.geeksforgeeks.org/how-to-learn-java-collections-a-complete-guide/](https://www.geeksforgeeks.org/how-to-learn-java-collections-a-complete-guide/)
1. [https://st-lab.tistory.com/243](https://st-lab.tistory.com/243)