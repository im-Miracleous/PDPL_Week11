package com.restaurant.product;

public class Burger implements MainCourse {
    @Override
    public void serve() {
        System.out.println("Serving Beef Burger with melted cheese and french fries.");
    }
}
