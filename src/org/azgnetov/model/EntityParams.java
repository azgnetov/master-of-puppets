package org.azgnetov.model;

public enum EntityParams {
  PLANT("Растение", 1, 200, 0, 0, 0),

  DEER("Олень", 300, 20, 4, 10, 10),
  HORSE("Лошадь", 400, 20, 4, 15, 10),
  RABBIT("Кролик", 10, 50, 10, 20, 50),

  BEAR("Медведь", 500, 5, 2, 80, 5),
  EAGLE("Орел", 8, 30, 2, 2, 5),
  FOX("Лиса", 8, 30, 2, 10, 5),
  SNAKE("Змея", 15, 30, 1, 5, 5),
  WOLF("Волк", 50, 30, 3, 20, 10),
  ;

  private final String title;
  private final int health;
  private final int density;
  private final int velocity;
  private final int voracity;
  private final int fertility;

  EntityParams(String title, int health, int density, int velocity, int voracity, int fertility) {
    this.title = title;
    this.health = health;
    this.density = density;
    this.velocity = velocity;
    this.voracity = voracity;
    this.fertility = fertility;
  }

  public String getTitle() {
    return title;
  }

  public int getHealth() {
    return health;
  }

  public int getDensity() {
    return density;
  }

  public int getVelocity() {
    return velocity;
  }

  public int getVoracity() {
    return voracity;
  }

  public int getFertility() {
    return fertility;
  }
}
