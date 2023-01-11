package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

import java.util.HashMap;

public class Wolf extends Carnivore {
  public static int[][] wolfMap = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];
  public static HashMap<String, Integer> wolfProps = new HashMap<>();

  public Wolf(int number) {
    super(EntityParams.WOLF, wolfMap);
    setTitle(getType() + "-" + number);
  }

  @Override
  public void reproduce() {
    super.reproduce(EntityParams.WOLF, wolfMap);
  }
}
