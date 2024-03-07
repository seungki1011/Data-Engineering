package de.springbasic1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // 필터로 컴포넌트 스캔에서 제외 시킬 것을 지정함 - AppConfig에서 @Configuration이 붙어 있기 때문
public class AutoAppConfig {

}
