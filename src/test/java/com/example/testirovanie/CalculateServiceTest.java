package com.example.testirovanie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {
    CalculateService service = new CalculateService();

    @Test
    void plus() {
        var actual = service.plus(1d, 2d);
        assertEquals(3d, actual);

        var actual1 = service.plus(-2d, -3d);
        assertEquals(-5d, actual1);

        var actual2 = service.plus(2d, -3d);
        assertEquals(-1d, actual2);

        var actual3 = service.plus(-2d, 3d);
        assertEquals(1d, actual3);

        var actual4 = service.plus(-2d, 0d);
        assertEquals(-2d, actual4);

    }

    @Test
    void minus() {
        var actual = service.minus(1d, 2d);
        assertEquals(-1d, actual);

        var actual1 = service.minus(-2d, -3d);
        assertEquals(1d, actual1);

        var actual2 = service.minus(2d, -3d);
        assertEquals(5d, actual2);

        var actual3 = service.minus(-2d, 3d);
        assertEquals(-5d, actual3);

        var actual4 = service.minus(-2d, 0d);
        assertEquals(-2d, actual4);
    }

    @Test
    void multiply() {
        var actual = service.multiply(1d, 2d);
        assertEquals(2d, actual);

        var actual1 = service.multiply(-2d, -3d);
        assertEquals(6d, actual1);

        var actual2 = service.multiply(2d, -3d);
        assertEquals(-6d, actual2);

        var actual3 = service.multiply(-2d, 3d);
        assertEquals(-6d, actual3);

        var actual4 = service.multiply(-2d, 0d);
        assertEquals(-0d, actual4);

        var actual5 = service.multiply(0d, -2d);
        assertEquals(-0d, actual5);
    }

    @Test
    void divide() {
        var actual = service.divide(1d, 2d);
        assertEquals(0.5d, actual);

        var actual1 = service.divide(-3d, -3d);
        assertEquals(1d, actual1);

        var actual2 = service.divide(6d, -3d);
        assertEquals(-2d, actual2);

        var actual3 = service.divide(-6d, 3d);
        assertEquals(-2d, actual3);

        var actual4 = service.divide(0d, 2d);
        assertEquals(0d, actual4);

        assertThrows(IllegalArgumentException.class, () -> service.divide(3d, 0));
    }
}