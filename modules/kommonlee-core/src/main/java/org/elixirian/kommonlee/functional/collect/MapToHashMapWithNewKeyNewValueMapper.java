/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.functional.collect;

import java.util.HashMap;
import java.util.Map;

import org.elixirian.kommonlee.type.Pair;
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
 * @param <NK>
 *          New Key after function applied.
 * @param <NE>
 *          New Value after the function applied.
 * @param <F>
 *          Function to map Key and Value
 */
public class MapToHashMapWithNewKeyNewValueMapper<K, E, T extends Map<? extends K, ? extends E>, NK, NE, F extends Function2<? super K, ? super E, Pair<NK, NE>>>
    extends MapToMapWithNewKeyNewValueMapper<K, E, T, NK, NE, F, HashMap<NK, NE>>
{
  MapToHashMapWithNewKeyNewValueMapper(final HashMapCreator<NK, NE> mapCreator)
  {
    super(mapCreator);
  }

  /* @formatter:off */
  public static <K,
                 E,
                 T extends Map<? extends K, ? extends E>,
                 NK,
                 NE,
                 F extends Function2<? super K, ? super E, Pair<NK, NE>>>
    MapToHashMapWithNewKeyNewValueMapper<K, E, T, NK, NE, F> newInstance(final HashMapCreator<NK, NE> mapCreator)
  {
    return new MapToHashMapWithNewKeyNewValueMapper<K, E, T, NK, NE, F>(mapCreator);
  }
  /* @formatter:on */
}