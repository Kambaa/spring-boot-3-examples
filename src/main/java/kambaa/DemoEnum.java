package kambaa;

public enum DemoEnum {
    ENUM_VALUE1(1L),
    ENUM_VALUE2(2L);

    private final Long id;

    DemoEnum(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
