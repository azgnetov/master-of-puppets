package org.azgnetov;

import org.azgnetov.arena.Arena;
import org.azgnetov.arena.HerbivoresThread;
import org.azgnetov.arena.CarnivoresThread;
import org.azgnetov.arena.PlantsThread;
import java.time.Instant;
import static org.azgnetov.arena.Arena.ITERATIONS;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Instant startTime = Instant.now();
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

    plantsThread.join();
    herbivoresThread.join();
    carnivoresThread.join();

    Instant endTime = Instant.now();
    System.out.println("Прошло времени: " + (endTime.getEpochSecond() - startTime.getEpochSecond()) + "сек");
    }
}

