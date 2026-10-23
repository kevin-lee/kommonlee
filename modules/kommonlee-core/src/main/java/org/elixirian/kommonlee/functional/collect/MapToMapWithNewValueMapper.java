/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.functional.collect;

import java.util.Map;
import java.util.Map.Entry;

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
 * @param <K>
 *          Key
 * @param <E>
 *          Element
 * @param <T>
 *          Input Map type
 * @param <NE>
 *          New value after function applied.
 * @param <F>
 *          Function to map value
 * @param <R>
 *          Return Map type
 */
public class MapToMapWithNewValueMapper<K, E, T extends Map<? extends K, ? extends E>, NE, F extends Function1<? super E, NE>, R extends Map<K, NE>>
    implements Function2<T, F, R>
{
  private final MapCreator<K, NE, ? extends R> mapCreator;

  public <MC extends MapCreator<K, NE, ? extends R>> MapToMapWithNewValueMapper(final MC mapCreator)
  {
    this.mapCreator = mapCreator;
  }

  @Override
  public R apply(final T inputMap, final F function)
  {
    final R result = mapCreator.createMap();
    for (final Entry<? extends K, ? extends E> entry : inputMap.entrySet())
    {
      result.put(entry.getKey(), function.apply(entry.getValue()));
    }
    return result;
  }

  /* @formatter:off */
  public static <K, E, T extends Map<? extends K, ? extends E>,
                 NE, F extends Function1<? super E, NE>,
                 R extends Map<K, NE>,
                 MC extends MapCreator<K, NE, ? extends R>>
    MapToMapWithNewValueMapper<K, E, T, NE, F, R> newInstance(final MC mapCreator)
  {
    return new MapToMapWithNewValueMapper<K, E, T, NE, F, R>(mapCreator);
  }
  /* @formatter:on */
}