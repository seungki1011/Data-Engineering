package de.stack;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        // 스택에 요소 넣기
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        // 스택에서 요소 꺼내기
        System.out.println("stack.pop() = " + stack.pop());

        stack.push(4);

        // 스택의 다음 요소 확인(꺼내지 않고 조회만)
        System.out.println("stack.peek() = " + stack.peek());

        System.out.println(stack);

    }
}
