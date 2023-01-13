package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Animal;
import org.azgnetov.model.EntityParams;
import org.azgnetov.model.Herbivore;

public class Deer extends Herbivore {
  public static int[][] deerPopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Deer(int number) {
    super(EntityParams.DEER, deerPopulation);
    setTitle(getType() + "-" + number);
  }

  @Override
  public Animal reproduce() {

    return null;
  }
}
