package tech.simter.start.jpa;

/**
 * @author RJ
 */
public enum ActorType {
  User(1),
  Group(1 << 1),
  Department(1 << 2);

  private final Integer value;

  ActorType(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }


  @Override
  public String toString() {
    return "AT:" + super.toString();
  }
}