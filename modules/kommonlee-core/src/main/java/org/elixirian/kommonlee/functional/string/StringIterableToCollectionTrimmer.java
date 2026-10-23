/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.functional.string;

import static org.elixirian.kommonlee.util.Strings.*;

import java.util.Collection;

import org.elixirian.kommonlee.functional.collect.CollectionCreator;
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
 * @version 0.0.1 (2011-02-18)
 * @param <OUT>
 *          type of collection which contains the trimmed strings.
 */
public final class StringIterableToCollectionTrimmer<OUT extends Collection<String>> implements
    Function1<Iterable<String>, OUT>
{
  private final CollectionCreator<String, ? extends OUT> collectionCreator;

  public <CC extends CollectionCreator<String, ? extends OUT>> StringIterableToCollectionTrimmer(
      final CC collectionCreator)
  {
    this.collectionCreator = collectionCreator;
  }

  @Override
  public OUT apply(final Iterable<String> input)
  {
    final OUT result = collectionCreator.createCollection();

    for (final String each : input)
    {
      result.add(nullSafeTrim(each));
    }
    return result;
  }

  public static <C extends Collection<String>, CC extends CollectionCreator<String, ? extends C>> StringIterableToCollectionTrimmer<C> newInstance(
      final CC collectionCreator)
  {
    return new StringIterableToCollectionTrimmer<C>(collectionCreator);
  }
}