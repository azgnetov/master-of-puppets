package org.azgnetov.model;

public abstract class Herbivore extends Animal {
  public Herbivore(EntityParams params, int[][] population) {
    super(params, population);
  }

  @Override
  public void eat(Entity entity) {
    if (entity instanceof Plant) {
      super.eat(entity);
    }
  }

}
