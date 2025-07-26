package org.techspark.investment.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(info = @Info(
        title = "TechSpark SpringBoot with MongoDB",
        version = "1.0",
        description = "This TechSpark project is a real-time portfolio tracker using Spring Boot and MongoDB",
        contact = @Contact(name = "Support Team", email = "codrixtechtrainer@gmail.com"),
        license = @License(name = "MIT License", url = "https://opensource.org/licenses/MIT")
))
public class OpenAPIConfig {
}
