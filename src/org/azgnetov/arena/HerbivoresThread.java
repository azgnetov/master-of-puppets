package org.azgnetov.arena;

import java.util.Random;

import static org.azgnetov.arena.Arena.ITERATIONS;
import static org.azgnetov.arena.Arena.ITERATION_DELAY_MS;

public class HerbivoresThread extends Thread {
  Arena arena;

  public HerbivoresThread(Arena arena) {
    this.arena = arena;
  }

  @Override
  public void run() {
    for (int i = 0; i < ITERATIONS; i++) {
      arena.moveHerbivores();
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
