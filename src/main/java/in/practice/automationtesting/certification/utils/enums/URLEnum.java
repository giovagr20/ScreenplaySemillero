package in.practice.automationtesting.certification.utils.enums;

public enum URLEnum {
    URLBase("http://practice.automationtesting.in/"),
    URL_API_BASE("https://reqres.in/api"),
    URL_API_PATH_USER("/users/2"),
    URL_API_PATH_POST_USER("/users");

    private String value;

    public String getValue() {
        return value;
    }

    URLEnum(String value) {
        this.value = value;
    }
}
