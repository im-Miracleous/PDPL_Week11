package com.restaurant.factory;

public class FactoryProducer {
    public static RestaurantFactory getFactory(String themeType) {
        if (themeType == null) {
            return null;
        }

        if (themeType.equalsIgnoreCase("LOCAL")) {
            return new LocalRestaurantFactory();
        } else if (themeType.equalsIgnoreCase("MODERN")) {
            return new ModernCafeFactory();
        }

        return null;
    }
}
