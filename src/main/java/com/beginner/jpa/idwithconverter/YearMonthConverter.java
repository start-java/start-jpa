package com.beginner.jpa.idwithconverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.YearMonth;

/**
 * A {@link YearMonth} {@link AttributeConverter} implementation that used to convert
 * entity {@link YearMonth} attribute value into database column representation with integer value and back again.
 * <p>
 * Such as YearMonth.of(2017, 1) convert to 201701.
 *
 * @author RJ Hwang
 */
@Converter(autoApply = true)
public class YearMonthConverter implements AttributeConverter<YearMonth, Integer> {
  @Override
  public Integer convertToDatabaseColumn(YearMonth attribute) {
    return toInteger(attribute);
  }

  @Override
  public YearMonth convertToEntityAttribute(Integer dbData) {
    return toYearMonth(dbData);
  }

  /**
   * Convert {@link YearMonth} to {@link Integer}.
   * <p>
   * Such as YearMonth.of(2017, 1) convert to 201701.
   *
   * @param yearMonth the value to be converted
   * @return the {@link Integer} instance
   */
  public static Integer toInteger(YearMonth yearMonth) {
    return yearMonth == null ? null : new Integer(yearMonth.getYear() +
      (yearMonth.getMonthValue() > 9 ? "" : "0") + yearMonth.getMonthValue());
  }

  /**
   * Convert {@link Integer} to {@link YearMonth}.
   * <p>
   * Such as 201701 convert to YearMonth.of(2017, 1).
   *
   * @param yearMonth the value to be converted
   * @return the {@link YearMonth} instance
   */
  public static YearMonth toYearMonth(Integer yearMonth) {
    if (null == yearMonth) return null;
    String ym = yearMonth.toString();
    if (ym.length() != 6)
      throw new IllegalStateException("Could not convert '" + ym + "' to java.time.YearMonth.");
    return YearMonth.of(Integer.parseInt(ym.substring(0, 4)), Integer.parseInt(ym.substring(4)));
  }
}