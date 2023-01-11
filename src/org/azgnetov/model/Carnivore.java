package org.azgnetov.model;

public abstract class Carnivore extends Animal {
  public Carnivore(EntityParams params, int[][] population) {
    super(params, population);
  }

  @Override
  public void eat(Entity entity) {
    if (entity instanceof Herbivore) {
      super.eat(entity);
    }
  }

  public abstract void reproduce();
}
