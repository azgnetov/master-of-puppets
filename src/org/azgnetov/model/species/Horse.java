package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Animal;
import org.azgnetov.model.EntityParams;
import org.azgnetov.model.Herbivore;

public class Horse extends Herbivore {
  public static int[][] horsePopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Horse() {
    super(EntityParams.HORSE, horsePopulation);
    setTitle(getType() + "-" + hashCode());
  }

  @Override
  protected Animal newInstance() {
    return new Horse();
  }
}
