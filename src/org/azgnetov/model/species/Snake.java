package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

public class Snake extends Carnivore {
  public static int[][] snakePopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Snake(int number) {
    super(EntityParams.SNAKE, snakePopulation);
    setTitle(getType() + "-" + number);
  }

  @Override
  public void reproduce() {

  }
}
