package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Animal;
import org.azgnetov.model.EntityParams;
import org.azgnetov.model.Herbivore;

public class Duck extends Herbivore {
  public static int[][] duckPopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Duck() {
    super(EntityParams.DUCK, duckPopulation);
    setTitle(getType() + "-" + hashCode());
  }

  @Override
  protected Animal newInstance() {
    return new Duck();
  }
}
