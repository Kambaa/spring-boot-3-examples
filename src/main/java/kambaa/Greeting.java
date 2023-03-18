package kambaa;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Greeting", description = "Greeting Description")
public record Greeting(
        @Schema(required = true, name = "id", description = "iddescription") long id,
        @Schema(required = true, name = "content", description = "contentdescription") String content) {
}

