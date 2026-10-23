/*
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the MIT License. See the LICENSE file in the project root.
 * SPDX-License-Identifier: MIT
 */
package org.elixirian.kommonlee.examples.util.number;

import java.math.BigDecimal;

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
 * @authoFr Lee, SeongHyun (Kevin)
 * @version 0.0.1 (2012-11-13)
 */
public class OrderedProduct
{
  private Long id;

  private Product product;

  private int quantity;

  public OrderedProduct(final Long id, final Product product, final int quantity)
  {
    this.id = id;
    this.product = product;
    this.quantity = quantity;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(final Long id)
  {
    this.id = id;
  }

  public Product getProduct()
  {
    return product;
  }

  public void setProduct(final Product product)
  {
    this.product = product;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(final int quantity)
  {
    this.quantity = quantity;
  }

  public BigDecimal getTotalPrice()
  {
    return product.getPrice()
        .multiply(BigDecimal.valueOf(quantity));
  }
}
