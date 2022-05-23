package io.zatec.zatectest.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Zatec Test API",
                version = "0.0.1",
                description = "List of APIs in the Zatec test project",
                contact = @Contact(name = "Amy Muhimpundu",email = "amydoxym@gmail.com"
                )
        )
)
public class OpenApiConfig {

}
