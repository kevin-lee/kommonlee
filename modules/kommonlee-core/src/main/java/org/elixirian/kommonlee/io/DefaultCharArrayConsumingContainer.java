/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.io;

import static org.elixirian.kommonlee.util.collect.Lists.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.elixirian.kommonlee.util.NeoArrays;

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
 * @version 0.0.1 (2013-05-12)
 */
public class DefaultCharArrayConsumingContainer implements CharArrayConsumingContainer
{
  private final List<Character> characterList = newArrayList();

  @Override
  public void consume(final char[] chars, final int offset, final int count) throws IOException
  {
    final int length = offset + count;
    for (int i = 0; i < length; i++)
    {
      @SuppressWarnings("boxing")
      final
      Character c = chars[i];
      characterList.add(c);
    }
  }

  @Override
  public List<Character> getDataList()
  {
    return Collections.unmodifiableList(characterList);
  }

  @Override
  public String toString()
  {
    return new String(NeoArrays.convertToPrimitive(characterList.toArray(new Character[0])));
  }
}
