/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.collect;

import org.elixirian.kommonlee.collect.immutable.ImmutableList;
import org.elixirian.kommonlee.collect.immutable.ImmutableLists;
import org.elixirian.kommonlee.type.functional.Condition1;
import org.elixirian.kommonlee.type.functional.Function1;
import org.elixirian.kommonlee.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CollectTest
{

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {
  }

  @Before
  public void setUp() throws Exception
  {
  }

  @After
  public void tearDown() throws Exception
  {
  }

  @Test
  public final void test()
  {
    final ReadableList<String> list =
      new ReadableArrayList<String>("Kevin", "Lee", "blah", "blah blah", null, "not null");
    final ReadableList<Integer> list2 =
      new ReadableArrayList<Integer>(1, 2, 3, 4, 5, 6, 7, 88, 999, 4, 5, 6, 7, 88, 999, 2, 3, 4, 5, 6, 7, 5, 5, 6, 232,
          8);
    final ReadableList<?> list3 =
      new ReadableArrayList<Object>(1, 2, 3, 4, 5, 6, 7, 88, 999, 2, 3, 4, 5, 6, 7, 5, 5, 6, 232, 8);

    System.out.println(list);
    System.out.println(list2);
    System.out.println(list3);

    System.out.println(list2.select(new Condition1<Integer>() {
      @Override
      public boolean isMet(final Integer input)
      {
        return 5 < input.intValue();
      }
    }));

    /* @formatter:off */
    System.out.println(list2.map(new Function1<Integer, Boolean>()
      { @Override public Boolean apply(final Integer input) { return 5 < input.intValue(); } }));
    /* @formatter:on */

    /* @formatter:off */
    System.out.println(list2.mapSelectively(new Condition1<Integer>()
      { @Override public boolean isMet(final Integer input) { return 5 < input.intValue(); } },
      new Function1<Integer, String>()
      { @Override public String apply(final Integer input) { return "{Yeah bigger than five: " + input + "}"; } }));
    /* @formatter:on */
  }

  @Test
  public final void test1()
  {
    System.out.println("\nCollectTest.test1()");
    final ReadableList<String> list = ImmutableLists.listOf("Kevin", "Lee", "blah", "blah blah", null, "not null");
    final ReadableList<Integer> list2 =
      ImmutableLists.listOf(1, 2, 3, 4, 5, 6, 7, 88, 999, 4, 5, 6, 7, 88, 999, 2, 3, 4, 5, 6, 7, 5, 5, 6, 232, 8);
    final ReadableList<?> list3 =
      ImmutableLists.listOf(1, 2, 3, 4, 5, 6, 7, 88, 999, 2, 3, 4, 5, 6, 7, 5, 5, 6, 232, 8);

    System.out.println(list);
    System.out.println(list2);
    System.out.println(list3);

    System.out.println("list2.select 5 < input.intValue(): " + list2.select(new Condition1<Integer>() {
      @Override
      public boolean isMet(final Integer input)
      {
        return 5 < input.intValue();
      }
    }));

    @SuppressWarnings("unchecked")
    final ImmutableList<Integer> emptyList = ImmutableLists.emptyList();
    /* @formatter:off */
    final ImmutableList<Integer> resultFromEmptyListSelect =
        emptyList.select(
            new Condition1<Integer>() {
              @Override
              public boolean isMet(final Integer input)
              {
                return 5 < input.intValue();
              }
            });
    /* @formatter:on */

    System.out.println("emptyList.select: " + resultFromEmptyListSelect);
    final ImmutableList<Integer> emptyListOfIntegerFromImmutableLists = ImmutableLists.<Integer> emptyList();
    System.out.println("emptyList.select == ImmutableLists.<Integer> emptyList()): "
        + (resultFromEmptyListSelect == emptyListOfIntegerFromImmutableLists));

    /* @formatter:off */
    System.out.println("list2.map: "+ list2.map(new Function1<Integer, String>()
        { @Override public String apply(final Integer input) { return -100 > input.intValue() ? "Fewer than -100" : "NO"; } }));
    /* @formatter:on */

    /* @formatter:off */
    final ImmutableList<String> resultFromEmptyListMapMethod = emptyList.map(new Function1<Integer, String>()
        { @Override public String apply(final Integer input) { return -100 > input.intValue() ? "Fewer than -100" : "NO"; } });
    /* @formatter:on */
    System.out.println("someList.map: " + resultFromEmptyListMapMethod);
    final ImmutableList<String> emptyListOfStringFromImmutableLists = ImmutableLists.<String> emptyList();
    System.out.println("resultFromEmptyList.map() == ImmutableArrayList.EMPTY_IMMUTABLE_ARRAY_LIST: "
        + (resultFromEmptyListMapMethod == emptyListOfStringFromImmutableLists));

    /* @formatter:off */
    System.out.println(list2.mapSelectively(new Condition1<Integer>()
        { @Override public boolean isMet(final Integer input) { return 5 < input.intValue(); } },
        new Function1<Integer, String>()
        { @Override public String apply(final Integer input) { return "{Yeah bigger than five: " + input + "}"; } }));
    /* @formatter:on */

    System.out.println("Objects.toStringOf(list2.toArray()): " + Objects.toStringOf(list2.toArray()));
  }

}
