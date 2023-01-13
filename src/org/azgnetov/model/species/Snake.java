package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

public class Snake extends Carnivore {
  public static int[][] snakePopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Snake() {
    super(EntityParams.SNAKE, snakePopulation);
    setTitle(getType() + "-" + hashCode());
  }

  @Override
  public void reproduce() {

  }
}
