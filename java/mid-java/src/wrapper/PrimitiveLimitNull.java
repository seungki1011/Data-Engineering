package wrapper;

public class PrimitiveLimitNull {
    public static void main(String[] args) {

        int[] intArr = {-1, 0, 1, 2, 3};

        System.out.println(findValue(intArr, -1)); //-1
        System.out.println(findValue(intArr, 0));
        System.out.println(findValue(intArr, 1));
        System.out.println(findValue(intArr, 100)); //-1
    }

    private static int findValue(int[] intArr, int target) {
        // 배열에 찾는 값이 존재하면 1 반환, 없으면 -1 반환
        for (int value : intArr) {
            if (value == target) {
                return value;
            }
        }
        return -1;
    }
}

