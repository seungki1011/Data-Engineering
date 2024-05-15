import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field() {
        log.info("Main thread start!");

        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("threadA");
        Thread threadB = new Thread(userB);
        threadB.setName("threadB");

        threadA.start();
        //SleepUtil.sleep(2000); // 동시성 문제 발생 x
        SleepUtil.sleep(200); // 동시성 문제 발생 o
        threadB.start();

        SleepUtil.sleep(3000); // Main thread 종료 대기
        log.info("Main Exit!");

    }
}
