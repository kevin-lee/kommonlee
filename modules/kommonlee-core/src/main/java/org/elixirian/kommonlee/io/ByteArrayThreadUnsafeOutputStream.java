/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

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
 * @version 0.0.1 (2013-07-18)
 */
public class ByteArrayThreadUnsafeOutputStream extends ByteArrayOutputStream implements LengthCheckable, SizeCheckable,
    EmptinessCheckable, NotEmptinessCheckable
{
  public static final int DEFAULT_INITIAL_CAPACITY = 32;

  public static final int DEFAULT_INCREASE_SIZE_BY = 32;

  protected final int increaseBy;

  ByteArrayThreadUnsafeOutputStream()
  {
    this(DEFAULT_INITIAL_CAPACITY, DEFAULT_INCREASE_SIZE_BY);
  }

  ByteArrayThreadUnsafeOutputStream(final int size)
  {
    this(size, DEFAULT_INCREASE_SIZE_BY);
  }

  ByteArrayThreadUnsafeOutputStream(final int size, final int increaseSizeBy)
  {
    super(size);
    this.increaseBy = increaseSizeBy;
  }

  public int getIncreaseBy()
  {
    return increaseBy;
  }

  @SuppressWarnings("sync-override")
  @Override
  public void write(final int b)
  {
    final int newcount = count + 1;
    ensureCapacity(newcount);
    buf[count] = (byte) b;
    count = newcount;
  }

  @Override
  public void write(final byte[] b)
  {
    if (null == b)
    {
      throw new NullPointerException("The given byte array b is null.");
    }
    write(b, 0, b.length);
  }

  @SuppressWarnings("sync-override")
  @Override
  public void write(final byte[] b, final int off, final int len)
  {
    if (0 > off || off > b.length || 0 > len || (off + len) - b.length > 0)
    {
      throw new IndexOutOfBoundsException(
          "off and len must be non-negative numbers and (off + len) must be less than or equal to b.length. [b.length="
              + b.length + ", int off=" + off + ", len=" + len + "]");
    }
    ensureCapacity(count + len);
    System.arraycopy(b, off, buf, count, len);
    count += len;
  }

  private void ensureCapacity(final int minimumCapacity)
  {
    if (0 < minimumCapacity - buf.length)
    {
      int newCapacity = buf.length + increaseBy;
      if (0 > newCapacity - minimumCapacity)
      {
        newCapacity = minimumCapacity;
      }
      if (0 > newCapacity)
      {
        if (0 > minimumCapacity)
        {
          throw new OutOfMemoryError();
        }
        newCapacity = Integer.MAX_VALUE;
      }
      buf = Arrays.copyOf(buf, newCapacity);
    }
  }

  @SuppressWarnings("sync-override")
  @Override
  public void writeTo(final OutputStream out) throws IOException
  {
    out.write(buf, 0, count);
  }

  @SuppressWarnings("sync-override")
  @Override
  public void reset()
  {
    count = 0;
  }

  @SuppressWarnings("sync-override")
  @Override
  public byte[] toByteArray()
  {
    return Arrays.copyOf(buf, count);
  }

  @SuppressWarnings("sync-override")
  @Override
  public int size()
  {
    return count;
  }

  @SuppressWarnings("sync-override")
  @Override
  public String toString()
  {
    return new String(buf, 0, count);
  }

  @SuppressWarnings("sync-override")
  @Override
  public String toString(final String charsetName) throws UnsupportedEncodingException
  {
    return new String(buf, 0, count, charsetName);
  }

  public String toString(final Charset charset)
  {
    return new String(buf, 0, count, charset);
  }

  @SuppressWarnings({ "deprecation", "sync-override" })
  @Deprecated
  @Override
  public String toString(final int hibyte)
  {
    return new String(buf, hibyte, 0, count);
  }

  /**
   * This method does NOTHING!
   */
  @Override
  public void flush()
  {
  }

  /**
   * This method does NOTHING!
   */
  @Override
  public void close() throws IOException
  {
  }

  @Override
  public boolean isNotEmpty()
  {
    return !isEmpty();
  }

  @Override
  public boolean isEmpty()
  {
    return 0 == count;
  }

  @Override
  public int length()
  {
    return count;
  }

  public int getCapacity()
  {
    return buf.length;
  }

  public static ByteArrayThreadUnsafeOutputStream newInstance()
  {
    return new ByteArrayThreadUnsafeOutputStream();
  }

  public static ByteArrayThreadUnsafeOutputStream newInstanceWithInitialSize(final int size)
  {
    return new ByteArrayThreadUnsafeOutputStream(size, DEFAULT_INCREASE_SIZE_BY);
  }

  public static ByteArrayThreadUnsafeOutputStream newInstanceWithIncreaseSizeBy(final int increaseBy)
  {
    return new ByteArrayThreadUnsafeOutputStream(DEFAULT_INITIAL_CAPACITY, increaseBy);
  }

  public static ByteArrayThreadUnsafeOutputStream newInstance(final int size, final int increaseBy)
  {
    return new ByteArrayThreadUnsafeOutputStream(size, increaseBy);
  }
}
