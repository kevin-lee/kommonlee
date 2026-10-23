/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.type;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

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
 * This test is to demonstrate how to use the {@link Pair} interface.
 *
 * @author Lee, SeongHyun (Kevin)
 * @version 0.0.1 (2010-11-14)
 */
public class Tuple2Test
{
  private static final String GIVEN_NAME = "Kevin";
  private static final String SURNAME = "Lee";
  private static final Long NUMBER = Long.valueOf(12345L);

  /* @formatter:off */
  private static class Pojo
  {
    private final String name;
    public Pojo(final String name) {   this.name = name; }
    public String getName()   { return name; }
  }

  private static class AnotherPojo
  {
    private final Long number;
    public AnotherPojo(final Long number) { this.number = number; }
    public Long getNumber() { return number; }
  }
  /* @formatter:on */

  private static class PojoPair implements Tuple2<Pojo, Pojo>
  {
    private final Pojo left;
    private final Pojo right;

    public PojoPair(final Pojo left, final Pojo right)
    {
      this.left = left;
      this.right = right;
    }

    @Override
    public Pojo getValue1()
    {
      return left;
    }

    @Override
    public Pojo getValue2()
    {
      return right;
    }

    @Override
    public Pojo _1()
    {
      return getValue1();
    }

    @Override
    public Pojo _2()
    {
      return getValue2();
    }
  }

  private static class PojoAnotherPojoPair implements Tuple2<Pojo, AnotherPojo>
  {
    private final Pojo left;
    private final AnotherPojo right;

    public PojoAnotherPojoPair(final Pojo left, final AnotherPojo right)
    {
      this.left = left;
      this.right = right;
    }

    @Override
    public Pojo getValue1()
    {
      return left;
    }

    @Override
    public AnotherPojo getValue2()
    {
      return right;
    }

    @Override
    public Pojo _1()
    {
      return getValue1();
    }

    @Override
    public AnotherPojo _2()
    {
      return getValue2();
    }
  }

  @Test
  public final void testGetLeft()
  {
    final Pair<Pojo, Pojo> pojoPair = new PojoPair(new Pojo(GIVEN_NAME), new Pojo(SURNAME));
    assertThat(pojoPair.getValue1()
        .getName(), is(equalTo(GIVEN_NAME)));

    final Pair<Pojo, AnotherPojo> pojoAnotherPojoPair =
      new PojoAnotherPojoPair(new Pojo(GIVEN_NAME), new AnotherPojo(NUMBER));
    assertThat(pojoAnotherPojoPair.getValue1()
        .getName(), is(equalTo(GIVEN_NAME)));
  }

  @Test
  public final void testGetRight()
  {
    final Pair<Pojo, Pojo> pojoPair = new PojoPair(new Pojo(GIVEN_NAME), new Pojo(SURNAME));
    assertThat(pojoPair.getValue2()
        .getName(), is(equalTo(SURNAME)));

    final Pair<Pojo, AnotherPojo> pojoAnotherPojoPair =
      new PojoAnotherPojoPair(new Pojo(GIVEN_NAME), new AnotherPojo(NUMBER));
    assertThat(pojoAnotherPojoPair.getValue2()
        .getNumber(), is(equalTo(NUMBER)));
  }

  @Test
  public final void testGetLeftAndGetRight()
  {
    final Pair<Pojo, Pojo> pojoPair = new PojoPair(new Pojo(GIVEN_NAME), new Pojo(SURNAME));
    assertThat(pojoPair.getValue1()
        .getName(), is(equalTo(GIVEN_NAME)));
    assertThat(pojoPair.getValue2()
        .getName(), is(equalTo(SURNAME)));

    final Pair<Pojo, AnotherPojo> pojoAnotherPojoPair =
      new PojoAnotherPojoPair(new Pojo(GIVEN_NAME), new AnotherPojo(NUMBER));
    assertThat(pojoAnotherPojoPair.getValue1()
        .getName(), is(equalTo(GIVEN_NAME)));
    assertThat(pojoAnotherPojoPair.getValue2()
        .getNumber(), is(equalTo(NUMBER)));
  }

}
