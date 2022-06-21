package web.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Configuration
@ComponentScan(basePackages = "core")
@Import({JPAConfig.class})
@PropertySources({@PropertySource(value = "classpath:db.properties")})
public class AppLocalConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}