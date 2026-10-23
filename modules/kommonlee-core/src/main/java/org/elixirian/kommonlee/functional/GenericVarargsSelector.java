/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.functional;

import java.util.Collection;

import org.elixirian.kommonlee.functional.collect.CollectionCreator;
import org.elixirian.kommonlee.type.functional.Condition1;
import org.elixirian.kommonlee.type.selector.ArgsSelector;

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
 * @version 0.0.1 (2011-08-27)
 * @param <T>
 * @param <C>
 * @param <R>
 */
public class GenericVarargsSelector<T, C extends Condition1<T>, R extends Collection<T>> implements
    ArgsSelector<T, C, R>
{
  private final CollectionCreator<T, ? extends R> collectionCreator;

  public <CC extends CollectionCreator<T, ? extends R>> GenericVarargsSelector(final CC collectionCreator)
  {
    this.collectionCreator = collectionCreator;
  }

  @Override
  public R select(final C condition, final T first)
  {
    final R result = collectionCreator.createCollection();
    if (condition.isMet(first))
      result.add(first);
    return result;
  }

  @Override
  public R select(final C condition, final T first, final T second)
  {
    final R result = collectionCreator.createCollection();
    if (condition.isMet(first))
      result.add(first);
    if (condition.isMet(second))
      result.add(second);
    return result;
  }

  @Override
  public R select(final C condition, final T first, final T second, final T third)
  {
    final R result = collectionCreator.createCollection();
    if (condition.isMet(first))
      result.add(first);
    if (condition.isMet(second))
      result.add(second);
    if (condition.isMet(third))
      result.add(third);
    return result;
  }

  @Override
  public R select(final C condition, final T first, final T second, final T third, final T fourth)
  {
    final R result = collectionCreator.createCollection();
    if (condition.isMet(first))
      result.add(first);
    if (condition.isMet(second))
      result.add(second);
    if (condition.isMet(third))
      result.add(third);
    if (condition.isMet(fourth))
      result.add(fourth);
    return result;
  }

  @Override
  public R select(final C condition, final T first, final T second, final T third, final T fourth, final T fifth)
  {
    final R result = collectionCreator.createCollection();
    if (condition.isMet(first))
      result.add(first);
    if (condition.isMet(second))
      result.add(second);
    if (condition.isMet(third))
      result.add(third);
    if (condition.isMet(fourth))
      result.add(fourth);
    if (condition.isMet(fifth))
      result.add(fifth);
    return result;
  }

  @Override
  public R select(final C condition, final T first, final T second, final T third, final T fourth, final T fifth,
      final T... rest)
  {
    final R result = select(condition, first, second, third, fourth, fifth);
    for (final T element : rest)
    {
      if (condition.isMet(element))
      {
        result.add(element);
      }
    }
    return result;
  }

  @Override
  public R select(final T[] values, final C condition)
  {
    final R result = collectionCreator.createCollection();
    for (final T element : values)
    {
      if (condition.isMet(element))
      {
        result.add(element);
      }
    }
    return result;
  }

}
