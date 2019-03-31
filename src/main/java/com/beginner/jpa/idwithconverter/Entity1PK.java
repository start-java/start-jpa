package com.beginner.jpa.idwithconverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import java.io.Serializable;
import java.time.YearMonth;
import java.util.Objects;

public class Entity1PK implements Serializable {
  @Column(name = "ID", columnDefinition = "int")
  @Convert(converter = YearMonthConverter.class)
  public YearMonth id;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Entity1PK entity1PK = (Entity1PK) o;
    return Objects.equals(id, entity1PK.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}