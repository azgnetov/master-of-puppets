package org.azgnetov.model.species;

import org.azgnetov.Zoo;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

public class Bear extends Carnivore {
  public static int[][] bearMap = new int[Zoo.X_RESOLUTION][Zoo.Y_RESOLUTION];

  public Bear(int number) {
    super(EntityParams.BEAR, bearMap);
    setTitle(getType() + "-" + number);
  }

  @Override
  public void move() {
    super.move(bearMap);
  }

  @Override
  public void reproduce() {

  }
}
