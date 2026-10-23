/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.functional.collect;

import java.util.HashMap;
import java.util.Map;

import org.elixirian.kommonlee.type.functional.Function1;

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
 */
public class MapToHashMapWithNewValueMapper<K, E, T extends Map<? extends K, ? extends E>, NE, F extends Function1<? super E, NE>>
    extends
    MapToMapWithNewValueMapper<K, E, Map<? extends K, ? extends E>, NE, Function1<? super E, NE>, HashMap<K, NE>>
{
  MapToHashMapWithNewValueMapper(final HashMapCreator<K, NE> mapCreator)
  {
    super(mapCreator);
  }

  /* @formatter:off */
  public static <K,
                 E,
                 T extends Map<? extends K, ? extends E>,
                 NE,
                 F extends Function1<? super E, NE>>
    MapToHashMapWithNewValueMapper<K, E, T, NE, F> newInstance(final HashMapCreator<K, NE> mapCreator)
  {
    return new MapToHashMapWithNewValueMapper<K, E, T, NE, F>(mapCreator);
  }
  /* @formatter:on */
}