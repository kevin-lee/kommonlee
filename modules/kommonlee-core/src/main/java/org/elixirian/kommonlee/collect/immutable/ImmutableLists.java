/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.collect.immutable;

import java.util.Collection;

import org.elixirian.kommonlee.collect.Kollection;
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
 * @version 0.0.1 (2011-09-18)
 */
public final class ImmutableLists
{
  private ImmutableLists() throws IllegalAccessException
  {
    throw new IllegalAccessException(getClass().getName() + CommonConstants.CANNOT_BE_INSTANTIATED);
  }

  public static <T> ImmutableList<T> emptyList()
  {
    return ImmutableArrayList.emptyList();
  }

  public static <T> ImmutableList<T> copyOf(final Collection<? extends T> collection)
  {
    return ImmutableArrayList.copyOf(collection);
  }

  public static <T> ImmutableList<T> copyOf(final Kollection<? extends T> kollection)
  {
    return ImmutableArrayList.copyOf(kollection);
  }

  public static <T> ImmutableList<T> listOf(final T... elements)
  {
    return ImmutableArrayList.listOf(elements);
  }

  public static <T> ImmutableList<T> listOf(final T[] elements, final int howMany)
  {
    return ImmutableArrayList.listOf(elements, howMany);
  }
}
