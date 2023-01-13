package org.azgnetov;

import org.azgnetov.arena.*;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Arena arena = new Arena();

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

    clearingThread.stopClearing();
    }
}

