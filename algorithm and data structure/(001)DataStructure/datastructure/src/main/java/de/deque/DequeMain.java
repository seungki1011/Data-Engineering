package de.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeMain {
    public static void main(String[] args) {

        Deque<String> deque = new ArrayDeque<>();

        // 데이터 앞에 추가
        deque.offerFirst("cat");
        deque.offerFirst("dog");
        System.out.println(deque);

        // 데이터 뒤에 추가
        deque.offerLast("bird");
        deque.offerLast("fish");
        System.out.println(deque);

        // 제일 앞 요소 조회(단순 조회)
        System.out.println("deque.peekFirst() = " + deque.peekFirst());
        // 마지막 요소 조회(단순 조회)
        System.out.println("deque.peekLast() = " + deque.peekLast());

        // 제일 앞 요소 꺼내기
        System.out.println("deque.pollFirst() = " + deque.pollFirst());

        // 마지막 요소 꺼내기
        System.out.println("deque.pollLast() = " + deque.pollLast());

        System.out.println(deque);

        // 스택의 push(), pop() 사용가능
        // push()로 앞에 데이터 추가
        deque.push("frog");
        System.out.println(deque);

        // pop()으로 마지막 요소 꺼내기
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println(deque);

        // 큐의 offer(), poll()도 사용가능

    }
}
