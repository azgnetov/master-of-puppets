package org.azgnetov.arena;

import org.azgnetov.model.*;
import org.azgnetov.model.species.*;
import org.azgnetov.utils.ConsoleColors;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import static org.azgnetov.model.Plant.plantsPopulation;

public class Arena {
  public static final int X_RESOLUTION = 3;
  public static final int Y_RESOLUTION = 3;
  public static final int ITERATIONS = 5;
  public static final int ITERATION_DELAY_MS = 200;
  public static final int PLANTS_MAX = EntityParams.PLANT.getDensity() * X_RESOLUTION * Y_RESOLUTION;
  public static final int PLANTS_DIFF = 20;

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

  public Arena() {
    growPlants();

    for (int i = 1; i <= 10; i++) {
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

  synchronized public void growPlants() {
    if (plants.size() < PLANTS_MAX) {
      int random = new Random().nextInt(PLANTS_DIFF);
      System.out.printf("Сейчас %d растений. Выросло еще %d растений%n", plants.size(), random);
      for (int i = 1; i <= random; i++) {
        plants.add(new Plant());
      }
    } else {
      System.out.printf("Сейчас %d растений. Рост новых растений остановлен%n", plants.size());
    }
    // показать карту распространения растений
    //System.out.println(Arrays.deepToString(plantsPopulation));
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

  synchronized public void killEntitiesOld() {
    plants.removeIf(plant -> plant.getHealth() == 0);
    herbivores.removeIf(herbivore -> herbivore.getHealth() == 0);
    carnivores.removeIf(herbivore -> herbivore.getHealth() == 0);
  }

  synchronized public <T extends Entity> void killEntities(HashSet<T> entities) {
    Iterator<T> iterator = entities.iterator();
    while (iterator.hasNext()) {
      T entity = iterator.next();
      if (entity.getHealth() == 0) {
        entity.decreasePopulation(entity.getX(), entity.getY());
        iterator.remove();
      }
    }
  }

}
