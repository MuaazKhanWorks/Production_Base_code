package com.Try.Production_Base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
// @OpenAPIDefinition(info = @Info(title = "Prod-Base-Application",version = "3.2.7",description = "DesXriPtioN"))
public class ProductionBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductionBaseApplication.class, args);
	}

}
