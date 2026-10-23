/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.util.number;

import java.math.BigDecimal;

import org.elixirian.kommonlee.type.functional.Function1;
import org.elixirian.kommonlee.util.CommonConstants;

/**
 * <pre>
 *     ___  _____                                              _____
 *    /   \/    / ______ __________________  ______ __ ______ /    /   ______  ______  
 *   /        / _/ __  // /  /   / /  /   /_/ __  // //     //    /   /  ___ \/  ___ \ 
 *  /        \ /  /_/ _/  _  _  /  _  _  //  /_/ _/   __   //    /___/  _____/  _____/
 * /____/\____\/_____//__//_//_/__//_//_/ /_____//___/ /__//________/\_____/ \_____/
 * </pre>
 * 
 * <pre>
 *     ___  _____                                _____
 *    /   \/    /_________  ___ ____ __ ______  /    /   ______  ______
 *   /        / /  ___ \  \/  //___// //     / /    /   /  ___ \/  ___ \
 *  /        \ /  _____/\    //   //   __   / /    /___/  _____/  _____/
 * /____/\____\\_____/   \__//___//___/ /__/ /________/\_____/ \_____/
 * </pre>
 * 
 * @author Lee, SeongHyun (Kevin)
 * @version 0.0.1 (2010-11-14)
 */
public final class BigDecimalTotal
{
  private BigDecimalTotal() throws IllegalAccessException
  {
    throw new IllegalAccessException(getClass().getName() + CommonConstants.CANNOT_BE_INSTANTIATED);
  }

  public static BigDecimal total(final BigDecimal number1, final BigDecimal number2)
  {
    return number1.add(number2);
  }

  public static BigDecimal total(final BigDecimal number1, final BigDecimal number2, final BigDecimal number3)
  {
    return number1.add(number2)
        .add(number3);
  }

  public static BigDecimal total(final BigDecimal number1, final BigDecimal number2, final BigDecimal number3,
      final BigDecimal number4)
  {
    return number1.add(number2)
        .add(number3)
        .add(number4);
  }

  public static BigDecimal total(final BigDecimal number1, final BigDecimal number2, final BigDecimal number3,
      final BigDecimal number4, final BigDecimal number5)
  {
    return number1.add(number2)
        .add(number3)
        .add(number4)
        .add(number5);
  }

  public static BigDecimal total(final BigDecimal number1, final BigDecimal number2, final BigDecimal number3,
      final BigDecimal number4, final BigDecimal number5, final BigDecimal... rest)
  {
    BigDecimal total = total(number1, number2, number3, number4, number5);
    for (final BigDecimal each : rest)
    {
      total = total.add(each);
    }
    return total;
  }

  public static BigDecimal total(final BigDecimal[] numbers)
  {
    BigDecimal total = BigDecimal.ZERO;
    for (final BigDecimal each : numbers)
    {
      total = total.add(each);
    }
    return total;
  }

  public static <T> BigDecimal total(final T[] numberSource, final Function1<T, BigDecimal> bigDecimalMapper)
  {
    BigDecimal total = BigDecimal.ZERO;
    for (final T each : numberSource)
    {
      final BigDecimal bigDecimal = bigDecimalMapper.apply(each);
      total = total.add(bigDecimal);
    }
    return total;
  }

  public static BigDecimal total(final Iterable<BigDecimal> numbers)
  {
    BigDecimal total = BigDecimal.ZERO;
    for (final BigDecimal each : numbers)
    {
      total = total.add(each);
    }
    return total;
  }

  public static <T> BigDecimal total(final Iterable<T> numberSource, final Function1<T, BigDecimal> bigDecimalMapper)
  {
    BigDecimal total = BigDecimal.ZERO;
    for (final T each : numberSource)
    {
      final BigDecimal bigDecimal = bigDecimalMapper.apply(each);
      total = total.add(bigDecimal);
    }
    return total;
  }
}