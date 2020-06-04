package info.sjd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
@EnableSwagger2
public class EShopRsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShopRsApplication.class, args);
	}
}
