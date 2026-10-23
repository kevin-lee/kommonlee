/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.util.type;

import static org.elixirian.kommonlee.util.MessageFormatter.*;
import static org.elixirian.kommonlee.util.Objects.*;

import org.elixirian.kommonlee.type.Tuple3;

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
 * The default implementation of the {@link Tuple3} interface. It is an immutable tuple object.
 *
 * @author Lee, SeongHyun (Kevin)
 * @version 0.0.1 (2010-09-14)
 * @param <T1>
 * @param <T2>
 * @param <T3>
 */
public class ImmutableTuple3<T1, T2, T3> implements Tuple3<T1, T2, T3>
{
  private final T1 value1;
  private final T2 value2;
  private final T3 value3;

  public ImmutableTuple3(final T1 value1, final T2 value2, final T3 value3)
  {
    this.value1 = value1;
    this.value2 = value2;
    this.value3 = value3;
  }

  @Override
  public T1 getValue1()
  {
    return _1();
  }

  @Override
  public T1 _1()
  {
    return value1;
  }

  @Override
  public T2 getValue2()
  {
    return _2();
  }

  @Override
  public T2 _2()
  {
    return value2;
  }

  @Override
  public T3 getValue3()
  {
    return _3();
  }

  @Override
  public T3 _3()
  {
    return value3;
  }

  @Override
  public int hashCode()
  {
    return hash(value1, value2, value3);
  }

  @Override
  public boolean equals(final Object tuple)
  {
    if (this == tuple)
    {
      return true;
    }
    final Tuple3<?, ?, ?> that = castIfInstanceOf(Tuple3.class, tuple);
    /* @formatter:off */
    return null != that &&
        (equal(this.value1, that._1()) &&
         equal(this.value2, that._2()) &&
         equal(this.value3, that._3()));
    /* @formatter:on */
  }

  @Override
  public String toString()
  {
    /* @formatter:off */
    return format("(%s, %s, %s)", value1, value2, value3);
    /* @formatter:on */
  }
}