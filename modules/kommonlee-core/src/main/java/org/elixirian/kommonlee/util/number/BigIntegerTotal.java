/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.util.number;

import java.math.BigInteger;

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
public final class BigIntegerTotal
{
  private BigIntegerTotal() throws IllegalAccessException
  {
    throw new IllegalAccessException(getClass().getName() + CommonConstants.CANNOT_BE_INSTANTIATED);
  }

  public static BigInteger total(final BigInteger number1, final BigInteger number2)
  {
    return number1.add(number2);
  }

  public static BigInteger total(final BigInteger number1, final BigInteger number2, final BigInteger number3)
  {
    return number1.add(number2)
        .add(number3);
  }

  public static BigInteger total(final BigInteger number1, final BigInteger number2, final BigInteger number3,
      final BigInteger number4)
  {
    return number1.add(number2)
        .add(number3)
        .add(number4);
  }

  public static BigInteger total(final BigInteger number1, final BigInteger number2, final BigInteger number3,
      final BigInteger number4, final BigInteger number5)
  {
    return number1.add(number2)
        .add(number3)
        .add(number4)
        .add(number5);
  }

  public static BigInteger total(final BigInteger number1, final BigInteger number2, final BigInteger number3,
      final BigInteger number4, final BigInteger number5, final BigInteger... rest)
  {
    BigInteger total = total(number1, number2, number3, number4, number5);
    for (final BigInteger each : rest)
    {
      total = total.add(each);
    }
    return total;
  }

  public static BigInteger total(final BigInteger[] numbers)
  {
    BigInteger total = BigInteger.ZERO;
    for (final BigInteger each : numbers)
    {
      total = total.add(each);
    }
    return total;
  }

  public static <T> BigInteger total(final T[] numberSource, final Function1<T, BigInteger> bigIntegerMapper)
  {
    BigInteger total = BigInteger.ZERO;
    for (final T each : numberSource)
    {
      final BigInteger bigInteger = bigIntegerMapper.apply(each);
      total = total.add(bigInteger);
    }
    return total;
  }

  public static BigInteger total(final Iterable<BigInteger> numbers)
  {
    BigInteger total = BigInteger.ZERO;
    for (final BigInteger each : numbers)
    {
      total = total.add(each);
    }
    return total;
  }

  public static <T> BigInteger total(final Iterable<T> numberSource, final Function1<T, BigInteger> bigIntegerMapper)
  {
    BigInteger total = BigInteger.ZERO;
    for (final T each : numberSource)
    {
      final BigInteger bigInteger = bigIntegerMapper.apply(each);
      total = total.add(bigInteger);
    }
    return total;
  }
}