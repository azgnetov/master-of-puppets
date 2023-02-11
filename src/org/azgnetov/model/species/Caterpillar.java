package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Animal;
import org.azgnetov.model.Entity;
import org.azgnetov.model.EntityParams;
import org.azgnetov.model.Herbivore;

public class Caterpillar extends Herbivore {
  public static int[][] catterpillarPopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Caterpillar() {
    super(EntityParams.CATERPILLAR, catterpillarPopulation);
    setTitle(getType() + "-" + hashCode());
  }

  @Override
  protected Animal newInstance() {
    return new Caterpillar();
  }
}
