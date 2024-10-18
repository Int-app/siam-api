package jp.co.siam.restapi;

import org.springframework.boot.SpringApplication;;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableOpenApi
public class SiamApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiamApiApplication.class, args);
	}

}
