package org.azgnetov.model.species;

import org.azgnetov.Zoo;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

public class Snake extends Carnivore {
  public static int[][] snakeMap = new int[Zoo.X_RESOLUTION][Zoo.Y_RESOLUTION];

  public Snake(int number) {
    super(EntityParams.SNAKE, snakeMap);
    setTitle(getType() + "-" + number);
  }

  @Override
  public void move() {
    super.move(snakeMap);
  }

  @Override
  public void reproduce() {

  }
}
