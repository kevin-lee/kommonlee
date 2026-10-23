/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.asm.analysis.visitor;

import java.lang.reflect.Member;
import java.util.Map;

import org.elixirian.kommonlee.asm.analysis.MemberCollector;
import org.elixirian.kommonlee.lib3rd.asm5.ClassVisitor;
import org.elixirian.kommonlee.lib3rd.asm5.MethodVisitor;
import org.elixirian.kommonlee.lib3rd.asm5.Opcodes;

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
 * @version 0.0.1 (2010-06-15)
 */
public class MethodAnalysisClassVisitor<T, M extends Member> extends ClassVisitor {
  private final MemberCollector<M> memberCollector;
  private final Class<T> theClass;
  private final Map<M, String[]> memberToParameterNamesMap;

  public MethodAnalysisClassVisitor(final int api, final MemberCollector<M> memberCollector, final Class<T> theClass,
      final Map<M, String[]> memberToParameterNamesMap) {
    super(api);
    this.memberCollector = memberCollector;
    this.theClass = theClass;
    this.memberToParameterNamesMap = memberToParameterNamesMap;
  }

  @Override
  public MethodVisitor visitMethod(final int access, final String name, final String desc,
      @SuppressWarnings("unused") final String signature, @SuppressWarnings("unused") final String[] exceptions) {
    if (0 == ((access & Opcodes.ACC_SYNTHETIC) | (access & Opcodes.ACC_BRIDGE))) {
      return new MethodAnalysisMethodVisitor<T, M>(Opcodes.ASM5, memberCollector, theClass, memberToParameterNamesMap, access, name, desc);
    }
    return null;
  }

}
