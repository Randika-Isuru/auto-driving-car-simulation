package org.example;

import org.example.model.Car;
import org.example.service.CarService;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        // Sample input
        int[] field = {10, 10};

        // Define cars
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A", 1, 2, 'N', "FFRFFFFRRL"));
        cars.add(new Car("B", 7, 8, 'W', "FFLFFFFFFF"));

        // Simulate movement and check for collisions
        CarService carService = new CarService();
        String collisionInfo = carService.moveParallel(field, cars);
        System.out.println(collisionInfo);

        System.out.println( "Hello World!" );
    }
}
