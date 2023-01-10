package org.azgnetov.model;

import java.util.Random;

import static org.azgnetov.Zoo.X_RESOLUTION;
import static org.azgnetov.Zoo.Y_RESOLUTION;

public abstract class Entity {
  private final String type;
  private String title;
  private int x;
  private int y;
  private float health; // здоровье или вес от 0 до healthMax
  private float healthMax; // максимальное здоровье или вес
  private final int density; // плотность на клетку

  public Entity(EntityParams params, int[][] map) {
    this.type = params.getTitle();
    this.title = params.getTitle();
    this.health = params.getHealth();
    this.healthMax = params.getHealth();
    this.density = params.getDensity();
    do {
      this.x = new Random().nextInt(X_RESOLUTION);
      this.y = new Random().nextInt(Y_RESOLUTION);
    } while (map[this.x][this.y] >= density);
    map[this.x][this.y]++;
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
    this.health = Math.max(health, 0);
  }

}
