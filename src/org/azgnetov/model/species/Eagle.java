package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

public class Eagle extends Carnivore {
  public static int[][] eaglePopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Eagle() {
    super(EntityParams.EAGLE, eaglePopulation);
    setTitle(getType() + "-" + hashCode());
  }

  @Override
  public void reproduce() {

  }
}
