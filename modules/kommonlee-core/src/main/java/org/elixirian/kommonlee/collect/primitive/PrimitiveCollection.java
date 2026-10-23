/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.collect.primitive;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import org.elixirian.kommonlee.type.checkable.EmptinessCheckable;
import org.elixirian.kommonlee.type.checkable.LengthCheckable;
import org.elixirian.kommonlee.type.checkable.NotEmptinessCheckable;
import org.elixirian.kommonlee.type.checkable.SizeCheckable;

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
 * @version 0.0.1 (2013-07-13)
 */
public interface PrimitiveCollection<E extends Comparable<E> & Serializable> extends Iterable<E>, LengthCheckable, SizeCheckable,
    EmptinessCheckable, NotEmptinessCheckable
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

  E[] toBoxedArray();

  Collection<E> convertTo();

  @Override
  int hashCode();

  @Override
  boolean equals(Object element);

  @Override
  String toString();
}
