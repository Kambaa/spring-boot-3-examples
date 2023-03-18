package kambaa;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A demo REST controller.
 *
 * @author Kambaa
 * <p>
 * OpenAPI specific annotations and basic explanations. Written in this rest controller class.
 * @Tag annotation is for describing the rest controller.
 * Basically, with this annotation, you can define name, description and custom external url for documentation.
 * @Operation annotation is for describing the rest method.
 * Basically, with this annotation, you can add summary, description, and custom operationId for url linking.
 * @Parameter annotation is for describing the rest method parameters/arguments.
 * Basically, with this annotation, you can add description, example/examples, required or not
 * From ZekAI:
 * @OpenAPIDefinition: This annotation is used to define the overall OpenAPI specification of an application. It can be used to specify basic information such as the API version and description.
 * @Operation: This annotation is used to define an API operation, such as a REST endpoint. It can be used to specify information such as the HTTP method, path, and operation summary.
 * @Parameter: This annotation is used to define a parameter for an API operation. It can be used to specify information such as the parameter name, location, and description.
 * @RequestBody: This annotation is used to define the request body of an API operation. It can be used to specify the data format and schema of the request body.
 * @ApiResponse: This annotation is used to define a response for an API operation. It can be used to specify the response status code, description, and data schema.
 */
@RestController
@Tag(name = "DemoController",
        description = "Demo Controller Description",
        externalDocs =
        @ExternalDocumentation(
                description = "Default `DemoController` externalUrlDescription",
                url = "http://localhost:8080/swagger-ui/index.html")
)
@ApiResponse(responseCode = "200", description = "OK")
@ApiResponse(responseCode = "400", description = "Invalid request", content = @Content)
@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
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


    @Operation(summary = "`addWithRequestParam` Summary",
            description = "`addWithRequestParam` Description: returns a new greeting from a request parameter",
            operationId = "addWithRequestParamOperationId"
    )
    @PostMapping(
            value = "/addWithRequestParam",
            produces = {"application/json"}
    )
    public Greeting addWithRequestParam(
            @RequestParam()
            @Parameter(description = "Enter a name for the greeting")
            String name) {
        return demoService.greet(name);
    }

    @Operation(summary = "`addWithRequestBody` Summary",
            description = "`addWithRequestBody` Description returns a greeting from given greeting RequestBody",
            operationId = "addWithRequestBodyOperationId"
    )
    @PostMapping(
            value = "/addWithRequestBody",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public Greeting addWithRequestBody(
            @RequestBody
            @Parameter(description = "Enter a greeting object")
            Greeting greeting) {
        return demoService.greet(greeting.id(), greeting.content());
    }

    @Operation(summary = "`addWithRequestBodyEnum` Summary",
            description = "`addWithRequestBodyEnum` Description returns a greeting from given greeting RequestBody",
            operationId = "addWithRequestBodyEnumOperationId"
    )
    @PostMapping(
            value = "/addWithRequestBodyEnum",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public Greeting addWithRequestBodyEnum(
            @RequestBody
            @Parameter(required = true, description = "Enter an ExampleRequest object with enum")
            ExampleRequest greeting) {
        System.out.println("selected demoEnum is: " + greeting.getDemoEnum().name());
        return demoService.greet(greeting.getId(), greeting.getContent());
    }

    @Operation(summary = "`getListOfGreets` Summary",
            description = "`getListOfGreets` Description returns a greeting from given greeting RequestBody",
            operationId = "getListOfGreetsOperationId"
    )
    @PostMapping(
            value = "/getListOfGreets",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public Greeting getListOfGreets(
            @RequestBody
            @Parameter(required = true, description = "list of ExampleRequest")
            List<ExampleRequest> requests
    ) {
        return demoService.greet(requests.size(), "hello to " + requests.size() + " people.");
    }
}
