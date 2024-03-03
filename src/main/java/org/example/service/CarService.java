package org.example.service;

import org.example.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    public String moveCar(int[] field, int[] position, char orientation, String commands) {
        int width = field[0];
        int height = field[1];
        int x = position[0];
        int y = position[1];

        //FFRFFFRRLF
        for (char command : commands.toCharArray()) {
            if (command == 'F') {
                switch (orientation) {
                    case 'N':
                        if (y + 1 < height) y++;
                        break;
                    case 'E':
                        if (x + 1 < width) x++;
                        break;
                    case 'S':
                        if (y - 1 >= 0) y--;
                        break;
                    case 'W':
                        if (x - 1 >= 0) x--;
                        break;
                }
            } else if (command == 'L') {
                orientation = turnLeft(orientation);
            } else if (command == 'R') {
                orientation = turnRight(orientation);
            }
        }

        return x + " " + y + " " + orientation;
    }

    public char turnLeft(char orientation) {
        switch (orientation) {
            case 'N':
                return 'W';
            case 'E':
                return 'N';
            case 'S':
                return 'E';
            case 'W':
                return 'S';
            default:
                return orientation;
        }
    }

    public char turnRight(char orientation) {
        switch (orientation) {
            case 'N':
                return 'E';
            case 'E':
                return 'S';
            case 'S':
                return 'W';
            case 'W':
                return 'N';
            default:
                return orientation;
        }
    }

    public String moveParallel(int[] field, List<Car> cars) {
        int steps = 1;
        while (true) {
            List<String> positions = new ArrayList<>();
            for (Car car : cars) {
                move(car);
                positions.add(getPosition(car));
            }

            for (int i = 0; i < positions.size(); i++) {
                for (int j = i + 1; j < positions.size(); j++) {
                    if (positions.get(i).equals(positions.get(j))) {
                        return getName(cars.get(i)) + " " + getName(cars.get(j)) + "\n" + positions.get(i) + "\n" + steps;
                    }
                }
            }

            // Check if all cars reached their destinations
            boolean allCarsReached = true;
            for (Car car : cars) {
                if (!isFinished(car)) {
                    allCarsReached = false;
                    break;
                }
            }
            if (allCarsReached) {
                return "no collision";
            }

            steps++;
        }
    }

    public void move(Car car) {
        char command = car.getCommands().charAt(car.getIndex());
        car.setIndex(car.getIndex() + 1);
        switch (command) {
            case 'F':
                switch (car.getOrientation()) {
                    case 'N':
                        car.setY(car.getY() + 1);
                        break;
                    case 'E':
                        car.setX(car.getX() + 1 );
                        break;
                    case 'S':
                        car.setY(car.getY() - 1 );
                        break;
                    case 'W':
                        car.setX(car.getX() - 1 );
                        break;
                }
                break;
            case 'L':
                switch (car.getOrientation()) {
                    case 'N':
                        car.setOrientation('W');
                        break;
                    case 'E':
                        car.setOrientation('N');
                        break;
                    case 'S':
                        car.setOrientation('E');
                        break;
                    case 'W':
                        car.setOrientation('S');
                        break;
                }
                break;
            case 'R':
                switch (car.getOrientation()) {
                    case 'N':
                        car.setOrientation('E');
                        break;
                    case 'E':
                        car.setOrientation('S');
                        break;
                    case 'S':
                        car.setOrientation('W');
                        break;
                    case 'W':
                        car.setOrientation('N');
                        break;
                }
                break;
        }
    }

    public String getPosition(Car car) {
        return car.getX() + " " + car.getY();
    }

    public boolean isFinished(Car car) {
        return car.getIndex() >= car.getCommands().length();
    }

    public String getName(Car car) {
        return car.getName();
    }
}


