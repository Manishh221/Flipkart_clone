package FlipKart.clone.Flipkart.enums;


import org.springframework.stereotype.Component;

public enum SubCategory {

    MOBILE_PHONES(MainCategory.ELECTRONICS, "Mobile Phones"),
    LAPTOPS(MainCategory.ELECTRONICS, "Laptops"),
    SMARTWATCHES(MainCategory.ELECTRONICS, "Smart Watches"),
    TELEVISIONS(MainCategory.ELECTRONICS, "Televisions"),

    MENS_CLOTHING(MainCategory.FASHION, "Men's Clothing"),
    WOMENS_CLOTHING(MainCategory.FASHION, "Women's Clothing"),
    KIDS_WEAR(MainCategory.FASHION, "Kids Wear"),
    FOOTWEAR(MainCategory.FASHION, "Footwear"),

    FURNITURE(MainCategory.HOME_AND_FURNITURE, "Furniture"),
    KITCHENWARE(MainCategory.HOME_AND_FURNITURE, "Kitchenware"),

    MAKEUP(MainCategory.BEAUTY, "Makeup"),
    SKIN_CARE(MainCategory.BEAUTY, "Skin Care"),

    GROCERY_ITEMS(MainCategory.GROCERY, "Grocery Items"),

    GYM_EQUIPMENT(MainCategory.SPORTS, "Gym Equipment"),

    SCHOOL_BOOKS(MainCategory.BOOKS, "School Books"),

    HELMETS(MainCategory.AUTOMOTIVE, "Helmets");

    private final MainCategory parentCategory;
    private final String displayName;

    SubCategory(MainCategory parentCategory, String displayName) {
        this.parentCategory = parentCategory;
        this.displayName = displayName;
    }

    public MainCategory getParentCategory() {
        return parentCategory;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}