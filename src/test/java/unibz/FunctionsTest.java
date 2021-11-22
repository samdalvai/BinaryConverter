package unibz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionsTest {

    @ParameterizedTest
    @MethodSource("helpers.ParametersProvider#decimalToBinaryProvider")
    void decimalToBinary(String expected, String input) {
        assertEquals(expected, Functions.decimalToBinary(input));
    }

    @ParameterizedTest
    @MethodSource("helpers.ParametersProvider#decimalToHexadecimalProvider")
    void decimalToHexadecimal(String expected, String input) {
        assertEquals(expected, Functions.decimalToHexadecimal(input));
    }

    @ParameterizedTest
    @MethodSource("helpers.ParametersProvider#decimalToOctalProvider")
    void decimalToOctal(String expected, String input) {
        assertEquals(expected, Functions.decimalToOctal(input));
    }

    @ParameterizedTest
    @MethodSource("helpers.ParametersProvider#binaryToDecimalProvider")
    void binaryToDecimal(String expected, String input) {
        assertEquals(expected, Functions.binaryToDecimal(input));
    }

    @ParameterizedTest
    @MethodSource("helpers.ParametersProvider#binaryToHexadecimalProvider")
    void binaryToHexadecimal(String expected, String input) {
        assertEquals(expected, Functions.binaryToHexadecimal(input));
    }

    @ParameterizedTest
    @MethodSource("helpers.ParametersProvider#binaryToOctalProvider")
    void binaryToOctal(String expected, String input) {
        assertEquals(expected, Functions.binaryToOctal(input));
    }

    @ParameterizedTest
    @MethodSource("helpers.ParametersProvider#hexadecimalToDecimalProvider")
    void hexadecimalToDecimal(String expected, String input) {
        assertEquals(expected, Functions.hexadecimalToDecimal(input));
    }

    @ParameterizedTest
    @MethodSource("helpers.ParametersProvider#hexadecimalToBinaryProvider")
    void hexadecimalToBinary(String expected, String input) {
        assertEquals(expected, Functions.hexadecimalToBinary(input));
    }

    @ParameterizedTest
    @MethodSource("helpers.ParametersProvider#hexadecimalToOctalProvider")
    void hexadecimalToOctal(String expected, String input) {
        assertEquals(expected, Functions.hexadecimalToOctal(input));
    }

    @ParameterizedTest
    @MethodSource("helpers.ParametersProvider#octalToDecimalProvider")
    void octalToDecimal(String expected, String input) {
        assertEquals(expected, Functions.octalToDecimal(input));
    }

    @ParameterizedTest
    @MethodSource("helpers.ParametersProvider#octalToBinaryProvider")
    void octalToBinary(String expected, String input) {
        assertEquals(expected, Functions.octalToBinary(input));
    }

    @ParameterizedTest
    @MethodSource("helpers.ParametersProvider#octalToHexadecimalProvider")
    void octalToHexadecimal(String expected, String input) {
        assertEquals(expected, Functions.octalToHexadecimal(input));
    }
}
