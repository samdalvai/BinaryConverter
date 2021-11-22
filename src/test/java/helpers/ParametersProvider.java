package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class ParametersProvider {

    private static Stream<Arguments> decimalToBinaryProvider() {
        return Stream.of(
                Arguments.of("11111111111111111111", "1048575"),
                Arguments.of("1", "1"),
                Arguments.of("111010110111100110100010101", "123456789")
        );
    }

    private static Stream<Arguments> decimalToHexadecimalProvider() {
        return Stream.of(
                Arguments.of("FFFFFFFFFFFFFFF", "1152921504606846975"),
                Arguments.of("1", "1"),
                Arguments.of("75BCD15", "123456789")
        );
    }

    private static Stream<Arguments> decimalToOctalProvider() {
        return Stream.of(
                Arguments.of("777777777777777777777", "9223372036854775807"),
                Arguments.of("1", "1"),
                Arguments.of("726746425", "123456789")
        );
    }

    private static Stream<Arguments> binaryToDecimalProvider() {
        return Stream.of(
                Arguments.of("1048575", "11111111111111111111"),
                Arguments.of("1", "1"),
                Arguments.of("123456789", "111010110111100110100010101")
        );
    }

    private static Stream<Arguments> binaryToHexadecimalProvider() {
        return Stream.of(
                Arguments.of("7FFFFFFFFFFFFFFF", "111111111111111111111111111111111111111111111111111111111111111"),
                Arguments.of("1", "1"),
                Arguments.of("AAAA", "1010101010101010")
        );
    }

    private static Stream<Arguments> binaryToOctalProvider() {
        return Stream.of(
                Arguments.of("777777777777777777777", "111111111111111111111111111111111111111111111111111111111111111"),
                Arguments.of("1", "1"),
                Arguments.of("125252", "1010101010101010")
        );
    }

    private static Stream<Arguments> hexadecimalToDecimalProvider() {
        return Stream.of(
                Arguments.of("188900977659375", "ABCDEFABCDEF"),
                Arguments.of("1", "1"),
                Arguments.of("123456789", "75BCD15")
        );
    }

    private static Stream<Arguments> hexadecimalToBinaryProvider() {
        return Stream.of(
                Arguments.of("111111111111111111111111111111111111111111111111111111111111111", "7FFFFFFFFFFFFFFF"),
                Arguments.of("1", "1"),
                Arguments.of("1010101010101010", "AAAA")
        );
    }

    private static Stream<Arguments> hexadecimalToOctalProvider() {
        return Stream.of(
                Arguments.of("777777777777777777777", "7FFFFFFFFFFFFFFF"),
                Arguments.of("1", "1"),
                Arguments.of("125252", "AAAA")
        );
    }

    private static Stream<Arguments> octalToDecimalProvider() {
        return Stream.of(
                Arguments.of("9223372036854775807", "777777777777777777777"),
                Arguments.of("1", "1"),
                Arguments.of("123456789", "726746425")
        );
    }

    private static Stream<Arguments> octalToBinaryProvider() {
        return Stream.of(
                Arguments.of("111111111111111111111111111111111111111111111111111111111111111", "777777777777777777777"),
                Arguments.of("1", "1"),
                Arguments.of("1010101010101010", "125252")
        );
    }

    private static Stream<Arguments> octalToHexadecimalProvider() {
        return Stream.of(
                Arguments.of("7FFFFFFFFFFFFFFF", "777777777777777777777"),
                Arguments.of("1", "1"),
                Arguments.of("AAAA", "125252")
        );
    }

}
