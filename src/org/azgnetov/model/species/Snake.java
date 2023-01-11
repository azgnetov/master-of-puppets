package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

public class Snake extends Carnivore {
  public static int[][] snakeMap = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Snake(int number) {
    super(EntityParams.SNAKE, snakeMap);
    setTitle(getType() + "-" + number);
  }

  @Override
  public void reproduce() {

  }
}
