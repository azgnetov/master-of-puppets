package org.azgnetov.model;

public enum EntityParams {
  PLANT("Растение", 1, 200, 0, 0),

  DEER("Олень", 300, 20, 4, 50),
  HORSE("Лошадь", 400, 20, 4, 60),
  RABBIT("Кролик", 10, 10, 10, 100),

  BEAR("Медведь", 500, 5, 2, 80),
  EAGLE("Орел", 8, 30, 2, 2),
  FOX("Лиса", 8, 30, 2, 2),
  SNAKE("Змея", 15, 30, 1, 3),
  WOLF("Волк", 50, 30, 3, 8),
  ;

  private final String title;
  private final int health;
  private final int density;
  private final int velocity;
  private final int voracity;

  EntityParams(String title, int health, int density, int velocity, int voracity) {
    this.title = title;
    this.health = health;
    this.density = density;
    this.velocity = velocity;
    this.voracity = voracity;
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
}
