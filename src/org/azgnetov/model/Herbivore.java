package org.azgnetov.model;

import org.azgnetov.model.species.Caterpillar;

public abstract class Herbivore extends Animal {
  public Herbivore(EntityParams params, int[][] population) {
    super(params, population);
  }

  @Override
  public void eat(Entity entity) {
    if (entity instanceof Plant || entity instanceof Caterpillar) {
      super.eat(entity);
    }
  }

}
