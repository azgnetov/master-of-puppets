package org.azgnetov.model;

public abstract class Herbivore extends Animal {
  public Herbivore(EntityParams params, int[][] map) {
    super(params, map);
  }

  @Override
  public void eat(Entity entity) {
    if (entity instanceof Plant) {
      super.eat(entity);
    }
  }

  public abstract void move();

  public abstract Animal reproduce();
}
