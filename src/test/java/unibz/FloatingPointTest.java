package unibz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class FloatingPointTest {

    @ParameterizedTest
    @MethodSource("helpers.FloatParametersProvider#floatToBinaryProvider")
    void floatToBinary(String expected, String input) {
        assertEquals(expected, FloatingPoint.floatToBinary(input));
    }

    @ParameterizedTest
    @MethodSource("helpers.FloatParametersProvider#floatToHexadecimalProvider")
    void floatToHexadecimal(String expected, String input) {
        assertEquals(expected, FloatingPoint.floatToHexadecimal(input));
    }

    /*
     * As opposed to the other tests, the last two test for precision, rather
     * than expecting a particular value, these two conversions are expected
     * to have a rounding error
     */
    @ParameterizedTest
    @MethodSource("helpers.FloatParametersProvider#binaryToFloatProvider")
    void binaryToFloat(double expected, String input) {
        double result = Double.parseDouble(FloatingPoint.binaryToFloat(input));

        assertTrue(Math.abs(result - expected) < 0.0000000001);
    }

    @ParameterizedTest
    @MethodSource("helpers.FloatParametersProvider#hexadecimalToFloatProvider")
    void hexadecimalToFloat(double expected, String input) {
        double result = Double.parseDouble(FloatingPoint.hexadecimalToFloat(input));

        assertTrue(Math.abs(result - expected) < 0.0000000001);
    }
}