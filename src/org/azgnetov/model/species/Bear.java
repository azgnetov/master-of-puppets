package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Animal;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

public class Bear extends Carnivore {
  public static int[][] bearPopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Bear() {
    super(EntityParams.BEAR, bearPopulation);
    setTitle(getType() + "-" + hashCode());
  }

  @Override
  protected Animal newInstance() {
    return new Bear();
  }
}
