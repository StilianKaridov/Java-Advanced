package oop.examPreparation.december_11th.catHouse.entities.cat;

public class LonghairCat extends BaseCat {

    private static int LONG_HAIR_CAT_KILOGRAMS = 9;
    private static final String LONG_HAIR_CAT_LIVING_PLACE = "LongHouse";

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    public static int getLongHairCatKilograms() {
        return LONG_HAIR_CAT_KILOGRAMS;
    }

    public static String getLongHairCatLivingPlace(){
        return LONG_HAIR_CAT_LIVING_PLACE;
    }

    @Override
    public void eating() {
        LONG_HAIR_CAT_KILOGRAMS += 3;
    }
}
