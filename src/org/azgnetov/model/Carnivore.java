package org.azgnetov.model;

public abstract class Carnivore extends Animal {
  public Carnivore(EntityParams params, int[][] map) {
    super(params, map);
  }

  @Override
  public void eat(Entity entity) {
    if (entity instanceof Herbivore) {
      super.eat(entity);
    }
  }

  public abstract void move();

  public abstract void reproduce();
}
