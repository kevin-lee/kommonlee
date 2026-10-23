/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.functional.collect;

import java.util.Collection;

import org.elixirian.kommonlee.type.functional.Condition1;
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
 * @param <T>
 * @param <C>
 * @param <NE>
 * @param <F>
 * @param <R>
 */
public class IterableToCollectionSelectableMapper<E, T extends Iterable<? extends E>, C extends Condition1<? super E>, NE, F extends Function1<? super E, NE>, R extends Collection<NE>>
    implements Function3<T, C, F, R>
{
  private final CollectionCreator<NE, ? extends R> collectionCreator;

  public <CC extends CollectionCreator<NE, ? extends R>> IterableToCollectionSelectableMapper(final CC collectionCreator)
  {
    this.collectionCreator = collectionCreator;
  }

  @Override
  public R apply( final T source, final C condition, final F function)
  {
    final R result = collectionCreator.createCollection();
    for (final E element : source)
    {
      if (condition.isMet(element))
      {
        result.add(function.apply(element));
      }
    }
    return result;
  }

  /* @formatter:off */
  public static <E,
                   T extends Iterable<? extends E>,
                   C extends Condition1<? super E>,
                   NE,
                   F extends Function1<? super E, NE>,
                   R extends Collection<NE>,
                   CC extends CollectionCreator<NE, ? extends R>>
          IterableToCollectionSelectableMapper<E, T, C, NE, F, R>
    newInstance(final CC collectionCreator)
  {
    return new IterableToCollectionSelectableMapper<E, T, C, NE, F, R>(collectionCreator);
  }
  /* @formatter:on */
}