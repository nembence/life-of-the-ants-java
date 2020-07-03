package com.codecool.ants.ants;

public class EmptyAnt extends Ants{
   public EmptyAnt(int id) {
      super(id);
   }

   @Override
   public void move() {

   }

   @Override
   public String toString() {
      return ".";
   }
}
