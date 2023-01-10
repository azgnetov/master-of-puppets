package org.azgnetov.model.species;

import org.azgnetov.Zoo;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

public class Eagle extends Carnivore {
  public static int[][] eagleMap = new int[Zoo.X_RESOLUTION][Zoo.Y_RESOLUTION];

  public Eagle(int number) {
    super(EntityParams.EAGLE, eagleMap);
    setTitle(getType() + "-" + number);
  }

  @Override
  public void move() {
    super.move(eagleMap);
  }

  @Override
  public void reproduce() {

  }
}
