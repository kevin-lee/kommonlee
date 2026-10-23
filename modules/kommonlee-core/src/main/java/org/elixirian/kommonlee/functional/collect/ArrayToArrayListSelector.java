package org.elixirian.kommonlee.functional.collect;

import static org.elixirian.kommonlee.util.collect.Lists.*;

import java.util.ArrayList;

import org.elixirian.kommonlee.type.functional.Condition1;
import org.elixirian.kommonlee.type.selector.ArraySelector;

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
 * @version 0.0.1 (2011-02-18)
 * @param <E>
 *          type of element to be filtered to remove all the null element in the given array.
 * @param <C>
 */
public final class ArrayToArrayListSelector<E> implements ArraySelector<E, Condition1<? super E>, ArrayList<E>>
{
  ArrayToArrayListSelector()
  {
  }

  @Override
  public ArrayList<E> select(final E[] source, final Condition1<? super E> condition)
  {
    final ArrayList<E> list = newArrayList();
    for (final E each : source)
    {
      if (condition.isMet(each))
      {
        list.add(each);
      }
    }
    return list;
  }
}