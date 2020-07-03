package com.codecool.ants;

import com.codecool.ants.ants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colony {
   private final int width;
   private final int height;
   private int id;
   private final List<Ants> colony;
   private final List<List<Ants>> map;

   public Colony(int width, int height) {
      this.width = width;
      this.height = height;
      this.id = 1;
      this.colony = new ArrayList<>();
      this.map = new ArrayList<>();
      generateMap(width, height);
   }

   private void generateMap(int width, int height) {
      for (int i = 0; i < height; i++) {
         ArrayList<Ants> row =  new ArrayList<>();
         for (int j = 0; j < width; j++) {
            row.add(new EmptyAnt(0));
         }
         map.add(row);
      }
   }

   public void generateAnts(int numberOfDrones, int numberOfWorkers, int numberOfSoldiers) {
      generateAnt(numberOfDrones, "drone");
      generateAnt(numberOfWorkers, "worker");
      generateAnt(numberOfSoldiers, "soldier");
      placeQueenOnMap(id);
      placeOnMap();
   }

   private void placeQueenOnMap(int id) {
      int queenHeight = height / 2;
      int queenWidth = width / 2;
      map.get(queenHeight).set(queenWidth,new Queen(id));
   }

   public void placeOnMap() {
      for (Ants ants : colony) {
         while (true) {
            Random random = new Random();
            int randomHeight = random.nextInt(height);
            int randomWidth = random.nextInt(width);
            if (map.get(randomHeight).get(randomWidth) instanceof EmptyAnt) {
               map.get(randomHeight).set(randomWidth, ants);
               break;
            }
         }
      }
   }

   public void display() {
      for (List<Ants> row:map) {
         StringBuilder stringBuilder = new StringBuilder();
         for (Ants col:row) {
            stringBuilder.append(col.toString()).append(" ");
         }
         System.out.println(stringBuilder.toString());
      }
   }

   public void update() {
      for (List<Ants> row:map) {
         for (Ants col:row) {
            col.move();
         }
      }
   }


   private void generateAnt(int numberOfAnts, String type) {
      for (int i=0; i < numberOfAnts; i++) {
         switch (type) {
            case "drone":
               colony.add(new Drone(id));
               break;
            case "worker":
               colony.add(new Worker(id));
               break;
            case "soldier":
               colony.add(new Soldier(id));
               break;
         }
         id ++;
      }
   }
}
