import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {

    private String nameStore;

    public String logic(String name) {
        log.info("Stored name = {} -> nameStore = {}", name, nameStore);
        nameStore = name;
        SleepUtil.sleep(1000);
        log.info("Found nameStore = {}", nameStore);
        return nameStore;
    }
}
