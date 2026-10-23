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
import org.elixirian.kommonlee.type.functional.Function1;
import org.elixirian.kommonlee.type.functional.Function4;

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
 * @version 0.0.1 (2011-07-23)
 * @param <E>
 *          source element type
 * @param <C>
 *          condition to choose whether to map the source to the new type, NE, or not
 * @param <NE>
 *          The mapped type from the type E. The return type will be an array of NE.
 * @param <F>
 *          the mapper function
 */
public class ArrayToArraySelectableMapper<E, C extends Condition1<? super E>, NE, F extends Function1<? super E, NE>>
    implements Function4<Class<NE>, E[], C, F, NE[]>
{
  ArrayToArraySelectableMapper()
  {
  }

  @Override
  public NE[] apply(final Class<NE> toArrayOf, final E[] source, final C condition, final F function)
  {
    final List<NE> list = newArrayList();
    for (final E element : source)
    {
      if (condition.isMet(element))
      {
        list.add(function.apply(element));
      }
    }
    /* @formatter:off */
    @SuppressWarnings("unchecked")
    final NE[] resultArray = list.toArray(
        (NE[]) Array
            .newInstance(toArrayOf,
                         list.size()));
    /* @formatter:on */
    return resultArray;
  }
}