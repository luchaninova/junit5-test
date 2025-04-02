package com.tau.automation.junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizeTest {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    void intParameters (int theParams) {
        System.out.println("theParams = " + theParams);
    }

    @ParameterizedTest (name = "Run: {index} - parameter: {arguments}")
    @NullAndEmptySource
    @ValueSource(strings = {"StringOne", "StringTwo"})
    void stringParameters (String theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest(name = "Run = {index} - value: {arguments}")
    @CsvSource(value = {"spring,season", "summer,season", "winter,season"})
    void csvSource_StringString (String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @CsvSource(value = {"'spring,good time',season", "'summer,better time',season", "'winter,I do not like',season"})
    void csvSource_StringWithComa (String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @CsvSource(value = {"Spring?season", "Summer?season"}, delimiter = '?')
    void csvSource_StringWithDelimiter (String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @CsvSource(value = {"Summer, 38, true", "Winter, 15, false"})
    void csvSource_StringIntBoolean (String param1, int param2, boolean param3) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/scv", "src/test/resources/scv1"}, numLinesToSkip = 1)
    void csvSourceFile_StringIntDoubleStringString (String item, int quantity, double price,
                                                    String currency, String supplier) {
        System.out.println("item = " + item + ", quantity = " + quantity +
                ", price = " + price + ", currency = " + currency + ", supplier = " + supplier);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/scv2", numLinesToSkip = 1)
    void csvSourceFileWithDelimiter_StringIntDoubleStringString(String item, int quantity, double price,
                                                               String currency, String supplier) {
        System.out.println("item = " + item + ", quantity = " + quantity +
                ", price = " + price + ", currency = " + currency + ", supplier = " + supplier);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String (String param1) {
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "streamSourceString")
    void methodSource_StreamString (String param1) {
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringDouble")
    void methodSource_StringDouble(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @MethodSource(value = "com.tau.automation.ParamProvider#sourceStreamStringDouble")
    void methodSource_StreamStringDouble(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    List<String> sourceString() {
        return Arrays.asList("spring", "summer", "winter");
    }

    Stream<String> streamSourceString() {
        return Stream.of("summer", "winter");
    }

    List<Arguments> sourceStringDouble () {
        return Arrays.asList(arguments("spring", 1.0), arguments("summer", 2.0));
    }
}
