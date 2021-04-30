package in.practice.automationtesting.certification.exceptions;

public class ElementNotFoundException extends RuntimeException {

    public static final String ELEMENT_NOT_FOUND = "Element is not visible, please check";
    public static final String ELEMENT_NOT_FOUND_ALERT = "Could not found alert";

    public ElementNotFoundException(String message) {
        super(message);
    }
}
