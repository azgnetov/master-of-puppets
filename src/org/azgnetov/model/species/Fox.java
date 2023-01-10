package org.azgnetov.model.species;

import org.azgnetov.Zoo;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

public class Fox extends Carnivore {
  public static int[][] foxMap = new int[Zoo.X_RESOLUTION][Zoo.Y_RESOLUTION];

  public Fox(int number) {
    super(EntityParams.FOX, foxMap);
    setTitle(getType() + "-" + number);
  }

  @Override
  public void move() {
    super.move(foxMap);
  }

  @Override
  public void reproduce() {

  }
}
