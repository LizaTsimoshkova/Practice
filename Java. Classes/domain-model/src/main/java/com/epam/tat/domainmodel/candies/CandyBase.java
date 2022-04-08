package com.epam.tat.domainmodel.candies;

/**
 * Class Description:
 * declare class candies.CandyBase as abstract and
 * put it into package 'com.epam.tat.domainmodel.candies'.
 * <p>
 */
public abstract class CandyBase {

    /**
     * No actions are required within the class
     */
    String name;
    int weight;

    abstract String getName();

    abstract void setName(String name);

    abstract int getWeight();

    abstract void setWeight(int weight);
}
