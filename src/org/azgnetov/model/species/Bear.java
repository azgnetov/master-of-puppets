package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

public class Bear extends Carnivore {
  public static int[][] bearMap = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Bear(int number) {
    super(EntityParams.BEAR, bearMap);
    setTitle(getType() + "-" + number);
  }

  @Override
  public void reproduce() {

  }
}
