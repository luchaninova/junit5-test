package com.tau.automation.junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionsTest {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    void intParameters (int theParams) {
        assumeTrue(theParams > 4);
        System.out.println("theParams = " + theParams);
    }

    @ParameterizedTest(name = "Run = {index} - value: {arguments}")
    @CsvSource(value = {"spring,season", "summer,season", "winter,season"})
    void csvSource_StringString (String param1, String param2) {
        assumeFalse(param1.equals("spring"), "The param 2 value is " + param2);
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @CsvSource(value = {"Summer, 38, true", "Winter, 15, false"})
    void csvSource_StringIntBoolean (String param1, int param2, boolean param3) {
        assumingThat(param2 > 20, () -> System.out.println("This code runs"));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }
}
