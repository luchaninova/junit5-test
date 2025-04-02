package com.tau.automation.junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTests {

    @RepeatedTest(3)
    @DisplayName(value = "This is demo repetition")
    void firstRepeatedTest() {
        System.out.println("This is first repeated test");
    }

    @RepeatedTest(value = 3, name = "The repetition: {currentRepetition} total: {totalRepetitions}")
    void secondRepeatedTest() {
        System.out.println("This is the second repetition");
    }

    @RepeatedTest(3)
    void thirdRepeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println("This is third repetition");
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition() == 3, () -> System.out.println("This" +
                " is the last repetition"));
    }
}
