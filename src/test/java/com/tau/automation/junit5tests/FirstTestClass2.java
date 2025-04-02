package com.tau.automation.junit5tests;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTestClass2 {

    @BeforeAll
    void beforeAll() {
        System.out.println("--THis is before All method");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("----This is before Each method");
    }

    @AfterAll
    void afterAll() {
        System.out.println("-- THis is the after All method");
    }

    @AfterEach
    void afterEach() {
        System.out.println("---- This is after Each method");
    }

    @Test
    @Order(2)
    void firstMethod() {
        System.out.println("This is a first test");
    }

    @Test
    @DisplayName("US1234 - TC12 -This is the second method")
    void secondMethod() {
        System.out.println("This is the second method");
    }

    @Test
    @Order(1)
    void thirdMethod() {
        System.out.println("This is the third method");
    }
}
