package org.azgnetov.arena;

import org.azgnetov.model.*;
import org.azgnetov.model.species.*;
import org.azgnetov.utils.ConsoleColors;

import java.util.*;

import static org.azgnetov.model.Plant.plantsPopulation;

public class Arena {
  public static final int X_RESOLUTION = 5; // длина арены
  public static final int Y_RESOLUTION = 5; // ширина арены
  public static final int ITERATIONS = 5; // число ходов
  public static final int ITERATION_DELAY_MS = 200; // задержка между ходами в мс
  public static final int PLANTS_MAX = EntityParams.PLANT.getDensity() * X_RESOLUTION * Y_RESOLUTION / 2; // лимит растений
  public static final int PLANTS_DIFF = 30; // прирост растений
  public static final boolean SHOW_PLANTS_MAP = false; // показать карту распространения растений
  public static final boolean SHOW_DETAILS = false; // показать детальный отчет

  public static final HashSet<Plant> plants = new HashSet<>();
  public static final HashSet<Herbivore> herbivores = new HashSet<>();
  public static final HashSet<Carnivore> carnivores = new HashSet<>();


  public Arena() {
    growPlants();

    for (int i = 1; i <= 5; i++) {
      herbivores.add(new Horse());
      herbivores.add(new Deer());
      herbivores.add(new Rabbit());
      herbivores.add(new Mouse());
      herbivores.add(new Goat());
      herbivores.add(new Sheep());
      herbivores.add(new Buffalo());
      herbivores.add(new Duck());
    }

    for (int i = 1; i <= 10; i++) {
      herbivores.add(new Caterpillar());
    }

    for (int i = 1; i <= 5; i++) {
      carnivores.add(new Wolf());
      carnivores.add(new Snake());
      carnivores.add(new Fox());
      carnivores.add(new Bear());
      carnivores.add(new Eagle());
      carnivores.add(new Boar());
    }
  }

  synchronized public void growPlants() {
    // растения растут в количестве от 0 до лимита
    if (plants.size() < PLANTS_MAX) {
      int random = new Random().nextInt(PLANTS_DIFF);
      System.out.printf("Сейчас %d растений. Выросло еще %d растений%n", plants.size(), random);
      for (int i = 1; i <= random; i++) {
        plants.add(new Plant());
      }
    } else {
      System.out.printf("Сейчас %d растений. Рост новых растений остановлен%n", plants.size());
    }
    if (SHOW_PLANTS_MAP) System.out.println(Arrays.deepToString(plantsPopulation));
  }

  synchronized public void showSummary() {
    System.out.printf(ConsoleColors.BLACK_BACKGROUND_BRIGHT +
            "Сейчас на арене есть существа: %s растений, %s травоядных, %s хищников",
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
    // травоядные двигаются и едят растения и гусениц
    for (Herbivore herbivore : herbivores) {
      if (herbivore instanceof Caterpillar) {
        herbivore.addSatiety(-0.01f);
      } else {
        herbivore.move();
        for (Herbivore caterpillar : herbivores) {
          herbivore.eat(caterpillar);
        }
      }
      synchronized (plants) {
        for (Plant plant : plants) {
          herbivore.eat(plant);
        }
      }
    }
    // травоядные размножатися
    HashSet<Herbivore> herbivoresCopy = new HashSet<>(herbivores);
    for (Herbivore herbivoreCopy : herbivoresCopy) {
      herbivoreCopy.reproduce(herbivores);
    }
    showSummary();
  }

  synchronized public void moveCarnivores() {
    // хищники двигаются и едят всех кроме сородичей
    for (Carnivore carnivore : carnivores) {
      carnivore.move();
      synchronized (herbivores) {
        for (Herbivore herbivore : herbivores) {
          carnivore.eat(herbivore);
        }
      }
      synchronized (carnivores) {
        for (Carnivore victim : carnivores) {
          if (!Objects.equals(carnivore.getClass().getName(), victim.getClass().getName())) {
            carnivore.eat(victim);
          }
        }
      }
    }
    // хищники размножаются
    HashSet<Carnivore> carnivoresCopy = new HashSet<>(carnivores);
    for (Carnivore carnivoreCopy : carnivoresCopy) {
      carnivoreCopy.reproduce(carnivores);
    }
    showSummary();
  }

  synchronized public <T extends Entity> void killEntities(HashSet<T> entities) {
    // если здоровье на нуле, животное умирает
    Iterator<T> iterator = entities.iterator();
    while (iterator.hasNext()) {
      T entity = iterator.next();
      if (entity.getHealth() == 0) {
        entity.decreasePopulation(entity.getX(), entity.getY());
        iterator.remove();
      }
    }
  }

  synchronized public <T extends Animal> void starve(HashSet<T> entities) {
    // если насыщение на нуле, животное голодает
    for (T entity : entities) {
      if (entity.getSatiety() == 0) {
        System.out.printf(ConsoleColors.GREEN + "%s голодает!",
            entity.getTitle());
        System.out.println(ConsoleColors.RESET);
        entity.setHealth(Math.round(entity.getHealth() / 10));
      }
    }
  }

}
