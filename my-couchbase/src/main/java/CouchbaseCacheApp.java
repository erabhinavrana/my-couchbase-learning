import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Abhinav on 12/18/2018.
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.abhi.couchbase" })
public class CouchbaseCacheApp{
    public static void main(String []args){
        SpringApplication.run(CouchbaseCacheApp.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext applicationContext){
        return args -> {
            String[] beanNames = applicationContext.getBeanDefinitionNames();
            for (String beanName: beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
