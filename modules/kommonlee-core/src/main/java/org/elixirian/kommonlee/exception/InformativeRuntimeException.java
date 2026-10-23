/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.exception;

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
 * @version 0.0.1 (2012-06-05)
 */
public abstract class InformativeRuntimeException extends ElixirianRuntimeException
{
  private static final long serialVersionUID = -6976968193484353401L;

  private final ExtraExceptionInformation extraExceptionInformation;

  public InformativeRuntimeException(final String message)
  {
    super(message);
    this.extraExceptionInformation = ExtraExceptionInformation.EMPTY_EXTRA_EXCEPTION_INFORMATION;
  }

  public InformativeRuntimeException(final Throwable cause)
  {
    super(cause);
    this.extraExceptionInformation = ExtraExceptionInformation.EMPTY_EXTRA_EXCEPTION_INFORMATION;
  }

  public InformativeRuntimeException(final String message, final Throwable cause)
  {
    super(message, cause);
    this.extraExceptionInformation = ExtraExceptionInformation.EMPTY_EXTRA_EXCEPTION_INFORMATION;
  }

  public InformativeRuntimeException(final ExtraExceptionInformation extraExceptionInformation)
  {
    this.extraExceptionInformation =
      null == extraExceptionInformation ? ExtraExceptionInformation.EMPTY_EXTRA_EXCEPTION_INFORMATION
          : extraExceptionInformation;
  }

  public InformativeRuntimeException(final String message, final ExtraExceptionInformation extraExceptionInformation)
  {
    super(message);
    this.extraExceptionInformation =
      null == extraExceptionInformation ? ExtraExceptionInformation.EMPTY_EXTRA_EXCEPTION_INFORMATION
          : extraExceptionInformation;
  }

  public InformativeRuntimeException(final Throwable cause, final ExtraExceptionInformation extraExceptionInformation)
  {
    super(cause);
    this.extraExceptionInformation =
      null == extraExceptionInformation ? ExtraExceptionInformation.EMPTY_EXTRA_EXCEPTION_INFORMATION
          : extraExceptionInformation;
  }

  public InformativeRuntimeException(final String message, final Throwable cause,
      final ExtraExceptionInformation extraExceptionInformation)
  {
    super(message, cause);
    this.extraExceptionInformation =
      null == extraExceptionInformation ? ExtraExceptionInformation.EMPTY_EXTRA_EXCEPTION_INFORMATION
          : extraExceptionInformation;
  }

  public ExtraExceptionInformation getExtraExceptionInformation()
  {
    return extraExceptionInformation;
  }

  @Override
  public String toString()
  {
    return super.toString() + "\n" + getExtraExceptionInformation();
  }
}
