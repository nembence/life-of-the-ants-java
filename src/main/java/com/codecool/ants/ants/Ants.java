package com.codecool.ants.ants;

import java.util.UUID;

public abstract class Ants {
   private final int id;

   public Ants(int id) {
      this.id = id;
   }

   public abstract void move();

   public int getId() {
      return id;
   }
}
