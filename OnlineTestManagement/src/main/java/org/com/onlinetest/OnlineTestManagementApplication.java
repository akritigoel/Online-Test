package  org.com.onlinetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class OnlineTestManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineTestManagementApplication.class, args);
		
	}
	/*
	 @Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("")).build();
	   }
*/
}
