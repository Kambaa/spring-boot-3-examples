package kambaa;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "ExampleRequest2", description = "ExampleRequest2 Description")
public class ExampleRequest2 {
    List<ExampleRequest> data;

    public List<ExampleRequest> getData() {
        return data;
    }

    public void setData(List<ExampleRequest> data) {
        this.data = data;
    }
}

