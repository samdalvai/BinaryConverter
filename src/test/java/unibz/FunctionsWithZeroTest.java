package unibz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionsWithZeroTest {

    @Test
    void decimalToBinaryWithZeroInput() {
        assertEquals("0", Functions.decimalToBinary("0"));
    }

    @Test
    void decimalToHexadecimalWithZeroInput() {
        assertEquals("0", Functions.decimalToHexadecimal("0"));
    }

    @Test
    void decimalToOctalWithZeroInput() {
        assertEquals("0", Functions.decimalToOctal("0"));
    }

    @Test
    void binaryToDecimalWithZeroInput() {
        assertEquals("0", Functions.binaryToDecimal("0"));
    }

    @Test
    void binaryToHexadecimalWithZeroInput() {
        assertEquals("0", Functions.binaryToHexadecimal("0"));
    }

    @Test
    void binaryToOctalWithZeroInput() {
        assertEquals("0", Functions.binaryToOctal("0"));
    }

    @Test
    void hexadecimalToDecimalWithZeroInput() {
        assertEquals("0", Functions.hexadecimalToDecimal("0"));
    }

    @Test
    void hexadecimalToBinaryWithZeroInput() {
        assertEquals("0", Functions.hexadecimalToBinary("0"));
    }

    @Test
    void hexadecimalToOctalWithZeroInput() {
        assertEquals("0", Functions.hexadecimalToOctal("0"));
    }

    @Test
    void octalToDecimalWithZeroInput() {
        assertEquals("0", Functions.octalToDecimal("0"));
    }

    @Test
    void octalToBinaryWithZeroInput() {
        assertEquals("0", Functions.octalToBinary("0"));
    }

    @Test
    void octalToHexadecimalWithZeroInput() {
        assertEquals("0", Functions.octalToHexadecimal("0"));
    }
}
