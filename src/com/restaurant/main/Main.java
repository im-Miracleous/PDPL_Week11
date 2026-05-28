package com.restaurant.main;

import com.restaurant.factory.*;
import com.restaurant.product.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RESTAURANT ORDERING SYSTEM ===");

        // SCENARIO 1: Customer orders a Local Package
        System.out.println("\n--- Processing LOCAL Theme Order ---");
        // We use the Producer to get the factory
        RestaurantFactory localFactory = FactoryProducer.getFactory("LOCAL");

        if (localFactory != null) {
            MainCourse localMeal = localFactory.createMainCourse();
            Drink localDrink = localFactory.createDrink();

            // The Client (Main) doesn't know these objects are FriedRice/IcedTea
            // The Client only knows to call the serve() and pour() methods
            localMeal.serve();
            localDrink.pour();
        }

        // SCENARIO 2: Customer orders a Modern Package
        System.out.println("\n--- Processing MODERN Theme Order ---");
        // Get the Modern factory from the Producer
        RestaurantFactory modernFactory = FactoryProducer.getFactory("MODERN");

        if (modernFactory != null) {
            MainCourse modernMeal = modernFactory.createMainCourse();
            Drink modernDrink = modernFactory.createDrink();

            modernMeal.serve();
            modernDrink.pour();
        }

        System.out.println("\n=================================");
    }
}
