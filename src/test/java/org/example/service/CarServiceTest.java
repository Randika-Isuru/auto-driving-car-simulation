package org.example.service;

import org.example.model.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceTest {
    @Test
    public void testMoveCar() {
        int[] field = {10, 10};
        int[] position = {1, 2};
        char orientation = 'N';
        String commands = "FFRFFFRRLF";

        CarService carService = new CarService();
        String finalPosition = carService.moveCar(field, position, orientation, commands);
        assertEquals("4 3 S", finalPosition);
    }

    @Test
    public void testTurnLeft() {
        char orientation = 'N';
        CarService carService = new CarService();
        assertEquals('W', carService.turnLeft(orientation));
    }

    @Test
    public void testTurnRight() {
        char orientation = 'N';
        CarService carService = new CarService();
        assertEquals('E', carService.turnRight(orientation));
    }

    @Test
    public void testParallelMovementWithCollision() {
        int[] field = {10, 10};

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A", 1, 2, 'N', "FFRFFFFRRL"));
        cars.add(new Car("B", 7, 8, 'W', "FFLFFFFFFF"));

        CarService carService = new CarService();
        String result = carService.moveParallel(field, cars);

        assertEquals("A B\n5 4\n7", result);
    }

    @Test
    public void testParallelMovementNoCollision() {
        int[] field = {10, 10};

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A", 1, 2, 'N', "FLFF")); // Car A moves 4 steps North
        cars.add(new Car("B", 1, 6, 'S', "FRFF")); // Car B moves 4 steps South

        CarService carService = new CarService();
        String result = carService.moveParallel(field, cars);

        assertEquals("no collision", result);
    }

}
