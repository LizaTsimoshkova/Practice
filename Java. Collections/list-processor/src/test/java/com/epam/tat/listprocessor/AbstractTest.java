package com.epam.tat.listprocessor;

import com.epam.tat.listprocessor.impl.ListProcessor;
import org.junit.jupiter.api.BeforeEach;

abstract class AbstractTest {

    IListProcessor testClass;

    @BeforeEach
    void setUp() {
        testClass = new ListProcessor();
    }
}
