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

import org.elixirian.kommonlee.type.functional.Function1;
import org.elixirian.kommonlee.type.functional.Function3;

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
 * @param <NE>
 *          The mapped type from the type E. The return type will be an array of NE.
 * @param <F>
 *          Function object to map the source type E to create the type NE
 */
public class ArrayToArrayMapper<E, F extends Function1<? super E, NE>, NE> implements
    Function3<Class<NE>, E[], F, NE[]>
{
  ArrayToArrayMapper()
  {
  }

  @Override
  public NE[] apply(final Class<NE> resultType, final E[] source, final F function)
  {
    final List<NE> list = newArrayList();
    for (final E element : source)
    {
      list.add(function.apply(element));
    }
    /* @formatter:off */
    @SuppressWarnings("unchecked")
    final NE[] resultArray = list.toArray(
        (NE[]) Array
            .newInstance(resultType,
                         list.size()));
    /* @formatter:on */
    return resultArray;
  }
}