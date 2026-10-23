/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.collect;

import java.util.Collection;
import java.util.Iterator;

import org.elixirian.kommonlee.functional.BreakableFunction1;
import org.elixirian.kommonlee.functional.VoidFunction1;
import org.elixirian.kommonlee.type.checkable.EmptinessCheckable;
import org.elixirian.kommonlee.type.checkable.LengthCheckable;
import org.elixirian.kommonlee.type.checkable.NotEmptinessCheckable;
import org.elixirian.kommonlee.type.checkable.SizeCheckable;
import org.elixirian.kommonlee.type.functional.Condition1;
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
 * @version 0.0.1 (2011-09-18)
 */
public interface Kollection<E> extends Iterable<E>, LengthCheckable, SizeCheckable, EmptinessCheckable,
    NotEmptinessCheckable
{
  @Override
  Iterator<E> iterator();

  @Override
  int length();

  /**
   * It must be the same as {@link #length()}.
   */
  @Override
  int size();

  @Override
  boolean isEmpty();

  @Override
  boolean isNotEmpty();

  boolean exists(Condition1<? super E> seeker);

  boolean contains(Object element);

  boolean containsAll(Kollection<?> kollection);

  /**
   * Finds the first element in the {@link Kollection} satisfying the given condition, if any.
   * 
   * @param condition
   *          the given condition to find the element
   * @return the first element in the {@link Kollection} satisfying the given condition. null if there is no element
   *         satisfying the condition.
   */
  E find(Condition1<? super E> condition);

  Kollection<E> select(Condition1<? super E> condition);

  <R> Kollection<R> map(Function1<? super E, R> function);

  <R> Kollection<R> mapSelectively(Condition1<? super E> condition, Function1<? super E, R> function);

  void forEach(VoidFunction1<? super E> function);

  void breakableForEach(BreakableFunction1<? super E> function);

  int howMany(Condition1<? super E> conditionToMeet);

  <R, F2 extends Function2<? super R, ? super E, R>> R foldLeft(R startValue, F2 function);

  <R, F2 extends Function2<? super R, ? super E, R>> Function1<F2, R> foldLeft(R startValue);

  <R, F2 extends Function2<? super E, ? super R, R>> Function1<F2, R> foldRight(R startValue);

  <R, F2 extends Function2<? super E, ? super R, R>> R foldRight(R startValue, F2 function);
  
  E reduce(Function2<? super E, ? super E, E> function);

  Object[] toArray();

  E[] toArray(E[] elements);

  Collection<E> convertTo();

  @Override
  int hashCode();

  @Override
  boolean equals(Object element);

  boolean notEquals(Object element);

  @Override
  String toString();
}
