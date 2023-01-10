package org.azgnetov;

import java.util.Random;

public class Main {

  public static void main(String[] args) {
    Zoo zoo = new Zoo();

    ZooThread thread1 = new ZooThread(zoo);
    thread1.start();

    ZooThread thread2 = new ZooThread(zoo);
    thread2.start();

    ZooThread thread3 = new ZooThread(zoo);
    thread3.start();

    ZooThread thread4 = new ZooThread(zoo);
    thread4.start();
    }
}

class ZooThread extends Thread {
  Zoo zoo;

  public ZooThread(Zoo zoo) {
    this.zoo = zoo;
  }

  @Override
  public void run() {
    int delay = 1;
    for (int i = 0; i < 100; i++) {
      try {
        zoo.growPlants();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      try {
        Thread.sleep(new Random().nextInt(delay));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      zoo.moveHerbivores();
      try {
        Thread.sleep(new Random().nextInt(delay));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      zoo.moveCarnivores();
      try {
        Thread.sleep(new Random().nextInt(delay));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      zoo.killEntities();
    }
    zoo.showSummary();
    //zoo.showDetails();
  }
}