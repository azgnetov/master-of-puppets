package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Animal;
import org.azgnetov.model.EntityParams;
import org.azgnetov.model.Herbivore;

public class Rabbit extends Herbivore {
  public static int[][] rabbitPopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Rabbit() {
    super(EntityParams.RABBIT, rabbitPopulation);
    setTitle(getType() + "-" + hashCode());
  }

  @Override
  public Animal reproduce() {
    return null;
  }
}
