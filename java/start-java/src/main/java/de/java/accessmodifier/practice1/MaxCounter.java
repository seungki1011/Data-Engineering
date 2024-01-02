package de.java.accessmodifier.practice1;

public class MaxCounter {
    private int count;
    private int max;

    public void increment(){
        if (count >= max){ // 검증 로직
            // 검증 로직에서 미리 return 사용 가능
            System.out.println("Reached max value!");
        } else{ // 실행 로직
            count++;
        }
    }
    public int getCount() {
        return count;
    }

    public MaxCounter(int max) {
        this.max = max;
    }
}
