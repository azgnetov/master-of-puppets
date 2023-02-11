package org.azgnetov.model;

public enum EntityParams {
  PLANT("Растение", 1, 200, 0, 0, 0),

  DEER("Олень", 300, 20, 4, 50, 10),
  HORSE("Лошадь", 400, 20, 4, 60, 10),
  RABBIT("Кролик", 2, 150, 2, 0.45f, 80),
  MOUSE("Мышь", 0.05f, 500, 1, 0.01f, 50),
  GOAT("Коза", 60, 140, 3, 15, 10),
  SHEEP("Овца", 70, 140, 3, 15, 10),
  BOAR("Кабан", 400, 50, 2, 50, 20),
  BUFFALO("Буйвол", 700, 10, 3, 100, 10),
  DUCK("Утка", 1, 200, 4, 0.25f, 10),
  CATERPILLAR("Гусеница", 0.01f, 1000, 0, 0.01f, 50),

  BEAR("Медведь", 500, 5, 2, 80, 5),
  EAGLE("Орел", 6, 20, 3, 1, 5),
  FOX("Лиса", 8, 30, 2, 2, 5),
  SNAKE("Змея", 15, 30, 1, 3, 5),
  WOLF("Волк", 50, 30, 3, 8, 10),
  ;

  private final String title;
  private final float health;
  private final int density;
  private final int velocity;
  private final float voracity;
  private final int fertility;

  EntityParams(String title, float health, int density, int velocity, float voracity, int fertility) {
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

  public float getHealth() {
    return health;
  }

  public int getDensity() {
    return density;
  }

  public int getVelocity() {
    return velocity;
  }

  public float getVoracity() {
    return voracity;
  }

  public int getFertility() {
    return fertility;
  }
}
