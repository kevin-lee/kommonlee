/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.examples.util.collect;

import static org.elixirian.kommonlee.util.collect.Lists.*;

import java.util.ArrayList;
import java.util.List;

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
 * @version 0.0.1 (2012-11-03)
 */
public class ListsExamples
{
  public static void main(final String[] args)
  {
    createNewArrayList();

    createAndAddJdk();

    createAndAddKommonLee();

    createAndAddJdk();

    createFromAnotherListJdk();

    createAndAddKommonLee();

    createFromAnotherListKommonLee();
  }

  private static void createNewArrayList()
  {
    // JDK
    final List<Integer> integerList1_1 = new ArrayList<Integer>();

    // KommonLee
    final List<Integer> integerList2_1 = newArrayList();
  }

  private static void createAndAddJdk()
  {
    // JDK
    final List<Integer> integerList = new ArrayList<Integer>();
    integerList.add(-14);
    integerList.add(-10);
    integerList.add(-1);
    integerList.add(0);
    integerList.add(1);
    integerList.add(2);
    integerList.add(10);
    integerList.add(35);
    integerList.add(100);
  }

  private static void createAndAddKommonLee()
  {
    // KommonLee
    final List<Integer> integerList = newArrayList(-14, -10, -1, 0, 1, 2, 10, 35, 100);
  }

  private static void createFromAnotherListJdk()
  {
    // JDK
    final List<Integer> integerList = new ArrayList<Integer>();
    integerList.add(-14);
    integerList.add(-10);
    integerList.add(-1);
    integerList.add(0);
    integerList.add(1);
    integerList.add(2);
    integerList.add(10);
    integerList.add(35);
    integerList.add(100);

    final List<Integer> anotherIntegerList = new ArrayList<Integer>(integerList);
    System.out.println("integerList: " + integerList);
    System.out.println("anotherIntegerList: " + anotherIntegerList);
  }

  private static void createFromAnotherListKommonLee()
  {
    // KommonLee
    final List<Integer> integerList = newArrayList(-14, -10, -1, 0, 1, 2, 10, 35, 100);
    final List<Integer> antherIntegerList = newArrayList(integerList);
  }
}
