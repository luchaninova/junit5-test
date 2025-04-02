package com.tau.automation.junit5tests;

import com.tau.automation.listeners.Listener;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@ExtendWith(Listener.class)
public class DisabledTest {

    @Test
    @Disabled(value = "Disabled for demo @Disabled")
    void firstTst() {
        System.out.println("This is 1 test");
    }

    @Test
    @DisabledOnOs(value = OS.LINUX, disabledReason = "The test run for @DisabledOnOs")
    void secondTst() {
        System.out.println("This is 2 test");
    }

    @Test
    void thirdTst() {
        System.out.println("This is 3 test");
    }

    @Test
    @DisabledIf(value = "provider", disabledReason = "The demo run to evaluate the day of the week")
    void firthTst() {
        System.out.println("This is 4 test");
    }

    @Test
    void fifthTst() {
        System.out.println("This is 5 test");
    }

    boolean provider() {
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.THURSDAY);
    }
}
