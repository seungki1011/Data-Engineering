package random;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        //Random random = new Random(777); // 시드(seed)가 같은 경우 랜덤의 결과가 똑같게 나온다

        int randomInt = random.nextInt();
        System.out.println("randomInt = " + randomInt);

        double randomDouble = random.nextDouble();
        System.out.println("randomDouble = " + randomDouble);

        boolean randomBoolean = random.nextBoolean();
        System.out.println("randomBoolean = " + randomBoolean);

        // 범위 조회
        int randomRange1 = random.nextInt(10); // 0 ~ 9의 범위에서 랜던한 값
        System.out.println("0 ~ 9 = " + randomRange1);

        int randomRange2 = random.nextInt(10) + 1; // 1 ~ 10의 범위에서 랜던한 값
        System.out.println("1 ~ 10 = " + randomRange2);
    }
}
