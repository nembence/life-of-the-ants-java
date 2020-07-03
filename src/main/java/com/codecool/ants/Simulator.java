package com.codecool.ants;

public class Simulator {

    public static void main(String[] args) {
        Colony colony = new Colony(9,5);
        colony.generateAnts(2,2,2);
        colony.display();
        System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");
    }

}
