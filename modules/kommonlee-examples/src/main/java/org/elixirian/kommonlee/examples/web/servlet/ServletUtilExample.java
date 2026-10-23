/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.examples.web.servlet;

import static org.elixirian.kommonlee.web3.servlet.ServletUtil.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
 * @version 0.0.1 (2012-11-03)
 */
public class ServletUtilExample
{
  private static void getAttributeExample(final HttpServletRequest request)
  {
    // Servlet
    @SuppressWarnings("unused")
    final String someString1 = (String) request.getAttribute("someString");

    @SuppressWarnings("unchecked")
    final List<String> nameList = (List<String>) request.getAttribute("nameList");

    // KommonLee
    final String someString2 = getAttribute(request, "someString");

    final List<String> nameList2 = getAttribute(request, "nameList");
  }

  private static void getForwardRequestUriExample(final HttpServletRequest request)
  {
    // Servlet
    final String forwardRequestUri1 = (String) request.getAttribute("javax.servlet.forward.request_uri");

    // KommonLee
    final String forwardRequestUri2 = getForwardRequestUri(request);
  }

}
