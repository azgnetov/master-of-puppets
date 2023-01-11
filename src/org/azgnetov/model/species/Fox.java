package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

public class Fox extends Carnivore {
  public static int[][] foxMap = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Fox(int number) {
    super(EntityParams.FOX, foxMap);
    setTitle(getType() + "-" + number);
  }

  @Override
  public void reproduce() {

  }
}
