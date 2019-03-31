package com.beginner.jpa.idwithconverter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.YearMonth;

@Entity
@Table(name = "ENTITY1")
@IdClass(Entity1PK.class)
public class Entity1 {
  @Id
  public YearMonth id;
}