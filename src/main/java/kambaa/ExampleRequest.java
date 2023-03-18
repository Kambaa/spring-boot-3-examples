package kambaa;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ExampleRequest", description = "ExampleRequest With Enum Example Description")
public class ExampleRequest {
    @Schema(required = true, description = "id description")
    private long id;
    @Schema(required = true, description = "content description")
    private String content;
    @Schema(required = true, enumAsRef = true, description = "Demo Enum Description")
    private DemoEnum demoEnum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DemoEnum getDemoEnum() {
        return demoEnum;
    }

    public void setDemoEnum(DemoEnum demoEnum) {
        this.demoEnum = demoEnum;
    }
}

