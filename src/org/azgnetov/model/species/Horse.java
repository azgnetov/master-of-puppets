package org.azgnetov.model.species;

import org.azgnetov.Zoo;
import org.azgnetov.model.Animal;
import org.azgnetov.model.EntityParams;
import org.azgnetov.model.Herbivore;

public class Horse extends Herbivore {
  public static int[][] horseMap = new int[Zoo.X_RESOLUTION][Zoo.Y_RESOLUTION];

  public Horse(int number) {
    super(EntityParams.HORSE, horseMap);
    setTitle(getType() + "-" + number);
  }

  @Override
  public void move() {
    super.move(horseMap);
  }

  @Override
  public Animal reproduce() {
    return reproduce(EntityParams.HORSE, horseMap);
  }
}
