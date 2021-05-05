package in.practice.automationtesting.certification.utils.enums;

public enum UserEnum {
    USER_EMAIL("giovagr225@yopmail.com"),
    USER_NAME("giovagr225"),
    USER_PASSWORD("Medellin.2019**"),
    USER_API_EMAIL("janet.weaver@reqres.in"),
    USER_API_POST_NAME("giovagr20m"),
    USER_API_POST_JOB("Automation");

    private String value;

    public String getValue() {
        return value;
    }

    UserEnum(String value) {
        this.value = value;
    }
}
