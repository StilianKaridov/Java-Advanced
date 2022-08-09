package oop.examPreparation.december_11th.catHouse.entities.cat;

public class ShorthairCat extends BaseCat {

    private static int SHORT_HAIR_CAT_KILOGRAMS = 7;
    private static final String SHORT_HAIR_CAT_LIVING_PLACE = "ShortHouse";

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    public static int getShortHairCatKilograms() {
        return SHORT_HAIR_CAT_KILOGRAMS;
    }

    public static String getShortHairCatLivingPlace(){
        return SHORT_HAIR_CAT_LIVING_PLACE;
    }

    @Override
    public void eating() {
        SHORT_HAIR_CAT_KILOGRAMS++;
    }
}
