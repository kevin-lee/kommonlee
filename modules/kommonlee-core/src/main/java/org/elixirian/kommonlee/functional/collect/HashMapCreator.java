/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.functional.collect;

import static org.elixirian.kommonlee.util.collect.Maps.*;

import java.util.HashMap;


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
 * @param <K>
 * @param <E>
 */
public class HashMapCreator<K, E> implements MapCreator<K, E, HashMap<K, E>>
{
  public static final HashMapCreator<Object, Object> HASH_MAP_CREATOR = new HashMapCreator<Object, Object>();
  
  @Override
  public HashMap<K, E> createMap()
  {
    return newHashMap();
  }

  public static <K, E> HashMapCreator<K, E> getInstance()
  {
    @SuppressWarnings("unchecked")
    final HashMapCreator<K, E> hashMapCreator = (HashMapCreator<K, E>) HASH_MAP_CREATOR;
    return hashMapCreator;
  }
}