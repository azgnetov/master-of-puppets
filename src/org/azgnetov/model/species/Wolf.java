package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Animal;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

public class Wolf extends Carnivore {
  public static int[][] wolfPopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Wolf() {
    super(EntityParams.WOLF, wolfPopulation);
    setTitle(getType() + "-" + hashCode());
  }

  @Override
  protected Animal newInstance() {
    return new Wolf();
  }
}
