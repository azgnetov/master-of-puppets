package org.azgnetov.arena;

import java.util.Random;

import static org.azgnetov.arena.Arena.ITERATION_DELAY_MS;

public class ClearingThread extends Thread {
  Arena arena;
  protected volatile boolean stopped;

  public ClearingThread(Arena arena) {
    this.arena = arena;
  }

  @Override
  public void run() {
    while (!stopped) {
      arena.starve(Arena.herbivores);
      arena.starve(Arena.carnivores);
      arena.killEntities(Arena.plants);
      arena.killEntities(Arena.herbivores);
      arena.killEntities(Arena.carnivores);
      try {
        Thread.sleep(new Random().nextInt(ITERATION_DELAY_MS));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public void stopClearing() {
    stopped = true;
    arena.showSummary();
    if (Arena.SHOW_DETAILS) arena.showDetails();
  }
}
