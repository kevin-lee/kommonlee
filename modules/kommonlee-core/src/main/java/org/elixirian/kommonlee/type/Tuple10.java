/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.type;

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
 * @version 0.0.1 (2014-04-19)
 */
public interface Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>
{
  T1 getValue1();

  T1 _1();

  T2 getValue2();

  T2 _2();

  T3 getValue3();

  T3 _3();

  T4 getValue4();

  T4 _4();

  T5 getValue5();

  T5 _5();

  T6 getValue6();

  T6 _6();

  T7 getValue7();

  T7 _7();

  T8 getValue8();

  T8 _8();

  T9 getValue9();

  T9 _9();

  T10 getValue10();

  T10 _10();
}
