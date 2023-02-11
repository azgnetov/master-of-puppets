package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Animal;
import org.azgnetov.model.EntityParams;
import org.azgnetov.model.Herbivore;

public class Mouse extends Herbivore {
  public static int[][] mousePopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Mouse() {
    super(EntityParams.MOUSE, mousePopulation);
    setTitle(getType() + "-" + hashCode());
  }

  @Override
  protected Animal newInstance() {
    return new Mouse();
  }
}
