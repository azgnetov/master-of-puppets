package org.azgnetov.arena;

import java.util.Random;

import static org.azgnetov.arena.Arena.ITERATIONS;
import static org.azgnetov.arena.Arena.ITERATION_DELAY_MS;

public class PlantsThread extends Thread {
  Arena arena;

  public PlantsThread(Arena arena) {
    this.arena = arena;
  }

  @Override
  public void run() {
    for (int i = 0; i < ITERATIONS; i++) {
      try {
        arena.growPlants();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      try {
        Thread.sleep(new Random().nextInt(ITERATION_DELAY_MS));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      arena.killEntities();
    }
    arena.showSummary();
    //zoo.showDetails();
  }
}
