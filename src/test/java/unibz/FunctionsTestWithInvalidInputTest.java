package unibz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionsTestWithInvalidInputTest {

    @Test
    public void binaryToDecimalWithInvalidInput() {
        assertEquals("ERROR, INVALID INPUT...", Functions.binaryToDecimal("1120110"));
    }

    @Test
    public void hexadecimalToDecimalWithInvalidInput() {
        assertEquals("ERROR, INVALID INPUT...", Functions.hexadecimalToDecimal("FGFFF"));
    }

    @Test
    public void octalToDecimalWithInvalidInput() {
        assertEquals("ERROR, INVALID INPUT...", Functions.octalToDecimal("777A123"));
    }

}
