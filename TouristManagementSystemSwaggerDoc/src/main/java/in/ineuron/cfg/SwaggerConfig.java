package in.ineuron.cfg;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("in.ineuron.restcontroller")).paths(PathSelectors.regex("api/tourist.*")).build().apiInfo(getInfo());
	}

	private ApiInfo getInfo() {
		springfox.documentation.service.Contact contact = new springfox.documentation.service.Contact("shri","www.ineuron.ai","shri@gmail.com");		
		return new ApiInfo("TouristInfo","Tourist management system","4.5 Release","http://", contact,"http://www.apache.com/license/guru","",Collections.emptyList());
	}

	

}
