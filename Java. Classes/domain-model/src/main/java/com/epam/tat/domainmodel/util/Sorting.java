package com.epam.tat.domainmodel.util;

import com.epam.tat.domainmodel.candies.Candy;

import java.util.List;

public interface Sorting {

    /**
     * No actions are required within the interface
     */
    List<Candy> sortCandiesByNameAsc();

    List<Candy> sortCandiesByWeightAsc();
}
