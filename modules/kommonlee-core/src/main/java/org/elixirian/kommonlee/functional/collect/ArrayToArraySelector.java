/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.functional.collect;

import static org.elixirian.kommonlee.util.collect.Lists.*;

import java.lang.reflect.Array;
import java.util.List;

import org.elixirian.kommonlee.type.functional.Condition1;
import org.elixirian.kommonlee.type.selector.ArraySelector;

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
 * @version 0.0.1 (2011-02-26)
 * @param <E>
 *          element
 * @param <C>
 *          condition to select.
 */
public final class ArrayToArraySelector<E, C extends Condition1<? super E>> implements ArraySelector<E, C, E[]>
{
  ArrayToArraySelector()
  {
  }

  @Override
  public E[] select(final E[] source, final C condition)
  {
    final List<E> result = newArrayList();
    for (final E t : source)
    {
      if (condition.isMet(t))
      {
        result.add(t);
      }
    }
    /* @formatter:off */
    @SuppressWarnings("unchecked")
    final E[] resultArray = (E[]) Array.newInstance(
        source.getClass()
              .getComponentType(),
        result.size());
    /* @formatter:on */
    return result.toArray(resultArray);
  }
}
