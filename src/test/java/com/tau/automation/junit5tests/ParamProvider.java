package com.tau.automation.junit5tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamProvider {

    static Stream<Arguments> sourceStreamStringDouble() {
        return Stream.of(arguments("summer", 2.1), arguments("winter", 3.0));
    }
}
