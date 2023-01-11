package org.azgnetov.model;

import org.azgnetov.arena.Arena;

public class Plant extends Entity {
  public static int[][] plantsPopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Plant() {
    super(EntityParams.PLANT, plantsPopulation);
    setTitle(getType() + "-" + hashCode());
  }
}
