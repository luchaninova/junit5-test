package com.tau.automation.junit5tests;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AssertTests {

    @Test
    void testAssertStrings () {
        assertEquals("first", "second", "Strings are not equal");
    }

    @ParameterizedTest (name = "Run: {index} - parameter: {arguments}")
    @NullAndEmptySource
    @ValueSource(strings = {"StringOne", "StringTwo"})
    void stringParameters (String theParam) {
        String str = "StringOne";
        assertEquals(str, theParam, "Strings are not equal ");
    }

    @Test
    void testArrayEquals () {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        assertArrayEquals(arr1, arr2, "Arrays are not equal");
    }

    @Test
    void testThrowException () {
       assertThrows(NullPointerException.class, null);
    }

    @Test
    void testAllAssertion(){
        assertAll(
                () -> assertThrows(NullPointerException.class, null),
                () -> assertEquals("first", "second", "Strings are not equal")
        );
    }

    @Test
    void testMatchersMap() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstString", 1);
        theMap.put("secondString", 2);
        theMap.put("thirdString", 3);
        assertThat(theMap, Matchers.hasKey("firstString"));
        assertThat(theMap, Matchers.hasValue(1));
    }

    @Test
    void testMatchersList() {
        List<String> theList = Arrays.asList("firstValue", "secondValue");
        assertThat(theList, Matchers.hasItem("firstValue"));
    }
}
