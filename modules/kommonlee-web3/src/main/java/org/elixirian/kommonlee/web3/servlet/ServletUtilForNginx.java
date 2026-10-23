/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.web3.servlet;

import static org.elixirian.kommonlee.web3.servlet.NginxConstants.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.elixirian.kommonlee.util.CommonConstants;
import org.elixirian.kommonlee.web3.CommonWebConstants;

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
 * @version 0.0.1 (2013-02-07)
 */
public class ServletUtilForNginx
{
  public ServletUtilForNginx() throws IllegalAccessException
  {
    throw new IllegalAccessException(getClass().getName() + CommonConstants.CANNOT_BE_INSTANTIATED);
  }

  public static String getScheme(final HttpServletRequest request)
  {
    final String scheme = request.getScheme();
    if (CommonWebConstants.HTTP.equals(scheme)
        && CommonWebConstants.HTTPS.equals(ServletUtilForNginx.getXForwardedProtocol(request)))
    {
      return CommonWebConstants.HTTPS;
    }
    return scheme;
  }

  public static String getRemoteAddr(final HttpServletRequest request)
  {
    final String realIp = request.getHeader(HEADER_NAME_X_REAL_IP);
    /* @formatter:off */
    return null == realIp ?
            request.getRemoteAddr() :
            realIp;
    /* @formatter:on */
  }

  public static String getRemoteHost(final HttpServletRequest request)
  {
    final String host = request.getHeader(HEADER_NAME_HOST);
    if (null != host)
    {
      return host;
    }
    /*
     * request.getRemoteHost() would return a remote IP address instead of the hostname so get the hostname using
     * InetAddress.
     */
    final String remoteAddr = getRemoteAddr(request);
    try
    {
      return InetAddress.getByName(remoteAddr)
          .getHostName();
    }
    catch (final UnknownHostException e)
    {
      return remoteAddr;
    }
  }

  public static String getForwardRequestUri(final HttpServletRequest request)
  {
    final String forwardFor = request.getHeader(HEADER_NAME_X_FORWARDED_FOR);
    return null == forwardFor ? ServletUtil.getForwardRequestUri(request) : forwardFor;
  }

  public static String getXForwardedProtocol(final HttpServletRequest request)
  {
    return request.getHeader(HEADER_NAME_X_FORWARDED_PROTOCOL);
  }

  public static boolean isSecure(final HttpServletRequest request)
  {
    return request.isSecure() || CommonWebConstants.HTTPS.equals(ServletUtilForNginx.getXForwardedProtocol(request));
  }
}
