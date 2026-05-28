package com.restaurant.factory;

import com.restaurant.product.*;

public class ModernCafeFactory implements RestaurantFactory {
    @Override
    public MainCourse createMainCourse() {
        return new Burger();      // Only creates Modern variants
    }

    @Override
    public Drink createDrink() {
        return new CoffeeLatte(); // Only creates Modern variants
    }
}
