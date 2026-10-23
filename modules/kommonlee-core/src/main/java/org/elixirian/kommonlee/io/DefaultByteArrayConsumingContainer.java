/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
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
public class DefaultByteArrayConsumingContainer implements ByteArrayConsumingContainer
{
  private final ByteArrayOutputStream bytes;

  /**
   * Use {@link DataConsumers} to instantiate this {@link DefaultByteArrayConsumingContainer}.
   * 
   * @param bytes
   */
  DefaultByteArrayConsumingContainer(final ByteArrayOutputStream bytes)
  {
    this.bytes = bytes;
  }

  @Override
  public void consume(final byte[] bytes, final int offset, final int count) throws IOException
  {
    this.bytes.write(bytes, offset, count);
  }

  @Override
  public byte[] toByteArray()
  {
    return this.bytes.toByteArray();
  }

  @Override
  public List<Byte> getDataList()
  {
    return Arrays.asList(NeoArrays.convertToBoxedPrimitive(bytes.toByteArray()));
  }

  @Override
  public String toString()
  {
    /* @formatter:off */
    return new String(bytes.toByteArray());
    /* @formatter:on */
  }

  public static ByteArrayConsumingContainer newInstance()
  {
    return new DefaultByteArrayConsumingContainer(ByteArrayThreadUnsafeOutputStream.newInstance());
  }

  public static ByteArrayConsumingContainer newInstance(final int increaseBy)
  {
    return new DefaultByteArrayConsumingContainer(ByteArrayThreadUnsafeOutputStream.newInstance(increaseBy, increaseBy));
  }

  public static ByteArrayConsumingContainer newInstance(final ByteArrayOutputStream byteArrayOutputStream)
  {
    return new DefaultByteArrayConsumingContainer(byteArrayOutputStream);
  }

}
