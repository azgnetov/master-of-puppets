package org.azgnetov;

import java.time.Instant;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    Instant startTime = Instant.now();
    Zoo zoo = new Zoo();

    for (int i = 0; i < 200; i++) {
      zoo.showSummary(String.valueOf(i));
      //if (i % 100 == 0) zoo.showDetails();
      zoo.turn();
      zoo.growPlants(100);
      //Thread.sleep(5000);
    }
    zoo.showSummary("последний");
    Instant endTime = Instant.now();
    System.out.println("Прошло времени: " + String.valueOf(endTime.getEpochSecond()-startTime.getEpochSecond()) + "сек");
  }
}