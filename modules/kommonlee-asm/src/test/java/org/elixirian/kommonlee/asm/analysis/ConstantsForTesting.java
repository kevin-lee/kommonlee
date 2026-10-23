/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.asm.analysis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.elixirian.kommonlee.util.CommonConstants;

/**
 * @author Lee, SeongHyun (Kevin)
 * @version 0.0.1 (2010-06-23)
 */
public final class ConstantsForTesting {
  @Target({ ElementType.METHOD })
  @Retention(RetentionPolicy.RUNTIME)
  static @interface MethodAnnotation {
    String value() default "";
  }

  @Target({ ElementType.METHOD })
  @Retention(RetentionPolicy.RUNTIME)
  static @interface AnotherMethodAnnotation {
    String value() default "";
  }

  @Target({ ElementType.PARAMETER })
  @Retention(RetentionPolicy.RUNTIME)
  static @interface ParamAnnotation {
    String value() default "";

    int number() default 0;
  }

  @Target({ ElementType.PARAMETER })
  @Retention(RetentionPolicy.RUNTIME)
  static @interface AnotherParamAnnotation {
    String value() default "default";

    String[] arrayValue() default { "defaultArray" };
  }

  static class TestPojo {
    public TestPojo() {
    }

    public TestPojo(@SuppressWarnings("unused") @ParamAnnotation(value = "someName", number = 2) @AnotherParamAnnotation() final String name) {
    }

    public TestPojo(
        @SuppressWarnings("unused") @ParamAnnotation(value = "someName", number = 2) @AnotherParamAnnotation() final String name,
        @SuppressWarnings("unused") @ParamAnnotation final int number) {
    }

    public TestPojo(@SuppressWarnings("unused") final TestPojo another) {
    }

    @AnotherMethodAnnotation
    @MethodAnnotation("something")
    public void testMethod1(@SuppressWarnings("unused") @AnotherParamAnnotation(arrayValue = { "A", "B" }, value = "test") final String name) {
    }

    public String testMethod2(@SuppressWarnings("unused") final int number) {
      return null;
    }

    public TestPojo testMethod3(@SuppressWarnings("unused") final Long id) {
      return null;
    }

    public void testMethod4(@SuppressWarnings("unused") final TestPojo another) {
    }

    public <T> String testGenericMethod(final T value) {
      return String.valueOf(value);
    }
  }

  /**
   * An empty class array.
   */
  public static final Class<?>[] PARAMS0 = new Class[0];

  /**
   * new Class[] { String.class }
   */
  public static final Class<?>[] PARAMS1 = new Class[] { String.class };

  /**
   * new Class[] { int.class }
   */
  public static final Class<?>[] PARAMS2 = new Class[] { int.class };

  /**
   * new Class[] { Long.class }
   */
  public static final Class<?>[] PARAMS3 = new Class[] { Long.class };

  /**
   * new Class[] { TestPojo.class }
   */
  public static final Class<?>[] PARAMS4 = new Class[] { TestPojo.class };

  private ConstantsForTesting() {
    throw new IllegalStateException(getClass() + CommonConstants.CANNOT_BE_INSTANTIATED);
  }
}
