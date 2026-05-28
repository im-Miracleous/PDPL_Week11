package com.restaurant.factory;

import com.restaurant.product.Drink;
import com.restaurant.product.MainCourse;

public interface RestaurantFactory {
    MainCourse createMainCourse();
    Drink createDrink();
}
