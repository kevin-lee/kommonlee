/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.type;

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
 * This interface is to create a Pair object which stores two objects in order to pass as a parameter or to return as a
 * result or to store in the data structure or just to have two different or the same types in one object for any
 * purposes.
 *
 * @author Lee, SeongHyun (Kevin)
 * @version 0.0.1 (2010-09-14)
 * @param <T1>
 * @param <T2>
 */
public interface Pair<T1, T2>
{
  /**
   * Returns the first object (T1) in this {@link Pair}.
   *
   * @return the first object (T1) in this {@link Pair}.
   */
  T1 getValue1();

  /**
   * Returns the first object (T1) in this {@link Pair}.
   *
   * @return the first object (T1) in this {@link Pair}.
   */
  T1 _1();

  /**
   * Returns the second object (T2) in this {@link Pair}.
   *
   * @return the second object (T2) in this {@link Pair}.
   */
  T2 getValue2();

  /**
   * Returns the second object (T2) in this {@link Pair}.
   *
   * @return the second object (T2) in this {@link Pair}.
   */
  T2 _2();
}