package org.azgnetov;

import org.azgnetov.arena.*;

import static org.azgnetov.arena.Arena.ITERATIONS;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Arena arena = new Arena();

    /*for (int i = 0; i < ITERATIONS; i++) {
      arena.turn();
      arena.showSummary(String.valueOf(i));
    }*/

    PlantsThread plantsThread = new PlantsThread(arena);
    plantsThread.start();

    HerbivoresThread herbivoresThread = new HerbivoresThread(arena);
    herbivoresThread.start();

    CarnivoresThread carnivoresThread = new CarnivoresThread(arena);
    carnivoresThread.start();

    ClearingThread clearingThread = new ClearingThread(arena);
    clearingThread.start();

    plantsThread.join();
    herbivoresThread.join();
    carnivoresThread.join();

    Thread.sleep(1000);
    clearingThread.stopClearing();
    }
}

