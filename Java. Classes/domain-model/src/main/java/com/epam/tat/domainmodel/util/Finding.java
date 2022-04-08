package com.epam.tat.domainmodel.util;

import com.epam.tat.domainmodel.candies.Candy;

import java.util.List;

public interface Finding {

    /**
     * No actions are required within the interface
     * @return
     */
    List<Candy> findCandiesByNameStartedWith(char candyNameFirstLetter);

    List<Candy> findCandiesByWeightInRange(int weightFrom, int weightTo);
}
