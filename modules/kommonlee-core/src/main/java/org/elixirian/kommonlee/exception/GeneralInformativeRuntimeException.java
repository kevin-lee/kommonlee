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
 * @version 0.0.1 (2012-10-07)
 */
public class GeneralInformativeRuntimeException extends InformativeRuntimeException
{
  private static final long serialVersionUID = 1629232711251802574L;

  public GeneralInformativeRuntimeException(final ExtraExceptionInformation extraExceptionInformation)
  {
    super(extraExceptionInformation);
  }

  public GeneralInformativeRuntimeException(final String message,
      final ExtraExceptionInformation extraExceptionInformation)
  {
    super(message, extraExceptionInformation);
  }

  public GeneralInformativeRuntimeException(final String message, final Throwable cause,
      final ExtraExceptionInformation extraExceptionInformation)
  {
    super(message, cause, extraExceptionInformation);
  }

  public GeneralInformativeRuntimeException(final String message, final Throwable cause)
  {
    super(message, cause);
  }

  public GeneralInformativeRuntimeException(final String message)
  {
    super(message);
  }

  public GeneralInformativeRuntimeException(final Throwable cause,
      final ExtraExceptionInformation extraExceptionInformation)
  {
    super(cause, extraExceptionInformation);
  }

  public GeneralInformativeRuntimeException(final Throwable cause)
  {
    super(cause);
  }

}
