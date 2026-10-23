/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.functional.collect;

import java.util.Map;

import org.elixirian.kommonlee.type.Pair;
import org.elixirian.kommonlee.type.functional.Function1;
import org.elixirian.kommonlee.type.functional.Function2;

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
 *          Element
 * @param <T>
 *          Input Map type
 * @param <NK>
 *          Key after function applied.
 * @param <NE>
 *          Value type after the function applied.
 * @param <F>
 *          Function to map Key and Value.
 * @param <R>
 *          Return Map type
 */
public class ArrayToMapMapper<E, NK, NE, F extends Function1<? super E, ? extends Pair<NK, NE>>, R extends Map<NK, NE>>
    implements Function2<E[], F, R>
{
  private final MapCreator<NK, NE, ? extends R> mapCreator;

  public <MC extends MapCreator<NK, NE, ? extends R>> ArrayToMapMapper(final MC mapCreator)
  {
    this.mapCreator = mapCreator;
  }

  @Override
  public R apply(final E[] source, final F function)
  {
    final R result = mapCreator.createMap();
    for (final E e : source)
    {
      final Pair<NK, NE> mappedKeyValuepPair = function.apply(e);
      result.put(mappedKeyValuepPair.getValue1(), mappedKeyValuepPair.getValue2());
    }
    return result;
  }

  /* @formatter:off */
  public static <E,
                 NK,
                 NE,
                 F extends Function1<? super E, ? extends Pair<NK, NE>>,
                 R extends Map<NK, NE>,
                 MC extends MapCreator<NK, NE, ? extends R>>
    ArrayToMapMapper<E, NK, NE, F, R> newInstance(final MC mapCreator)
  {
    return new ArrayToMapMapper<E, NK, NE, F, R>(mapCreator);
  }
  /* @formatter:on */
}