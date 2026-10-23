/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.functional.collect;

import java.util.HashMap;

import org.elixirian.kommonlee.type.Pair;
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
public class IterableToHashMapMapper<E, T extends Iterable<? extends E>, NK, NE, F extends Function1<? super E, ? extends Pair<NK, NE>>>
    extends IterableToMapMapper<E, T, NK, NE, F, HashMap<NK, NE>>
{

  IterableToHashMapMapper(final HashMapCreator<NK, NE> mapCreator)
  {
    super(mapCreator);
  }

  /* @formatter:off */
  public static <E,
                 T extends Iterable<? extends E>,
                 NK,
                 NE,
                 F extends Function1<? super E, ? extends Pair<NK, NE>>>
    IterableToHashMapMapper<E, T, NK, NE, F> newInstance(final HashMapCreator<NK, NE> mapCreator)
  {
    return new IterableToHashMapMapper<E, T, NK, NE, F>(mapCreator);
  }
  /* @formatter:on */
}