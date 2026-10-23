/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.examples.util.collect;

import static org.elixirian.kommonlee.util.collect.Sets.*;

import java.util.HashSet;
import java.util.Set;

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
public class SetsExamples
{
  public static void main(final String[] args)
  {
    createJdk();

    createKommonLee();

    createAndAddJdk();

    createAndAddKommonLee();

    createHashSetFromAnotherSetJdk();

    createHashSetFromAnotherSetKommonLee();
  }

  private static void createJdk()
  {
    // JDK
    final Set<Integer> integerSet = new HashSet<Integer>();
  }

  private static void createKommonLee()
  {
    // KommonLee
    final Set<Integer> integerSet = newHashSet();
  }

  private static void createAndAddJdk()
  {
    // JDK
    final Set<Integer> integerSet = new HashSet<Integer>();
    integerSet.add(-14);
    integerSet.add(-10);
    integerSet.add(-1);
    integerSet.add(0);
    integerSet.add(1);
    integerSet.add(2);
    integerSet.add(10);
    integerSet.add(35);
    integerSet.add(100);
  }

  private static void createAndAddKommonLee()
  {
    // KommonLee
    final Set<Integer> integerSet2_2 = newHashSet(-14, -10, -1, 0, 1, 2, 10, 35, 100);
  }

  private static void createHashSetFromAnotherSetJdk()
  {
    // JDK
    final Set<Integer> integerSet = new HashSet<Integer>();
    integerSet.add(-14);
    integerSet.add(-10);
    integerSet.add(-1);
    integerSet.add(0);
    integerSet.add(1);
    integerSet.add(2);
    integerSet.add(10);
    integerSet.add(35);
    integerSet.add(100);
    final Set<Integer> anotherintegerSet = new HashSet<Integer>(integerSet);
  }

  private static void createHashSetFromAnotherSetKommonLee()
  {
    // KommonLee
    final Set<Integer> integerSet = newHashSet(-14, -10, -1, 0, 1, 2, 10, 35, 100);
    final Set<Integer> antherintegerSet = newHashSet(integerSet);
  }

}
