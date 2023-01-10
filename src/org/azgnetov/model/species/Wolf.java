package org.azgnetov.model.species;

import org.azgnetov.Zoo;
import org.azgnetov.model.Carnivore;
import org.azgnetov.model.EntityParams;

import java.util.HashMap;

public class Wolf extends Carnivore {
  public static int[][] wolfMap = new int[Zoo.X_RESOLUTION][Zoo.Y_RESOLUTION];
  public static HashMap<String, Integer> wolfProps = new HashMap<>();

  public Wolf(int number) {
    super(EntityParams.WOLF, wolfMap);
    setTitle(getType() + "-" + number);
  }

  @Override
  public void move() {
    super.move(wolfMap);
  }

  @Override
  public void reproduce() {
    super.reproduce(EntityParams.WOLF, wolfMap);
  }
}
