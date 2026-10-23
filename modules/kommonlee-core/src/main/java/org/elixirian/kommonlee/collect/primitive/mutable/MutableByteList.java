/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.collect.primitive.mutable;

import java.util.List;

import org.elixirian.kommonlee.collect.primitive.ByteList;
import org.elixirian.kommonlee.type.functional.primitive.ByteCondition1;
import org.elixirian.kommonlee.type.functional.primitive.ByteToByteFunction1;
import org.elixirian.kommonlee.type.mutable.Clearable;
import org.elixirian.kommonlee.type.mutable.Trimmable;

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
public interface MutableByteList extends ByteList, Trimmable<MutableByteList>, Clearable
{
  @Override
  MutableByteList select(ByteCondition1 condition);

  @Override
  MutableByteList mapToByte(ByteToByteFunction1 function);

  @Override
  MutableByteList mapToByteSelectively(ByteCondition1 condition, ByteToByteFunction1 function);

  @Override
  List<Byte> convertTo();

  @Override
  MutableByteList subList(int fromIndex, int toIndex);

  boolean add(byte element);

  boolean addAll(byte[] elements);

  boolean addAll(ByteList elements);

  byte removeAt(int index);

  boolean remove(byte element);

  int getIncreaseBy();

  @Override
  MutableByteList trim();

  @Override
  void clear();
}
