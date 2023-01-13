package org.azgnetov.arena;

import org.azgnetov.model.*;
import org.azgnetov.model.species.*;
import org.azgnetov.utils.ConsoleColors;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import static org.azgnetov.model.Plant.plantsPopulation;

public class Arena {
  public static final int X_RESOLUTION = 10;
  public static final int Y_RESOLUTION = 10;
  public static final int ITERATIONS = 50;
  public static final int ITERATION_DELAY_MS = 200;
  public static final int PLANTS_MAX = EntityParams.PLANT.getDensity() * X_RESOLUTION * Y_RESOLUTION / 2;
  public static final int PLANTS_DIFF = 200;
  public static final boolean SHOW_PLANTS_MAP = false;

  public static final HashSet<Plant> plants = new HashSet<>();
  public static final HashSet<Herbivore> herbivores = new HashSet<>();
  public static final HashSet<Carnivore> carnivores = new HashSet<>();

  public Arena() {
    growPlants();

    for (int i = 1; i <= 50; i++) {
      herbivores.add(new Horse());
      herbivores.add(new Deer());
      //herbivores.add(new Rabbit());
    }

    for (int i = 1; i <= 10; i++) {
      carnivores.add(new Wolf());
      carnivores.add(new Snake());
      carnivores.add(new Fox());
      carnivores.add(new Bear());
      carnivores.add(new Eagle());
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
    if (SHOW_PLANTS_MAP) System.out.println(Arrays.deepToString(plantsPopulation)); // показать карту распространения растений
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
      synchronized (plants) {
        for (Plant plant : plants) {
          herbivore.eat(plant);
        }
      }
    }
    HashSet<Herbivore> herbivoresCopy = new HashSet<>(herbivores);
    for (Herbivore herbivoreCopy : herbivoresCopy) {
      herbivoreCopy.reproduce(herbivores);
    }
  }

  synchronized public void moveCarnivores() {
    for (Carnivore carnivore : carnivores) {
      carnivore.move();
      synchronized (herbivores) {
        for (Herbivore herbivore : herbivores) {
          carnivore.eat(herbivore);
        }
      }
    }
    HashSet<Carnivore> carnivoresCopy = new HashSet<>(carnivores);
    for (Carnivore carnivoreCopy : carnivoresCopy) {
      carnivoreCopy.reproduce(carnivores);
    }
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
