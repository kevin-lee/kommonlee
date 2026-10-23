/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.functional.collect;

import static org.elixirian.kommonlee.util.collect.Lists.*;

import java.util.ArrayList;

/**
 * @author Lee, SeongHyun (Kevin)
 * @version 0.0.1 (2011-07-23)
 * @param <E>
 */
public class ArrayListCreator<E> implements CollectionCreator<E, ArrayList<E>>
{
  public static final ArrayListCreator<Object> ARRAY_LIST_CREATOR = new ArrayListCreator<Object>();

  @Override
  public ArrayList<E> createCollection()
  {
    return newArrayList();
  }

  public static <E> ArrayListCreator<E> getInstance()
  {
    @SuppressWarnings("unchecked")
    final ArrayListCreator<E> arrayListCreator = (ArrayListCreator<E>) ARRAY_LIST_CREATOR;
    return arrayListCreator;
  }
}