package FlipKart.clone.Flipkart.enums;

public enum MainCategory {

    ELECTRONICS("Electronics"),
    FASHION("Fashion"),
    HOME_AND_FURNITURE("Home & Furniture"),
    BEAUTY("Beauty"),
    GROCERY("Grocery"),
    SPORTS("Sports"),
    BOOKS("Books"),
    AUTOMOTIVE("Automotive");

    private final String displayName;

    MainCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
