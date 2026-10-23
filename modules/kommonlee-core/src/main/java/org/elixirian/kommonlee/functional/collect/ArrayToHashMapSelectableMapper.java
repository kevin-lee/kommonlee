/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.functional.collect;

import java.util.HashMap;

import org.elixirian.kommonlee.type.Pair;
import org.elixirian.kommonlee.type.functional.Condition1;
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
 * @version 0.0.1 (2014-03-26)
 * @param <E>
 *          element type
 * @param <NK>
 *          key type
 * @param <NE>
 *          new value type
 * @param <C>
 *          condition
 * @param <F>
 *          mapper to convert an element to a key value pair.
 */
public class ArrayToHashMapSelectableMapper<E, NK, NE, C extends Condition1<? super E>, F extends Function1<? super E, ? extends Pair<NK, NE>>>
    extends ArrayToMapSelectableMapper<E, NK, NE, C, F, HashMap<NK, NE>>
{

  ArrayToHashMapSelectableMapper(final HashMapCreator<NK, NE> hashMapCreator)
  {
    super(hashMapCreator);
    // TODO Auto-generated constructor stub
  }

  /* @formatter:off */
  public static <E,
                 NK,
                 NE,
                 C extends Condition1<? super E>,
                 F extends Function1<? super E, ? extends Pair<NK, NE>>>
    ArrayToHashMapSelectableMapper<E, NK, NE, C, F>
    newInstance(final HashMapCreator<NK, NE> hashMapCreator)
  {
    return new ArrayToHashMapSelectableMapper<E, NK, NE, C, F>(hashMapCreator);
  }
  /* @formatter:on */
}