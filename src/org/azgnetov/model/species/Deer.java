package org.azgnetov.model.species;

import org.azgnetov.Zoo;
import org.azgnetov.model.Animal;
import org.azgnetov.model.EntityParams;
import org.azgnetov.model.Herbivore;

public class Deer extends Herbivore {
  public static int[][] deerMap = new int[Zoo.X_RESOLUTION][Zoo.Y_RESOLUTION];

  public Deer(int number) {
    super(EntityParams.DEER, deerMap);
    setTitle(getType() + "-" + number);
  }

  @Override
  public void move() {
    super.move(deerMap);
  }

  @Override
  public Animal reproduce() {

    return null;
  }
}
