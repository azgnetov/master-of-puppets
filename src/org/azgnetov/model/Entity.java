package org.azgnetov.model;

import java.util.Random;

import static org.azgnetov.arena.Arena.X_RESOLUTION;
import static org.azgnetov.arena.Arena.Y_RESOLUTION;

public abstract class Entity {
  private final String type;
  private String title;
  private int x;
  private int y;
  private float health; // здоровье или вес от 0 до healthMax
  private final float healthMax; // максимальное здоровье или вес
  private final int density; // максимальная плотность на клетку
  private final int[][] population; // карта населенности вида

  public Entity(EntityParams params, int[][] population) {
    this.type = params.getTitle();
    this.title = params.getTitle();
    this.health = params.getHealth();
    this.healthMax = params.getHealth();
    this.density = params.getDensity();
    this.population = population;
    int attempts = 0;
    int attemptLimit = 100;
    do {
      this.x = new Random().nextInt(X_RESOLUTION);
      this.y = new Random().nextInt(Y_RESOLUTION);
      attempts++;
      if (attempts > attemptLimit) {
        System.out.printf("Обнаружено перенаселение для вида '%s', новая особь родилась нежизнеспособной%n", this.type);
        this.health = 0;
        break;
      }
    } while (this.population[this.x][this.y] >= density);
    this.population[this.x][this.y]++;
  }

  public String getTitle() {
    return title;
  }

  public String getType() {
    return type;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public float getHealth() {
    return health;
  }

  public float getHealthMax() {
    return healthMax;
  }

  public int getDensity() {
    return density;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setHealth(float health) {
    this.health = Math.min(Math.max(health, 0), this.healthMax);
  }

  public int getPopulation(int x, int y) {
    return population[x][y];
  }

  public void increasePopulation(int x, int y) {
    this.population[x][y]++;
  }

  public void decreasePopulation(int x, int y) {
    this.population[x][y]--;
  }

}
