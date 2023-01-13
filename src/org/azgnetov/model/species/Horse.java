package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Animal;
import org.azgnetov.model.EntityParams;
import org.azgnetov.model.Herbivore;

public class Horse extends Herbivore {
  public static int[][] horsePopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Horse(int number) {
    super(EntityParams.HORSE, horsePopulation);
    setTitle(getType() + "-" + number);
  }

  @Override
  public Animal reproduce() {
    return reproduce(EntityParams.HORSE, horsePopulation);
  }
}
