package com.beginner.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 指定 autoApply = true 后, 就不需要在实体类的属性上声明 @Convert 注解指定转换器了.
 *
 * @author RJ
 */
@Converter(autoApply = true)
public class ActorTypeConverter implements AttributeConverter<ActorType, Integer> {
  @Override
  public Integer convertToDatabaseColumn(ActorType actorType) {
    return actorType == null ? null : actorType.getValue();
  }

  @Override
  public ActorType convertToEntityAttribute(Integer value) {
    if (value == null) return null;
    for (ActorType type : ActorType.values()) {
      if (type.getValue().equals(value)) return type;
    }
    throw new IllegalArgumentException("No ActorType for value " + value);
  }
}