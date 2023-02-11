package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Animal;
import org.azgnetov.model.EntityParams;
import org.azgnetov.model.Herbivore;

public class Sheep extends Herbivore {
  public static int[][] sheepPopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Sheep() {
    super(EntityParams.SHEEP, sheepPopulation);
    setTitle(getType() + "-" + hashCode());
  }

  @Override
  protected Animal newInstance() {
    return new Sheep();
  }
}
