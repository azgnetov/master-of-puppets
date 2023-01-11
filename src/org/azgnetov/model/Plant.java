package org.azgnetov.model;

import org.azgnetov.arena.Arena;

public class Plant extends Entity {
  public static int[][] plantMap = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Plant() {
    super(EntityParams.PLANT, plantMap);
    setTitle(getType() + "-" + hashCode());
  }
}
