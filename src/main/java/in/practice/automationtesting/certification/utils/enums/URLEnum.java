package in.practice.automationtesting.certification.utils.enums;

public enum URLEnum {
    URLBase("http://practice.automationtesting.in/");

    private String value;

    public String getValue() {
        return value;
    }

    URLEnum(String value) {
        this.value = value;
    }
}
