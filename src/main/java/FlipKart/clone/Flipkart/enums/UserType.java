package FlipKart.clone.Flipkart.enums;

public enum UserType {

    CUSTOMER("CUSTOMER"),
    SELLER("SELLER");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
