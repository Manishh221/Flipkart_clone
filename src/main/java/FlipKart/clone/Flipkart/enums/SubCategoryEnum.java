package FlipKart.clone.Flipkart.enums;


public enum SubCategoryEnum {

    MOBILE_PHONES(MainCategoryEnum.ELECTRONICS),
    LAPTOPS(MainCategoryEnum.ELECTRONICS),
    SMARTWATCHES(MainCategoryEnum.ELECTRONICS),
    TELEVISIONS(MainCategoryEnum.ELECTRONICS),


    MENS_CLOTHING(MainCategoryEnum.FASHION),
    WOMENS_CLOTHING(MainCategoryEnum.FASHION),
    KIDS_WEAR(MainCategoryEnum.FASHION),
    FOOTWEAR(MainCategoryEnum.FASHION),


    FURNITURE(MainCategoryEnum.HOME_AND_FURNITURE),
    KITCHENWARE(MainCategoryEnum.HOME_AND_FURNITURE),


    MAKEUP(MainCategoryEnum.BEAUTY),
    SKIN_CARE(MainCategoryEnum.BEAUTY),


    GROCERY_ITEMS(MainCategoryEnum.GROCERY),


    GYM_EQUIPMENT(MainCategoryEnum.SPORTS),


    SCHOOL_BOOKS(MainCategoryEnum.BOOKS),


    HELMETS(MainCategoryEnum.AUTOMOTIVE);

    private final MainCategoryEnum parentCategory;

    SubCategoryEnum(MainCategoryEnum parentCategory) {
        this.parentCategory = parentCategory;
    }

    public MainCategoryEnum getParentCategory() {
        return parentCategory;
    }
}