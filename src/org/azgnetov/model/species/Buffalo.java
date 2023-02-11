package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Animal;
import org.azgnetov.model.EntityParams;
import org.azgnetov.model.Herbivore;

public class Buffalo extends Herbivore {
  public static int[][] buffaloPopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Buffalo() {
    super(EntityParams.BUFFALO, buffaloPopulation);
    setTitle(getType() + "-" + hashCode());
  }

  @Override
  protected Animal newInstance() {
    return new Buffalo();
  }
}
