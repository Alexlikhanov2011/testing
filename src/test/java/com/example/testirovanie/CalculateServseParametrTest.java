package com.example.testirovanie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculateServseParametrTest {
    CalculateService service = new CalculateService();

    private static List<Arguments> parametrs() {
        return List.of(
                Arguments.of(1d, 2d),
                Arguments.of(-2d, -3d),
                Arguments.of(2d, -3d),
                Arguments.of(-2d, -3d),
                Arguments.of(-2d, 1d));
    }

    @ParameterizedTest
    @MethodSource("parametrs")
    void test(double num1, double num2) {
        assertEquals(num1 + num2, service.plus(num1, num2));
        assertEquals(num1 - num2, service.minus(num1, num2));
        assertEquals(num1 * num2, service.multiply(num1, num2));
        assertEquals(num1 / num2, service.divide(num1, num2));
    }

    @Test
    void testZero() {
        assertThrows(IllegalArgumentException.class, () -> service.divide(3d, 0));
    }
}
