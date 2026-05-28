package com.restaurant.factory;

import com.restaurant.product.*;

public class LocalRestaurantFactory implements RestaurantFactory {
    @Override
    public MainCourse createMainCourse() {
        return new FriedRice(); // Only creates Local variants
    }

    @Override
    public Drink createDrink() {
        return new IcedTea();   // Only creates Local variants
    }
}
