package com.flaremars.interstingdb;

import java.lang.String;

public class MealFactory {
  public Meal create(String id) {
    if (id == null) {
      throw new IllegalArgumentException("id is null!");
    }
    if ("Beef".equals(id)) {
      return new com.flaremars.interstingdb.BeefPizza();
    }
    if ("Calzone".equals(id)) {
      return new com.flaremars.interstingdb.CalzonePizza();
    }
    if ("Margherita".equals(id)) {
      return new com.flaremars.interstingdb.MargheritaPizza();
    }
    if ("Tiramisu".equals(id)) {
      return new com.flaremars.interstingdb.Tiramisu();
    }
    throw new IllegalArgumentException("Unknown id = " + id);
  }
}
