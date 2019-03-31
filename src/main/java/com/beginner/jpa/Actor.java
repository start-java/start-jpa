package com.beginner.jpa;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author RJ
 */
@Entity
@Table(name = "ACTOR")
public class Actor {
  private Integer id;
  private ActorType type;
  private String name;
  private BigDecimal money;
  private boolean empty;
  private String from;

  public Actor() {
  }

  public Actor(ActorType type, String name) {
    this.name = name;
    this.type = type;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean isEmpty() {
    return empty;
  }

  public void setEmpty(boolean empty) {
    this.empty = empty;
  }

  @Column(name = "\"from\"")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  @Column(length = 100, nullable = false, unique = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * <ul>
   * <li>不添加任何注解, 默认的持久化值为 Enum 实例 ordinal() 方法的返回值</li>
   * <li>通过 @Enumerated 注解可以控制持久化值为 ordinal 还是 name</li>
   * <li>通过 @Convert(converter = ActorTypeConverter.class) 指定转换器</li>
   * <li>或通过在转换器类上声明 @Converter(autoApply = true) 实现自动类型转换</li>
   * </ul>
   */
  //@Enumerated(value = EnumType.STRING)
  //@Convert(converter = ActorTypeConverter.class)
  public ActorType getType() {
    return type;
  }

  public void setType(ActorType type) {
    this.type = type;
  }

  /**
   * 虽然指定建表时列的默认值, 但初始化实体时没有设置此属性, 其值为 null,
   * 通过 JPA 保存实体对象时数据库的依然为 null, 不会默认为 100.00 的,
   * 这个要注意! 因为 JPA insert 或 update 实体时, 依然强制将值设为 null.
   */
  @Column(precision = 10, scale = 2, columnDefinition = "decimal(10,2) default 100.00")
  public BigDecimal getMoney() {
    return money;
  }

  public void setMoney(BigDecimal money) {
    this.money = money;
  }
}