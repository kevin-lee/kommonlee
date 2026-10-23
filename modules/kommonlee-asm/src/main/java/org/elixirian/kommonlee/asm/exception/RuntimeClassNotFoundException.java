/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.asm.exception;

import org.elixirian.kommonlee.exception.ExtraExceptionInformation;
import org.elixirian.kommonlee.exception.InformativeRuntimeException;

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
 * @version 0.0.1 (2012-08-29)
 */
public class RuntimeClassNotFoundException extends InformativeRuntimeException
{
	private static final long serialVersionUID = 6595167991174393566L;

	public RuntimeClassNotFoundException(final ExtraExceptionInformation extraExceptionInformation)
	{
		super(extraExceptionInformation);
	}

	public RuntimeClassNotFoundException(final String message, final ExtraExceptionInformation extraExceptionInformation)
	{
		super(message, extraExceptionInformation);
	}

	public RuntimeClassNotFoundException(final String message, final Throwable cause,
			final ExtraExceptionInformation extraExceptionInformation)
	{
		super(message, cause, extraExceptionInformation);
	}

	public RuntimeClassNotFoundException(final String message, final Throwable cause)
	{
		super(message, cause);
	}

	public RuntimeClassNotFoundException(final String message)
	{
		super(message);
	}

	public RuntimeClassNotFoundException(final Throwable cause, final ExtraExceptionInformation extraExceptionInformation)
	{
		super(cause, extraExceptionInformation);
	}

	public RuntimeClassNotFoundException(final Throwable cause)
	{
		super(cause);
	}
}
