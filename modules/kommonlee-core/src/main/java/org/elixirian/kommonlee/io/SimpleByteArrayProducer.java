/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.io;

import java.io.IOException;

import org.elixirian.kommonlee.validation.Assertions;

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
 * @version 0.0.1 (2012-10-18)
 */
public class SimpleByteArrayProducer implements ByteArrayProducer
{
  protected final ByteArrayThreadUnsafeInputStream byteArrayThreadUnsafeInputStream;

  protected SimpleByteArrayProducer(final byte[] byteArray)
  {
    Assertions.assertNotNull(byteArray, "byteArray is null yet it must not be null.");
    this.byteArrayThreadUnsafeInputStream = new ByteArrayThreadUnsafeInputStream(byteArray);
  }

  @Override
  public int produce(final byte[] bytes) throws IOException
  {
    return byteArrayThreadUnsafeInputStream.read(bytes);
  }

  @Override
  public int length()
  {
    return byteArrayThreadUnsafeInputStream.length();
  }

  @Override
  public byte[] toByteArray()
  {
    return byteArrayThreadUnsafeInputStream.toByteArray();
  }
}
