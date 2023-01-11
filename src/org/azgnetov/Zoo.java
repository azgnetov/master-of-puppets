package org.azgnetov;

import org.azgnetov.model.*;
import org.azgnetov.model.species.*;
import org.azgnetov.utils.ConsoleColors;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Random;

public class Zoo {
  public static final int X_RESOLUTION = 20;
  public static final int Y_RESOLUTION = 20;
  public static final int ITERATIONS = 100;
  public static final int ITERATION_DELAY_MS = 100;

  public static HashSet<Plant> plants = new HashSet<>();
  public static HashSet<Herbivore> herbivores = new HashSet<>();
  public static HashSet<Carnivore> carnivores = new HashSet<>();
  public static HashSet<Horse> horses = new HashSet<>();
  public static HashSet<Deer> deers = new HashSet<>();
  public static HashSet<Wolf> wolfs = new HashSet<>();
  public static HashSet<Snake> snakes = new HashSet<>();
  public static HashSet<Fox> foxes = new HashSet<>();
  public static HashSet<Bear> bears = new HashSet<>();
  public static HashSet<Eagle> eagles = new HashSet<>();

  public Zoo() {
    growPlants(100);

    for (int i = 1; i <= 100; i++) {
      herbivores.add(new Horse(i));
      herbivores.add(new Deer(i));
    }

    for (int i = 1; i <= 10; i++) {
      carnivores.add(new Wolf(i));
      carnivores.add(new Snake(i));
      carnivores.add(new Fox(i));
      carnivores.add(new Bear(i));
      carnivores.add(new Eagle(i));
    }
  }

  public void growPlants(int number) {
    System.out.printf("Начинается рост %d растений%n", number);
    for (int i = 1; i <= number; i++) {
      plants.add(new Plant());
    }
  }

  synchronized public void growPlants() throws InterruptedException {
    if (plants.size() < 1000) {
      int random = new Random().nextInt(100);
      System.out.printf("Сейчас %d растений. Выросло еще %d растений%n", plants.size(), random);
      for (int i = 1; i <= random; i++) {
        plants.add(new Plant());
      }
    } else {
      System.out.printf("Сейчас %d растений. Рост новых растений остановлен%n", plants.size());
    }
  }

  // не работает
  public void growEntities(EntityParams params, HashSet<Entity> set, int number)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    for (int i = 1; i <= number; i++) {
      Entity entity = (Entity) Class.forName("org.azgnetov.model.Entity").getConstructor().newInstance(number);
      set.add(entity);
    }
  }

  public void showSummary(String step) {
    System.out.printf(ConsoleColors.BLACK_BACKGROUND_BRIGHT +
        "Ход %s. Сейчас в зоопарке есть существа: %s растений, %s травоядных, %s хищников",
        step, plants.size(), herbivores.size(), carnivores.size());
    System.out.println(ConsoleColors.RESET);
  }

  synchronized public void showSummary() {
    System.out.printf(ConsoleColors.BLACK_BACKGROUND_BRIGHT +
            "Сейчас в зоопарке есть существа: %s растений, %s травоядных, %s хищников",
        plants.size(), herbivores.size(), carnivores.size());
    System.out.println(ConsoleColors.RESET);
  }

  synchronized public void showDetails() {
    HashSet<Entity> entities = new HashSet<>();
    entities.addAll(plants);
    entities.addAll(herbivores);
    entities.addAll(carnivores);
    for (Entity entity : entities) {
      System.out.printf("%s (%s HP) в клетке [%s:%s]",
          entity.getTitle(), entity.getHealth(), entity.getX(), entity.getY());
      System.out.println(ConsoleColors.RESET);
    }
  }

  public void turn() {
    for (Herbivore herbivore : herbivores) {
      herbivore.move();
      for (Plant plant : plants) {
        herbivore.eat(plant);
      }
    }
    plants.removeIf(plant -> plant.getHealth() == 0);

    for (Carnivore carnivore : carnivores) {
      carnivore.move();
      for (Herbivore herbivore : herbivores) {
        carnivore.eat(herbivore);
      }
    }
    herbivores.removeIf(herbivore -> herbivore.getHealth() == 0);
  }

  synchronized public void moveHerbivores() {
    for (Herbivore herbivore : herbivores) {
      herbivore.move();
      for (Plant plant : plants) {
        herbivore.eat(plant);
      }
    }
  }

  synchronized public void moveCarnivores() {
    for (Carnivore carnivore : carnivores) {
      carnivore.move();
      for (Herbivore herbivore : herbivores) {
        carnivore.eat(herbivore);
      }
    }
  }

  synchronized public void killEntities() {
    plants.removeIf(plant -> plant.getHealth() == 0);
    herbivores.removeIf(herbivore -> herbivore.getHealth() == 0);
  }

}
