package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Animal;
import org.azgnetov.model.EntityParams;
import org.azgnetov.model.Herbivore;

public class Goat extends Herbivore {
  public static int[][] goatPopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Goat() {
    super(EntityParams.GOAT, goatPopulation);
    setTitle(getType() + "-" + hashCode());
  }

  @Override
  protected Animal newInstance() {
    return new Goat();
  }
}
