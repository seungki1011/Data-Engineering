import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {
    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("Stored name = {} -> nameStore = {}", name, nameStore.get());
        nameStore.set(name);
        SleepUtil.sleep(1000);
        log.info("Found nameStore = {}", nameStore.get());
        return nameStore.get();
    }
}
