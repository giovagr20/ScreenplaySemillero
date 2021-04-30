package in.practice.automationtesting.certification.utils.enums;

public enum UserEnum {
    USER_EMAIL("giovagr225@yopmail.com"),
    USER_NAME("giovagr225"),
    USER_PASSWORD("Medellin.2019**");

    private String value;

    public String getValue() {
        return value;
    }

    UserEnum(String value) {
        this.value = value;
    }
}
