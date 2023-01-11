package org.azgnetov;

import org.azgnetov.arena.HerbivoresThread;
import org.azgnetov.arena.CarnivoresThread;
import org.azgnetov.arena.PlantsThread;

public class Main {

  public static void main(String[] args) {
    Zoo zoo = new Zoo();

    PlantsThread plantsThread = new PlantsThread(zoo);
    plantsThread.start();

    HerbivoresThread herbivoresThread = new HerbivoresThread(zoo);
    herbivoresThread.start();

    CarnivoresThread carnivoresThread = new CarnivoresThread(zoo);
    carnivoresThread.start();
    }
}

