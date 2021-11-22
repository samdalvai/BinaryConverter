package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class FloatParametersProvider {

    private static Stream<Arguments> floatToBinaryProvider() {
        return Stream.of(
                Arguments.of("0 01111111 00010100101000010000000", "1.0805817"),
                Arguments.of("0 10001111 10000110101000000001110", "100000.1111"),
                Arguments.of("0 01100001 00010010111000001011111", "0.000000001")
        );
    }

    private static Stream<Arguments> floatToHexadecimalProvider() {
        return Stream.of(
                Arguments.of("3F8A5080", "1.0805817"),
                Arguments.of("47C3500E", "100000.1111"),
                Arguments.of("3089705F", "0.000000001")
        );
    }

    private static Stream<Arguments> binaryToFloatProvider() {
        return Stream.of(
                Arguments.of(1.080581700, "0 01111111 00010100101000010000000"),
                Arguments.of(100000.110000000, "0 10001111 10000110101000000001110"),
                Arguments.of(0.000000001, "0 01100001 00010010111000001011111")
        );
    }

    private static Stream<Arguments> hexadecimalToFloatProvider() {
        return Stream.of(
                Arguments.of(1.080581700, "3F8A5080"),
                Arguments.of(100000.110000000, "47C3500E"),
                Arguments.of(0.000000001, "3089705F")
        );
    }

}
