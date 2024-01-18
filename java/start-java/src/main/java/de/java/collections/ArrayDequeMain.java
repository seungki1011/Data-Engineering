package de.java.collections;

import java.util.ArrayDeque;

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
