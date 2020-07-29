package springbootfilter.springbootfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import springbootfilter.springbootfilter.filter.ResponseFilter;

@SpringBootApplication
public class SpringbootFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFilterApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ResponseFilter());
        registration.addUrlPatterns("/filterTest");
        return registration;
    }
}
