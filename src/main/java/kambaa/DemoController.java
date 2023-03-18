package kambaa;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * A demo REST controller.
 *
 * @author Kambaa
 * OpenAPI specific annotations and basic explanations. Written in this rest controller class.
 * @Tag annotation is for describing the rest controller.
 * Basically, with this annotation, you can define name, description and custom external url for documentation.
 * @Operation annotation is for describing the rest method.
 * Basically, with this annotation, you can add summary, description, and custom operationId for url linking.
 * @Parameter annotation is for describing the rest method parameters/arguments.
 * Basically, with this annotation, you can add description, example/examples, required or not
 */
@RestController
@Tag(name = "DemoController",
        description = "Demo Controller Description",
        externalDocs =
        @ExternalDocumentation(
                description = "Default `DemoController` externalUrlDescription",
                url = "http://localhost:8080/swagger-ui/index.html")
)
public class DemoController {

    /**
     * No need to add the @Autowired anymore, just write and add in constructor. This is easier.
     */
    DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }


    /**
     * Basic greeting example for the main url
     *
     * @param name enter your name to have a personalized greeting
     * @return Greeting text
     */
    @Operation(summary = "Default Get Mapping `/` Summary",
            description = "Default Get Mapping `/` Description",
            operationId = "operationIdLink",
            externalDocs =
            @ExternalDocumentation(
                    description = "Default Get Mapping `/`  externalUrlDescription",
                    url = "http://localhost:8080/swagger-ui/index.html")
    )
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content)
    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    @GetMapping(
            value = "/",
            produces = {"application/json"}
    )
    public Greeting greeting(
            @Parameter(description = "Name to greet", example = "World", required = false)
            @RequestParam(value = "name", defaultValue = "World")
            String name) {
        return demoService.greet(name);
    }
}
