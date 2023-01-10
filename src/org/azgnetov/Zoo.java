package org.azgnetov;

import org.azgnetov.model.*;
import org.azgnetov.model.species.*;
import org.azgnetov.utils.ConsoleColors;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

public class Zoo {
  public static final int X_RESOLUTION = 20;
  public static final int Y_RESOLUTION = 20;

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
    growPlants(1000);

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

  public void growHorses(int number) {
    for (int i = 1; i <= number; i++) {
      Horse horse = new Horse(i);
      horses.add(horse);
    }
    herbivores.addAll(horses);
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

  public void showDetails() {
    HashSet<Entity> entities = new HashSet<>();
    entities.addAll(plants);
    entities.addAll(herbivores);
    entities.addAll(carnivores);
    for (Entity entity : entities) {
      System.out.printf("%s (%s HP) в клетке [%s:%s]%n",
          entity.getTitle(), entity.getHealth(), entity.getX(), entity.getY());
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

}
