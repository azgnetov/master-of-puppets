package org.azgnetov.model.species;

import org.azgnetov.arena.Arena;
import org.azgnetov.model.Animal;
import org.azgnetov.model.EntityParams;
import org.azgnetov.model.Herbivore;

public class Boar extends Herbivore {
  public static int[][] boarPopulation = new int[Arena.X_RESOLUTION][Arena.Y_RESOLUTION];

  public Boar() {
    super(EntityParams.BOAR, boarPopulation);
    setTitle(getType() + "-" + hashCode());
  }

  @Override
  protected Animal newInstance() {
    return new Boar();
  }
}
