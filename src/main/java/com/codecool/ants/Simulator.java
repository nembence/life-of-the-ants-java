package com.codecool.ants;

import java.util.Scanner;

public class Simulator {
    private static void simulate() {
        Colony colony = new Colony(9,5);
        colony.generateAnts(2,2,2);
        while (true) {
            colony.display();
            Scanner input = new Scanner(System.in);
            String option = input.nextLine();
            if (option.toLowerCase().equals("q")) {
                System.exit(1);
            } else {
                colony.update();
            }
        }
    }

    public static void main(String[] args) {
        Simulator.simulate();
        System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");
    }

}
