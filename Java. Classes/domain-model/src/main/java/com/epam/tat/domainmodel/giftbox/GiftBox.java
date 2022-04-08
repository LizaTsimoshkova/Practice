package com.epam.tat.domainmodel.giftbox;

import com.epam.tat.domainmodel.candies.Candy;
import com.epam.tat.domainmodel.util.Finding;
import com.epam.tat.domainmodel.util.Sorting;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class Description:
 * Implement interfaces: Sorting and Finding and
 * their methods for sorting candies by name or weight and
 * finding candies by parameters.
 * <p>
 */
public class GiftBox implements Finding, Sorting {
    /**
     * No actions are required for class variable candiesList.
     */
    private List<Candy> candiesList;

    /**
     * No actions are required for constructor GiftBox().
     */
    public GiftBox() {
        candiesList = new ArrayList<Candy>();
    }

    /**
     * No actions are required for method addCandy().
     */
    public void addCandy(Candy candy) {
        this.candiesList.add(candy);
    }

    /**
     * Implement sorting of candiesList by its names in ascending order
     * and return sorted by name ascending list of candies.
     */
    @Override
    public List<Candy> sortCandiesByNameAsc() {
        return candiesList.stream()
                    .sorted(Comparator.comparing(Candy::getName)).collect(Collectors.toList());
    }

    /**
     * Implement sorting of candiesList by its weight in ascending order
     * and return sorted by weight ascending list of candies.
     */
    @Override
    public List<Candy> sortCandiesByWeightAsc() {
        return candiesList.stream()
                    .sorted(Comparator.comparing(Candy::getWeight)).collect(Collectors.toList());
    }


    /**
     * Implement selection of candies from candiesList with names started with candyNameFirstLetter
     * and return list of candies which names started with candyNameFirstLetter in name ascending list of candies.
     * @return
     */
    @Override
    public List<Candy> findCandiesByNameStartedWith(char candyNameFirstLetter) {
        return candiesList .stream()
                .filter(name -> name.getName()
                .startsWith(String.valueOf(candyNameFirstLetter)))
                .sorted(Comparator.comparing(Candy::getName))
                .collect(Collectors.toList());
    }

    /**
     * Implement selection ot candies from candiesList so that its [weightFrom <= weight => weightTo]
     * and return list of candies with weight in range [weightFrom, weightTo] in weight ascending list of candies.
     */
    @Override
    public List<Candy> findCandiesByWeightInRange(int weightFrom, int weightTo) {
        return candiesList.stream()
                    .filter(weight -> weight.getWeight() >= weightFrom && weight.getWeight() <= weightTo)
                    .sorted(Comparator.comparing(Candy::getWeight))
                    .collect(Collectors.toList());
    }

}
