package org.azgnetov.model;

import org.azgnetov.utils.CSVScanner;
import org.azgnetov.utils.ConsoleColors;
import java.util.Random;
import static org.azgnetov.Zoo.X_RESOLUTION;
import static org.azgnetov.Zoo.Y_RESOLUTION;

public class Animal extends Entity {
  private int velocity; // скорость
  private float voracity; // прожорливость
  private float satiety; // насыщение от 0 до voracity

  public Animal(EntityParams params, int[][] map) {
    super(params, map);
    this.velocity = params.getVelocity();
    this.voracity = params.getVoracity();
    this.satiety = params.getVoracity();
  }

  public float getSatiety() {
    return satiety;
  }

  public float getVoracity() {
    return voracity;
  }

  public void addSatiety(float diff) {
    this.satiety = Math.max(0, Math.min(this.satiety + diff, this.voracity));
  }

  public void move(int[][] map) {
    addSatiety(-1);

    if (getHealth() / getHealthMax() < 0.5) {
      System.out.printf(ConsoleColors.PURPLE + "Существо %s (%s HP) ранено и не может покинуть клетку [%s:%s]",
          getTitle(), getHealth(), getX(), getY());
      System.out.println(ConsoleColors.RESET);
      return;
    }

    int oldX = getX();
    int oldY = getY();
    do {
      int step = new Random().nextInt(velocity + 1);
      int direction = new Random().nextInt(4);
      switch (direction) {
        case 0 -> setY(Math.min(getY() + step, Y_RESOLUTION - 1)); // up
        case 1 -> setY(Math.max(getY() - step, 0)); // down
        case 2 -> setX(Math.min(getX() + step, X_RESOLUTION - 1)); // right
        case 3 -> setX(Math.max(getX() - step, 0)); // left
      }
    } while (map[getX()][getY()] >= getDensity());

    if (oldX == getX() && oldY == getY()) {
      System.out.printf(ConsoleColors.CYAN + "Существо %s решило никуда не ходить и остался в клетке [%s:%s]",
          getTitle(), getX(), getY());
    } else {
      System.out.printf(ConsoleColors.BLUE + "Существо %s ушло из клетки [%s:%s] в клетку [%s:%s]",
          getTitle(), oldX, oldY, getX(), getY());
    }
    System.out.println(ConsoleColors.RESET);

    map[oldX][oldY]--;
    map[getX()][getY()]++;
  }

  public void eat(Entity entity) {
    if (getX() == entity.getX() && getY() == entity.getY() && entity.getHealth() > 0) {
      if (getSatiety() < getVoracity()) {
        int probability = CSVScanner.scan(getType(), entity.getType());
        if (new Random().nextInt(100) < probability) {
          System.out.printf(ConsoleColors.RED + "%s (%s SP) выпил и закусил существом %s",
              getTitle(), getSatiety(), entity.getTitle());
          addSatiety(Math.min(entity.getHealth(), voracity));
          entity.setHealth(entity.getHealth() - voracity);
          System.out.printf(", стало %s SP, у жертвы осталось %s HP", getSatiety(), entity.getHealth());
          if (entity.getHealth() == 0) {
            System.out.printf(". " + ConsoleColors.RED_UNDERLINED + "В следующий ход %s умрет", entity.getTitle());
          }
          System.out.println(ConsoleColors.RESET);
        } else if (probability > 0) {
          System.out.printf(ConsoleColors.YELLOW + "%s (%s SP) не смог съесть существо %s",
              getTitle(), getSatiety(), entity.getTitle());
          System.out.println(ConsoleColors.RESET);
        }
      } else {
        System.out.printf(ConsoleColors.GREEN + "%s (%s SP) сытый и не захотел есть существо %s",
            getTitle(), getSatiety(), entity.getTitle());
        System.out.println(ConsoleColors.RESET);
      }
    }
  }

  // не работает
  protected Animal reproduce(EntityParams params, int[][] map) {
    Animal animal = new Animal(params, map);
    System.out.printf(ConsoleColors.GREEN_BOLD + "Существо %s встретило сородича и размножилось", getTitle());
    System.out.println(ConsoleColors.RESET);
    return animal;
  }

}
