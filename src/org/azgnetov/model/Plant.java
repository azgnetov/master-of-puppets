package org.azgnetov.model;

import org.azgnetov.Zoo;

public class Plant extends Entity {
  public static int[][] plantMap = new int[Zoo.X_RESOLUTION][Zoo.Y_RESOLUTION];

  public Plant() {
    super(EntityParams.PLANT, plantMap);
    setTitle(getType() + "-" + hashCode());
  }
}
