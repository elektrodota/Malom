package Model;

/*-
 * #%L
 * Malom
 * %%
 * Copyright (C) 2018 University of Debrecen
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creates ArrayList from arrays.
 */
public class ArrayToList {
    public ArrayToList(){}

    /**
     * Returns a 2D ArrayList from an array.
     * @param twoDArray
     * @return
     */
    public List<List<Integer>> twoDArrayToList(Integer[][] twoDArray) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (Integer[] array : twoDArray) {
            list.add(new ArrayList<Integer>(Arrays.asList(array)));

        }
        return list;
    }

}
